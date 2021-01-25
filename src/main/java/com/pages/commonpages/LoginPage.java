package com.pages.commonpages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.LogHelper;
import com.pages.adminpages.HomePage;
import com.utilities.CommonFunc;
import com.utilities.CommonXpath;
import com.utilities.FilesPaths;

public class LoginPage {

	WebDriver driver;
	HomePage homePage;
	CommonFunc commonFunc;
	CommonXpath CommonXpath;

	private Logger log = LogHelper.getLogger(LoginPage.class);
	JSONParser jsonParser1 = new JSONParser();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String un, String pw) {
		
		CommonXpath.username.sendKeys(un);
		CommonXpath.password.sendKeys(pw);
		CommonXpath.login.click();
		
		return homePage;
	}

	
}