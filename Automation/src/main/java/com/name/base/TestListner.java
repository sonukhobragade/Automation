package com.name.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListner extends TestListenerAdapter {

	@Override
	public void onTestSuccess(ITestResult tr) {
		System.out.println(tr.getTestContext().getCurrentXmlTest().getName() + " Test Success");
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		
		Object currentClass = tr.getInstance();
		WebDriver webDriver = ((BaseTestObject<?>) currentClass).getDriver();

		File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		try {
			Thread.sleep(3000);
			FileUtils.copyFile(scrFile,
					new File("test-output/ScreenShot/" + tr.getTestContext().getCurrentXmlTest().getName() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(tr.getTestContext().getCurrentXmlTest().getName() + " Test Failure");
	}
	
	@Override
	public void onStart(ITestContext testContext) {
		System.out.println(testContext.getCurrentXmlTest().getName() + " Test Start");
	}
	
	@Override
	public void onFinish(ITestContext testContext) {
		System.out.println(testContext.getCurrentXmlTest().getName() + " Test Finish");
	}
}