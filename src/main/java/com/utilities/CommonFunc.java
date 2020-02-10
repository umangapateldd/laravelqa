package com.utilities;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.ExcelHelper;
import com.basicactions.LogHelper;
import com.pages.adminpages.Ourteam;

public class CommonFunc {

	WebDriver driver;
	CommonVariables commonVariables;
	DropDownHelper dropDownHelper;
	Ourteam ourteam;
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
				

				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div/div[" + i + "]/a")).click();
				Thread.sleep(3000);
				ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.users);
				ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.ourteam);
				break;
			}
		}
	}

	public void searchRecord(String searchText, String xpath, String moduleName) throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='search-btn']")).click();
//		Thread.sleep(1000);
		System.out.println(searchText);
		driver.findElement(By.xpath("//*[@id='search']")).clear();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='search']")).sendKeys(searchText);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='btnsearch']")).click();
		Thread.sleep(4000);

		if (CommonVariables.deleteRecord == true) {
			if (moduleName.equals(CommonVariables.users)) {
				searchText = "No user(s) found";
			} else if (moduleName.equals(CommonVariables.ourteam)) {
				searchText = "No team member(s) found";
			}
		}

		Thread.sleep(5000);

		if (driver.findElement(By.xpath(xpath)).getText().trim().equalsIgnoreCase(searchText)) {
			System.out.println(moduleName + " data match " + driver.findElement(By.xpath(xpath)).getText());
			Thread.sleep(3000);
			assert true;
		} else {
			System.out.println("no record found");
			assert false;
		}
	}

	public void clickOnAddNewButton() {
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
			System.out.println("edit if users");
			editButton.click();
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
		Thread.sleep(5000);
		CancelButton.click();
		Thread.sleep(5000);
	}

	public void clickOnsavecontinuebutton() throws InterruptedException {
		log.info("********************Click on save and continue button********************");
		Thread.sleep(5000);
		savecontinueButton.click();
		Thread.sleep(2000);

	}

	public void clickOnSave() {
		log.info("********************Click on submit button********************");
		saveButton.click();
	}

}