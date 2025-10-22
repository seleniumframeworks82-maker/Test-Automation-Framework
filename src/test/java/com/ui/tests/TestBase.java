package com.ui.tests;

import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.ui.constants.Browser.*;

import com.ui.constants.Browser;
import com.ui.pages.HomePage;

import com.ui.utility.BrowserUtility;
import com.ui.utility.LambdaTestUtility;
import com.ui.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;
	private boolean isHeadless = true;

	@Parameters({"broswer","isLambdaTest","isHeadless"})
	@BeforeMethod(description = "Load the Homepage of website")
	public void setup(
			@Optional("chrome") String browser,
			@Optional("false") boolean isLambdaTest,
			@Optional("true") boolean isHeadless,ITestResult result) {
		this.isLambdaTest= isLambdaTest;
		WebDriver lambdadriver;
		if (isLambdaTest) {
			lambdadriver = LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdadriver);
		} else {
			logger.info("Loading the Homepage of the website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);

		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "TearDown the browser")
	public void tearDown() {
		if(isLambdaTest) {
		LambdaTestUtility.quitSession();
	}
	else {
		homePage.quit();
	}
	
}
}