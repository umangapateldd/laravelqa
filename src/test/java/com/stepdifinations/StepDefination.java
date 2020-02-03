package com.stepdifinations;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	@And("^Click on Add button in Users grid$")
	public void Click_on_Add_button_in_Users_grid() throws Throwable {
		Thread.sleep(5000);
		usersPage.clickOnAddNewUserButton();
		Thread.sleep(3000);

	}

	@Then("^Users Add page gets open$")
	public void Users_Add_page_gets_open() throws Throwable {

		String page = "Add User";
		if (driver.findElement(By.xpath("//*[@id='frmaddedit']/div[1]/div[1]/h1")).getText().equalsIgnoreCase(page)) {

			System.out.println("Verify the title:"
					+ driver.findElement(By.xpath("//*[@id='frmaddedit']/div[1]/div[1]/h1")).getText());
		}
	}

	@And("^Verify test data with proper validation message for Users$")
	public void Verify_test_data_with_proper_validation_message_for_Users() throws Throwable {

		usersPage.clickOnSubmit();
		Thread.sleep(3000);
		String firstname = "The first name field is required.";
		String email = "The email field is required.";

		if (driver.findElement(By.xpath("//*[@id='frmaddedit']/div[2]/div/div[1]/div")).getText()
				.equalsIgnoreCase(firstname)) {
			System.out.println("Verify the validation message : "
					+ driver.findElement(By.xpath("//*[@id='frmaddedit']/div[2]/div/div[1]/div")).getText());
		}
		if (driver.findElement(By.xpath("//*[@id='frmaddedit']/div[2]/div/div[3]/div")).getText()
				.equalsIgnoreCase(email)) {
			System.out.println("Verify the validation message : "
					+ driver.findElement(By.xpath("//*[@id='frmaddedit']/div[2]/div/div[3]/div")).getText());

		}
	}

	@When("^I enter all mandatory fields for add User$")
	public void I_enter_all_mandatory_fields_for_add_User() throws Throwable {

		
		String firstname = ExcelHelper.getData(1, 0);
		String lastname = ExcelHelper.getData(1, 1);
		String email = ExcelHelper.getData(1, 2);

		usersPage.enterUserFirstName(firstname);
		usersPage.enterUserLastName(lastname);
		usersPage.enterUserEmail(email);

	}

	@And("^Click on Save button in Users$")
	public void Click_on_Save_button_in_Users() throws Throwable {

		usersPage.clickOnSubmit();
		Thread.sleep(2000);
	}

	@Then("^I should get account created successfully message on Users list page$")
	public void I_should_get_account_created_successfully_message_on_Users_list_page() throws Throwable {
		String firstname = ExcelHelper.getData(1, 0);
		String lastname = ExcelHelper.getData(1, 1);
		String message = firstname + " " + lastname + " account created successfully.";

		System.out.println("Message test:" + driver.findElement(By.xpath("//*[@id='main']/div[1]/span")).getText());
		System.out.println("Message test:" + message);

		if (driver.findElement(By.xpath("//*[@id='main']/div[1]/span")).getText().equalsIgnoreCase(message)) {
			System.out.println("Message :" + driver.findElement(By.xpath("//*[@id='main']/div[1]/span")).getText());

			Thread.sleep(5000);
		}
	}

	@And("^Verify details in Users grid$")
	public void Verify_details_in_Users_grid() throws Throwable {
		Thread.sleep(6000);
		String email = ExcelHelper.getData(1, 2);

		driver.findElement(By.xpath("//*[@id='search-btn']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@id='search']")).sendKeys(email);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='btnsearch']")).click();
		Thread.sleep(4000);
		if (driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[5]/div/a")).getText()
				.equalsIgnoreCase(email)) {
			System.out.println("User detail match "
					+ driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[5]/div/a")).getText());
			Thread.sleep(3000);
		}
	}

	@And("^Click on Edit button in Users grid$")
	public void Click_on_Edit_button_in_Users_grid() throws Throwable {
		{
			Thread.sleep(6000);
			driver.findElement(
					By.xpath("/html/body/div[2]/div[3]/div/div[2]/section/form/div/table/tbody/tr/td[9]/a")).click();
			Thread.sleep(5000);

		}
	}

	@Then("^Users Edit page gets open$")
	public void Users_Edit_page_gets_open() throws Throwable {
		String title = "Edit User";

		if (driver.findElement(By.xpath("//*[@id='frmaddedit']/div[1]/div[1]/h1")).getText().equals(title)) {
			System.out.println("Edit page title= "
					+ driver.findElement(By.xpath("//*[@id='frmaddedit']/div[1]/div[1]/h1")).getText());
		}
	}

	@When("^I enter all mandatory fields for update User$")
	public void I_enter_all_mandatory_fields_for_update_User() throws Throwable {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.users);
		String updatefirstname = ExcelHelper.getData(1, 3);
		String updatelastname = ExcelHelper.getData(1, 4);
		usersPage.enterUserFirstName(updatefirstname);
		usersPage.enterUserLastName(updatelastname);

	}

	@Then("^I should get account updated successfully message on Users list page$")
	public void I_should_get_account_updated_successfully_message_on_Users_list_page() throws Throwable {
		String updatefirstname = ExcelHelper.getData(1, 3);
		String updatelastname = ExcelHelper.getData(1, 4);
		
		String message = updatefirstname + " " + updatelastname + " account updated successfully.";
		System.out.println("Message = "+message);
		System.out.println("Message value= "+driver.findElement(By.xpath("//*[@id='main']/div[1]/span")).getText());
		
		if (driver.findElement(By.xpath("//*[@id='main']/div[1]/span")).getText().equals(message)) {
			System.out.println("messsge: = " + message);
		}
	}
}