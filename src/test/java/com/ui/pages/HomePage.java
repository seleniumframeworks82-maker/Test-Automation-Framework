package com.ui.pages;

import  com.ui.constants.Browser;
import static com.ui.constants.ENV.QA;
import static com.ui.utility.PropertiesUtil.*;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;
import com.ui.utility.JSONUtility;
import com.ui.utility.LoggerUtility;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	// page Object Design Pattern
	// final variable are the variable values cannot be changed
//	if we creating any variable inside the page classes we try to create variables 
//	inside the page classes the first type variables will be locators using by locators
// java constant always shown with final

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);
		//goToWebsite(readProperty(QA, "URL"));
		goToWebSiteUrl(JSONUtility.readJson(QA).getUrl());
	}

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebSiteUrl(JSONUtility.readJson(QA).getUrl());
	}

	private static final By SIGIN_IN_LINK_LOCATOR = By.xpath("//a[normalize-space()='Sign in']");
	// if the variable is final it is alo going to be static
	// const value always write in uppercase

	public LoginPage goToLoginPage() { // page function we didn't write void
		logger.info("Trying to performing login on the login page ");
		logger.info("goToLoginPage");
		clickOn(SIGIN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

}
