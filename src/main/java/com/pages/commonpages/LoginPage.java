package com.pages.commonpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.LogHelper;
import com.pages.adminpages.HomePage;

public class LoginPage {

	WebDriver driver;
	HomePage homePage;
	private Logger log = LogHelper.getLogger(LoginPage.class);

	@FindBy(xpath = "//input[@id='email']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "/html/body/div[3]/form/div/div/div[5]/button")
	WebElement login;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String un, String pw) {
		username.sendKeys(un);
		log.info("********************Entered the admin username********************");
		password.sendKeys(pw);
		log.info("********************Entered the admin password********************");
		login.click();
		log.info("********************Clicked on the submit button********************");
		return homePage;
	}
}