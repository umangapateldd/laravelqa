package com.pages.adminpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
import com.utilities.CommonXpath;

public class Changepassword {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	CommonXpath commonXpath;
	private Logger log = LogHelper.getLogger(Events.class);
	boolean verifyDetails = false;

	public Changepassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		commonXpath = new CommonXpath(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void entercurrentpwd(String password) {
		log.info("********************Enter the Author Name********************");
		commonXpath.currentpwd.clear();
		commonXpath.currentpwd.sendKeys(password);
	}

	public void enternewpwd(String newpassword) {
		log.info("********************Enter the URL********************");
		commonXpath.newpwd.clear();
		commonXpath.newpwd.sendKeys(newpassword);
	}

	public void enterconfirmpwd(String passwordconfirm) {
		log.info("********************Enter the URL********************");
		commonXpath.passwordconfirm.sendKeys(passwordconfirm);
	}

}
