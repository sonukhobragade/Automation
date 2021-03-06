package com.name.test;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.name.base.BaseTestObject;
import com.name.base.ExcelReader;
import com.name.base.PropertiesUtils;
import com.name.pages.DashboardPage;
import com.name.pages.DesignationPage;
import com.name.pages.EmaktabLoginPage;

public class AddDesignationTest extends BaseTestObject<EmaktabLoginTest> {

	PropertiesUtils pu = new PropertiesUtils();
	ExcelReader excelReader = new ExcelReader();

	@DataProvider(name = "LoginData")
	public Object[][] loginData() {
		Object[][] arrayObject = excelReader.getRowDataMap(pu.getValue("LoginExcelFile"),
				pu.getValue("LoginSheetName"));
		return arrayObject;
	}

	@DataProvider(name = "AddDesgination")
	public Object[][] AddData() {

		Object[][] arrayObject = excelReader.getRowDataMap(pu.getValue("DesignationExcelFile"),
				pu.getValue("DesginationAddSheetName"));
		return arrayObject;
	}

	@Test(dataProvider = "LoginData", priority = 1)
	public void LoginEmaktabTest(HashMap<String, Object> rowMap) {

		String url = pu.getValue("URL");
		String userName = (String) rowMap.get("UserName");
		String passWord = (String) rowMap.get("PassWord");
		String firmName = (String) rowMap.get("Firm");
		String branchName = (String) rowMap.get("Branch");
		String adminName = "ADMIN";

		EmaktabLoginPage EmakLogin = new EmaktabLoginPage(driver);

		EmakLogin.openLogInPage(url);
		EmakLogin.enterUserNamePassWord(userName, passWord);
		EmakLogin.selectFirmDropDown(firmName);
		EmakLogin.selectBranchDropDown(branchName);
		EmakLogin.pushSignInButton();
		EmakLogin.verifyLink(adminName);
	}

	@Test(dataProvider = "AddDesgination", priority = 2)
	public void AddDesgination(HashMap<String, Object> rowMap) {

		String code = (String) rowMap.get("Code");
		String name = (String) rowMap.get("Name");
		String description = (String) rowMap.get("Description");
		String successfulMsg = (String) rowMap.get("Sucessful Msg");

		DashboardPage Dashboard = new DashboardPage(driver);
		DesignationPage Designation = new DesignationPage(driver);

		Dashboard.hoverAdminLink();
		Dashboard.clickDesginationLink();

		Designation.clickAddNewLink();
		Designation.enterCode(code);
		Designation.enterName(name);
		Designation.enterDescription(description);
		Designation.saveButton();
		Designation.verifySucessMsg(successfulMsg);
		Designation.clickOkButton();
	}
}