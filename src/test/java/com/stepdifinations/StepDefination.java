package com.stepdifinations;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
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

	public StepDefination() {
		driver = HookHelper.driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		commonFunc = new CommonFunc(driver);
		homePage = new HomePage(driver);
		usersPage = new UsersPage(driver);
		commonWhenStepDefinations = new CommonWhenStepDefinations();
	}

	@Then("^verify the \"([^\"]*)\" details \"([^\"]*)\"$")
	public void verify_the_something_details_something(String userType, String userAvailability) throws Throwable {
		switch (userType) {
		case "Users":
			usersPage.verifyUserDetailsTable("Users", CommonVariables.userData.get("userEmail"));
			if (userAvailability.equals("for update")) {
				usersPage.clickOnEditButton(CommonVariables.userData.get("userEmail"));
			} else if (userAvailability.equals("for delete")) {
				usersPage.clickOnDeleteButton(CommonVariables.userData.get("userEmail"));
			}
			break;
		default:
			System.out.println("module is not declared for verify details");
			break;
		}
	}

	@And("^admin user add new User$")
	public void admin_user_add_new_User(Map<String, String> table) throws Throwable {
		usersPage.clickOnAddNewUserButton();
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
		log.info("********************Get data from data table********************");
		String firstName = table.get("firstName");
		String lastName = table.get("lastName");
		String email = table.get("email");

		usersPage.enterUserFirstName(firstName);
		usersPage.enterUserLastName(lastName);
		usersPage.enterUserEmail(email);
		CommonVariables.userData.put("userFirstName", firstName);
		CommonVariables.userData.put("userLastName", lastName);
		CommonVariables.userData.put("userEmail", email);
		usersPage.clickOnSubmit();
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
	}

	@And("^admin user update User$")
	public void admin_user_update_User(Map<String, String> table) throws Throwable {
		log.info("********************Get data from data table********************");
		String firstName = table.get("updatefirstName");
		String lastName = table.get("updatelastName");

		usersPage.enterUserFirstName(firstName);
		usersPage.enterUserLastName(lastName);
		CommonVariables.userData.put("userFirstName", firstName);
		CommonVariables.userData.put("userLastName", lastName);
		usersPage.clickOnSubmit();
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
	}
}
