package com.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.basicactions.DropDownHelper;
import com.basicactions.ExcelHelper;
import com.basicactions.LogHelper;
import com.pages.adminpages.Blogs;
import com.pages.adminpages.Categories;
import com.pages.adminpages.Events;
import com.pages.adminpages.FAQ;
import com.pages.adminpages.Galleries;
import com.pages.adminpages.Homesliders;
import com.pages.adminpages.Ourteam;
import com.pages.adminpages.Pages;
import com.pages.adminpages.Settings;
import com.pages.adminpages.Testimonial;
import com.pages.adminpages.UsersPage;

public class CommonFunc {

	WebDriver driver;
	CommonVariables commonVariables;
	CommonXpath commonXpath;
	DropDownHelper dropDownHelper;
	Ourteam ourteam;
	Blogs blogs;
	Testimonial testimonial;
	UsersPage userspage;
	Categories categories;
	FAQ faq;
	Events events;
	Pages pages;
	Galleries galleries;
	Homesliders homepagesliders;

	Settings settings;
	private Logger log = LogHelper.getLogger(CommonFunc.class);

	@FindBy(xpath = "//*[@id='add-btn']")
	WebElement addNewButton;

	@FindBy(xpath = "//button[@value='save']")
	WebElement saveButton;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[9]/a")
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

	@FindBy(xpath = "//*[@id='frmaddedit']/div[1]/div[2]/div/div/a")
	WebElement CancelButton;

	@FindBy(xpath = "//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]/a[1]/span[1]")
	WebElement statuscolumn;

	@FindBy(xpath = "//*[@id='main']/div[1]/span")
	WebElement successmsg;

	@FindBy(xpath = "/html/body/main/div/div/div[1]/div[1]/div/div/div[2]/h3/a")
	WebElement Bloglist_record;

	public CommonFunc(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonVariables = new CommonVariables(driver);
		commonXpath = new CommonXpath(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void checkElementAvailable(List<WebElement> xpathListElement) {
		int tmp = 1;
		long t = System.currentTimeMillis();
		long end = t + 40000;

		do {
			if (System.currentTimeMillis() > end) {
				System.out.println("timeout");
				tmp = 1;
			}

			if (xpathListElement.size() > 0) {
				tmp = 0;
			} else {
				tmp = 1;
			}

		} while (tmp == 1);
	}

	public void checkElementAvailableWithAttributeCompare(List<WebElement> xpathListElement, WebElement xpath,
			String attributeName, String attributeValue) {
		int tmp = 1;
		long t = System.currentTimeMillis();
		long end = t + 40000;

		do {
			if (System.currentTimeMillis() > end) {
				System.out.println("timeout");
				tmp = 1;
			}

			if (xpathListElement.size() > 0 && xpath.getAttribute(attributeName).equals(attributeValue)) {
				tmp = 0;
			} else {
				tmp = 1;
			}

		} while (tmp == 1);
	}

	public void clickMenuOption(String menuTitle) throws InterruptedException {
		checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element, "style",
				"display: none;");

		if (menuTitle.toLowerCase().equals("my profile")) {
			CommonXpath.profileMainMenu.click();
			CommonXpath.myProfileMenu.click();
		} else if (menuTitle.toLowerCase().equals("change password")) {
			CommonXpath.profileMainMenu.click();
			CommonXpath.changePasswordMenu.click();

		} else {
			List<WebElement> menu = driver.findElements(By.xpath("//*[@id='main']/div[2]/div/div/div/a"));

			int count = menu.size();
			for (int i = 1; i <= count; i++) {
				String m1 = driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div/div[" + i + "]/a")).getText();
				System.out.println("m1=" + m1);
				System.out.println("menu title=" + menuTitle);
				if (m1.equals(menuTitle)) {
					driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div/div[" + i + "]/a")).click();
					break;
				}
			}
		}
	}

	public void verifythesheetname(String moduleName) throws InterruptedException {
		System.out.println("Module name =" + moduleName);
		System.out.println("Commvariable =" + CommonVariables.galleries);

		if (moduleName.equals(CommonVariables.users)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.users);
		} else if (moduleName.equals(CommonVariables.ourteam)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.ourteam);
		} else if (moduleName.equals(CommonVariables.blogs)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.blogs);
		} else if (moduleName.equals(CommonVariables.testimonial)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.testimonial);
		} else if (moduleName.equals(CommonVariables.categories)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.categories);
		} else if (moduleName.equals(CommonVariables.faqs)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.faqs);
		} else if (moduleName.equals(CommonVariables.events)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.events);
		} else if (moduleName.equals(CommonVariables.pages)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.pages);
		} else if (moduleName.equals(CommonVariables.iptracker)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.iptracker);
		} else if (moduleName.equals(CommonVariables.settings)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.settings);
		} else if (moduleName.equals(CommonVariables.contactus)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.contactus);
		} else if (moduleName.equals(CommonVariables.Homeslider)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.Homeslider);
		} else if (moduleName.equals(CommonVariables.galleries)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.galleries);
		} else if (moduleName.toLowerCase().equals("change password")) {

		} else if (moduleName.toLowerCase().equals("my profile")) {

		} else {
			assert false;
		}
	}

	public void searchRecord(String searchText, String verifyTableText, String xpath, String moduleName)
			throws InterruptedException {
		checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element, "style",
				"display: none;");

		driver.findElement(By.xpath("//*[@id='search-btn']")).click();
		System.out.println(searchText);
		driver.findElement(By.xpath("//*[@id='search']")).clear();
		driver.findElement(By.xpath("//*[@id='search']")).sendKeys(searchText);
		driver.findElement(By.xpath("//*[@id='btnsearch']")).click();

		checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element, "style",
				"display: none;");
		if (moduleName.equals("Galleries")) {
			List<WebElement> IMage = driver.findElements(By.xpath("//*[@id='main']/div[3]/form/div/div[2]/div"));
			int imgcount = IMage.size();
			System.out.println("Image =" + imgcount);
			xpath = "//*[@id='main']/div[3]/form/div/div[2]/div[" + imgcount + "]/div/div/div[2]/ul/li[2]/p";

		}
		System.out.println("XPATH VALUE =" + driver.findElement(By.xpath(xpath)).getText());
		System.out.println("verify table text=" + verifyTableText);

		if (CommonVariables.deleteRecord == true) {
			if (moduleName.equals(CommonVariables.users)) {
				searchText = "No user(s) found";
			} else if (moduleName.equals(CommonVariables.ourteam)) {
				searchText = "No team member(s) found";
			} else if (moduleName.equals(CommonVariables.blogs)) {
				searchText = "No blog(s) found";
				System.out.println("SEARCH TEXT2" + searchText);
			} else if (moduleName.equals(CommonVariables.testimonial)) {
				searchText = "No testimonial(s) found";
			} else if (moduleName.equals(CommonVariables.categories)) {
				searchText = "No category(s) found";
			} else if (moduleName.equals(CommonVariables.faqs)) {
				searchText = "No FAQ(s) found";
			} else if (moduleName.equals(CommonVariables.events)) {
				searchText = "No event(s) found";
			} else if (moduleName.equals(CommonVariables.pages)) {
				searchText = "No page(s) found";
			} else {
				assert false;
			}
		}
		System.out.println("xpath =" + driver.findElement(By.xpath(xpath)).getText());
		System.out.println("tabletext = " + verifyTableText);
		if (driver.findElement(By.xpath(xpath)).getText().trim().contains(verifyTableText.trim())) {
			System.out.println(moduleName + " data match " + driver.findElement(By.xpath(xpath)).getText());

			if (moduleName.equals(CommonVariables.blogs) && CommonVariables.deleteRecord == false) {
				blogs = new Blogs(driver);
				System.out.println("Module name =" + moduleName);
				System.out.println("commonvariable =" + CommonVariables.blogs);
				CommonVariables.publishdate = blogs.getPublishdate();
				System.out.println("Publish date value : " + CommonVariables.publishdate);
			}

			CommonVariables.deleteRecord = false;
			assert true;
		} else {
			System.out.println("no record found");
			assert false;
		}
	}

	public void checkSuccessMessage(String inactive_msg, String active_msg, String moduleName, WebElement statuscolumn,
			WebElement successmsg) {

		String msg = "";

		String msg2 = "";

		if (CommonVariables.inactive.equals("false")) {
			msg = inactive_msg;
		} else if (CommonVariables.inactive.equals("true")) {
			msg2 = active_msg;
		} else {
			System.out.println(moduleName + " Message is not match");
			assert false;
		}

		statuscolumn.click();

		checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element, "style",
				"display: none;");

		if (successmsg.getText().equals(msg)) {
			System.out.println("Messgae for active = " + moduleName + " > " + msg);
		} else if (successmsg.getText().equals(msg2)) {
			System.out.println("Messgae for inactive = " + moduleName + " > " + msg2);
		} else {
			System.out.println(moduleName + " Message is not match:");
			assert false;
		}
	}

	public void clickOnAddNewButton(String modulename) throws InterruptedException {
		log.info("********************Click on add new user button********************");
		if (modulename.equals("Home Page Sliders")) {
			System.out.println("Home page sliders module is open");
			commonXpath.HomesliderAddbutton.click();
		} else {
			System.out.println("Else condition");
			addNewButton.click();
		}
	}

	public void clickOnEditButton(String moduleName) throws InterruptedException {
		log.info("********************Click on edit button********************");
		Thread.sleep(2000);
		if (moduleName.equals("Our Team")) {
			System.out.println("edit if our team");
			ourteam = new Ourteam(driver);
			ourteam.ClickonEditbutton();
		} else if (moduleName.equals("Users")) {
			userspage = new UsersPage(driver);
			System.out.println("edit if users");
			editButton.click();
		} else if (moduleName.equals("Blogs")) {
			System.out.println("edit if blogs");
			blogs = new Blogs(driver);
			blogs.ClickonEditbutton();
		} else if (moduleName.equals("Testimonial")) {
			System.out.println("edit if Testimonial");
			testimonial = new Testimonial(driver);
			testimonial.ClickonEditbutton();
		} else if (moduleName.equals("Categories")) {
			System.out.println("edit if Categories");
			categories = new Categories(driver);
			categories.ClickonEditbutton();
		} else if (moduleName.equals("FAQs")) {
			System.out.println("edit if FAQ");
			faq = new FAQ(driver);
			faq.ClickonEditbutton();
		} else if (moduleName.equals("Events")) {
			System.out.println("edit if Events");
			events = new Events(driver);
			events.ClickonEditbutton();
		} else if (moduleName.equals("Pages")) {
			System.out.println("edit if Pages");
			pages = new Pages(driver);
			pages.ClickonEditbutton();
		} else if (moduleName.equals("Home Page Sliders")) {
			System.out.println("edit if Home Page Sliders");
			homepagesliders = new Homesliders(driver);
			Actions actions = new Actions(driver);
			WebElement menuOption = driver.findElement(By.xpath("//*[@id='display_order_62']/div/div/div[1]"));
			actions.moveToElement(menuOption).perform();
			homepagesliders.ClickonEditbutton();
		} else if (moduleName.equals("Galleries")) {
			System.out.println("edit if Galleries");
			galleries = new Galleries(driver);
			Actions actions = new Actions(driver);
			WebElement menuOption = driver
					.findElement(By.xpath("//*[@id='main']/div[3]/form/div/div[2]/div[1]/div/div/div[1]/div/a[2]"));
			actions.moveToElement(menuOption).perform();
			galleries.ClickonEditbutton();
		} else {
			System.out.println("edit else - module is not defined");
			assert false;
		}

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
		CancelButton.click();
	}

	public void clickOnsavecontinuebutton() throws InterruptedException {
		log.info("********************Click on save and continue button********************");
		savecontinueButton.click();
	}

	public void clickOnSave(String moduleName) throws InterruptedException {
		log.info("********************Click on submit button********************");
		saveButton.click();
		Thread.sleep(1000);
		System.out.println("email vlaue=" + CommonVariables.email);
		if (moduleName.equals(CommonVariables.users)) {
			ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.users);
			String msg = "The email has already been taken.";

			if ((driver.findElements(By.xpath("//*[@id='frmaddedit']/div[2]/div/div[3]/div")).size() > 0) && msg
					.equals(driver.findElement(By.xpath("//*[@id='frmaddedit']/div[2]/div/div[3]/div")).getText())) {
				System.out.println("email vlaue=" + CommonVariables.email);
				System.out.println("message text is match");
				driver.findElement(By.xpath("//*[@id='frmaddedit']/div[1]/div[2]/div/div/a")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='search-btn']")).click();
				driver.findElement(By.xpath("//*[@id='search']")).sendKeys(CommonVariables.email);
				System.out.println(CommonVariables.email);
				driver.findElement(By.xpath("//*[@id='btnsearch']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[2]/div")).click();
				deletebutton.click();
				confirmyesbutton.click();
				Thread.sleep(2000);
			}
//			addNewButton.click();
//			Thread.sleep(2000);
//			String firstname = ExcelHelper.getData(1, 0);
//			String lastname = ExcelHelper.getData(1, 1);
//			String email = ExcelHelper.getData(1, 2);
//			commonXpath.FirstName.sendKeys(firstname);
//			commonXpath.LastName.sendKeys(lastname);
//			commonXpath.userEmail.sendKeys(email);
//
//			saveButton.click();
		}
	}

	public void clickOnstatuscolumn(String moduleName) throws InterruptedException {
		log.info("********************Click on status********************");
		Thread.sleep(2000);
		String Msg = "";
		String Msg2 = "";
		Thread.sleep(3000);

		if (CommonVariables.inactive.equals("false")) {
			Msg = "The " + moduleName + " successfully inactivated.";
			System.out.println("test msg1 = " + Msg);
		} else if (CommonVariables.inactive.equals("true")) {
			Msg2 = "The " + moduleName + " successfully activated.";
			System.out.println("test msg2 = " + Msg2);
		} else {
			System.out.println("Message is not match:");
			assert false;
		}

		statuscolumn.click();
		Thread.sleep(3000);

		if (successmsg.getText().equals(Msg)) {
			System.out.println("Messgae for inactive  = " + successmsg.getText());
		} else if (successmsg.getText().equals(Msg2)) {
			System.out.println("Messgae for active  = " + successmsg.getText());
		} else {
			assert false;
		}
	}

	public void verifyTestAllData(String excelSheetName, String xpathTextbox, String xpathErrorMessage)
			throws InterruptedException {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file, excelSheetName);

		for (int i = 0; i < ExcelHelper.getTotalRowsCount(); i++) {
			driver.findElement(By.xpath(xpathTextbox)).clear();
			driver.findElement(By.xpath(xpathTextbox)).sendKeys(ExcelHelper.getData(0, i));
			driver.findElement(By.xpath(xpathTextbox)).sendKeys(Keys.TAB);
			Thread.sleep(1500);

			if (driver.findElement(By.xpath(xpathErrorMessage)).getText().isEmpty()) {
				String msgtext = "Error not show";
				if (msgtext.equals(ExcelHelper.getData(1, i))) {
					assert true;
				}
			} else {
				assert false;
			}
		}
	}

	public void verifyTestEmailData(String excelSheetName, String xpathTextbox, String xpathErrorMessage)
			throws InterruptedException {
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file, excelSheetName);

		for (int i = 0; i < ExcelHelper.getTotalRowsCount(); i++) {
			driver.findElement(By.xpath(xpathTextbox)).clear();
			driver.findElement(By.xpath(xpathTextbox)).sendKeys(ExcelHelper.getData(0, i));
			driver.findElement(By.xpath(xpathTextbox)).sendKeys(Keys.TAB);
			Thread.sleep(1500);

			if (driver.findElement(By.xpath(xpathErrorMessage)).getText().isEmpty()) {
				String msgtext = "Error not show";
				if (msgtext.equals(ExcelHelper.getData(1, i))) {
					assert true;
				}
			} else {
				String text = "Error show";

				if (text.equals(ExcelHelper.getData(1, i))) {
					System.out.println("Error show text is match");

					String emailError = driver.findElement(By.xpath(xpathErrorMessage)).getText();
					if (emailError.contains(ExcelHelper.getData(2, i))) {
						assert true;
					}
				} else {
					assert false;
				}
			}
		}
	}

	public void verifytablegridData(String Excelvalue, String moduleName) {

		List<WebElement> ele = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th"));
		int count = ele.size();
		int j = 0;

		String[] values = Excelvalue.split(",");
		System.out.println("values = " + values);
		int i = 4;
		if (moduleName.equals("IP Tracker")) {
			i = 2;
		} else {
			i = 4;
		}

		for (; i <= count; i++) {
			System.out.println("iiiiiiii = " + i);
			System.out.println("th row = " + driver
					.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[" + i + "]")).getText().trim());
			System.out.println(values[j]);
			if (driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[" + i + "]")).getText().trim()
					.equals(values[j].trim())) {
			} else {
				assert false;
			}
			j++;
		}
	}

	public void verifypaginationcount() {
		List<WebElement> numofrecord = driver.findElements(By.xpath(" //*[@id='DataTables_Table_0']/tbody/tr/td[4]"));
		int rcount = numofrecord.size();
		System.out.println("record of count=" + rcount);

		Select select = new Select(driver.findElement(By.xpath("//*[@id='DataTables_Table_0_length']/label/select")));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		System.out.println("selected item = " + defaultItem);
		System.out.println("value of test=" + String.valueOf(rcount));

		if (defaultItem.equals(CommonVariables.Numrecord)) {
			System.out.println("Count is match");
			if (Integer.parseInt(defaultItem) >= rcount) {
				System.out.println("page count match");
			}
		} else {
			assert false;

		}
	}

	public void URLget() {
		String credentials[] = null;
		JSONParser jsonParser = new JSONParser();
		System.out.println("file=" + FilesPaths.json_data_laravel_file);

		try (FileReader reader = new FileReader(FilesPaths.json_data_laravel_file)) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONObject jobj = new JSONObject(obj.toString());
			int numOfTestCase = jobj.getJSONArray("cases").length();
			System.out.println("numOfTestCase = " + numOfTestCase);
			credentials = new String[numOfTestCase];
			JSONObject jb;
			for (int i = 0; i < jobj.getJSONArray("cases").length(); i++) {
				jb = (JSONObject) jobj.getJSONArray("cases").get(i);
				if (jb.has("testcase") == true) {
					credentials[i] = jb.getString("testcase");
				}
			}
			List<String> list = Arrays.asList(credentials);
			jb = (JSONObject) jobj.getJSONArray("cases").get(list.indexOf("stageURL"));

			CommonVariables.frontURL = jb.has("frontURL") ? jb.getString("frontURL") : "nofrontURL";
			CommonVariables.adminURL = jb.has("adminURL") ? jb.getString("adminURL") : "noadminURL";

			System.out.println(CommonVariables.frontURL);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void Credentialget() {
		String credentials[] = null;
		JSONParser jsonParser = new JSONParser();
		System.out.println("file=" + FilesPaths.json_data_credentials_file);

		try (FileReader reader = new FileReader(FilesPaths.json_data_credentials_file)) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONObject jobj = new JSONObject(obj.toString());
			int numOfTestCase = jobj.getJSONArray("credentials").length();
			System.out.println("numOfTestCase = " + numOfTestCase);
			credentials = new String[numOfTestCase];
			JSONObject jb;
			for (int i = 0; i < jobj.getJSONArray("credentials").length(); i++) {
				jb = (JSONObject) jobj.getJSONArray("credentials").get(i);
				if (jb.has("testcase") == true) {
					credentials[i] = jb.getString("testcase");
				}
			}
			List<String> list = Arrays.asList(credentials);
			jb = (JSONObject) jobj.getJSONArray("credentials").get(list.indexOf("stageURL"));

			CommonVariables.loginEmail = jb.has("loginEmail") ? jb.getString("loginEmail") : "loginEmail";
			CommonVariables.loginPwd = jb.has("loginPwd") ? jb.getString("loginPwd") : "loginPwd";

			System.out.println(CommonVariables.loginEmail);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}