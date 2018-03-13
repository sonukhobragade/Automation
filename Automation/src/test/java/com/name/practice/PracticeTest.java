package com.name.practice;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.name.base.BaseTestObject;
import com.name.base.ExcelReader;
import com.name.base.PropertiesUtils;
import com.name.pages.PracticePage;

public class PracticeTest extends BaseTestObject<PracticeTest> {

	PropertiesUtils pu = new PropertiesUtils();
	ExcelReader excelReader = new ExcelReader();

	@DataProvider(name = "TestData")
	public Object[][] loginData() {
		Object[][] arrayObject = excelReader.getRowDataMap(pu.getValue("LoginExcelFile"),
				pu.getValue("LoginSheetName"));
		return arrayObject;
	}

	@Test(dataProvider = "TestData")
	public void PractTest(HashMap<String, Object> rowMap) {

		String url = "http://www.gooogle.com"; 
	/*	String url = pu.getValue("URL");
		String userName = (String) rowMap.get("UserName");
		String passWord = (String) rowMap.get("PassWord");
		String firmName = (String) rowMap.get("Firm");
		String branchName = (String) rowMap.get("Branch");
		String adminName = "ADMIN";
*/
		PracticePage PracPage = new PracticePage(driver);

		PracPage.openLogInPage(url);
		//PracPage.enterUserNamePassWord(userName, passWord);
		//PracPage.selectFirmDropDown(firmName);
		//PracPage.selectBranchDropDown(branchName);
		//PracPage.pushSignInButton();
		//PracPage.hoverAdminLink();
		//PracPage.rightClickActivityGroup();
		PracPage.rightClickMail();
	}
}
