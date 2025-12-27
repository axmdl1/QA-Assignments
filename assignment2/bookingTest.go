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
		log.Fatalf("Error starting ChromeDriver: %v", err)
	}
	defer service.Stop()

	caps := selenium.Capabilities{
		"browserName": "chrome",
	}

	driver, err := selenium.NewRemote(caps, fmt.Sprintf("http://localhost:%d/wd/hub", port))
	if err != nil {
		log.Fatalf("Error creating WebDriver: %v", err)
	}
	defer driver.Quit()

	err = driver.Get("https://blazedemo.com")
	if err != nil {
		log.Fatalf("Failed to load page: %v", err)
	}

	time.Sleep(5 * time.Second)

	fromPort, err := driver.FindElement(selenium.ByCSSSelector, "select[name='fromPort']")
	if err != nil {
		log.Fatalf("FROM dropdown not found: %v", err)
	}
	fromPort.SendKeys("Boston")

	toPort, err := driver.FindElement(selenium.ByCSSSelector, "select[name='toPort']")
	if err != nil {
		log.Fatalf("TO dropdown not found: %v", err)
	}
	toPort.SendKeys("London")

	findFlightsBtn, err := driver.FindElement(selenium.ByXPATH, "//input[@value='Find Flights']")
	if err != nil {
		log.Fatalf("Find Flights button not found: %v", err)
	}
	findFlightsBtn.Click()

	time.Sleep(3 * time.Second)

	chooseFlight, err := driver.FindElement(selenium.ByXPATH, "//input[@value='Choose This Flight']")
	if err != nil {
		log.Fatalf("Find Flights button not found: %v", err)
	}
	chooseFlight.Click()

	time.Sleep(4 * time.Second)

	purchaseBtn, err := driver.FindElement(selenium.ByXPATH, "//input[@value='Purchase Flight']")
	if err != nil {
		log.Fatalf("Find Flights button not found: %v", err)
	}
	purchaseBtn.Click()

	time.Sleep(3 * time.Second)

	log.Println("✅ Search test PASSED successfully")

	fmt.Println("Press ENTER to close the browser...")
	fmt.Scanln()
}
