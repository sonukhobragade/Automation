package com.name.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.name.base.BasePageObject;

public class DesignationPage extends BasePageObject<DesignationPage> {

	public DesignationPage(WebDriver driver) {
		super(driver);
	}

	private By addNewLink = By.xpath("//i[@title='Add New']");
	private By savebutton = By.xpath("//i[@class='a-icon-save']");
	private By successMsg = By.xpath("//div[@id=\"success\"]/div");
	private By codeField = By.xpath("//input[@name=\"data[Designation][Code]\"]");
	private By nameField = By.xpath("//input[@name=\"data[Designation][Name]\"]");
	private By descriptionField = By.xpath("//textarea[@name=\"data[Designation][Description]\"]");
	private By okButton = By.xpath("//input[@id='ok']");

	public void clickAddNewLink() {
		click(addNewLink);
		wait_until(2);
	}

	public void enterCode(String code) {
		enter(codeField, code);
	}

	public void enterName(String name) {
		enter(nameField, name);
	}

	public void enterDescription(String description) {
		enter(descriptionField, description);
	}

	public void saveButton() {
		click(savebutton);
	}

	public void verifySucessMsg(String expectedResult) {
		wait_until(3);
		verify_element(successMsg, expectedResult);
	}

	public void clickOkButton() {
		click(okButton);
	}
}