package com.name.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.name.base.BasePageObject;

public class EmployeesPage extends BasePageObject<EmployeesPage> {

	public EmployeesPage(WebDriver driver) {
		super(driver);
	}
	private By addEmployeeButton = By.xpath("//i[@class='a-icon-add-new']");
	private By departmentTab = By.xpath("//*[@id=\"tabstrip\"]/ul/li[4]/a");
	private By deptAddButton = By.xpath("//*[@id=\"EmployeeExecutive\"]/div[1]/a");
/*	private By lawFirmStart = By.xpath("//*[@id=\"EmployeeExecutive_active_cell\"]/span[1]/span/span[1]");
	private By toDateEnd = By.xpath("//input[@id='ToDate']");*/
	
	public void addEmployeeButton() {
		click(addEmployeeButton);
	}
	
	public void clickDepartmentTab() {
		click(departmentTab);
	}
	
	public void clickAddNewRecordButton() {
		click(deptAddButton);
		wait_until(3);
	}
	
	public void DragtoEnd() {
		scroll_right();
		wait_until(3);
	}
}
