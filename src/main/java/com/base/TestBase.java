package com.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.basicactions.LogHelper;
import com.utilities.FilesPaths;

public class TestBase {

	public static WebDriver driver;
	Logger log = LogHelper.getLogger(TestBase.class);
	BrowserCapabilities browserCapabilities;

	public WebDriver launchBrowser(String BrowserName) {
		/*System.setProperty("java.library.path", System.getProperty("user.dir"));
		if (System.getProperty("os.name").toLowerCase().equals("linux")) {
			System.load(FilesPaths.EXTRA_FILES_FOLDER_linux + "chilkat.dll");
		}else{
			System.load(FilesPaths.EXTRA_FILES_FOLDER + "chilkat.dll");	
		}*/
		

		if (BrowserName.equalsIgnoreCase("chrome")) {
			log.info("********************Initializing chrome browser********************");
			browserCapabilities = new BrowserCapabilities();
			ChromeOptions cap = browserCapabilities.getChromeOptions();
			if (System.getProperty("os.name").toLowerCase().equals("linux")) {
				System.setProperty("webdriver.chrome.driver", FilesPaths.CHROME_DRIVER_linux);
			}else{
				System.setProperty("webdriver.chrome.driver", FilesPaths.CHROME_DRIVER);	
			}
			driver = new ChromeDriver(cap);
			log.info("********************Initialized chrome browser********************");

		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			log.info("********************Initializing firefox browser********************");
			browserCapabilities = new BrowserCapabilities();
			FirefoxOptions cap = browserCapabilities.getFirefoxOptions();
			System.setProperty("webdriver.gecko.driver", FilesPaths.GECKO_DRIVER_FF);
			driver = new FirefoxDriver(cap);
			log.info("********************Initialized firefox browser********************");

		} else if (BrowserName.equalsIgnoreCase("ie")) {
			log.info("********************Initializing internet explorer browser********************");
			browserCapabilities = new BrowserCapabilities();
			InternetExplorerOptions cap = browserCapabilities.getIExplorerCapabilities();
			System.setProperty("webdriver.ie.driver", FilesPaths.IE_DRIVER);
			driver = new InternetExplorerDriver(cap);
			log.info("********************Initialized internet explorer browser********************");

		} else {
			System.out.println(BrowserName + ": is not proper browser name ");
			log.info("********************Invalid browser name********************");

			try {
				throw new Exception("No Browser found exception");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return driver;
	}
}
