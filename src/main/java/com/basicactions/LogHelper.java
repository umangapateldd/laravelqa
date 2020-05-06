package com.basicactions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.utilities.FilesPaths;


public class LogHelper {
	
	private static boolean root = false;
	
	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class clss){
		
		if(root){
			return Logger.getLogger(clss);
		}
		
		if (System.getProperty("os.name").toLowerCase().equals("linux")) {
			PropertyConfigurator.configure(FilesPaths.LOG_PROPERTIES_FILE_linux);
		}else{
			PropertyConfigurator.configure(FilesPaths.LOG_PROPERTIES_FILE);
		}
		
		root = true;
		return Logger.getLogger(clss);
	}
}
