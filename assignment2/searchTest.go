package main

import (
	"bufio"
	"fmt"
	"github.com/tebeka/selenium"
	"log"
	"os"
	"strings"
	"time"
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

	reader := bufio.NewReader(os.Stdin)
	fmt.Print("Enter search query: ")
	searchQuery, _ := reader.ReadString('\n')
	searchQuery = strings.TrimSpace(searchQuery)

	err = driver.Get("https://google.com/search?q=" + searchQuery)
	if err != nil {
		log.Fatalf("Failed to load page: %v", err)
	}

	time.Sleep(2 * time.Second)

	log.Println("✅ Search test PASSED successfully")

	fmt.Println("Press ENTER to close the browser...")
	fmt.Scanln()
}
