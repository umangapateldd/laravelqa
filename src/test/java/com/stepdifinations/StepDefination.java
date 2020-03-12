package com.stepdifinations;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.basicactions.ExcelHelper;
import com.basicactions.LogHelper;
import com.basicactions.WaitHelper;
import com.pages.adminpages.Blogs;
import com.pages.adminpages.Categories;
import com.pages.adminpages.Events;
import com.pages.adminpages.FAQ;
import com.pages.adminpages.HomePage;
import com.pages.adminpages.Ourteam;
import com.pages.adminpages.Pages;
import com.pages.adminpages.Settings;
import com.pages.adminpages.Testimonial;
import com.pages.adminpages.UsersPage;
import com.pages.commonpages.LoginPage;
import com.runners.HookHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
import com.utilities.CommonXpath;
import com.utilities.CurrentDateFormat;
import com.utilities.FilesPaths;
import com.utilities.ReadPropFile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
	Blogs blogs;
	Testimonial testimonial;
	Categories categories;
	FAQ faq;
	Events events;
	Pages pages;
	Settings settings;
	CommonXpath commonXpath;
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
		ourteam = new Ourteam(driver);
		blogs = new Blogs(driver);
		testimonial = new Testimonial(driver);
		categories = new Categories(driver);
		faq = new FAQ(driver);
		events = new Events(driver);
		pages = new Pages(driver);
		settings = new Settings(driver);
		commonXpath = new CommonXpath(driver);
		commonWhenStepDefinations = new CommonWhenStepDefinations();
	}

	@And("Click on {string} button in {string}")
	public void Click_on_Add_button_in_Users_grid(String buttonName, String moduleName) throws Throwable {
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
		switch (buttonName) {
		case "Add":
			commonFunc.clickOnAddNewButton();
			break;
		case "Save":
			commonFunc.clickOnSave();
			break;
		case "Edit":
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

	@Then("{string} {string} page gets open")
	public void Users_Add_page_gets_open(String moduleName, String formName) throws Throwable {
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
		String page = formName + " " + moduleName;
		String settingpage = moduleName + " " + formName;

		if (formName.equals("Settings")) {
			if (moduleName.equals(CommonVariables.blogs)) {
				if (commonXpath.blogsettingtitle.getText().equalsIgnoreCase(settingpage)) {
					System.out.println("Verify the title:" + commonXpath.blogsettingtitle.getText());
				} else {
					assert false;
				}
			} else if (moduleName.equals(CommonVariables.testimonial)) {
				if (commonXpath.testimonialsettingtitle.getText().equalsIgnoreCase(settingpage)) {
					System.out.println("Verify the title:" + commonXpath.testimonialsettingtitle.getText());
				} else {
					assert false;
				}
			} else {
				assert false;
			}
		} else if (commonXpath.addtitle.getText().equalsIgnoreCase(page)) {
			System.out.println("Verify the title:" + commonXpath.addtitle.getText());
		} else {
			assert false;
		}
	}

	@When("I enter all mandatory fields for {string} User")
	public void I_enter_all_mandatory_fields_for_add_User(String formName) throws Throwable {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.users);
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

	@Then("I should get {string} message on {string}")
	public void I_should_get_account_created_successfully_message_on_Users_list_page(String sucessmessage,
			String moduleName) throws Throwable {
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
		if (commonXpath.successmsg.getText().contains("account restored successfully.")) {
			System.out.println("Message :" + commonXpath.successmsg.getText());
		} else {
			if (commonXpath.successmsg.getText().contains(sucessmessage)) {
				System.out.println("Message :" + commonXpath.successmsg.getText());
			} else {
				System.out.println("Message is not match: ");
				assert false;
			}
		}

		if (CommonVariables.saveandcontinue == true) {
			commonFunc.clickOnCancelbutton();
			CommonVariables.saveandcontinue = false;
		}
	}

	@And("Verify details in {string}")
	public void Verify_details_in_Users_grid(String moduleName) throws Throwable {
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
		String searchText = "";
		String xpath = "";
		if (moduleName.equals(CommonVariables.users)) {
			System.out.println("Inside IF condition");
			searchText = CommonVariables.txtSearchCmnVar;
			System.out.println("Search text is :- " + searchText);
			xpath = "//table[@id='DataTables_Table_0']/tbody[1]/tr[1]/td[4]";
		} else if (moduleName.equals(CommonVariables.ourteam)) {
			searchText = CommonVariables.txtSearchCmnVar;
			xpath = "//table[@id='DataTables_Table_0']/tbody/tr[1]/td[4]//div[2][@class='title']";
		} else if (moduleName.equals(CommonVariables.blogs)) {
			searchText = CommonVariables.txtSearchCmnVar;
			xpath = "//table[@id='DataTables_Table_0']/tbody/tr[1]/td[4]/a";
		} else if (moduleName.equals(CommonVariables.testimonial)) {
			searchText = CommonVariables.txtSearchCmnVar;
			xpath = "//table[@id='DataTables_Table_0']/tbody/tr[1]/td[4]/a";
		} else if (moduleName.equals(CommonVariables.categories)) {
			searchText = CommonVariables.txtSearchCmnVar;
			xpath = "//table[@id='DataTables_Table_0']/tbody/tr[1]/td[4]/a";
		} else if (moduleName.equals(CommonVariables.faqs)) {
			searchText = CommonVariables.txtSearchCmnVar;
			xpath = "//table[@id='DataTables_Table_0']/tbody/tr[1]/td[4]";
		} else if (moduleName.equals(CommonVariables.events)) {
			searchText = CommonVariables.txtSearchCmnVar;
			xpath = "//table[@id='DataTables_Table_0']/tbody/tr[1]/td[4]/a";
		} else if (moduleName.equals(CommonVariables.pages)) {
			searchText = CommonVariables.txtSearchCmnVar;
			xpath = "//table[@id='DataTables_Table_0']/tbody/tr[1]/td[4]/a";
		} else {
			assert false;
		}

		if (CommonVariables.deleteRecord == true) {
			xpath = "//*[@id='frmlist']/table/tbody/tr/td";
			System.out.println("delete record " + driver.findElement(By.xpath(xpath)).getText());
		}

		commonFunc.searchRecord(searchText, xpath, moduleName);
	}

	@And("{string} is Inactive")
	public void User_is_Inactive(String moduleName) throws Throwable {
		if (commonXpath.statuscolumn.getAttribute("class").equals("sort inactive ")) {
			System.out
					.println("Value for Inactive user = " + commonXpath.statuscolumn.getAttribute("class").equals("sort active "));
		} else if (commonXpath.statuscolumn.getAttribute("class").equals("sort active ")) {
			System.out.println("Value for active user = " + commonXpath.statuscolumn.getAttribute("class").equals("sort active "));

		} else {
			System.out.println("Not match record:");
			assert false;
		}
	}

	@Then("Make {string} {string} and verify {string}")
	public void Make_User_Active_and_verify_error_message(String moduleName, String status, String message)
			throws Throwable {

		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");

		if (moduleName.equals(CommonVariables.users)) {
			String Message = "The user account is not validated yet, user needs to validate his/her account.";
			commonXpath.statuscolumn.click();
			if (commonXpath.successmsg.getText().equals(Message)) {
				System.out.println("Messgae for Inactive user = " + commonXpath.successmsg.getText());
			} else {
				assert false;
			}
		} else if (moduleName.equals(CommonVariables.ourteam)) {
			commonFunc.clickOnstatuscolumn("team member");
		} else if (moduleName.equals(CommonVariables.blogs)) {
			commonFunc.clickOnstatuscolumn("blog");
		} else if (moduleName.equals(CommonVariables.testimonial)) {
			commonFunc.clickOnstatuscolumn("testimonial");
		} else if (moduleName.equals(CommonVariables.categories)) {
			commonFunc.clickOnstatuscolumn("category");
		} else if (moduleName.equals(CommonVariables.faqs)) {
			commonFunc.clickOnstatuscolumn("FAQ");
		} else if (moduleName.equals(CommonVariables.events)) {
			commonFunc.clickOnstatuscolumn("event");
		} else if (moduleName.equals(CommonVariables.pages)) {
			commonFunc.clickOnstatuscolumn("page");
		}
	}

	@When("I enter all mandatory fields for {string} Our Team")
	public void I_enter_all_mandatory_fields_for_add_Our_Team(String formName) throws Throwable {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.ourteam);
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

			CommonVariables.txtSearchCmnVar = firstname + " " + lastname;

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

	@When("I enter all mandatory fields for {string} Blogs")
	public void I_enter_all_mandatory_fields_for_Add_Blogs(String formName) throws Throwable {
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.blogs);
		switch (formName) {
		case "add":
			String title = ExcelHelper.getData(1, 0);
			String blogCategory = ExcelHelper.getData(1, 1);
			String authorfirstName = ExcelHelper.getData(1, 2);
			String authorlastName = ExcelHelper.getData(1, 3);
			String image = ExcelHelper.getData(1, 4);
			String imageAlt = ExcelHelper.getData(1, 5);
//			String publishdate = ExcelHelper.getData(1, 6);
			String status = ExcelHelper.getData(1, 7);
			String description = ExcelHelper.getData(1, 8);
			String metaTitle = ExcelHelper.getData(1, 9);
			String metaDescription = ExcelHelper.getData(1, 10);

			CommonVariables.txtSearchCmnVar = title;
			CommonVariables.adminauthor = authorfirstName + " " + authorlastName;

			blogs.enterTitle(title);
			blogs.selectBlogCategory(blogCategory);
			blogs.enterAuthorFirstName(authorfirstName);
			blogs.enterAuthorLastName(authorlastName);
			blogs.selectImage(image);
			blogs.enterImageAlt(imageAlt);
			blogs.enterPublishDate();
			blogs.selectStatus(status);
			blogs.enterDescription(description);
			blogs.enterMetaTitle(metaTitle);
			blogs.enterMetaDescription(metaDescription);

			break;

		case "edit":
			String updatetitle = ExcelHelper.getData(1, 11);

			blogs.enterTitle(updatetitle);
			CommonVariables.txtSearchCmnVar = updatetitle;

			break;

		default:
			assert false;
			break;
		}
	}

	@And("{string} is {string}")
	public void User_is_Active(String moduleName, String status) throws Throwable {
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
		if (commonXpath.statuscolumn.getAttribute("class").equals("sort active ")) {
			CommonVariables.inactive = "false";
			if (status.equals("Inactive")) {
				assert false;
			}
		} else if (commonXpath.statuscolumn.getAttribute("class").equals("sort inactive ")) {
			CommonVariables.inactive = "true";
			if (status.equals("Active")) {
				assert false;
			}
		} else {
			CommonVariables.inactive = "";
			System.out.println("Not click on status column");
			assert false;
		}
	}

	@When("I enter all mandatory fields for {string} Testimonial")
	public void I_enter_all_mandatory_fields_for_Add_Testimonial(String formName) throws Throwable {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.testimonial);
		switch (formName) {
		case "add":
			String authorName = ExcelHelper.getData(1, 0);
			String url = ExcelHelper.getData(1, 1);
			String status = ExcelHelper.getData(1, 2);
			String description = ExcelHelper.getData(1, 3);
			String image = ExcelHelper.getData(1, 6);

			CommonVariables.txtSearchCmnVar = authorName;

			testimonial.enterAuthorName(authorName);
			testimonial.enterURL(url);
			testimonial.enterStatus(status);
			testimonial.enterDescription(description);
			testimonial.selectImage(image);

			break;

		case "edit":
			String updateauthorName = ExcelHelper.getData(1, 4);
			System.out.println("Excel value EDIT=" + ExcelHelper.getData(1, 4));

			testimonial.enterAuthorName(updateauthorName);
			CommonVariables.txtSearchCmnVar = updateauthorName;

			break;

		default:
			assert false;
			break;
		}
	}

	@When("Click on {string} Settings menu")
	public void Click_on_Settings_menu(String moduleName) throws Throwable {
		Thread.sleep(2000);
		if (moduleName.equals(CommonVariables.blogs)) {
			blogs.ClickonSettingmenu();
		} else if (moduleName.equals(CommonVariables.testimonial)) {
			testimonial.ClickonSettingmenu();
		} else {
			assert false;
		}
	}

	@When("I enter all mandatory fields for {string} Settings")
	public void I_enter_all_mandatory_fields_for_blogs_setting(String moduleName) throws Throwable {

		if (moduleName.equals(CommonVariables.blogs)) {

			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.blogs);

			String fieldblog = ExcelHelper.getData(1, 12);

			blogs.enterFieldblog(fieldblog);
			Thread.sleep(2000);

		} else if (moduleName.equals(CommonVariables.testimonial)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.testimonial);

			System.out.println("Excel value : " + ExcelHelper.getData(1, 5));
			String settingfield = ExcelHelper.getData(1, 5);
			System.out.println("Excel value : " + settingfield);

			testimonial.entersettingfield(settingfield);
			Thread.sleep(2000);
		} else {
			assert false;
		}
	}

	@And("Click on {string} button in {string} Settings")
	public void Click_on_Save_button_in_Blogs_Settings(String buttonName, String moduleName) throws Throwable {
		Thread.sleep(2000);
		if (moduleName.equals(CommonVariables.blogs)) {
			blogs.ClickonSettingsave();
		} else if (moduleName.equals(CommonVariables.testimonial)) {
			testimonial.ClickonSettingsave();
		} else {
			assert false;
		}
	}

	@Then("I should get {string} message on {string} Settings")
	public void I_should_get_Settings_have_been_saved_successfully_message_on_Blogs_Settings(String successmessage,
			String moduleName) throws Throwable {
		System.out.println("Message : " + successmessage);
		if (commonXpath.successmsg.getText().equals(successmessage)) {
			System.out.println("Message mathch:" + successmessage);
		} else {
			assert false;
		}
	}

	@When("I enter all mandatory fields for {string} Category")
	public void I_enter_all_mandatory_fields_for_Add_category(String formName) throws Throwable {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.categories);
		switch (formName) {
		case "add":
			String title = ExcelHelper.getData(1, 0);
			String status = ExcelHelper.getData(1, 1);
			String imageAlt = ExcelHelper.getData(1, 2);
			String image = ExcelHelper.getData(1, 3);
			String description = ExcelHelper.getData(1, 4);
			String metaTitle = ExcelHelper.getData(1, 5);
			String metaDescription = ExcelHelper.getData(1, 6);

			CommonVariables.txtSearchCmnVar = title;

			categories.enterTitle(title);
			categories.enterImage(image);
			categories.enterImageAlt(imageAlt);
			categories.enterStatus(status);
			categories.enterDescription(description);
			categories.enterMetaTitle(metaTitle);
			categories.enterMetaDescription(metaDescription);

			break;

		case "edit":
			System.out.println("value of excel =" + ExcelHelper.getData(1, 7));
			String updateTitle = ExcelHelper.getData(1, 7);

			categories.enterTitle(updateTitle);
			CommonVariables.txtSearchCmnVar = updateTitle;

			break;

		default:
			assert false;
			break;
		}
	}

	@When("I enter all mandatory fields for {string} FAQ")
	public void I_enter_all_mandatory_fields_for_Add_FAQ(String formName) throws Throwable {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.faqs);
		System.out.println("Print excel data = " + ExcelHelper.getData(1, 0));
		switch (formName) {
		case "add":
			String question = ExcelHelper.getData(1, 0);
			String status = ExcelHelper.getData(1, 1);
			String answer = ExcelHelper.getData(1, 2);

			CommonVariables.txtSearchCmnVar = question;

			faq.enterQuestion(question);
			faq.enterStatus(status);
			faq.enterAnswer(answer);

			break;

		case "edit":
			System.out.println("value of excel =" + ExcelHelper.getData(1, 3));
			String updatequestion = ExcelHelper.getData(1, 3);

			faq.enterQuestion(updatequestion);
			CommonVariables.txtSearchCmnVar = updatequestion;

			break;

		default:
			assert false;
			break;
		}
	}

	@When("I enter all mandatory fields for {string} Event")
	public void I_enter_all_mandatory_fields_for_Add_Event(String formName) throws Throwable {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.events);
		switch (formName) {
		case "add":
			String title = ExcelHelper.getData(1, 0);
			String recurrence = ExcelHelper.getData(1, 1);
			String startDate = ExcelHelper.getData(1, 2);
			String endDate = ExcelHelper.getData(1, 3);
			String eventTime = ExcelHelper.getData(1, 4);
			String status = ExcelHelper.getData(1, 5);
			String description = ExcelHelper.getData(1, 6);
			String url = ExcelHelper.getData(1, 7);
			String address1 = ExcelHelper.getData(1, 8);
			String address2 = ExcelHelper.getData(1, 9);
			String city = ExcelHelper.getData(1, 10);
			String state = ExcelHelper.getData(1, 11);
			String zipcode = ExcelHelper.getData(1, 12);
			String country = ExcelHelper.getData(1, 13);

			CommonVariables.txtSearchCmnVar = title;

			events.enterTitle(title);
			events.enterRecurrence(recurrence);
			events.enterStartDate(startDate);
			events.enterEndDate(endDate);
			events.enterEventTime(eventTime);
			events.enterStatus(status);
			events.enterDescription(description);
			events.enterURL(url);
			events.enterAddress1(address1);
			events.enterAddress2(address2);
			events.enterCity(city);
			events.enterState(state);
			events.enterZipcode(zipcode);
			events.enterCountry(country);

			break;

		case "edit":
			String updatetitle = ExcelHelper.getData(1, 14);

			events.enterTitle(updatetitle);
			Thread.sleep(2000);
			CommonVariables.txtSearchCmnVar = updatetitle;

			break;

		default:
			assert false;
			break;
		}
	}

	@When("I enter all mandatory fields for {string} Page")
	public void I_enter_all_mandatory_fields_for_Add_Page(String formName) throws Throwable {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.pages);
		switch (formName) {
		case "add":
			String title = ExcelHelper.getData(1, 0);
			String status = ExcelHelper.getData(1, 1);
			String pageContent = ExcelHelper.getData(1, 2);
			String metaTitle = ExcelHelper.getData(1, 3);
			String metaDescription = ExcelHelper.getData(1, 4);

			CommonVariables.txtSearchCmnVar = title;

			pages.enterTitle(title);
			pages.enterStatus(status);
			pages.enterPageContent(pageContent);
			pages.enterMetaTitle(metaTitle);
			pages.enterMetaDescription(metaDescription);

			break;

		case "edit":
			System.out.println("value of excel =" + ExcelHelper.getData(1, 5));
			String updateTitle = ExcelHelper.getData(1, 5);

			pages.enterTitle(updateTitle);
			CommonVariables.txtSearchCmnVar = updateTitle;

			break;

		default:
			assert false;
			break;
		}
	}

	@When("Verify details in Pages with other filters")
	public void Verify_details_in_pages_grid_with_other_filters() throws Throwable {
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
		pages.Searchfilters();
	}

	@When("Get list of pages title")
	public void Get_list_of_pages_title() throws Throwable {
		pages.Admintitle();
	}

	@When("Data update and verify details for Admin {string} section")
	public void Data_update_and_verify_details_for_Admin_Settings_section(String formName) throws Throwable {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.settings);
		// System.out.println("EXCEL VALUE PRINT : = " + ExcelHelper.getData(1,1));

		// Admin Settings
		String appName = ExcelHelper.getData(1, 1);
		String noofRecordsperPage = ExcelHelper.getData(1, 2);
		String footerTitleforAdmin = ExcelHelper.getData(1, 3);

		settings.adminSettings(appName, noofRecordsperPage, footerTitleforAdmin);

		// Front End Settings
		String sitetitle = ExcelHelper.getData(3, 1);
		String tagline = ExcelHelper.getData(3, 2);
		System.out.println("Tagline = " + ExcelHelper.getData(3, 2));
		String copyrightText = ExcelHelper.getData(3, 3);
		String metaDescription = ExcelHelper.getData(3, 4);

		settings.frontEndSettings(sitetitle, tagline, copyrightText, metaDescription);

		// Company Settings
		String companyName = ExcelHelper.getData(5, 1);
		String addressline1 = ExcelHelper.getData(5, 2);
		String addressline2 = ExcelHelper.getData(5, 3);
		String city = ExcelHelper.getData(5, 4);
		String state = ExcelHelper.getData(5, 5);
		String country = ExcelHelper.getData(5, 6);
		String zipcode = ExcelHelper.getData(5, 7);
		String phone = ExcelHelper.getData(5, 8);
		String email = ExcelHelper.getData(5, 9);
		String googlemap = ExcelHelper.getData(5, 10);

		settings.companySettings(companyName, addressline1, addressline2, city, state, country, zipcode, phone, email,
				googlemap);

		// Email Settings
		String fromName = ExcelHelper.getData(7, 1);
		String fromEmail = ExcelHelper.getData(7, 2);
		String adminEmail = ExcelHelper.getData(7, 3);

		settings.emailSettings(fromName, fromEmail, adminEmail);

		// Password Settings

		String passwordStrength = ExcelHelper.getData(9, 1);
		String loginattempt = ExcelHelper.getData(9, 2);
		String minpwdlength = ExcelHelper.getData(9, 3);
		String userBlockTime = ExcelHelper.getData(9, 4);

		settings.passwordSettings(passwordStrength, loginattempt, minpwdlength, userBlockTime);

		// Social link Settings
		String facebook = ExcelHelper.getData(11, 1);
		String twitter = ExcelHelper.getData(11, 2);
		String linkedIn = ExcelHelper.getData(11, 3);
		settings.sociallinkSettings(facebook, twitter, linkedIn);

		// Google Captcha
		String googleRecaptchaSiteKey = ExcelHelper.getData(13, 1);
		String googleRecaptchaSecertKey = ExcelHelper.getData(13, 2);
		settings.googlecaptchaSettings(googleRecaptchaSiteKey, googleRecaptchaSecertKey);

		// SEO Settings
		String robotsMetaTag = ExcelHelper.getData(15, 1);
		String googleAnalyticsCode = ExcelHelper.getData(15, 2);
		settings.SEOSettings(googleAnalyticsCode, robotsMetaTag);

	}

	@And("Verify test data with proper validation message for {string}")
	public void Verify_test_data_with_proper_validation_message_for_Users(String moduleName) throws Throwable {
		if (moduleName.equals("Users")) {
			// First Name
			commonFunc.verifyTestAllData(CommonVariables.allStrings, "//*[@id='first_name']",
					"//*[@id='frmaddedit']/div[2]/div/div[1]/div");

			// Email
			commonFunc.verifyTestEmailData(CommonVariables.email, "//*[@id='email']",
					"//*[@id='frmaddedit']/div[2]/div/div[3]/div");

		} else if (moduleName.equals("Settings")) {

			// Company Detail
			driver.findElement(By.xpath("//*[@id='site-config-heading-2']/h5/a")).click();

			commonFunc.verifyTestEmailData(CommonVariables.email, "//*[@id='company_email']",
					"//*[@id='accordion-item-2']/div/div/div[9]/div");

			// Email Settings
			driver.findElement(By.xpath("//*[@id='site-config-heading-3']/h5/a")).click();

			commonFunc.verifyTestEmailData(CommonVariables.email, "//*[@id='from_email']",
					"//*[@id='accordion-item-3']/div/div/div[2]/div");

		} else if (moduleName.equals("Our Team")) {
			System.out.println("modulename = " + moduleName);
			// First Name
			commonFunc.verifyTestAllData(CommonVariables.allStrings, "//*[@id='first_name']",
					"//*[@id='frmaddedit']/div[2]/div/div[1]/div");

			// Last Name
			commonFunc.verifyTestAllData(CommonVariables.allStrings, "//*[@id='last_name']",
					"//*[@id='frmaddedit']/div[2]/div/div[2]/div");

		} else if (moduleName.equals("Categories")) {
			System.out.println("modulename = " + moduleName);
			// Title
			commonFunc.verifyTestAllData(CommonVariables.allStrings, "//*[@id='title']",
					"//*[@id='frmaddedit']/div[2]/div/div[1]/div");

		} else if (moduleName.equals("Testimonials")) {
			System.out.println("modulename = " + moduleName);
			// Title
			commonFunc.verifyTestAllData(CommonVariables.allStrings, "//*[@id='client_name']",
					"//*[@id='frmaddedit']/div[2]/div/div[1]/div");

		} else if (moduleName.equals("Blogs")) {
			System.out.println("modulename = " + moduleName);
			// Title
			commonFunc.verifyTestAllData(CommonVariables.allStrings, "//*[@id='title']",
					"//*[@id='frmaddedit']/div[2]/div/div[1]/div");

		} else if (moduleName.equals("FAQs")) {
			System.out.println("modulename = " + moduleName);
			// Title
			commonFunc.verifyTestAllData(CommonVariables.allStrings, "//*[@id='question']",
					"//*[@id='frmaddedit']/div[2]/div/div[1]/div");
			
		} else if (moduleName.equals("Events")) {
			System.out.println("modulename = " + moduleName);
			// Title
			commonFunc.verifyTestAllData(CommonVariables.allStrings, "//*[@id='title']",
					"//*[@id='frmaddedit']/div[2]/div/div[1]/div");
		}

	}

}
