package com.ui.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.ui.constants.Browser;

public abstract class BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); // instance variable always credted in heap memeory
	// job of the constuctor used to insitiate the instance variable

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);; // intialize the the instance variable

	}	

	
	public void setDriver(WebDriver driver) {
		this.driver.set(driver); 
	}

	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set( new EdgeDriver());
		} else {
			logger.error("invalid browser name .. please enter correct browser Name");
			System.err.println("invalid browser name .. please enter correct browser Name");
		}
	}
	
	public BrowserUtility(Browser browserName) {
		logger.info("Lounching brouser"+ browserName);
		if (browserName==Browser.CHROME) {
			driver.set(new ChromeDriver()); 
		}
		else if (browserName==Browser.EDGE) {
			driver.set(new EdgeDriver());  
			}
		else if (browserName==Browser.FIREFOX) {
			driver.set(new FirefoxDriver());  
			}

	}

	public BrowserUtility(Browser browserName,boolean isHeadless) {
		logger.info("opening browser "+ browserName);
		if (browserName == Browser.CHROME )
		if (isHeadless){
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--headless=new");
			options.addArguments("--window-size=1920,1080");
			driver.set(new ChromeDriver(options));
		}else {
			driver.set(new ChromeDriver());
		}
		else if (browserName == Browser.EDGE)
		if (isHeadless){
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--headless=old");
			options.addArguments("disabled-gpu");			
			driver.set( new EdgeDriver(options));
		} else {
			driver.set(new EdgeDriver());
		}
		 else if (browserName == Browser.FIREFOX)
		 if(isHeadless){
			 FirefoxOptions options = new FirefoxOptions();
			 options.addArguments("--headless=old");
			driver.set(new FirefoxDriver(options));
		} else {
			driver.set(new FirefoxDriver());
		}
	}

	public void goToWebSiteUrl(String url) {
		logger.info("visting the website"+url );
		driver.get().get(url);
	}

	public void maxmimizeWindow() {
		logger.info("visting the website and maxmimizeWindow" );
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding the element with locator"+locator );
		WebElement element = driver.get().findElement(locator);
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding found entering the text "+textToEnter );
		WebElement element = driver.get().findElement(locator);
		element.clear();
		element.sendKeys(textToEnter);

	}

	public String getVisibleText(By locator) {
		logger.info("Finding element with locator  "+ locator );
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}
	
	public String takeScreenShot(String fName) {
		
		TakesScreenshot screenshot =(TakesScreenshot)driver.get();
		File screenshotdata = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timestamp = format.format(date);
		String path = System.getProperty("user.dir")+"//screenshots//"+ fName+ " - "+timestamp+".png";
		File screenshotFile = new File (path);
		try {
			FileUtils.copyFile(screenshotdata,screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
		
	}
	public void quit() {
	    logger.info("Closing the browser");
	    getDriver().quit();      // close the browser
	    setDriver(null);         // clean up the ThreadLocal reference (optional but recommended)
	}
}
