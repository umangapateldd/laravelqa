package com.utilities;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
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

	public CommonFunc(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonVariables = new CommonVariables(driver);
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

	public void clickonmenuondashboard(String menuTitle) throws InterruptedException {
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

		if (driver.findElement(By.xpath(xpath)).getText().trim().equalsIgnoreCase(searchText)) {
			System.out.println(moduleName + " data match " + driver.findElement(By.xpath(xpath)).getText());

			if (moduleName.equals(CommonVariables.blogs)) {
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

}