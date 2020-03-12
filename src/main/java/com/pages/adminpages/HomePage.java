package com.pages.adminpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.LogHelper;
import com.basicactions.MouseMovement;
import com.basicactions.WaitHelper;
import com.utilities.CommonXpath;

public class HomePage {

	WebDriver driver;
	MouseMovement mouseMovement;
	WaitHelper waitHelper;
	UsersPage usersPage;
	CommonXpath commonXpath;
	private Logger log = LogHelper.getLogger(HomePage.class);

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		mouseMovement = new MouseMovement(driver);
		waitHelper = new WaitHelper(driver);
		commonXpath = new CommonXpath(driver);
	}

	// Mouse hover on particular menu
//	public void navigateToAdmin() {
//		log.info("********************Navigate to Admin tab********************");
//		mouseMovement.mouseHover(driver.findElement(By.linkText("Admin")));
//	}	

	public UsersPage clickOnUsersMenu() {
		log.info("********************Click on Users Menu********************");
		commonXpath.usersMenu.click();
		return usersPage;
	}

}