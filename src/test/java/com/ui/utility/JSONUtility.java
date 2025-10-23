package com.ui.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

import com.ui.constants.ENV;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility {
	
	public static Environment readJson(ENV env)
	{
		
		Gson gson = new Gson();
		//System.out.println(System.getProperty("user.dir")+"\\config\\config.json");
		File jsonFile = new File(System.getProperty("user.dir")+"//config//config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config= gson.fromJson(fileReader, Config.class);
		//System.out.println(config.getEnvironments().get("QA"));
		Environment environment = config.getEnvironments().get("QA");
		//return environment.getUrl();  
		//updated to 
		return environment;
	}
}
