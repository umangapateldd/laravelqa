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

public class Ourteam {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	private Logger log = LogHelper.getLogger(Ourteam.class);
	boolean verifyDetails = false;

	@FindBy(xpath = "//*[@id='add-btn']")
	WebElement addNewUserButton;

	@FindBy(id = "first_name")
	WebElement userFirstName;

	@FindBy(id = "last_name")
	WebElement userLastName;
	
	@FindBy(id = "//*[@id='position']")
	WebElement position;

	@FindBy(id = "//*[@id='linkedin']")
	WebElement linkedin;
	
	@FindBy(id = "//*[@id='status']/option[1]")
	WebElement status;
	
	@FindBy(id = "//*[@id='short_bio']")
	WebElement ShortBio;
	
	@FindBy(id = "email")
	WebElement userEmail;

	@FindBy(xpath = "//button[@value='save']")
	WebElement saveButton;

	@FindBy(id = "search-btn")
	WebElement searchButtonOpenSearchSection;

	@FindBy(id = "search")
	WebElement searchTextbox;

	@FindBy(id = "btnsearch")
	WebElement searchButtonGetData;

	@FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[9]/a")
	WebElement editButton;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/section/form/div/table/tbody/tr[1]/td[2]/div/input")
	WebElement checkbox;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[2]/div/label")
	WebElement selectcheckbox;

	@FindBy(xpath = "//*[@id='confirm-action-submit']")
	WebElement confirmyesbutton;

	@FindBy(xpath = "//*[@id='action_btns']/div/a[3]")
	WebElement deletebutton;

	@FindBy(xpath = "//button[@value='savecontinue']")
	WebElement savecontinueButton;
	
	@FindBy(xpath ="//*[@id='frmaddedit']/div[1]/div[2]/div/div/a")
	WebElement CancelButton;

	public Ourteam(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void clickOnAddNewUserButton() {
		log.info("********************Click on add new user button********************");
		addNewUserButton.click();
	}

	public void clickOnEditButton() {
		log.info("********************Click on edit button********************");
		editButton.click();
	}

	public void clickOnselectcheckbox() {
		log.info("********************Click on select checkbox button********************");
		selectcheckbox.click();
	}

	public void clickOnDeleteButton() {
		log.info("********************Click on delete button********************");
		deletebutton.click();
	}

	public void clickOnconfirmyesbutton() {
		log.info("********************Click on confirm yes button********************");
		confirmyesbutton.click();
	}
	
	public void clickOnCancelbutton() throws InterruptedException {
		log.info("********************Click on confirm yes button********************");
		Thread.sleep(5000);
		CancelButton.click();
		Thread.sleep(5000);
	}

	public void clickOnsavecontinuebutton() throws InterruptedException {
		log.info("********************Click on save and continue button********************");
		Thread.sleep(5000);
		savecontinueButton.click();
		Thread.sleep(2000);
		
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

	public void clickOnSave() {
		log.info("********************Click on submit button********************");
		saveButton.click();
	}


}
