package com.base;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserCapabilities {

	public ChromeOptions getChromeOptions() {

		DesiredCapabilities chrome = new DesiredCapabilities();

		String downloadFilepath = System.getProperty("user.dir") + "\\src\\main\\resources\\com\\extrafiles";
		System.out.println("download path = " + downloadFilepath);
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
		options.addArguments("--disable-popup-blocking");
		options.setCapability(ChromeOptions.CAPABILITY, chrome);
		chrome.setJavascriptEnabled(true);
		options.setExperimentalOption("prefs", chromePrefs);

		return options;
	}

	public FirefoxOptions getFirefoxOptions() {

		DesiredCapabilities firefox = new DesiredCapabilities();

		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);

		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("marionette", true);

		FirefoxOptions firefoxOptions = new FirefoxOptions(firefox);

		return firefoxOptions;
	}

	public InternetExplorerOptions getIExplorerCapabilities() {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, true);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setJavascriptEnabled(true);

		InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions(cap);

		return internetExplorerOptions;
	}
}
