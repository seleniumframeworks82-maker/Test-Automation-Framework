package com.ui.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static com.ui.constants.ENV.*;

import com.ui.utility.JSONUtility;
import com.ui.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	
	//private static final int MAX_NUMBER_OF_ATTEMPTS =Integer.parseInt(PropertiesUtil.readProperty(QA, "MAX_NUMBER_OF_ATTEMPTS"));
	private static final int MAX_NUMBER_OF_ATTEMPTS =JSONUtility.readJson(QA).getMAX_NUMBER_OF_ATTEMPTS();	
	
	private static int currentAttempt =1;
	
	public boolean retry (ITestResult result) {
		if (currentAttempt<=MAX_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		return false;
	}

}
