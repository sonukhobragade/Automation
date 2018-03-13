package com.name.test;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.name.base.BaseTestObject;
import com.name.base.CsvDataProvider;
import com.name.pages.LogInPage;
import com.name.pages.ProfilePage;

public class LogInTest extends BaseTestObject<LogInTest>{
	
	@Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
	public void positiveLogInTest(Map<String, String> testData ) {
		
		String expectedPageTitle = "Dashboard";
		String email = testData.get("email");
		String password = testData.get("password");
		LogInPage LogInPage = new LogInPage(driver);
		ProfilePage ProfilePage = new ProfilePage(driver);
			
		LogInPage.openLogInPage();
		LogInPage.fillUpEmailAndPassword(email, password);
		LogInPage.pushSignInButton();
		
		ProfilePage.waitForProfilePagetoLoad();
	
		String actualTitle = ProfilePage.getTitleof();
		Assert.assertTrue(expectedPageTitle.equals(actualTitle), "Page Title is not Expected.");
	}
	
	/*@Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class, groups = "negative")
	public void negativeLogInTest(Map<String, String> testData ) {
		
		String email = testData.get("email");
		String password = testData.get("password");
		
		LogInPage.openLogInPage();
		LogInPage.fillUpEmailAndPassword(email, password);
		LogInPage.pushSignInButton();
		
		ProfilePage.waitForProfilePagetoLoad();
	
		String actualTitle = ProfilePage.getTitleof();
		Assert.assertTrue(expectedPageTitle.equals(actualTitle), "Page Title is not Expected.");
	}*/
}
