package com.name.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.name.base.BasePageObject;

public class LogInPage extends BasePageObject<LogInPage> {

	private static final String URL = "http://www.phptravels.net/admin";
	private By emailField = By.xpath("//input[@name='email']");
	private By passwordField = By.xpath("//input[@name='password']");
	private By signInButton = By.xpath("//button[@type='submit']");
	
	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	public void openLogInPage() {
		getPage(URL);
	}

	public void fillUpEmailAndPassword (String email, String password) {
		enter(email, emailField);
		enter(password, passwordField);
	}
	
	public void pushSignInButton() {
		wait_until(ExpectedConditions.elementToBeClickable(signInButton));
		click(signInButton);
	}
}