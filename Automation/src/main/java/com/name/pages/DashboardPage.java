package com.name.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.name.base.BasePageObject;

public class DashboardPage extends BasePageObject<DashboardPage> {

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	private By adminLink = By.xpath("//a[@class='admin']");
	private By employeeLink = By.xpath("//a[text()='Employee']");
	private By desginationLink = By.xpath("//a[text()='Designation']");

	public void hoverAdminLink() {
		mousehover(adminLink);
	}

	public void clickEmployeeLink() {
		click(employeeLink);
		wait_until(2);
	}

	public void clickDesginationLink() {
		click(desginationLink);
		wait_until(2);
	}
}