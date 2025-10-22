package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;

import static com.ui.constants.Browser.*;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.ui.utility.LoggerUtility;

@Listeners({com.ui.listners.TestListener.class})

public class LoginTestExcel2 extends TestBase{
	Logger logger = LoggerUtility.getLogger(this.getClass());

	
	
	@Test(description = "Verifies the valid user is able to login into the application", 
			groups = { "e2e","sanity" },
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, 
			dataProvider = "LoginTestExcelDataProvider",
			retryAnalyzer = com.ui.listners.MyRetryAnalyzer.class)
	public void loginExcelTest(User user) {
		
		assertEquals(homePage.goToLoginPage().dologinWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Raja raja");
		
	}
}

// Test Method !!!
/*
 * 1 Test script small you cannot have conditional stmts loops stmts , try catch
 * in you test method Test scripts --> Test steps Reduce the use of local
 * variables we shoud have atleast one assertion.
 */
