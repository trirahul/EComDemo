package com.gmail.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    	WebDriverManager.chromedriver().browserVersion("126.0.6478.127").setup();
//        WebDriverManager.chromedriver().setup();
        // Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        // Initialize a new WebDriver instance of ChromeDriver with options
        driver = new ChromeDriver(options);
    }

    @Test
    public void testGoogleTitle() {
        // Open a website
        driver.get("https://www.google.com");

        // Get the title of the page
        String title = driver.getTitle();

        // Print the title of the page
        System.out.println("Title: " + title);

        // Verify the title of the page
        Assert.assertEquals(title, "Google");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
