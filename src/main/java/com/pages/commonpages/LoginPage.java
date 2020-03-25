package com.pages.commonpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.LogHelper;
import com.pages.adminpages.HomePage;
import com.utilities.CommonVariables;
import com.utilities.CommonXpath;

public class LoginPage {

	WebDriver driver;
	HomePage homePage;

	private Logger log = LogHelper.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String un, String pw) {
		CommonXpath.username.sendKeys(un);
		CommonVariables.email = un;
		log.info("********************Entered the admin username********************");
		CommonXpath.password.sendKeys(pw);
		log.info("********************Entered the admin password********************");
		CommonXpath.login.click();
		log.info("********************Clicked on the submit button********************");
		return homePage;
	}
}