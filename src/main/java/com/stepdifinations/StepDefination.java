package com.stepdifinations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.basicactions.ExcelHelper;
import com.basicactions.ExcelHelperPOI;
import com.basicactions.LogHelper;
import com.basicactions.WaitHelper;
import com.pages.adminpages.Blogs;
import com.pages.adminpages.Categories;
import com.pages.adminpages.Changepassword;
import com.pages.adminpages.ContactUS;
import com.pages.adminpages.Events;
import com.pages.adminpages.FAQ;
import com.pages.adminpages.Galleries;
import com.pages.adminpages.HomePage;
import com.pages.adminpages.Homesliders;
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
	ContactUS contactus;
	Galleries galleries;
	CommonXpath commonXpath;
	Changepassword changepwd;
	Homesliders homesliders;
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
		galleries = new Galleries(driver);
		settings = new Settings(driver);
		changepwd = new Changepassword(driver);
		commonXpath = new CommonXpath(driver);
		contactus = new ContactUS(driver);
		homesliders = new Homesliders(driver);
		commonWhenStepDefinations = new CommonWhenStepDefinations();
	}

	@And("Click on {string} button in {string}")
	public void Click_on_Add_button_in_Users_grid(String buttonName, String moduleName) throws Throwable {

		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		And thenann = (And) StepDefination.class.getMethod(methodName, String.class, String.class).getAnnotations()[0];
		ArrayList<String> arr = new ArrayList<String>();
		arr.add(buttonName);
		arr.add(moduleName);
		CommonVariables.step.add(getStepsName(thenann.value(), arr));

		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
		switch (buttonName) {
		case "Add":
			commonFunc.clickOnAddNewButton(moduleName);
			break;
		case "Save":
			commonFunc.clickOnSave(moduleName);
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
		CommonVariables.stepResult.add("Pass");
	}

	public String getStepsName(String step, ArrayList<String> arr) {
		String[] words = step.split(" ");
		String word = "{string}";
		String sent = "";
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			// if match found increase count
			if (word.equals(words[i])) {
				words[i] = arr.get(count);
				count++;
			}
			sent = sent + " " + words[i];
		}
		return sent.trim();
	}

	@Then("{string} {string} page gets open")
	public void Users_Add_page_gets_open(String moduleName, String formName) throws Throwable {

		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		Then thenann = (Then) StepDefination.class.getMethod(methodName, String.class, String.class)
				.getAnnotations()[0];
		ArrayList<String> arr = new ArrayList<String>();
		arr.add(moduleName);
		arr.add(formName);
		CommonVariables.step.add(getStepsName(thenann.value(), arr));

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
			} else if (moduleName.equals(CommonVariables.contactsetting)) {
				if (commonXpath.contactSettingTitle.getText().equalsIgnoreCase(settingpage)) {
					System.out.println("Verify the title:" + commonXpath.contactSettingTitle.getText());
				} else {
					assert false;
				}
			} else if (moduleName.equals(CommonVariables.ourteam)) {
				if (commonXpath.OurteamSettingTitle.getText().equalsIgnoreCase(settingpage)) {
					System.out.println("Verify the title:" + commonXpath.OurteamSettingTitle.getText());
				} else {
					assert false;
				}
			}
//				else if (moduleName.equals(CommonVariables.Homeslider)) {
//				if (commonXpath.Homeslider_setting.getText().equalsIgnoreCase(settingpage)) {
//					System.out.println("Verify the title:" + commonXpath.OurteamSettingTitle.getText());
//				} else {
//					assert false;
//				}
//			} else {
//				assert false;
//			}
		} else if (commonXpath.addtitle.getText().equalsIgnoreCase(page)) {
			System.out.println("Verify the title:" + commonXpath.addtitle.getText());
		} else {
			assert false;
		}
		CommonVariables.stepResult.add("Pass");
	}

	@When("I enter all mandatory fields for {string} User")
	public void I_enter_all_mandatory_fields_for_add_User(String formName) throws Throwable {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		When thenann = (When) StepDefination.class.getMethod(methodName, String.class).getAnnotations()[0];
		ArrayList<String> arr = new ArrayList<String>();
		arr.add(formName);
		CommonVariables.step.add(getStepsName(thenann.value(), arr));

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
		CommonVariables.stepResult.add("Pass");
	}

	@Then("I should get {string} message on {string}")
	public void I_should_get_account_created_successfully_message_on_Users_list_page(String sucessmessage,
			String moduleName) throws Throwable {
//		String methodName = new Throwable().getStackTrace()[0].getMethodName();
//		Then thenann = (Then) StepDefination.class.getMethod(methodName, String.class, String.class)
//				.getAnnotations()[0];
//		ArrayList<String> arr = new ArrayList<String>();
//		arr.add(sucessmessage);
//		arr.add(moduleName);
//		CommonVariables.step.add(getStepsName(thenann.value(), arr));

		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
		if (moduleName.equals("Home Page Sliders")) {
			if (commonXpath.successmsg.getText().contains(sucessmessage)) {
				System.out.println("Message :" + commonXpath.successmsg.getText());
			} else {
				System.out.println("message = " + commonXpath.successmsg.getText());
				System.out.println("Message is not match: ");
				assert false;
			}
		}
		String Title = ExcelHelper.getData(1, 0);
		if (moduleName.equals("Galleries")) {
			if (commonXpath.successmsg.getText().contains(Title + sucessmessage)) {
				System.out.println("Message :" + commonXpath.successmsg.getText());
			} else {
				System.out.println("Message is not match: ");
				assert false;
			}
		}
		Thread.sleep(1500);
		String firstname = ExcelHelper.getData(1, 0);
		String lastname = ExcelHelper.getData(1, 1);
		System.out.println("Firstname= " + firstname);
		System.out.println("Lastname= " + lastname);
		System.out.println("message = " + commonXpath.successmsg.getText());
		if (commonXpath.successmsg.getText().trim().contains(firstname + lastname + "account restored successfully.")) {
			System.out.println("Message :" + commonXpath.successmsg.getText());
		} else {

			if (commonXpath.successmsg.getText().contains(sucessmessage)) {
				System.out.println("Message :" + commonXpath.successmsg.getText());
			} else {
				System.out.println("message = " + commonXpath.successmsg.getText());
				System.out.println("Message is not match: ");
				assert false;
			}
		}

		if (CommonVariables.saveandcontinue == true) {
			commonFunc.clickOnCancelbutton();
			CommonVariables.saveandcontinue = false;
		}

		CommonVariables.stepResult.add("Pass");
	}

	@And("Verify details in {string}")
	public void Verify_details_in_Users_grid(String moduleName) throws Throwable {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();

		And thenann = (And) StepDefination.class.getMethod(methodName, String.class).getAnnotations()[0];
		ArrayList<String> arr = new ArrayList<String>();
		arr.add(moduleName);
		CommonVariables.step.add(getStepsName(thenann.value(), arr));

		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
		String searchText = "";
		String xpath = "";
		if (moduleName.equals(CommonVariables.users)) {
			System.out.println("Inside IF condition");
			searchText = CommonVariables.txtSearchCmnVar;
			System.out.println("Search text is :- " + searchText);
			xpath = "//table[@id='DataTables_Table_0']/tbody[1]/tr[1]/td[4]";
			if (searchText.equals(xpath)) {
				commonFunc.clickOnselectcheckbox();
				commonFunc.clickOnDeleteButton();
				commonFunc.clickOnconfirmyesbutton();
				CommonVariables.deleteRecord = true;
				Thread.sleep(4000);
				commonFunc.clickOnAddNewButton(moduleName);

				ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.users);
				String firstname = ExcelHelper.getData(1, 0);
				String lastname = ExcelHelper.getData(1, 1);
				String email = ExcelHelper.getData(1, 2);

				CommonVariables.txtSearchCmnVar = firstname + " " + lastname;

				usersPage.enterUserFirstName(firstname);
				usersPage.enterUserLastName(lastname);
				usersPage.enterUserEmail(email);

				commonFunc.clickOnSave(moduleName);
			}
		} else if (moduleName.equals(CommonVariables.Homeslider)) {
			searchText = CommonVariables.txtSearchCmnVar;
			System.out.println("searchtext = " + searchText);
			xpath = "//*[@id='main']/div[3]/form/div/div[2]/div[1]/div/div/div[2]/ul/li[2]/div/a";
		} else if (moduleName.equals(CommonVariables.galleries)) {
			searchText = CommonVariables.txtSearchCmnVar;
			System.out.println("searchtext = " + searchText);
			xpath = "//*[@id='main']/div[3]/form/div/div[2]/div[1]/div/div/div[2]/ul/li[2]/p";

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
		} else if (moduleName.equals(CommonVariables.iptracker)) {
			String searchvar = driver.findElement(By.xpath("//*[@id='dropdownMenu2']/span/span[1]")).getText();
			String[] values = searchvar.split(":");
			System.out.println("string value =" + values[1]);
			searchText = values[1];
			xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[2]";
			System.out.println("Search text is :- " + searchText);
			String loggedin = driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr[1]/td[4]")).getText();
			String lastactivity = driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr[1]/td[5]"))
					.getText();
			if (loggedin.equals(lastactivity)) {
				System.out.println("string1=" + loggedin);
				System.out.println("string2=" + lastactivity);
				System.out.println("date and time is match");
			} else {
				assert false;
			}

		} else {
			assert false;
		}

		if (CommonVariables.deleteRecord == true) {
			xpath = "//*[@id='frmlist']/table/tbody/tr/td";
			System.out.println("delete record " + driver.findElement(By.xpath(xpath)).getText());
		}

		commonFunc.searchRecord(searchText.trim(), searchText.trim(), xpath, moduleName);
		CommonVariables.stepResult.add("Pass");
	}

	@And("{string} is Inactive")
	public void User_is_Inactive(String moduleName) throws Throwable {
		if (commonXpath.statuscolumn.getAttribute("class").equals("sort inactive ")) {
			System.out.println("Value for Inactive user = "
					+ commonXpath.statuscolumn.getAttribute("class").equals("sort active "));
		} else if (commonXpath.statuscolumn.getAttribute("class").equals("sort active ")) {
			System.out.println(
					"Value for active user = " + commonXpath.statuscolumn.getAttribute("class").equals("sort active "));

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
		} else if (moduleName.equals(CommonVariables.galleries)) {
			commonFunc.clickOnstatuscolumn("galleries");
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
			System.out.println("blogCategory =456" + blogCategory + "123123");
			if (blogCategory != "" || !blogCategory.isEmpty()) {
				blogs.selectBlogCategory(blogCategory);
			}
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
		System.out.println("module name 1 " + moduleName);
		System.out.println("module name 2 " + CommonVariables.testimonial);
		if (moduleName.equals(CommonVariables.blogs)) {
			blogs.ClickonSettingmenu();
		} else if (moduleName.equals(CommonVariables.testimonial)) {
			testimonial.ClickonSettingmenu();
		} else if (moduleName.equals(CommonVariables.contactus)) {
			commonXpath.contactSetting.click();
		} else if (moduleName.equals(CommonVariables.ourteam)) {
			commonXpath.OurteamSetting.click();
		} else if (moduleName.equals(CommonVariables.Homeslider)) {
			commonXpath.HomeSettingmenu.click();
		} else {
			assert false;
		}
	}

	@When("I enter all mandatory fields for {string} Settings")
	public void I_enter_all_mandatory_fields_for_blogs_setting(String moduleName) throws Throwable {

		if (moduleName.equals(CommonVariables.blogs)) {

			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.blogs);

			String fieldblog = ExcelHelper.getData(1, 12);
			String commentmoderation = ExcelHelper.getData(1, 13);

			blogs.enterFieldblog(fieldblog);
			blogs.selectCommentmoderation(commentmoderation);
			Thread.sleep(2000);

		} else if (moduleName.equals(CommonVariables.testimonial)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.testimonial);

			System.out.println("Excel value : " + ExcelHelper.getData(1, 5));
			String settingfield = ExcelHelper.getData(1, 5);
			System.out.println("Excel value : " + settingfield);

			testimonial.entersettingfield(settingfield);
			Thread.sleep(2000);
		} else if (moduleName.equals(CommonVariables.ourteam)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.ourteam);

			System.out.println("Excel value : " + ExcelHelper.getData(1, 11));
			String ourteamTitlefield = ExcelHelper.getData(1, 11);
			String ourteamSubTitle = ExcelHelper.getData(1, 12);
			ourteam.enterOurteamTitle(ourteamTitlefield);
			ourteam.enterOurteamSubTitle(ourteamSubTitle);
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
		} else if (moduleName.equals(CommonVariables.ourteam)) {
			ourteam.ClickonSavebutton();
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

	@When("Verify table column in each grid {string} page")
	public void Verify_table_column_in_each_grid_users_page(String moduleName) throws Throwable {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		When thenann = (When) StepDefination.class.getMethod(methodName, String.class).getAnnotations()[0];
		ArrayList<String> arr = new ArrayList<String>();
		arr.add(moduleName);
		CommonVariables.step.add(getStepsName(thenann.value(), arr));

		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.tableColumns);

		if (moduleName.equals(ExcelHelper.getData(0, 0))) {
			commonFunc.verifytablegridData(ExcelHelper.getData(1, 0), moduleName);
		} else if (moduleName.equals(ExcelHelper.getData(0, 1))) {
			commonFunc.verifytablegridData(ExcelHelper.getData(1, 1), moduleName);
		} else if (moduleName.equals(ExcelHelper.getData(0, 2))) {
			commonFunc.verifytablegridData(ExcelHelper.getData(1, 2), moduleName);
		} else if (moduleName.equals(ExcelHelper.getData(0, 3))) {
			commonFunc.verifytablegridData(ExcelHelper.getData(1, 3), moduleName);
		} else if (moduleName.equals(ExcelHelper.getData(0, 4))) {
			commonFunc.verifytablegridData(ExcelHelper.getData(1, 4), moduleName);
		} else if (moduleName.equals(ExcelHelper.getData(0, 5))) {
			commonFunc.verifytablegridData(ExcelHelper.getData(1, 5), moduleName);
		} else if (moduleName.equals(ExcelHelper.getData(0, 6))) {
			commonFunc.verifytablegridData(ExcelHelper.getData(1, 6), moduleName);
		} else if (moduleName.equals(ExcelHelper.getData(0, 7))) {
			commonFunc.verifytablegridData(ExcelHelper.getData(1, 7), moduleName);
		} else if (moduleName.equals(ExcelHelper.getData(0, 8))) {
			commonFunc.verifytablegridData(ExcelHelper.getData(1, 8), moduleName);
		}

		CommonVariables.stepResult.add("Pass");
	}

	@When("Change First Name and Last Name")
	public void change_First_Name_and_Last_Name() throws InterruptedException {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.users);
		System.out.println("user value=" + CommonVariables.users);

		String changefirstname = ExcelHelper.getData(1, 5);
		String changelastName = ExcelHelper.getData(1, 6);
		System.out.println("String value1 =" + changefirstname);
		System.out.println("String value2 =" + changelastName);

		usersPage.enterchangeFirstName(changefirstname);
		usersPage.enterchangeLastName(changelastName);

		CommonVariables.changename = changefirstname + " " + changelastName;

		System.out.println("check value commvariable=" + CommonVariables.changename);

		CommonVariables.txtSearchCmnVar = driver.findElement(By.xpath("//*[@id='email']")).getAttribute("value");
		System.out.println("Email value =" + CommonVariables.txtSearchCmnVar);

		commonXpath.Settingsave.click();
	}

	@When("Verify in {string} Module")
	public void verify_in_Module(String modulename) throws InterruptedException {

		commonFunc.clickMenuOption(modulename);

		commonFunc.searchRecord(CommonVariables.txtSearchCmnVar, CommonVariables.changename,
				"//*[@id='DataTables_Table_0']/tbody/tr/td[4]", modulename);
	}

	@When("Set new password")
	public void set_new_password() throws ConfigurationException, InterruptedException {
		readPropFile = new ReadPropFile();

		String password = readPropFile.readProp().getProperty("password").toString();
		String newpassword = readPropFile.readProp().getProperty("newpassword").toString();

		changepwd.entercurrentpwd(password);
		changepwd.enternewpwd(newpassword);
		changepwd.enterconfirmpwd(newpassword);

		commonXpath.Settingsave.click();

		PropertiesConfiguration out = new PropertiesConfiguration(FilesPaths.CONFIG_PROPERTIES_FILE);
		out.setProperty("password", newpassword);
		out.save();
		Thread.sleep(5000);

	}

	@Then("Logged out the admin user")
	public void Logged_out_the_admin_user() throws InterruptedException {

		commonXpath.profilemenu.click();
		Thread.sleep(3000);
		commonXpath.logoutprofile.click();
	}

	@Then("Verify checkbox for login user {string} Module")
	public void Verify_checkbox_for_login_user_string_Module(String modulename) throws InterruptedException {

		String username = driver.findElement(By.xpath("// *[@id='dropdownMenu2']/span/span[1]")).getText();
		String[] user = username.split(":");
		System.out.println("Verify the user=" + user[1]);

		commonFunc.searchRecord(CommonVariables.email, user[1], "//*[@id='DataTables_Table_0']/tbody/tr/td[4]",
				modulename);

		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int count = checkbox.size();

		if (count > 0) {
			System.out.println("Checkbox is not aviable for login user");
		} else {
			System.out.println("condition is not match");
		}

	}

	@When("I enter all fields for {string} {string}")
	public void I_enter_all_fields_for_add_User(String sheetname, String modulename) throws Throwable {
		if (modulename.equals("Users")) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.users);
			int endvalue = ExcelHelper.getTotalRowsCount();
			System.out.println("count = " + ExcelHelper.getTotalRowsCount());
			for (int i = 8; i < endvalue; i++) {
				String firstname = ExcelHelper.getData(1, i);
				if (firstname.isEmpty()) {
					break;
				}
				usersPage.enterUserFirstName(firstname);
				String lastname = ExcelHelper.getData(3, i);
				usersPage.enterUserLastName(lastname);
				String email = ExcelHelper.getData(5, i);
				usersPage.enterUserEmail(email);
				CommonVariables.email = email;
				Thread.sleep(2000);
				commonFunc.clickOnSave(modulename);
				Thread.sleep(2000);
				commonFunc.clickOnAddNewButton(modulename);

			}
		} else if (modulename.equals("Pages")) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.pages);
			int endvalue = ExcelHelper.getTotalRowsCount();
			System.out.println("count = " + ExcelHelper.getTotalRowsCount());
			for (int i = 8; i < endvalue; i++) {
				String title = ExcelHelper.getData(0, i);
				if (title.isEmpty()) {
					break;
				} else {
					pages.enterTitle(title);
					String status = ExcelHelper.getData(1, i);
					pages.enterStatus(status);
					String pageContent = ExcelHelper.getData(2, i);
					pages.enterPageContent(pageContent);
					String metaTitle = ExcelHelper.getData(3, i);
					pages.enterMetaTitle(metaTitle);
					String metaDescription = ExcelHelper.getData(4, i);
					pages.enterMetaDescription(metaDescription);
					Thread.sleep(2000);
					commonFunc.clickOnSave(modulename);
					Thread.sleep(2000);
					commonFunc.clickOnAddNewButton(modulename);
				}
			}

		} else if (modulename.equals("Our Team")) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.ourteam);
			int endvalue = ExcelHelper.getTotalRowsCount();
			System.out.println("count = " + ExcelHelper.getTotalRowsCount());
			for (int i = 13; i < endvalue; i++) {
				System.out.println("Excel value=" + ExcelHelper.getData(0, i));
				String firstname = ExcelHelper.getData(0, i);
				if (firstname.isEmpty()) {
					break;
				} else {
					ourteam.enterFirstName(firstname);
					String lastname = ExcelHelper.getData(1, i);
					ourteam.enterLastName(lastname);
					String position = ExcelHelper.getData(2, i);
					ourteam.enterPosition(position);
					String status = ExcelHelper.getData(3, i);
					ourteam.enterStatus(status);
					String image = ExcelHelper.getData(4, i);
					ourteam.enterImage(image);
					String imageAlt = ExcelHelper.getData(5, i);
					ourteam.enterImageAlt(imageAlt);
					Thread.sleep(2000);
					commonFunc.clickOnSave(modulename);
					Thread.sleep(2000);
					commonFunc.clickOnAddNewButton(modulename);
				}
			}

		} else if (modulename.equals("Categories")) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.categories);
			int categoriesendvalue = ExcelHelper.getTotalRowsCount();
			System.out.println("count = " + ExcelHelper.getTotalRowsCount());
			for (int i = 10; i < categoriesendvalue; i++) {
				System.out.println("Excel value=" + ExcelHelper.getData(0, i));
				String title = ExcelHelper.getData(0, i);
				if (title.isEmpty()) {
					break;
				} else {
					categories.enterTitle(title);
					String status = ExcelHelper.getData(1, i);
					categories.enterStatus(status);
					String imageAlt = ExcelHelper.getData(2, i);
					categories.enterImageAlt(imageAlt);
					String image = ExcelHelper.getData(3, i);
					categories.enterImage(image);
					String description = ExcelHelper.getData(4, i);
					categories.enterDescription(description);
					Thread.sleep(2000);
					commonFunc.clickOnSave(modulename);
					Thread.sleep(2000);
					commonFunc.clickOnAddNewButton(modulename);
				}
			}
		} else if (modulename.equals("Testimonials")) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.testimonial);
			int testimonialendvalue = ExcelHelper.getTotalRowsCount();
			System.out.println("count = " + ExcelHelper.getTotalRowsCount());
			for (int i = 9; i < testimonialendvalue; i++) {
				String authorName = ExcelHelper.getData(0, i);
				if (authorName.isEmpty()) {
					break;
				} else {
					testimonial.enterAuthorName(authorName);
					String url = ExcelHelper.getData(1, i);
					testimonial.enterURL(url);
					String status = ExcelHelper.getData(2, i);
					testimonial.enterStatus(status);
					String description = ExcelHelper.getData(3, i);
					testimonial.enterDescription(description);
					commonFunc.clickOnSave(modulename);
					Thread.sleep(2000);
					commonFunc.clickOnAddNewButton(modulename);
				}
			}
		} else if (modulename.equals("FAQs")) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.faqs);
			System.out.println("FAQ =" + CommonVariables.faqs);
			int faqendvalue = ExcelHelper.getTotalRowsCount();
			for (int i = 6; i < faqendvalue; i++) {
				String question = ExcelHelper.getData(0, i);
				if (question.isEmpty()) {
					break;
				} else {
					faq.enterQuestion(question);
					String status = ExcelHelper.getData(1, i);
					faq.enterStatus(status);
					String answer = ExcelHelper.getData(2, i);
					faq.enterAnswer(answer);
					commonFunc.clickOnSave(modulename);
					Thread.sleep(2000);
					commonFunc.clickOnAddNewButton(modulename);
				}
			}

		} else if (modulename.equals("Event")) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.events);
			int eventendvalue = ExcelHelper.getTotalRowsCount();
			for (int i = 17; i < eventendvalue; i++) {
				String title = ExcelHelper.getData(0, i);
				if (title.isEmpty()) {
					break;
				} else {
					events.enterTitle(title);
					String startDate = ExcelHelper.getData(1, i);
					events.enterStartDate(startDate);
					String endDate = ExcelHelper.getData(2, i);
					events.enterEndDate(endDate);
					String eventTime = ExcelHelper.getData(3, i);
					events.enterEventTime(eventTime);
					String status = ExcelHelper.getData(4, i);
					events.enterStatus(status);
					String description = ExcelHelper.getData(5, i);
					events.enterDescription(description);
					commonFunc.clickOnSave(modulename);
					Thread.sleep(2000);
					commonFunc.clickOnAddNewButton(modulename);
				}
			}

		} else if (modulename.equals("Blogs")) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.blogs);
			int blogendvalue = ExcelHelper.getTotalRowsCount();
			System.out.println("Excel value =" + ExcelHelper.getData(0, 15));
			for (int i = 15; i < blogendvalue; i++) {
				String title = ExcelHelper.getData(0, i);
				if (title.isEmpty()) {
					break;
				} else {
					blogs.enterTitle(title);
					String image = ExcelHelper.getData(1, i);
					blogs.selectImage(image);
					String imageAlt = ExcelHelper.getData(2, i);
					blogs.enterImageAlt(imageAlt);
					blogs.enterPublishDate();
					String description = ExcelHelper.getData(3, i);
					blogs.enterDescription(description);
					String metaTitle = ExcelHelper.getData(4, i);
					blogs.enterMetaTitle(metaTitle);
					String metaDescription = ExcelHelper.getData(5, i);
					blogs.enterMetaDescription(metaDescription);
					commonFunc.clickOnSave(modulename);
					Thread.sleep(2000);
					commonFunc.clickOnAddNewButton(modulename);
				}
			}

		}

	}

	@And("Select all record and Click on {string} button in {string}")
	public void Select_all_record_and_Click_on_Delete_button_in_Users(String FormName, String ModuleName)
			throws Throwable {
		CommonXpath.selectallcheckbox.click();
		Thread.sleep(2000);
		CommonXpath.deletebutton.click();
		Thread.sleep(2000);
		CommonXpath.confirmyesbutton.click();
		Thread.sleep(3000);
	}

	@And("value get in Settings Module")
	public void value_get_in_Settings_Module() throws Throwable {
		Thread.sleep(2000);
		String setting = commonXpath.NoofRecordsperPage.getAttribute("value");
		System.out.println("value of common variable =" + setting);
		CommonVariables.Numrecord = setting;
	}

	@And("Verify Pagination count in {string}")
	public void Verify_Pagination_count_in_FAQ(String menuTitle) throws Throwable {
		driver.findElement(By.xpath("/html/body/nav/ul/li[1]/a")).click();

		commonFunc.clickMenuOption(menuTitle);

		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
		commonFunc.verifypaginationcount();

//				String paginationcount = driver.findElement(By.xpath("//*[@id='DataTables_Table_0_paginate']/ul/li[3]/a")).getText();
//				
//				if (paginationcount.matches("2")) {
//							
//					driver.findElement(By.xpath("//*[@id='DataTables_Table_0_paginate']/ul/li[3]/a")).click();
//					Thread.sleep(2000);
//					System.out.println("click on 2 page");
//					 commonFunc.verifypaginationcount();
//				} else {
//					
//					System.out.println("button is not found");
//					assert true;
//				}

//		int pagecount = pagec1.size();
		List<WebElement> pagec11 = driver.findElements(By.xpath("//*[@style='cursor:pointer']"));
		int countc1 = pagec11.size();
		System.out.println("Number page count =" + countc1);
		for (int i = 1; i <= countc1; i++) {
			String paginationcount = driver
					.findElement(By.xpath("//*[@id='DataTables_Table_0_paginate']/ul/li[" + (i + 1) + "]/a")).getText();

			System.out.println("paginationcount = " + paginationcount);

			if (Integer.parseInt(paginationcount) > 1) {
				driver.findElement(By.xpath("//*[@id='DataTables_Table_0_paginate']/ul/li[" + (i + 1) + "]/a")).click();
				Thread.sleep(2000);
				System.out.println("click on next" + "page");
				commonFunc.verifypaginationcount();
			} else {
				System.out.println("button is not found");
				assert true;
			}

		}
	}

	@And("Verify Sorting record in {string}")
	public void Verify_Sorting_record_in_Users(String ModuleName) throws Throwable {

		if (ModuleName.equals("Users")) {
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");
			List<WebElement> tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]"));
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list.add(tdList.get(i).getText());
			}

			System.out.println("ArryList before= " + list);
			Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

//		Collections.sort(list);

			System.out.println("ArryList after sorting= " + list);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]"));
			ArrayList<String> list1 = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list1.add(tdList.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data :" + list1);
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();
			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");
			List<WebElement> tdList2 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[5]"));
			ArrayList<String> list2 = new ArrayList<String>();
			for (int i = 0; i < tdList2.size(); i++) {
				list2.add(tdList2.get(i).getText());
			}

			System.out.println("ArryList before for column 2= " + list2);
			Collections.sort(list2, String.CASE_INSENSITIVE_ORDER);

//		Collections.sort(list);

			System.out.println("ArryList after sorting for column 2= " + list2);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList2 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]"));
			ArrayList<String> list3 = new ArrayList<String>();
			for (int i = 0; i < tdList2.size(); i++) {
				list3.add(tdList2.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data for column 2 :" + list3);

		}

		if (ModuleName.equals("FAQs")) {
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");
			List<WebElement> tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]"));
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list.add(tdList.get(i).getText());
			}

			System.out.println("ArryList before= " + list);
			Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

//		Collections.sort(list);

			System.out.println("ArryList after sorting= " + list);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]"));
			ArrayList<String> list1 = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list1.add(tdList.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data :" + list1);
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();
			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");
			List<WebElement> tdList2 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[5]"));
			ArrayList<String> list2 = new ArrayList<String>();
			for (int i = 0; i < tdList2.size(); i++) {
				list2.add(tdList2.get(i).getText());
			}

			System.out.println("ArryList before for column 2= " + list2);
			Collections.sort(list2, String.CASE_INSENSITIVE_ORDER);

//		Collections.sort(list);

			System.out.println("ArryList after sorting for column 2= " + list2);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList2 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]"));
			ArrayList<String> list3 = new ArrayList<String>();
			for (int i = 0; i < tdList2.size(); i++) {
				list3.add(tdList2.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data for column 2 :" + list3);

		}
		if (ModuleName.equals("Testimonials")) {
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");
			List<WebElement> tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]"));
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list.add(tdList.get(i).getText());
			}

			System.out.println("ArryList before= " + list);
			Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

//		Collections.sort(list);

			System.out.println("ArryList after sorting= " + list);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]"));
			ArrayList<String> list1 = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list1.add(tdList.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data :" + list1);
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();
			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");
			List<WebElement> tdList2 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[5]"));
			ArrayList<String> list2 = new ArrayList<String>();
			for (int i = 0; i < tdList2.size(); i++) {
				list2.add(tdList2.get(i).getText());
			}

			System.out.println("ArryList before for column 2= " + list2);
			Collections.sort(list2, String.CASE_INSENSITIVE_ORDER);

//		Collections.sort(list);

			System.out.println("ArryList after sorting for column 2= " + list2);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList2 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]"));
			ArrayList<String> list3 = new ArrayList<String>();
			for (int i = 0; i < tdList2.size(); i++) {
				list3.add(tdList2.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data for column 2 :" + list3);

		}
		if (ModuleName.equals("Pages")) {
			System.out.println("TEST PAGES MODULES:=" + ModuleName);
			List<WebElement> tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]/a"));
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {

				list.add(tdList.get(i).getText());
			}
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			System.out.println("ArryList before= " + list);
			Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

//		Collections.sort(list);

			System.out.println("ArryList after sorting= " + list);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]/a"));
			ArrayList<String> list1 = new ArrayList<String>();

			for (int i = 0; i < tdList.size(); i++) {
				list1.add(tdList.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data :" + list1);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();

			List<WebElement> tdList2 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[5]"));
			ArrayList<String> list2 = new ArrayList<String>();
			for (int i = 0; i < tdList2.size(); i++) {

				list2.add(tdList2.get(i).getText());
			}
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			System.out.println("2nd column: ArryList before= " + list2);
			Collections.sort(list2, String.CASE_INSENSITIVE_ORDER);

//		Collections.sort(list);

			System.out.println("ArryList after sorting= " + list2);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList2 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[5]"));
			ArrayList<String> list3 = new ArrayList<String>();
			for (int i = 0; i < tdList2.size(); i++) {
				list3.add(tdList.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data :" + list3);
		}
		if (ModuleName.equals("Blogs")) {
			System.out.println("TEST BLOGS MODULES:=" + "");
			List<WebElement> tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]/a"));
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list.add(tdList.get(i).getText());
			}
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			System.out.println("ArryList before= " + list);
			Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

//	Collections.sort(list);

			System.out.println("ArryList after sorting= " + list);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]/a"));
			ArrayList<String> list1 = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list1.add(tdList.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data :" + list1);

			List<WebElement> tdList1 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[5]"));
			ArrayList<String> list2 = new ArrayList<String>();
			for (int i = 0; i < tdList1.size(); i++) {
				list2.add(tdList1.get(i).getText());
			}
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			System.out.println("ArryList before for 2nd column = " + list2);
			Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

//	Collections.sort(list);

			System.out.println("ArryList after sorting for 2nd column = " + list2);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[5]"));
			ArrayList<String> list3 = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list3.add(tdList.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data for 2nd column:" + list3);
		}
		if (ModuleName.equals("Our Team")) {
			System.out.println("TEST Our Team MODULES:=" + ModuleName);
			List<WebElement> tdList = driver
					.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]/div[2]"));
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list.add(tdList.get(i).getText());
			}
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			System.out.println("ArryList before= " + list);
			Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

//	Collections.sort(list);

			System.out.println("ArryList after sorting= " + list);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]/div[2]"));
			ArrayList<String> list1 = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list1.add(tdList.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data :" + list1);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();
			List<WebElement> tdList2 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[5]"));
			ArrayList<String> list2 = new ArrayList<String>();
			for (int i = 0; i < tdList2.size(); i++) {
				list2.add(tdList2.get(i).getText());
			}
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			System.out.println("2nd column :ArryList before= " + list2);
			Collections.sort(list2, String.CASE_INSENSITIVE_ORDER);

//	Collections.sort(list);

			System.out.println("2nd column :ArryList after sorting= " + list2);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList2 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[5]"));
			ArrayList<String> list3 = new ArrayList<String>();
			for (int i = 0; i < tdList2.size(); i++) {
				list3.add(tdList2.get(i).getText());
			}

			System.out.println("2nd column :ArrayList Ascendtion data :" + list3);
		}
		if (ModuleName.equals("Events")) {
			System.out.println("TEST Events MODULES:=" + "");
			List<WebElement> tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]/a"));
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list.add(tdList.get(i).getText());
			}
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			System.out.println("ArryList before= " + list);
			Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

//	Collections.sort(list);

			System.out.println("ArryList after sorting= " + list);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]/a"));
			ArrayList<String> list1 = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list1.add(tdList.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data :" + list1);

			List<WebElement> tdList2 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[5]"));
			ArrayList<String> list2 = new ArrayList<String>();
			for (int i = 0; i < tdList2.size(); i++) {
				list2.add(tdList2.get(i).getText());
			}
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			System.out.println("ArryList before 2nd column= " + list2);
			Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

//	Collections.sort(list);

			System.out.println("ArryList after sorting= " + list2);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[5]"));
			ArrayList<String> list3 = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list3.add(tdList.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data 2nd column:" + list3);
		}
		if (ModuleName.equals("Categories")) {

			System.out.println("TEST Categories MODULES:=" + ModuleName);
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();
			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			List<WebElement> tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]/a"));
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list.add(tdList.get(i).getText());
			}

			System.out.println("ArryList before= " + list);
			Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

			System.out.println("ArryList after sorting= " + list);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]/a"));
			ArrayList<String> list1 = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list1.add(tdList.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data :" + list1);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();
			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			List<WebElement> tdList2 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[5]"));
			ArrayList<String> list2 = new ArrayList<String>();
			for (int i = 0; i < tdList2.size(); i++) {
				list2.add(tdList2.get(i).getText());
			}

			System.out.println("2nd column : ArryList before= " + list2);
			Collections.sort(list2, String.CASE_INSENSITIVE_ORDER);

			System.out.println("2nd column : ArryList after sorting= " + list2);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList2 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[5]"));
			ArrayList<String> list3 = new ArrayList<String>();
			for (int i = 0; i < tdList2.size(); i++) {
				list3.add(tdList2.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data :" + list3);
		}
		if (ModuleName.equals("IP Tracker")) {
			System.out.println("TEST IP Tracker MODULES:=" + "");
			List<WebElement> tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[2]"));
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list.add(tdList.get(i).getText());
			}
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			System.out.println("ArryList before= " + list);
			Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

//	Collections.sort(list);

			System.out.println("ArryList after sorting= " + list);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[2]"));
			ArrayList<String> list1 = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list1.add(tdList.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data :" + list1);

			List<WebElement> tdList2 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[3]"));
			ArrayList<String> list2 = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list2.add(tdList.get(i).getText());
			}
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			System.out.println("ArryList before for 2nd column= " + list2);
			Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

//	Collections.sort(list);

			System.out.println("ArryList after sorting for 2nd column= " + list2);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[5]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList2 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[3]"));
			ArrayList<String> list3 = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list3.add(tdList2.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data for 2nd column :" + list3);
		}
		if (ModuleName.equals("Conatct Us")) {
			System.out.println("TEST MODULES:=" + ModuleName);
			List<WebElement> tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[2]"));
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list.add(tdList.get(i).getText());
			}
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[2]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			System.out.println("ArryList before= " + list);
			Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

//	Collections.sort(list);

			System.out.println("ArryList after sorting= " + list);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[2]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[2]"));
			ArrayList<String> list1 = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list1.add(tdList.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data :" + list1);

			List<WebElement> tdList2 = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[3]"));
			ArrayList<String> list2 = new ArrayList<String>();
			for (int i = 0; i < tdList2.size(); i++) {
				list2.add(tdList2.get(i).getText());
			}
			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[3]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			System.out.println("ArryList before 2nd column= " + list2);
			Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

//	Collections.sort(list);

			System.out.println("ArryList after sorting= " + list2);

			driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[3]")).click();

			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");

			tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[3]"));
			ArrayList<String> list3 = new ArrayList<String>();
			for (int i = 0; i < tdList.size(); i++) {
				list3.add(tdList.get(i).getText());
			}

			System.out.println("ArrayList Ascendtion data 2nd column:" + list3);
		}
	}

	@When("Verify data in Contact Us")
	public void Verify_data_in_Contact_Us() throws InterruptedException, IOException {
		List<WebElement> tdList = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[2]"));
//		ArrayList<String> list = new ArrayList<String>();
//		for (int i = 0; i < tdList.size(); i++) {
//			list.add(tdList.get(i).getText());
//			Thread.sleep(1000);
//		}
//		System.out.println("value= " + list);
//		Thread.sleep(2500);
//		driver.findElement(By.xpath("//*[@id='DataTables_Table_0_wrapper']/div[1]/div[1]/div/button")).click();
//		Thread.sleep(5000);
//		ExcelHelperPOI.getExcelData(FilesPaths.excel_data_file_new, "Sheet1");
//		System.out.println("File path= "+FilesPaths.excel_data_file_new);
//		System.out.println("Excel= "+ExcelHelperPOI.getExcelData(FilesPaths.excel_data_file_new, "Sheet1"));

		ExcelHelperPOI.readExcel(FilesPaths.excel_data_file_new, "Sheet1");
		ExcelHelperPOI.readExcelData(0, 0);
//		System.out.println("Test Excel" + CommonVariables.contactinquiries);
//		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_new, "Sheet1");
//		int i = 0;
//		for (int k = 2; k < ExcelHelper.getTotalRowsCount(); k++) {
//			String exceldata = ExcelHelper.getData(0, k);
//			System.out.println("excel value= " + exceldata);
//			System.out.println("list value= " + list.get(i));
//			if (list.get(i).equalsIgnoreCase(exceldata)) {
//				System.out.println("Excel data match");
//				assert true;
//			} else {
//				System.out.println("ELSE Condition is true");
//				assert false;
//			}
//			i++;
//		}
	}

	@And("Verify detail image for add and edit page")
	public void Verify_detail_image_for_add_and_edit_page() throws InterruptedException, IOException {
		String Allowimg = ExcelHelper.getData(1, 5);
		String imgallowyes = "Yes";
		String imagallowno = "No";
		List<WebElement> ImageTag = driver.findElements(By.xpath("//*[@id='temp_image']"));
		List<WebElement> Imagealt = driver.findElements(By.xpath("//*[@id='image_alt']"));
		if (imgallowyes.equalsIgnoreCase(Allowimg)) {
			System.out.println("Allow yes found setting section");
			if ((ImageTag.size() > 0) && (Imagealt.size() > 0)) {
				System.out.println("Image tag & alt is found");
			}
		} else if (imagallowno.equalsIgnoreCase(Allowimg)) {
			System.out.println("Allow No found setting section");
			if ((ImageTag.size() <= 0) && (Imagealt.size() <= 0)) {
				System.out.println("Image tag & alt is not found");
			} else {
				System.out.println("allow section is found");

				assert false;
			}
		}
	}

	@And("Verify admintest data for contactUs setting")
	public void Verify_admintest_data_for_contactUs_setting() throws InterruptedException, IOException {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.contactsetting);
		// System.out.println("EXCEL VALUE PRINT : = " + ExcelHelper.getData(1,1));

		// Contact Settings
		String contacttitle = ExcelHelper.getData(1, 0);
		String contactmessage = ExcelHelper.getData(1, 1);
		String contactemail = ExcelHelper.getData(1, 2);

		contactus.contactSettings(contacttitle, contactmessage, contactemail);

	}

	@Then("Verify the front site")
	public void Verify_the_title_in_front() throws InterruptedException, IOException {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.Homeslider);
		driver.get("http://laravelcms-qa.devdigdev.com/");
		Thread.sleep(2000);
		List<WebElement> Element = driver.findElements(By.xpath("//*[@id='carouselCaptions']/div[1]/div/div/div/h3"));
		int Elementsize = Element.size();
		System.out.println("Element =" + Elementsize);

		for (int i = 1; i <= Elementsize; i++) {
			System.out.println("commxpath =" + commonXpath.Slider_Front_Text.getText());
			System.out.println("Excel value =" + ExcelHelper.getData(1, 1));
			System.out.println("OVERlay text =" + commonXpath.Overlay_Text.getText());
			System.out.println("Excel value1 =" + ExcelHelper.getData(1, 3));
			WebElement Title = driver
					.findElement(By.xpath("//*[@id='carouselCaptions']/div[1]/div[" + i + "]/div/div/h3"));
			WebElement Overlay = driver
					.findElement(By.xpath("//*[@id='carouselCaptions']/div[1]/div[" + i + "]/div/div/p"));
			if (Title.getText().equals(ExcelHelper.getData(1, 1))) {
				System.out.println("Slider Title is match");
				if (Overlay.getText().equals(ExcelHelper.getData(1, 3))) {
					System.out.println("Overlay Test is match");
				} else {
					driver.findElement(By.xpath("//*[@id='carouselCaptions']/div[2]/a")).click();
					System.out.println("Slider Title is not match");
				}
			} else {
				driver.findElement(By.xpath("//*[@id='carouselCaptions']/div[2]/a")).click();
				System.out.println("SLider Title");

			}
		}
	}

	@And("Verify record per page on blog listing page")
	public void Verify_record_per_page_on_blog_listing_page() throws InterruptedException, IOException {
		List<WebElement> bloglist = driver
				.findElements(By.xpath("/html/body/main/div/div/div[1]/div[1]/div/div/div[2]/h3/a"));
		String Blogfield = ExcelHelper.getData(1, 12);
		int bloglist_count = bloglist.size();
		System.out.println("Blog List count =" + bloglist.size());
		if (Blogfield.equals(bloglist_count)) {
			System.out.println("Blog list count is match");
		} else {
			assert false;
			System.out.println("Blog list count is not match");
		}
	}

	@When("I enter all mandatory fields for {string} Homeslider")
	public void I_enter_all_mandatory_fields_for_Add_Homeslider(String formName) throws Throwable {
		switch (formName) {
		case "add":
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.Homeslider);
			String img = ExcelHelper.getData(1, 0);
			System.out.println("Image =" + FilesPaths.EXTRA_FILES_FOLDER + img);
//		commonXpath.AddFileButton.click();
			commonXpath.Image.sendKeys(FilesPaths.EXTRA_FILES_FOLDER + img);
			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");
			commonXpath.uploadButton.click();
			CommonVariables.txtSearchCmnVar = "Slider";
			Thread.sleep(4000);

			break;

		case "edit":
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.Homeslider);
			String title = ExcelHelper.getData(1, 2);
			String overlaytxt = ExcelHelper.getData(1, 3);
			String imagealt = ExcelHelper.getData(1, 4);

			homesliders.enterTitle(title);
			homesliders.enterOverlayText(overlaytxt);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			WebElement Element = driver.findElement(By.xpath("//*[@id='alt_image_text']"));

			js.executeScript("arguments[0].scrollIntoView();", Element);

			homesliders.enterImageAlt(imagealt);
			System.out.println("title = " + title);
			CommonVariables.txtSearchCmnVar = title;

			break;

		default:
			assert false;
			break;
		}
	}

	@Then("Verify detail in {string}")
	public void Verify_detail_in_Home_Slider(String image) throws Throwable {
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement Element = driver.findElement(By.xpath("//*[@id='addimagebtn']"));

		js.executeScript("arguments[0].scrollIntoView();", Element);

		Thread.sleep(2000);
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.Homeslider);
		String Text = ExcelHelper.getData(1, 1);
		String UpdatedTitle = ExcelHelper.getData(1, 2);
		System.out.println("Excel Text =" + Text);
		Thread.sleep(2000);
		commonXpath.Search_Button.click();
		commonXpath.Slider_searchtextbox.sendKeys(Text);
		Thread.sleep(2000);
		commonXpath.Slider_search_button.click();
		Thread.sleep(2000);

		List<WebElement> img = driver.findElements(By.xpath("//*[@id='main']/div[3]/form/div/div[2]/div/div/div"));
		int numofimg = img.size();
		System.out.println("Img size =" + numofimg);

		for (int i = 1; i <= numofimg; i++) {

			if (numofimg > 0)

			{
				WebElement img1 = driver.findElement(By
						.xpath("//*[@id='main']/div[3]/form/div/div[2]/div[" + i + "]/div/div/div[2]/ul/li[2]/div/a"));
				img1.getText();
				System.out.println("Last image =" + img1.getText());
				if (img1.getText().equals(Text)) {
					System.out.println("Slider name is match");
					Thread.sleep(4000);
//					img1.click();
					Actions actions = new Actions(driver);
					WebElement menuOption = driver.findElement(
							By.xpath("//*[@id='main']/div[3]/form/div/div[2]/div[1]/div/div/div[2]/ul/li[2]/div/a"));
					actions.moveToElement(menuOption).perform();

				} else {
					if (img1.equals(UpdatedTitle))
						System.out.println("Slider name is not match");
				}
			}
		}
	}

	@And("Click on Delete button in Home Page Sliders")
	public void Click_on_Delete_button_in_Home_Page_Sliders() throws Throwable {
		commonXpath.Slider_DELETE.click();
		Thread.sleep(2000);
		commonXpath.Slider_submit.click();

	}

	@And("I enter all mandatory fields for Homeslider setting")
	public void I_enter_all_mandatory_fields_for_Homeslider_setting() throws Throwable {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.Homeslider);
		String Dis = ExcelHelper.getData(1, 5);

		homesliders.selectDisplaySlider(Dis);
		Thread.sleep(2000);
		commonXpath.DisplaySlider_save.click();

	}

	@When("I enter all mandatory fields for {string} Galleries")
	public void I_enter_all_mandatory_fields_for_Add_Galleries(String formName) throws Throwable {
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.galleries);
		switch (formName) {
		case "add":
			String title = ExcelHelper.getData(1, 0);
			String imagealt = ExcelHelper.getData(1, 1);
			String image = ExcelHelper.getData(1, 2);
			String description = ExcelHelper.getData(1, 3);
			String metaTitle = ExcelHelper.getData(1, 4);
			String metaDescription = ExcelHelper.getData(1, 5);

			CommonVariables.txtSearchCmnVar = title;

			galleries.enterTitle(title);
			galleries.enterImageAlt(imagealt);
			galleries.selectImage(image);
			galleries.enterDescription(description);
			galleries.enterMetaTitle(metaTitle);
			galleries.enterMetaDescription(metaDescription);

			break;

		case "edit":
			String updatetitle = ExcelHelper.getData(1, 6);

			galleries.enterTitle(updatetitle);
			CommonVariables.txtSearchCmnVar = updatetitle;

			break;

		default:
			assert false;
			break;
		}

	}

	@And("Click on Delete button in Galleries")
	public void Click_on_Delete_button_in_Galleries() throws Throwable {
		Actions actions = new Actions(driver);
		WebElement menuOption = driver
				.findElement(By.xpath("//*[@id='main']/div[3]/form/div/div[2]/div[1]/div/div/div[1]/div/a[2]"));
		actions.moveToElement(menuOption).perform();
		commonXpath.Gallery_DELETE.click();
		Thread.sleep(2000);
		commonXpath.Gallery_Submit.click();

	}

	@Then("Make Galleries status and verify {string}")
	public void Make_Galleries_Active_and_verify_success_message(String message) throws Throwable {
		Thread.sleep(2000);
		commonXpath.Selectcheckbox.click();
		Thread.sleep(2000);
		commonXpath.Inactive_button.click();
		commonXpath.Submit_button.click();
		Thread.sleep(2000);
		System.out.println("msg =" + commonXpath.Inactive_msg_gallery.getText());
		System.out.println("Str ="+message);
		String msg = "Selected Gallery(s) have been inactivated successfully.";
		if (commonXpath.Inactive_msg_gallery.getText().equals(msg)) {
			System.out.println("Inactive status msg =" + commonXpath.Inactive_msg_gallery.getText());
		}
		commonXpath.Selectcheckbox.click();
		Thread.sleep(2000);
		commonXpath.Active_button.click();
		commonXpath.Submit_button.click();
		Thread.sleep(2000);
		String msg1 = "Selected Gallery(s) have been activated successfully.";
		if (commonXpath.Inactive_msg_gallery.getText().equals(msg1)) {
			System.out.println("Active status msg =" + commonXpath.Inactive_msg_gallery.getText());
		}
	}
	@Then("Make Home Page Sliders status and verify {string}")
	public void Make_Home_Page_Sliders_Active_and_verify_success_message(String message) throws Throwable {
		Thread.sleep(2000);
		commonXpath.Selectcheckbox.click();
		Thread.sleep(2000);
		commonXpath.Inactive_button.click();
		commonXpath.Submit_button.click();
		Thread.sleep(2000);
		System.out.println("msg =" + commonXpath.Inactive_msg_gallery.getText());
		System.out.println("Str ="+message);
		String msg = "Selected Slider(s) have been inactivated successfully.";
		if (commonXpath.Inactive_msg_gallery.getText().equals(msg)) {
			System.out.println("Inactive status msg =" + commonXpath.Inactive_msg_gallery.getText());
		}
		commonXpath.Selectcheckbox.click();
		Thread.sleep(2000);
		commonXpath.Active_button.click();
		commonXpath.Submit_button.click();
		Thread.sleep(2000);
		String msg1 = "Selected Slider(s) have been activated successfully.";
		if (commonXpath.Inactive_msg_gallery.getText().equals(msg1)) {
			System.out.println("Active status msg =" + commonXpath.Inactive_msg_gallery.getText());
		}
	}
}