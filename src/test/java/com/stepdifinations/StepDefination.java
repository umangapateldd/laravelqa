package com.stepdifinations;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.basicactions.ExcelHelper;
import com.basicactions.LogHelper;
import com.basicactions.WaitHelper;
import com.pages.adminpages.HomePage;
import com.pages.adminpages.Ourteam;
import com.pages.adminpages.UsersPage;
import com.pages.commonpages.LoginPage;
import com.runners.HookHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
import com.utilities.CurrentDateFormat;
import com.utilities.FilesPaths;
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
	Ourteam ourteam;
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
		ourteam = new Ourteam(driver);
		commonWhenStepDefinations = new CommonWhenStepDefinations();
	}

	@And("^Click on \"([^\"]*)\" button in \"([^\"]*)\"$")
	public void Click_on_Add_button_in_Users_grid(String buttonName, String moduleName) throws Throwable {

		switch (buttonName) {
		case "Add":
			commonFunc.clickOnAddNewButton();
			break;
		case "Save":
			commonFunc.clickOnSave();
			break;
		case "Edit":
//			CommonVariables.OurTeam = true;
			commonFunc.clickOnEditButton(moduleName);
			break;
		case "Delete":
			commonFunc.clickOnselectcheckbox();
			commonFunc.clickOnDeleteButton();
			commonFunc.clickOnconfirmyesbutton();
			CommonVariables.deleteRecord = true;
			break;
		case "Save and Continue":
			commonFunc.clickOnsavecontinuebutton();
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

			CommonVariables.txtSearchCmnVar = firstname + " " + lastname;

			usersPage.enterUserFirstName(firstname);
			usersPage.enterUserLastName(lastname);
			usersPage.enterUserEmail(email);
			break;

		case "edit":
			String updatefirstname = ExcelHelper.getData(1, 3);
			String updatelastname = ExcelHelper.getData(1, 4);

			CommonVariables.txtSearchCmnVar = updatefirstname + " " + updatelastname;

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
			commonFunc.clickOnCancelbutton();
		}
	}

	@And("^Verify details in \"([^\"]*)\"$")
	public void Verify_details_in_Users_grid(String moduleName) throws Throwable {
		Thread.sleep(1000);
		String searchText = "";
		String xpath = "";
		;
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.users);
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.ourteam);
		if (moduleName.equals(CommonVariables.users)) {
			System.out.println("Inside IF condition");
			searchText = ExcelHelper.getData(1, 2);
			System.out.println("Search text is :- " + searchText);
			xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[5]/div/a";
		} else if (moduleName.equals(CommonVariables.ourteam)) {
			searchText = CommonVariables.txtSearchCmnVar;
			xpath = "//*[@id='DataTables_Table_0_wrapper']/table/tbody/tr[1]/td[4]//div[2][@class='title']";
		}
		if (CommonVariables.deleteRecord == true) {
			xpath = "//*[@id='frmlist']/table[1]/tbody[1]/tr[1]/td[1]";
		}
		commonFunc.searchRecord(searchText, xpath, moduleName);
	}

	@And("^\"([^\"]*)\" is Inactive$")
	public void User_is_Inactive(String moduleName) throws Throwable {
		if (statuscolumn.getAttribute("class").equals("sort inactive ")) {
			System.out
					.println("Value for Inactive user = " + statuscolumn.getAttribute("class").equals("sort active "));
		} else if (statuscolumn.getAttribute("class").equals("sort active ")) {
			System.out
					.println("Value for Inactive user = " + statuscolumn.getAttribute("class").equals("sort active "));

		} else {
			System.out.println("Not match record:");
		}
	}

	@Then("^Make \"([^\"]*)\" \"([^\"]*)\" and verify \"([^\"]*)\"$")
	public void Make_User_Active_and_verify_error_message(String moduleName, String status, String message)
			throws Throwable {

		if (moduleName.equals(CommonVariables.users)) {
		
			String Message = "The user account is not validated yet, user needs to validate his/her account.";
			Thread.sleep(3000);
			statuscolumn.click();
			Thread.sleep(3000);
			if (successmsg.getText().equals(Message)) {
				System.out.println("Messgae for Inactive user = " + successmsg.getText());
			}
		} else if (moduleName.equals(CommonVariables.ourteam)) {
			
			String Msg = "The team member successfully inactivated.";
			String Msg2 = "The team member successfully activated.";
			Thread.sleep(3000);

			statuscolumn.click();
			Thread.sleep(3000);
			System.out.println("msg: =" + successmsg.getText());
			System.out.println("msg1 =" + Msg);

			if (successmsg.getText().equals(Msg)) {
				System.out.println("Messgae for active user = " + successmsg.getText());
			} else if (successmsg.getText().equals(Msg2)) {
				System.out.println("Messgae for active user = " + successmsg.getText());
			} else {
				System.out.println("Message is not match:");
				assert false;

			}
		}
	}

	@When("^I enter all mandatory fields for \"([^\"]*)\" Our Team$")
	public void I_enter_all_mandatory_fields_for_add_Our_Team(String formName) throws Throwable {

		switch (formName) {
		case "add":
			String firstname = ExcelHelper.getData(1, 0);
			String lastname = ExcelHelper.getData(1, 1);
			String position = ExcelHelper.getData(1, 2);
			String linkdin = ExcelHelper.getData(1, 3);
			String status = ExcelHelper.getData(1, 4);
			String shortBio = ExcelHelper.getData(1, 5);
			String additionalBio = ExcelHelper.getData(1, 6);
			String image = ExcelHelper.getData(1, 7);
			String imageAlt = ExcelHelper.getData(1, 8);

			ourteam.enterFirstName(firstname);
			ourteam.enterLastName(lastname);
			ourteam.enterPosition(position);
			ourteam.enterLinkedin(linkdin);
			ourteam.enterStatus(status);
			ourteam.enterShortBio(shortBio);
			ourteam.enterAdditionalBio(additionalBio);
			Thread.sleep(2000);
			ourteam.enterImage(image);
			ourteam.enterImageAlt(imageAlt);

			CommonVariables.txtSearchCmnVar = firstname + " " + lastname;

			break;

		case "edit":
			String updatefirstname = ExcelHelper.getData(1, 9);
			String updatelastname = ExcelHelper.getData(1, 10);
			ourteam.enterFirstName(updatefirstname);
			ourteam.enterLastName(updatelastname);
			CommonVariables.txtSearchCmnVar = updatefirstname + " " + updatelastname;
			
			break;

		default:
			assert false;
			break;
		}

	}


	@When("^I enter all mandatory fields for \"([^\"]*)\" Blogs$")
	public void I_enter_all_mandatory_fields_for_Add_Blogs(String formName) throws Throwable {

		switch (formName) {
		case "add":
			String title = ExcelHelper.getData(1, 0);
			String lastname = ExcelHelper.getData(1, 1);
			String email = ExcelHelper.getData(1, 2);

			usersPage.enterUserFirstName(title);
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
	@And("^\"([^\"]*)\" is \"([^\"]*)\"$")
	public void User_is_Active(String moduleName, String status) throws Throwable {
		if (statuscolumn.getAttribute("class").equals("sort active ")) {

			statuscolumn.click();

		} else if (statuscolumn.getAttribute("class").equals("sort inactive ")) {

			statuscolumn.click();

		} else {
			System.out.println("Not click on status column");
			assert false;
		}

	}

}