package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.basicactions.LogHelper;

public class ReadPropFile {

	public Properties prop = new Properties();
	Logger log = LogHelper.getLogger(ReadPropFile.class);

	public Properties readProp() {
		log.info("********************Initialization of properties file********************");
		try {
			FileInputStream fi = null;
			if (System.getProperty("os.name").toLowerCase().equals("linux")) {
				fi = new FileInputStream(FilesPaths.CONFIG_PROPERTIES_FILE_linux);
			}else{
				fi = new FileInputStream(FilesPaths.CONFIG_PROPERTIES_FILE);
			}
			prop.load(fi);
			log.info("********************Loading of config properties file********************");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public Properties readProp(String PropFilePath) {
		log.info("********************Initialization of properties file********************");
		try {
			FileInputStream fi = new FileInputStream(PropFilePath);
			prop.load(fi);
			log.info("********************Loading of PropFilePath properties file********************");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
