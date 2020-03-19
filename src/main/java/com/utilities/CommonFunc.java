package com.utilities;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.ExcelHelper;
import com.basicactions.LogHelper;
import com.pages.adminpages.Blogs;
import com.pages.adminpages.Categories;
import com.pages.adminpages.Events;
import com.pages.adminpages.FAQ;
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

				if (m1.equals(menuTitle)) {
					driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div/div[" + i + "]/a")).click();
					break;
				}
			}
		}
	}

	public void verifythesheetname(String moduleName) throws InterruptedException {

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
		} else {
			assert false;
		}
	}

	public void searchRecord(String searchText, String xpath, String moduleName) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='search-btn']")).click();
		System.out.println(searchText);
		driver.findElement(By.xpath("//*[@id='search']")).clear();
		driver.findElement(By.xpath("//*[@id='search']")).sendKeys(searchText);
		driver.findElement(By.xpath("//*[@id='btnsearch']")).click();
		checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element, "style",
				"display: none;");

		System.out.println("module name =" + moduleName);
		System.out.println("searchtext name =" + searchText);
		System.out.println("xpath = " + xpath);
		System.out.println("XPATH VALUE =" + driver.findElement(By.xpath(xpath)).getText());

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

		if (driver.findElement(By.xpath(xpath)).getText().equalsIgnoreCase(searchText)) {
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

	public void clickOnAddNewButton() throws InterruptedException {
		log.info("********************Click on add new user button********************");
		addNewButton.click();
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

	public void clickOnSave() throws InterruptedException {
		log.info("********************Click on submit button********************");
		saveButton.click();
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

	public void verifytablegridData(String Excelvalue) {

		List<WebElement> ele = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th"));
		int count = ele.size();
		int j = 0;

		String[] values = Excelvalue.split(",");
		int i = 4;
		if (ExcelHelper.getData(0, 8).equals("IP Tracker")) {
			i = 2;
		} else {
			i = 4;
		}

		for (; i <= count; i++) {
			if (driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[" + i + "]")).getText().trim()
					.equals(values[j].trim())) {
			} else {
				assert false;
			}
			j++;
		}
	}
}