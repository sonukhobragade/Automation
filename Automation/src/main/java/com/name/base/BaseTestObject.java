package com.name.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class BaseTestObject<T> {

	protected WebDriver driver;
	protected Logger log;

	@BeforeClass(alwaysRun = true)
	protected void setUpClass(ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();
		log = Logger.getLogger(testName);
	}

	@Parameters({ "browser" })
	@BeforeClass(alwaysRun = true)
	protected void methodSetUp(String browser) {
		//log.info("Method Set Up");
		driver = BrowserFactory.getDriver(browser);
	}

	@AfterClass(alwaysRun = true)
	protected void methodTearDown() {
		log.info("Method Tear Down");
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}
}