package com.ui.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
	// global configuration/setup for logger
	// design pattern : ensure that you were using OOP in rightway
	//POJO
	/*Page Object MOdel
	 * SIngleton design pattern  DB connectivity, logger
	 */
	

 
 private LoggerUtility() {
	 
 }

 
 public static Logger getLogger(Class<?> clazz) {
		 Logger	logger = null;
	 if (logger== null) {
		 logger = LogManager.getLogger(clazz);
	 }
	 return logger;
	 
 }
}
