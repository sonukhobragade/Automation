package com.name.test;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.name.base.BaseTestObject;
import com.name.base.ExcelReader;
import com.name.base.PropertiesUtils;
import com.name.pages.DashboardPage;
import com.name.pages.EmaktabLoginPage;
import com.name.pages.EmployeesPage;

public class EmaktabLoginTest extends BaseTestObject<EmaktabLoginTest> {

	PropertiesUtils pu = new PropertiesUtils();
	ExcelReader excelReader = new ExcelReader();

	@DataProvider(name = "TestData")
	public Object[][] loginData() {
		Object[][] arrayObject = excelReader.getRowDataMap(pu.getValue("LoginExcelFile"), pu.getValue("LoginSheetName"));
		return arrayObject;
	}

	@Test(dataProvider = "TestData")
	public void LoginEmaktabTest(HashMap<String, Object> rowMap) {
		
		String url = pu.getValue("URL");
		String userName = (String) rowMap.get("UserName");
		String passWord = (String) rowMap.get("PassWord");
		String firmName = (String) rowMap.get("Firm");
		String branchName = (String) rowMap.get("Branch");
		String adminName = "ADMIN";

		EmaktabLoginPage EmakLogin = new EmaktabLoginPage(driver);
		DashboardPage Dashboard = new DashboardPage(driver);
		EmployeesPage EmpPage = new EmployeesPage(driver);
		
		EmakLogin.openLogInPage(url);
		EmakLogin.enterUserNamePassWord(userName, passWord);
		EmakLogin.selectFirmDropDown(firmName);
		EmakLogin.selectBranchDropDown(branchName);
		EmakLogin.pushSignInButton();
		EmakLogin.verifyLink(adminName);
		
		Dashboard.hoverAdminLink();
		Dashboard.clickEmployeeLink();
		
		EmpPage.addEmployeeButton();
		EmpPage.clickDepartmentTab();
		EmpPage.clickAddNewRecordButton();
		EmpPage.DragtoEnd();
	}
}