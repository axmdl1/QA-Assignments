package main

import (
	"fmt"
	"log"
	"time"

	"github.com/tebeka/selenium"
)

func main() {
	const port = 9515

	service, err := selenium.NewChromeDriverService("chromedriver", port)
	if err != nil {
		panic(err)
	}
	defer service.Stop()

	caps := selenium.Capabilities{"browserName": "chrome"}
	driver, err := selenium.NewRemote(caps, fmt.Sprintf("http://localhost:%d/wd/hub", port))
	if err != nil {
		panic(err)
	}
	defer driver.Quit()

	driver.SetImplicitWaitTimeout(10 * time.Second)

	driver.Get("https://github.com")

	searchBtn, err := driver.FindElement(selenium.ByCSSSelector, "button.header-search-button")
	if err != nil {
		log.Fatalf("Error while clicking search button: %v", err)
	}
	searchBtn.Click()

	driver.SetImplicitWaitTimeout(5 * time.Second)

	var realInput selenium.WebElement
	err = driver.WaitWithTimeout(func(wd selenium.WebDriver) (bool, error) {
		el, err := wd.FindElement(selenium.ByID, "query-builder-test")
		if err != nil {
			return false, nil
		}
		realInput = el
		return true, nil
	}, 10*time.Second)

	if err != nil {
		log.Fatalf("Search input did not appear: %v", err)
	}
	realInput.SendKeys("MedicalDataExchange" + selenium.EnterKey)

	repoLink, err := driver.FindElement(
		selenium.ByCSSSelector,
		"a[class='Link__StyledLink-sc-1syctfj-0 prc-Link-Link-9ZwDx']",
	)
	if err != nil {
		log.Fatalf("Repository link not found: %v", err)
	}
	repoLink.Click()

	log.Println("✅ Search test PASSED successfully")
	fmt.Println("Press ENTER to close the browser...")
	fmt.Scanln()
}
