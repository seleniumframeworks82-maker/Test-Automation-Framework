package com.ui.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;



public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName) {

		File xlsxFile = new File(System.getProperty("user.dir") + "//testData//"+fileName);
		XSSFWorkbook xssfWorkbook;
		List<User> userList = new ArrayList<User>();
		Row row;
		Cell emailAddress;
		Cell password;
		
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			XSSFSheet xssfSheet= xssfWorkbook.getSheet("LoginTestData");
			Iterator <Row> rowIterator =xssfSheet.iterator();
			rowIterator.next();// skipping the header column
			while (rowIterator.hasNext()) {
			 row = rowIterator.next();
			 emailAddress = row.getCell(0);
			  password = row.getCell(1);
			User user = new User(emailAddress.toString(),password.toString());
			userList.add(user);
			}
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		return userList.iterator();
		
	}

}
