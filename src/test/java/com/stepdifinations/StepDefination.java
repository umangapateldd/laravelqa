package com.stepdifinations;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.basicactions.ExcelHelper;
import com.basicactions.LogHelper;
import com.basicactions.WaitHelper;
import com.pages.adminpages.HomePage;
import com.pages.adminpages.UsersPage;
import com.pages.commonpages.LoginPage;
import com.runners.HookHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
import com.utilities.CurrentDateFormat;
import com.utilities.ReadPropFile;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefination {

	WebDriver driver;

	TestBase testBase;
	ReadPropFile readPropFile;
	LoginPage loginPage;
	HomePage homePage;
	WaitHelper waitHelper;
	CommonFunc commonFunc;
	UsersPage usersPage;
	CommonWhenStepDefinations commonWhenStepDefinations;
	private Logger log = LogHelper.getLogger(StepDefination.class);

	CurrentDateFormat dateTime = new CurrentDateFormat();

	@FindBy(xpath = "//*[@id='main']/div[1]/span")
	WebElement successmsg;

	@FindBy(xpath = "//*[@id='frmaddedit']/div[1]/div[1]/h1")
	WebElement addtitle;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[1]/a/span")
	WebElement statuscolumn;

	public StepDefination() {
		driver = HookHelper.driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		commonFunc = new CommonFunc(driver);
		homePage = new HomePage(driver);
		usersPage = new UsersPage(driver);
		commonWhenStepDefinations = new CommonWhenStepDefinations();
	}

	@And("^Click on \"([^\"]*)\" button in \"([^\"]*)\"$")
	public void Click_on_Add_button_in_Users_grid(String buttonName, String moduleName) throws Throwable {

		switch (buttonName) {
		case "Add":
			usersPage.clickOnAddNewUserButton();
			break;
		case "Save":
			usersPage.clickOnSave();
			break;
		case "Edit":
			usersPage.clickOnEditButton();
			break;
		case "Delete":
			usersPage.clickOnselectcheckbox();
			usersPage.clickOnDeleteButton();
			usersPage.clickOnconfirmyesbutton();
			CommonVariables.deleteRecord = true;
			break;
		case "Save and Continue":
			usersPage.clickOnsavecontinuebutton();
			CommonVariables.saveandcontinue = true;
			break;
		default:
			log.error(buttonName + " is not defined in " + moduleName);
			break;
		}

	}

	@Then("^\"([^\"]*)\" \"([^\"]*)\" page gets open$")
	public void Users_Add_page_gets_open(String moduleName, String formName) throws Throwable {

		String page = formName + " " + moduleName;
		if (addtitle.getText().equalsIgnoreCase(page)) {

			System.out.println("Verify the title:" + addtitle.getText());
		}
	}

	@When("^I enter all mandatory fields for \"([^\"]*)\" User$")
	public void I_enter_all_mandatory_fields_for_add_User(String formName) throws Throwable {

		switch (formName) {
		case "add":
			String firstname = ExcelHelper.getData(1, 0);
			String lastname = ExcelHelper.getData(1, 1);
			String email = ExcelHelper.getData(1, 2);

			usersPage.enterUserFirstName(firstname);
			usersPage.enterUserLastName(lastname);
			usersPage.enterUserEmail(email);
			break;

		case "edit":
			String updatefirstname = ExcelHelper.getData(1, 3);
			String updatelastname = ExcelHelper.getData(1, 4);
			usersPage.enterUserFirstName(updatefirstname);
			usersPage.enterUserLastName(updatelastname);
			break;

		default:
			assert false;
			break;
		}

	}

	@Then("^I should get \"([^\"]*)\" message on \"([^\"]*)\"$")
	public void I_should_get_account_created_successfully_message_on_Users_list_page(String sucessmessage,
			String moduleName) throws Throwable {
		System.out.println("Message :" + successmsg.getText());

		if (successmsg.getText().contains("account restored successfully.")) {
			System.out.println("Message :" + successmsg.getText());

			Thread.sleep(5000);
		} else {
			if (successmsg.getText().contains(sucessmessage)) {
				System.out.println("Message :" + successmsg.getText());

				Thread.sleep(5000);
			} else {
				System.out.println("Message is not match: ");
				assert false;
			}
		}

		if (CommonVariables.saveandcontinue == true) {
			usersPage.clickOnCancelbutton();
		}
	}

	@And("^Verify details in \"([^\"]*)\"$")
	public void Verify_details_in_Users_grid(String moduleName) throws Throwable {
		Thread.sleep(6000);
		String searchText = "";
		String xpath = "";
		if (moduleName.equals(CommonVariables.users)) {
			searchText = ExcelHelper.getData(1, 2);
			xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[5]/div/a";
		} else if (moduleName.equals("Blogs")) {
			searchText = ExcelHelper.getData(1, 2);
			xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[5]";
		}
		if (CommonVariables.deleteRecord == true) {
			xpath = "//*[@id='frmlist']/table[1]/tbody[1]/tr[1]/td[1]";
		}
		commonFunc.searchRecord(searchText, xpath);
	}

	@And("^\"([^\"]*)\" is Inactive$")
	public void User_is_Inactive(String moduleName) throws Throwable {
		if (statuscolumn.getAttribute("class").equals("sort inactive ")) {
			System.out.println(
					"Value for Inactive user = " + statuscolumn.getAttribute("class").equals("sort inactive "));
		} else {
			assert false;
		}
	}

	@Then("^Make \"([^\"]*)\" \"([^\"]*)\" and verify \"([^\"]*)\"$")
	public void Make_User_Active_and_verify_error_message(String moduleName, String status, String message)
			throws Throwable {
		String Message = "The user account is not validated yet, user needs to validate his/her account.";
		Thread.sleep(3000);
		statuscolumn.click();
		Thread.sleep(3000);
		if (successmsg.getText().equals(Message)) {
			System.out.println("Messgae for Inactive user = " + successmsg.getText());

		}
	}

	@When("^I enter all mandatory fields for \"([^\"]*)\" Our Team$")
	public void I_enter_all_mandatory_fields_for_add_Our_Team(String formName) throws Throwable {

		switch (formName) {
		case "add":
			String firstname = ExcelHelper.getData(1, 0);
			String lastname = ExcelHelper.getData(1, 1);
			String email = ExcelHelper.getData(1, 2);

			usersPage.enterUserFirstName(firstname);
			usersPage.enterUserLastName(lastname);
			usersPage.enterUserEmail(email);
			break;

		case "edit":
			String updatefirstname = ExcelHelper.getData(1, 3);
			String updatelastname = ExcelHelper.getData(1, 4);
			usersPage.enterUserFirstName(updatefirstname);
			usersPage.enterUserLastName(updatelastname);
			break;

		default:
			assert false;
			break;
		}

	}

}