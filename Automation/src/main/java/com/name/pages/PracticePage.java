package com.name.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.name.base.BasePageObject;
import com.name.base.PropertiesUtils;

public class PracticePage extends BasePageObject<PracticePage> {

	PropertiesUtils pu = new PropertiesUtils();

	public PracticePage(WebDriver driver) {
		super(driver);
	}
	
	private By userNameField = By.id("UserUsername");
	private By passwordField = By.xpath("//input[@id='UserPassword']");
	private By firmDropDown = By.xpath("//Form[@id=\"UserLoginForm\"]/div[2]/div[3]/div/span/span/span[1]");
	private By branchDropDown = By.xpath("//Form[@id=\"UserLoginForm\"]/div[2]/div[4]/div/span/span/span[1]");
	private By signInButton = By.xpath("//input[@value='Login']");
	private By sessionalYesButton = By.xpath("//input[@id='yes']");
	private By adminLink = By.xpath("//a[@class='admin']");
	//private By casesWidget = By.xpath("//*[@id=\"RnRChartContainer\"]/div[2]/div[1]/div/div[2]/a/div");
	private By activityGroupLink = By.xpath("//a[text()='Activity Group']");
	private By mailLink = By.xpath("//a[text()='Gmail']");

	public void openLogInPage(String URL) {
		getPage(URL);
	}
	
	public void enterUserNamePassWord(String username, String password) {
		enter(username, userNameField);
		enter(password + Keys.TAB, passwordField);
	}
	
	public void selectFirmDropDown(String firmName) {
		click_button(firmDropDown);
		wait_until(1);
		enter(firmName + Keys.ENTER, firmDropDown);
	}

	public void selectBranchDropDown(String branchName) {
		click_button(branchDropDown);
		wait_until(1);
		enter(branchName + Keys.ENTER, branchDropDown);
		wait_until(1);
	}

	public void pushSignInButton() {
		wait_until(ExpectedConditions.elementToBeClickable(signInButton));
		click(signInButton);
		wait_until(2);
		if(is_element_exist(sessionalYesButton)) {
			click(sessionalYesButton);
			wait_until(3);
		}
	}
	
	public void hoverAdminLink() {
		wait_until(5);
		mousehover(adminLink);
	}
	
	public void rightClickActivityGroup() {
		wait_until(10);
		right_click_button(activityGroupLink);
		wait_until(10);
	}
	
	public void rightClickMail() {
		wait_until(10);
		right_click_button(mailLink);
		wait_until(10);
	}
}