package com.pages.adminpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
import com.utilities.CommonXpath;

public class UsersPage {

	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	CommonXpath commonXpath;

	private Logger log = LogHelper.getLogger(UsersPage.class);
	boolean verifyDetails = false;


	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		commonXpath = new CommonXpath(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void enterUserFirstName(String firstName) {
		log.info("********************Enter User First Name********************");
		commonXpath.FirstName.clear();
		commonXpath.FirstName.sendKeys(firstName);
		commonXpath.FirstName.sendKeys(Keys.TAB);
	}

	public void enterUserLastName(String lastName) {
		log.info("********************Enter User Last Name********************");
		commonXpath.LastName.clear();
		commonXpath.LastName.sendKeys(lastName);
		commonXpath.LastName.sendKeys(Keys.TAB);
	}

	public void enterUserEmail(String email) {
		log.info("********************Enter User Email********************");
		commonXpath.userEmail.clear();
		commonXpath.userEmail.sendKeys(email);
		commonXpath.userEmail.sendKeys(Keys.TAB);
	}

}
