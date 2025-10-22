package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.utility.BrowserUtility;

public class LoginTest3 {

	public static void main(String[] args) {

WebDriver wd = new ChromeDriver();
//HomePage homePage = new HomePage(wd);
//homePage.goToLoginPage();
LoginPage loginPage = new LoginPage(wd);

loginPage.dologinWith("corofak677@gta5hx.com","P@ssword123");

	}

}
