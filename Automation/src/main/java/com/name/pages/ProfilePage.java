package com.name.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.name.base.BasePageObject;

public class ProfilePage extends BasePageObject<ProfilePage> {

	protected By quickBookingBtn = By.xpath("//button[@class='btn btn-danger btn-block']");

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	public void waitForProfilePagetoLoad() {
		wait_until(ExpectedConditions.elementToBeClickable(quickBookingBtn));
	}

	public String getTitleof() {
		return getTitle();
	}
}