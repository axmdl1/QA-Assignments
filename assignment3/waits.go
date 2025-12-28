package main

import (
	"fmt"
	"log"
	"time"

	"github.com/tebeka/selenium"
)

func main() {
	const port = 9515

	// Start ChromeDriver service on the specified port
	service, err := selenium.NewChromeDriverService("chromedriver", port)
	if err != nil {
		panic(err)
	}
	defer service.Stop()

	// Define browser capabilities (Chrome)
	caps := selenium.Capabilities{"browserName": "chrome"}

	// Create a new WebDriver session
	driver, err := selenium.NewRemote(caps, fmt.Sprintf("http://localhost:%d/wd/hub", port))
	if err != nil {
		panic(err)
	}
	defer driver.Quit()

	// IMPLICIT WAIT
	// Global wait applied to all FindElement calls.
	// Selenium will wait up to 10 seconds when searching for elements.
	driver.SetImplicitWaitTimeout(10 * time.Second)

	// Open GitHub main page
	driver.Get("https://github.com")

	// Click on the search button to open the search input dialog
	searchBtn, err := driver.FindElement(selenium.ByCSSSelector, "button.header-search-button")
	if err != nil {
		log.Fatalf("Error while clicking search button: %v", err)
	}
	searchBtn.Click()

	// EXPLICIT WAIT,
	// Wait until the GitHub search input appears.
	// This input is rendered dynamically after clicking the search button.
	var realInput selenium.WebElement
	err = driver.WaitWithTimeout(func(wd selenium.WebDriver) (bool, error) {
		el, err := wd.FindElement(selenium.ByID, "query-builder-test")
		if err != nil {
			return false, nil // element not ready yet
		}
		realInput = el
		return true, nil
	}, 10*time.Second)

	if err != nil {
		log.Fatalf("Search input did not appear: %v", err)
	}

	// Enter repository name and submit search
	realInput.SendKeys("MedicalDataExchange" + selenium.EnterKey)

	// FLUENT WAIT,
	// Wait until the repository link appears in search results.
	// This wait uses:
	// - polling interval (500 ms)
	// - ignored exceptions
	// - dynamic condition
	var repoLink selenium.WebElement
	err = driver.WaitWithTimeout(func(wd selenium.WebDriver) (bool, error) {
		// Polling interval
		time.Sleep(500 * time.Millisecond)

		el, err := wd.FindElement(
			selenium.ByXPATH,
			"//a[@href='/axmdl1/MedicalDataExchange']",
		)
		if err != nil {
			return false, nil // ignore exception and continue waiting
		}

		repoLink = el
		return true, nil
	}, 15*time.Second)

	if err != nil {
		log.Fatalf("Repository link did not appear %v", err)
	}

	// Click on the repository link
	repoLink.Click()

	log.Println("✅ Search test PASSED successfully")

	// Keep browser open for manual verification
	fmt.Println("Press ENTER to close the browser...")
	fmt.Scanln()
}
