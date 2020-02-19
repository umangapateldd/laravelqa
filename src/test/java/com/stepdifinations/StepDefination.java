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
	Blogs blogs;
	Testimonial testimonial;
	Categories categories;
	FAQ faq;
	Events events;
	Pages pages;
	Settings settings;
	CommonWhenStepDefinations commonWhenStepDefinations;
	private Logger log = LogHelper.getLogger(StepDefination.class);

	CurrentDateFormat dateTime = new CurrentDateFormat();

	@FindBy(xpath = "//*[@id='main']/div[1]/span")
	WebElement successmsg;

	@FindBy(xpath = "//*[@id='frmaddedit']/div[1]/div[1]/h1")
	WebElement addtitle;

	@FindBy(xpath = "//*[@id='site-config-heading-12']/h5/a")
	WebElement blogsettingtitle;

	@FindBy(xpath = "//*[@id='site-config-heading-11']/h5/a")
	WebElement testimonialsettingtitle;

	@FindBy(xpath = "//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]/a[1]/span[1]")
	WebElement statuscolumn;

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
		String settingpage = moduleName + " " + formName;

		if (formName.equals("Settings")) {
			if (moduleName.equals(CommonVariables.blogs)) {
				if (blogsettingtitle.getText().equalsIgnoreCase(settingpage)) {
					System.out.println("Verify the title:" + blogsettingtitle.getText());
				} else {
					assert false;
				}
			} else if (moduleName.equals(CommonVariables.testimonial)) {
				if (testimonialsettingtitle.getText().equalsIgnoreCase(settingpage)) {
					System.out.println("Verify the title:" + testimonialsettingtitle.getText());
				} else {
					assert false;
				}
			} else {
				assert false;
			}
		} else if (addtitle.getText().equalsIgnoreCase(page)) {
			System.out.println("Verify the title:" + addtitle.getText());
		} else {
			assert false;
		}
	}

	@When("^I enter all mandatory fields for \"([^\"]*)\" User$")
	public void I_enter_all_mandatory_fields_for_add_User(String formName) throws Throwable {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.users);
		switch (formName) {
		case "add":
			String firstname = ExcelHelper.getData(1, 0);
			String lastname = ExcelHelper.getData(1, 1);
			String email = ExcelHelper.getData(1, 2);

			CommonVariables.txtSearchCmnVar = email;

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
		if (moduleName.equals(CommonVariables.users)) {
			System.out.println("Inside IF condition");
			searchText = CommonVariables.txtSearchCmnVar;
			System.out.println("Search text is :- " + searchText);
			xpath = "//table[@id='DataTables_Table_0']/tbody[1]/tr[1]/td[5]/div/a[1]";
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

	@And("^\"([^\"]*)\" is Inactive$")
	public void User_is_Inactive(String moduleName) throws Throwable {
		if (statuscolumn.getAttribute("class").equals("sort inactive ")) {
			System.out
					.println("Value for Inactive user = " + statuscolumn.getAttribute("class").equals("sort active "));
		} else if (statuscolumn.getAttribute("class").equals("sort active ")) {
			System.out.println("Value for active user = " + statuscolumn.getAttribute("class").equals("sort active "));

		} else {
			System.out.println("Not match record:");
			assert false;
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
			} else {
				assert false;
			}
		} else if (moduleName.equals(CommonVariables.ourteam)) {

			String Msg = "";
			String Msg2 = "";
			Thread.sleep(3000);

			if (CommonVariables.inactive.equals("false")) {
				Msg = "The team member successfully inactivated";
			} else if (CommonVariables.inactive.equals("true")) {
				Msg2 = "The team member successfully activated.";
			} else {
				System.out.println("Message is not match:");
				assert false;
			}

			statuscolumn.click();
			Thread.sleep(3000);

			if (successmsg.getText().equals(Msg)) {
				System.out.println("Messgae for inactive ourteam = " + successmsg.getText());
			} else if (successmsg.getText().equals(Msg2)) {
				System.out.println("Messgae for active ourteam = " + successmsg.getText());
			} else {
				assert false;
			}
		}

		else if (moduleName.equals(CommonVariables.blogs)) {

			String blogsmsg = "";

			String blogmsg2 = "";

			if (CommonVariables.inactive.equals("false")) {
				blogsmsg = "The blog successfully inactivated.";
			} else if (CommonVariables.inactive.equals("true")) {
				blogmsg2 = "The blog successfully activated.";
			} else {
				System.out.println("Blog1 Message is not match:");
				assert false;
			}

			statuscolumn.click();
			Thread.sleep(3000);

			if (successmsg.getText().equals(blogsmsg)) {
				System.out.println("Messgae for active blogs = " + blogsmsg);
			} else if (successmsg.getText().equals(blogmsg2)) {
				System.out.println("Messgae for inactive blogs = " + blogmsg2);
			} else {
				System.out.println("Blog2 Message is not match:");
				assert false;
			}

		} else if (moduleName.equals(CommonVariables.testimonial)) {
			String testimonialsmsg = "";
			String testimonialmsg2 = "";
			if (CommonVariables.inactive.equals("false")) {
				testimonialsmsg = "The testimonial successfully inactivated.";
			} else if (CommonVariables.inactive.equals("true")) {
				testimonialmsg2 = "The testimonial successfully activated.";
			} else {
				assert false;
			}

			statuscolumn.click();
			Thread.sleep(3000);

			if (successmsg.getText().equals(testimonialsmsg)) {
				System.out.println("Messgae for active testimonial = " + testimonialsmsg);
			} else if (successmsg.getText().equals(testimonialmsg2)) {
				System.out.println("Messgae for inactive testimonial = " + testimonialmsg2);
			} else {
				System.out.println("testimonial Message is not match:");
				assert false;
			}
		}

		else if (moduleName.equals(CommonVariables.categories)) {
			String categorymsg = "";
			String categorymsg2 = "";
			if (CommonVariables.inactive.equals("false")) {
				categorymsg = "The category successfully inactivated.";
			} else if (CommonVariables.inactive.equals("true")) {
				categorymsg2 = "The category successfully activated.";
			} else {
				assert false;
			}

			statuscolumn.click();
			Thread.sleep(3000);

			if (successmsg.getText().equals(categorymsg)) {
				System.out.println("Messgae for active Categories = " + categorymsg);
			} else if (successmsg.getText().equals(categorymsg2)) {
				System.out.println("Messgae for inactive Categories = " + categorymsg2);
			} else {
				System.out.println("categories Message is not match:");
				assert false;
			}
		} else if (moduleName.equals(CommonVariables.faqs)) {
			String faqsmsg = "";
			String faqsmsg2 = "";
			if (CommonVariables.inactive.equals("false")) {
				faqsmsg = "The FAQ successfully inactivated.";
			} else if (CommonVariables.inactive.equals("true")) {
				faqsmsg2 = "The FAQ successfully activated.";
			} else {
				assert false;
			}

			statuscolumn.click();
			Thread.sleep(3000);

			if (successmsg.getText().equals(faqsmsg)) {
				System.out.println("Messgae for active faqsmsg = " + faqsmsg);
			} else if (successmsg.getText().equals(faqsmsg2)) {
				System.out.println("Messgae for inactive faqsmsg = " + faqsmsg2);
			} else {
				System.out.println("FAQ Message is not match:");
				assert false;
			}
		} else if (moduleName.equals(CommonVariables.events)) {
			String eventsmsg = "";
			String eventsmsg2 = "";
			if (CommonVariables.inactive.equals("false")) {
				eventsmsg = "The event successfully inactivated.";
			} else if (CommonVariables.inactive.equals("true")) {
				eventsmsg = "The event successfully activated.";
			} else {
				assert false;
			}

			statuscolumn.click();
			Thread.sleep(3000);

			if (successmsg.getText().equals(eventsmsg)) {
				System.out.println("Messgae for active  = " + eventsmsg);
			} else if (successmsg.getText().equals(eventsmsg2)) {
				System.out.println("Messgae for inactive  = " + eventsmsg2);
			} else {
				System.out.println("Event Message is not match:");
				assert false;
			}
		} else if (moduleName.equals(CommonVariables.pages)) {
			String pagessmsg = "";
			String pagessmsg2 = "";
			if (CommonVariables.inactive.equals("false")) {
				pagessmsg = "The page successfully inactivated.";
			} else if (CommonVariables.inactive.equals("true")) {
				pagessmsg2 = "The page successfully activated.";
			} else {
				assert false;
			}

			statuscolumn.click();
			Thread.sleep(3000);

			if (successmsg.getText().equals(pagessmsg)) {
				System.out.println("Messgae for active  = " + pagessmsg);
			} else if (successmsg.getText().equals(pagessmsg2)) {
				System.out.println("Messgae for inactive  = " + pagessmsg2);
			} else {
				System.out.println("Pages Message is not match:");
				assert false;
			}
		}
	}

	@When("^I enter all mandatory fields for \"([^\"]*)\" Our Team$")
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

	@When("^I enter all mandatory fields for \"([^\"]*)\" Blogs$")
	public void I_enter_all_mandatory_fields_for_Add_Blogs(String formName) throws Throwable {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.blogs);
		switch (formName) {
		case "add":
			String title = ExcelHelper.getData(1, 0);
			String blogCategory = ExcelHelper.getData(1, 1);
			String authorfirstName = ExcelHelper.getData(1, 2);
			String authorlastName = ExcelHelper.getData(1, 3);
			String image = ExcelHelper.getData(1, 4);
			String imageAlt = ExcelHelper.getData(1, 5);
			String publishdate = ExcelHelper.getData(1, 6);
			String status = ExcelHelper.getData(1, 7);
			String description = ExcelHelper.getData(1, 8);
			String metaTitle = ExcelHelper.getData(1, 9);
			String metaDescription = ExcelHelper.getData(1, 10);

			CommonVariables.txtSearchCmnVar = title;

			blogs.enterTitle(title);
			blogs.enterBlogCategory(blogCategory);
			blogs.enterAuthorFirstName(authorfirstName);
			blogs.enterAuthorLastName(authorlastName);
			blogs.enterImage(image);
			blogs.enterImageAlt(imageAlt);
			blogs.enterPublishDate(publishdate);
			blogs.enterStatus(status);
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

	@And("^\"([^\"]*)\" is \"([^\"]*)\"$")
	public void User_is_Active(String moduleName, String status) throws Throwable {
		if (statuscolumn.getAttribute("class").equals("sort active ")) {

			CommonVariables.inactive = "false";
			if (status.equals("Inactive")) {
				assert false;
			}
//			statuscolumn.click();
//			Thread.sleep(2000);

		} else if (statuscolumn.getAttribute("class").equals("sort inactive ")) {

			CommonVariables.inactive = "true";
			if (status.equals("Active")) {
				assert false;
			}
//			statuscolumn.click();
//			Thread.sleep(2000);

		} else {
			CommonVariables.inactive = "";
			System.out.println("Not click on status column");
			assert false;
		}

	}

	@When("^I enter all mandatory fields for \"([^\"]*)\" Testimonial$")
	public void I_enter_all_mandatory_fields_for_Add_Testimonial(String formName) throws Throwable {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.testimonial);
		switch (formName) {
		case "add":
			String authorName = ExcelHelper.getData(1, 0);
			String url = ExcelHelper.getData(1, 1);
			String status = ExcelHelper.getData(1, 2);
			String description = ExcelHelper.getData(1, 3);

			CommonVariables.txtSearchCmnVar = authorName;

			testimonial.enterAuthorName(authorName);
			testimonial.enterURL(url);
			testimonial.enterStatus(status);
			testimonial.enterDescription(description);

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

	@When("^Click on \"([^\"]*)\" Settings menu$")
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

	@When("^I enter all mandatory fields for \"([^\"]*)\" Settings$")
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

	@And("^Click on \"([^\"]*)\" button in \"([^\"]*)\" Settings$")
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

	@Then("^I should get \"([^\"]*)\" message on \"([^\"]*)\" Settings$")
	public void I_should_get_Settings_have_been_saved_successfully_message_on_Blogs_Settings(String successmessage,
			String moduleName) throws Throwable {
		System.out.println("Message : " + successmessage);
		if (successmsg.getText().equals(successmessage)) {
			System.out.println("Message mathch:" + successmessage);
		} else {
			assert false;
		}
	}

	@When("^I enter all mandatory fields for \"([^\"]*)\" Category$")
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

	@When("^I enter all mandatory fields for \"([^\"]*)\" FAQ$")
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

	@When("^I enter all mandatory fields for \"([^\"]*)\" Event$")
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

	@When("^I enter all mandatory fields for \"([^\"]*)\" Page$")
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

	@When("^Data update and verify details for Admin \"([^\"]*)\" section$")
	public void Data_update_and_verify_details_for_Admin_Settings_section(String formName) throws Throwable {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.settings);
		//System.out.println("EXCEL VALUE PRINT : = " + ExcelHelper.getData(1,1));

		// Admin Settings
		String appName = ExcelHelper.getData(1, 1);
		String noofRecordsperPage = ExcelHelper.getData(1, 2);
		String footerTitleforAdmin = ExcelHelper.getData(1, 3);

		settings.adminSettings(appName, noofRecordsperPage, footerTitleforAdmin);

		// Front End Settings
		String sitetitle = ExcelHelper.getData(3, 1);
		String tagline = ExcelHelper.getData(3, 2);
		System.out.println("Tagline = " +ExcelHelper.getData(3, 2));
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

		settings.companySettings(companyName, addressline1, addressline2, city, state, country, zipcode, phone, email);
		
		//Email Settings
		String fromName =ExcelHelper.getData(7, 1);
		String fromEmail = ExcelHelper.getData(7, 2);
		String adminEmail = ExcelHelper.getData(7, 3);
		
		settings.emailSettings(fromName, fromEmail, adminEmail);
		
		//Password Settings
		
		String passwordStrength =ExcelHelper.getData(7, 1);
		String loginattempt = ExcelHelper.getData(7, 2);
		String minpwdlength = ExcelHelper.getData(7, 3);
		String userBlockTime = ExcelHelper.getData(7, 3);
		
		settings.passwordSettings(passwordStrength, loginattempt, minpwdlength, userBlockTime);
		
		//Social link Settings
		String facebook =ExcelHelper.getData(7, 1);
		String twitter = ExcelHelper.getData(7, 2);
		String linkedIn = ExcelHelper.getData(7, 3);
		
		
	}
}
