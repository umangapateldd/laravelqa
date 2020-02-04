package com.stepdifinations;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

	@And("^Click on \"([^\"]*)\" button in \"([^\"]*)\"$")
	public void Click_on_Add_button_in_Users_grid(String buttonName, String moduleName) throws Throwable {

		switch (buttonName) {
		case "Add":
			usersPage.clickOnAddNewUserButton();
			break;
		case "Save":
			usersPage.clickOnAddNewUserButton();
			break;
		default:
			log.error(buttonName + " is not defined in " + moduleName);
			break;
		}

	}

	@Then("^\"([^\"]*)\" \"([^\"]*)\" page gets open$")
	public void Users_Add_page_gets_open(String moduleName, String formName) throws Throwable {

		String page = formName + " " + moduleName;
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
			driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/section/form/div/table/tbody/tr/td[9]/a"))
					.click();
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

		if (driver.findElement(By.xpath("//*[@id='main']/div[1]/span")).getText().equals(message)) {
			System.out.println("messsge: = " + message);
		}
	}

	@And("^User is Inactive$")
	public void User_is_Inactive() throws Throwable {

		String classname = "sort inactive";

		if (driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[1]/a/span")).getAttribute("class")
				.equals("sort inactive ")) {
			System.out.println("Value for Inactive user = "
					+ driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[1]/a/span"))
							.getAttribute("class").equals("sort inactive "));
		}
	}

	@Then("^Make User Active and verify error message$")
	public void Make_User_Active_and_verify_error_message() throws Throwable {
		String Message = "The user account is not validated yet, user needs to validate his/her account.";
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[1]/a/span")).click();
		Thread.sleep(3000);
		if (driver.findElement(By.xpath("//*[@id='main']/div[1]/span")).getText().equals(Message)) {
			System.out.println("Messgae for Inactive user = "
					+ driver.findElement(By.xpath("//*[@id='main']/div[1]/span")).getText());

		}
	}

	@And("^Click on Delete button in Users grid$")
	public void Click_on_Delete_button_in_Users_grid() throws Throwable {
//		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('class')", driver.findElement(
//				By.xpath("/html/body/div[2]/div[3]/div/div[2]/section/form/div/table/tbody/tr/td[2]/div/input")));
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[2]/div/label")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id='action_btns']/div/a[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='confirm-action-submit']")).click();
		Thread.sleep(3000);

	}

	@Then("^I should get acccount has been deleted successfully message on Users list page$")
	public void I_should_get_acccount_has_been_deleted_successfully_message_on_Users_list_page() throws Throwable {
		String message = "Selected user(s) acccount has been deleted successfully.";

		if (driver.findElement(By.xpath("//*[@id='main']/div[1]/span")).getText().equals(message)) {
			System.out.println("Message = " + driver.findElement(By.xpath("//*[@id='main']/div[1]/span")).getText());
		}

	}

	@Then("^Verify details in Users grid after delete$")
	public void Verify_details_in_Users_grid_after_delete() throws Throwable {
		String email = ExcelHelper.getData(1, 2);

		driver.findElement(By.xpath("//*[@id='search-btn']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@id='search']")).sendKeys(email);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='btnsearch']")).click();
		Thread.sleep(4000);

	}

	@And("^Click on Save and Continue button in Users$")
	public void Click_on_Save_and_Continue_button_in_Users() throws Throwable {
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[@value='savecontinue']")).click();
		Thread.sleep(2000);

	}

	@Then("^I should get added successfully message on Users Edit page$")
	public void I_should_get_added_successfully_message_on_Users_Edit_page() throws Throwable {
		String firstname = ExcelHelper.getData(1, 0);
		String lastname = ExcelHelper.getData(1, 1);
		String message = firstname + " " + lastname + " account created successfully.";

		System.out.println("messsge: = " + message);
		System.out.println("Message :" + driver.findElement(By.xpath("//*[@id='main']/div[1]/span")).getText());

		if (driver.findElement(By.xpath("//*[@id='main']/div[1]/span")).getText().equals(message)) {
			System.out.println("messsge: = " + message);
			System.out.println("Message :" + driver.findElement(By.xpath("//*[@id='main']/div[1]/span")).getText());
			System.out.println("Message :" + message);

			Thread.sleep(5000);

			driver.findElement(By.xpath("//*[@id='frmaddedit']/div[1]/div[2]/div/div/a")).click();
			Thread.sleep(6000);
		}

	}
}
