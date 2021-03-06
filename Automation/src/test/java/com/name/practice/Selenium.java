package com.name.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium {

	public static void main(String[] args) {

		// System.setProperty("webdriver.gecko.driver",
		// "src/main/resources/Driver/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/Driver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println(driver.findElement(By.xpath("//a[contains(text(), Mail)]")).getAttribute("class"));

		List<WebElement> List = driver.findElements(By.tagName("a"));
		for (WebElement webElement1 : List) {
			if (webElement1.getAttribute("href") != null)
				System.out.println(webElement1.getText());
		}
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		alert.getText();
		alert.sendKeys("");
	}
}