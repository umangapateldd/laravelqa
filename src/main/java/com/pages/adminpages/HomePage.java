package com.pages.adminpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.LogHelper;
import com.basicactions.MouseMovement;
import com.basicactions.WaitHelper;

public class HomePage {

	WebDriver driver;
	MouseMovement mouseMovement;
	WaitHelper waitHelper;
	UsersPage usersPage;
	private Logger log = LogHelper.getLogger(HomePage.class);

	@FindBy(xpath = "//*[@id=\"main\"]/div[2]/div/div/div[2]/a")
	WebElement usersMenu;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		mouseMovement = new MouseMovement(driver);
		waitHelper = new WaitHelper(driver);
	}

	// Mouse hover on particular menu
//	public void navigateToAdmin() {
//		log.info("********************Navigate to Admin tab********************");
//		mouseMovement.mouseHover(driver.findElement(By.linkText("Admin")));
//	}	

	public UsersPage clickOnUsersMenu() {
		log.info("********************Click on Users Menu********************");
		usersMenu.click();
		return usersPage;
	}

}