package com.name.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BrowserFactory<T> {

	public static WebDriver getDriver(String browser) {
		WebDriver driver = null;
		final int defaultTimeout = 30;

		switch (browser.toLowerCase()) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		default:
			System.setProperty("webdriver.gecko.driver", "src/main/resources/Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}

		driver.manage().timeouts().implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}