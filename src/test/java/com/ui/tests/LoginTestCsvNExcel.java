package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;

public class LoginTestCsvNExcel {
	HomePage homePage;
	
	@BeforeMethod (description= "Load the Homepage of website")
	public void setup() {
	//	homePage= new HomePage(Browser.CHROME);
	}
	@Test (description = "Verifies the valid user is able to login into the application",
			groups ={"e2e","sanity"},dataProviderClass =com.ui.dataproviders.LoginDataProvider.class,
			dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {	

	assertEquals(homePage.goToLoginPage().dologinWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Raja raja");
	}
	@Test (description = "Verifies the valid user is able to login into the application",
			groups ={"e2e","sanity"},dataProviderClass =com.ui.dataproviders.LoginDataProvider.class,
			dataProvider = "LoginTestCSVDataProvider")
	public void loginCSVTest(User user) {	

	assertEquals(homePage.goToLoginPage().dologinWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Raja raja");
	}
	
	
	@Test (description = "Verifies the valid user is able to login into the application",
			groups ={"e2e","sanity"},dataProviderClass =com.ui.dataproviders.LoginDataProvider.class,
			dataProvider = "LoginTestExcelDataProvider")
	public void loginExcelTest(User user) {	

	assertEquals(homePage.goToLoginPage().dologinWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Raja raja");
	}
}

// Test Method !!!
/*
 * 1 Test script small
 * you cannot have conditional stmts loops stmts , try catch in you test method
 * Test scripts  --> Test steps
 * Reduce the use of local variables
 * we shoud have atleast one assertion.
 */
