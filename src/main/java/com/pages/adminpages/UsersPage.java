package com.pages.adminpages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

	@FindBy(xpath = "//*[@id='add-btn']")
	WebElement addNewUserButton;

	@FindBy(id = "first_name")
	WebElement userFirstName;

	@FindBy(id = "last_name")
	WebElement userLastName;

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

	@FindBy(xpath = "//*[@id='action_btns']/div/a[3]")
	WebElement deleteButton;
	
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/section/form/div/table/tbody/tr[1]/td[2]/div/input")
	WebElement checkbox;
	

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void clickOnAddNewUserButton() {
		log.info("********************Click on add new user button********************");
		addNewUserButton.click();
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

	public void clickOnSubmit() {
		log.info("********************Click on submit button********************");
		saveButton.click();
	}

	public void verifyUserDetailsTable(String userType, String baseValueForVerification) throws InterruptedException {
		verifyDetails = false;
		searchUser(userType, baseValueForVerification);
		log.info("********************" + baseValueForVerification + " => Verify " + userType
				+ " User details on table********************");

		if (driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[5]/div/a")).getText()
				.equals(CommonVariables.userData.get("userEmail"))) {
			log.info("Email is verified in table");
			if (driver.findElement(By.xpath("// *[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[4]")).getText()
					.equals(CommonVariables.userData.get("userFirstName") + " "
							+ CommonVariables.userData.get("userLastName"))) {
				verifyDetails = true;
				log.info("Firstname and Lastname are verified in table");
			} else {
				log.error("Firstname and Lastname are not verified in table");
			}
		} else {
			log.error("Email is not verified in table");
		}
	}

	public void searchUser(String userType, String baseValueForVerification) {
		searchButtonOpenSearchSection.click();
		searchTextbox.clear();
		searchTextbox.sendKeys(baseValueForVerification);
		searchButtonGetData.click();
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
	}

	public void clickOnEditButton(String baseValueForVerification) throws InterruptedException, IOException {
		if (verifyDetails == true) {
			editButton.click();
			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");
		} else {
			log.error("User verification is failed");
		}

	}

	public void clickOnDeleteButton(String baseValueForVerification) throws InterruptedException, IOException {
		if (verifyDetails == true) {
		    checkbox.click();
		    Thread.sleep(5000);
			deleteButton.click();
			Thread.sleep(5000);
			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");
		} else {
			log.error("User verification is failed");
		}

	}

	}

