package com.name.test;

import java.util.HashMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.name.base.BaseTestObject;
import com.name.base.ExcelReader;
import com.name.base.PropertiesUtils;

public class LogInDpTest extends BaseTestObject<LogInTest> {

	PropertiesUtils pu = new PropertiesUtils();
	ExcelReader excelReader = new ExcelReader();

	@DataProvider(name = "TestData")
	public Object[][] loginData() {
		Object[][] arrayObject = excelReader.getRowDataMap(pu.getValue("ExcelFile"), pu.getValue("SheetName"));
		return arrayObject;
	}

	@Test(dataProvider = "TestData")
	public void LoginTest(HashMap<String, Object> rowMap) {

		System.out.println(rowMap.get("No"));
		System.out.println(rowMap.get("Name"));
		System.out.println(rowMap.get("Pass"));
		System.out.println(rowMap.get("Desc"));
	}
}