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

	emailInput, err := driver.FindElement(selenium.ByName, "user_email")
	if err != nil {
		panic("Search input not found")
	}

	emailInput.SendKeys("selenium webdriver, Akhmedali!")

	driver.SetImplicitWaitTimeout(10 * time.Second)

	//Not working well continue here.
	searchInput, err := driver.FindElement(selenium.ByName, "query-builder-test")
	if err != nil {
		log.Fatalf("Cannot search project: %v", err)
	}
	searchInput.SendKeys("MedicalDataExchange")

	log.Println("✅ Search test PASSED successfully")
	fmt.Println("Press ENTER to close the browser...")
	fmt.Scanln()
}
