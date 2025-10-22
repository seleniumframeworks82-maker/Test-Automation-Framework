package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {

WebDriver wd = new ChromeDriver();
// chromedriver is the class
//class is the rule imposed on object
// anything exists in reality occupy space  object 
/*
 * classes are rules
 * objects are real world entities, objects will always follow rules
 * loose coupling 
 * tight coupling is like an house or appartment if i want ot connvert into 
 * Webdriver is interface , parent entity
 * wd is reference variable unqiue identification
 * when ever u create an object of chromedriver object it will launch the chrome browser session is created 
 * 
 */
// url is hard coded
wd.get("http://www.automationpractice.pl/index.php");
//maximize browser window
wd.manage().window().maximize();
//wd.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();

/*
 * by class is ststic in nature 
 * xpath,id every thing \
 * when every we going to create By type returns by type
 * findelement requires by type element
 * 
 */


//below code is duplicate
// test data is directly attached to the test or hard coded
//Naming Convention for method class variables
// EXception handling 
//Synchronization is not there
// better to use explict wait or fulent wait
///Assertion are missing
///// Abstraction  /// we need to call wrapper class 
///install sonarlint from help m
///

By SiginLocator = By.xpath("//a[normalize-space()='Sign in']");
WebElement sigInLinkWebElement= wd.findElement(SiginLocator);  // find the element
sigInLinkWebElement.click();


By EmailLocator = By.xpath("//input[@id='email']");
WebElement EmailEditElement= wd.findElement(EmailLocator);
EmailEditElement.clear();
EmailEditElement.sendKeys("corofak677@gta5hx.com");

By PwdLocator = By.xpath("//input[@id='passwd']");
WebElement PwdEditElement= wd.findElement(PwdLocator);
PwdEditElement.sendKeys("P@ssword123");

By SiginbtnLocator = By.xpath("//button[@id='SubmitLogin']");
WebElement SiginbtnElement = wd.findElement(SiginbtnLocator);
SiginbtnElement.click();


	}

}
