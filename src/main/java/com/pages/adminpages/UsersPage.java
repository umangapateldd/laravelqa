package com.pages.adminpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;

public class UsersPage {

	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	private Logger log = LogHelper.getLogger(UsersPage.class);
	boolean verifyDetails = false;

	@FindBy(id = "first_name")
	WebElement userFirstName;

	@FindBy(id = "last_name")
	WebElement userLastName;

	@FindBy(id = "email")
	WebElement userEmail;

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void enterUserFirstName(String firstName) {
		log.info("********************Enter User First Name********************");
		userFirstName.clear();
		userFirstName.sendKeys(firstName);
	}

	public void enterUserLastName(String lastName) {
		log.info("********************Enter User Last Name********************");
		userLastName.clear();
		userLastName.sendKeys(lastName);
	}

	public void enterUserEmail(String email) {
		log.info("********************Enter User Email********************");
		userEmail.clear();
		userEmail.sendKeys(email);
	}

}
