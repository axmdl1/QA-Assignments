package main

import (
	"fmt"
	"github.com/tebeka/selenium"
	"log"
	"time"
)

func main() {
	var username, password = "student", "Password123"

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

	err = driver.Get("https://practicetestautomation.com/practice-test-login/")
	if err != nil {
		log.Fatalf("Failed to load page: %v", err)
	}

	time.Sleep(5 * time.Second)

	loginU, err := driver.FindElement(selenium.ByCSSSelector, "input[name='username']")
	if err != nil {
		log.Fatalf("Username field cannot enter: %v", err)
	}
	loginU.SendKeys(username)

	passwordU, err := driver.FindElement(selenium.ByCSSSelector, "input[name='password']")
	if err != nil {
		log.Fatalf("Username field cannot enter: %v", err)
	}
	passwordU.SendKeys(password)

	submitBtn, err := driver.FindElement(selenium.ByXPATH, "//button[@class='btn']")
	if err != nil {
		log.Fatalf("Find Flights button not found: %v", err)
	}
	submitBtn.Click()

	time.Sleep(4 * time.Second)

	logoutBtn, err := driver.FindElement(selenium.ByXPATH, "//a[text()='Log out']")
	if err != nil {
		log.Fatalf("Cannot click logout button: %v", err)
	}
	logoutBtn.Click()

	log.Println("✅ Search test PASSED successfully")

	fmt.Println("Press ENTER to close the browser...")
	fmt.Scanln()
}
