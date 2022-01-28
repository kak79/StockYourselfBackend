package com.revature.stockYourself.automation;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunSeleniumTests {

	public static void main(String[] args) {
		File file = new File("src/main/resources/chromedriver");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		WebDriver driver = new ChromeDriver();

		
		
		
		
		driver.quit();
	}

}
