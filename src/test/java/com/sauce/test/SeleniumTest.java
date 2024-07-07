package com.sauce.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sauce.utils.HelperFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
//    	WebDriverManager.chromedriver().setup();
//        WebDriverManager.chromedriver().setup();
		// Create an instance of ChromeOptions
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--disable-infobars");
//        options.addArguments("--disable-notifications");

//        options.addArguments("--headless");
		// Initialize a new WebDriver instance of ChromeDriver with options
		driver = new ChromeDriver(options);
		driver.navigate().refresh();
		driver.manage().window().maximize();
	}

	@Test
	public void testGoogleTitle() throws Exception {
		// Open a website
		HelperFunctions help = null;
		
		driver.get("https://www.google.com");
		help = new HelperFunctions(driver);
		// Get the title of the page
		String title = driver.getTitle();

		help.customExplicitWaitTillElementBecomesActive("//textarea[@aria-label='Search']", 2, 1);
		help.customExplicitWaitTillElementBecomesClickable("//textarea[@aria-label='Search']", 5, 0.5);
		driver.findElement(By.xpath("//textarea[@aria-label='Search']")).click();
		help.customExplicitWaitTillElementBecomesClickable("//textarea[@aria-label='Search']", 5, 0.5);
		driver.findElement(By.xpath("//textarea[@aria-label='Search']")).sendKeys("Hello Bhai");
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
