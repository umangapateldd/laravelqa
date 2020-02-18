package com.pages.adminpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;

public class Events {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	private Logger log = LogHelper.getLogger(Events.class);
	boolean verifyDetails = false;

	@FindBy(id = "title")
	WebElement Title;

	@FindBy(id = "url")
	WebElement URL;

	@FindBy(xpath = "//*[@id='status']")
	WebElement Status;

	@FindBy(xpath = "//*[@id='description']")
	WebElement Description;

	@FindBy(xpath = "//*[@id='start_date']")
	WebElement StartDate;

	@FindBy(xpath = "//*[@id='end_date']")
	WebElement EndDate;

	@FindBy(xpath = "//*[@id='event_time']")
	WebElement EventTime;

	@FindBy(xpath = "//*[@id='address1']")
	WebElement Address1;

	@FindBy(xpath = "//*[@id='address2']")
	WebElement Address2;

	@FindBy(xpath = "//*[@id='city']")
	WebElement City;

	@FindBy(xpath = "//*[@id='state']")
	WebElement State;

	@FindBy(xpath = "//*[@id='frmaddedit']/div[2]/div/div[3]/div[2]/div[3]/table/tbody/tr[4]/td[2]")
	WebElement selectdate;

	@FindBy(xpath = "//*[@id='frmaddedit']/div[2]/div/div[4]/div[2]/div[3]/table/tbody/tr[4]/td[6]")
	WebElement selectenddate;

	@FindBy(xpath = "//*[@id='zipcode']")
	WebElement Zipcode;

	@FindBy(xpath = "//*[@id='country']")
	WebElement Country;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[10]/a")
	WebElement editbutton;

	@FindBy(xpath = "//*[@id='frmaddedit']/div[2]/div/div[5]/div[2]/div[2]/table/tbody/tr/td/fieldset[1]/span[1]")
	WebElement eventtime;

	@FindBy(xpath = "//*[@id='frmaddedit']/div[2]/div/div[5]/div[2]/div[1]/table/tbody/tr/td/fieldset/span[1]")
	WebElement AMPMtime;

	@FindBy(xpath = "//*[@id='recurrence']")
	WebElement Recurrence;

	@FindBy(xpath = "//*[@id='field_testimonial_title_display']")
	WebElement Settingfield;

	@FindBy(xpath = "//*[@id='btnsave']")
	WebElement Settingsave;

	public Events(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void enterTitle(String title) {
		log.info("********************Enter the Author Name********************");
		Title.clear();
		Title.sendKeys(title);
	}

	public void enterURL(String url) {
		log.info("********************Enter the URL********************");
		URL.clear();
		URL.sendKeys(url);
	}
	
	public void enterRecurrence(String recurrence) {
		log.info("********************Enter the URL********************");
		Recurrence.sendKeys(recurrence);
	}


	public void enterStatus(String status) {
		log.info("********************Enter the Status********************");
		Status.click();
		Status.sendKeys(status);
	}

	public void ClickonEditbutton() {
		log.info("********************Click on Edit button********************");
		editbutton.click();
	}

	public void enterDescription(String description) throws InterruptedException {
		log.info("********************Enter the Additional Bio ********************");
		Description.sendKeys(description);
	}

	public void enterStartDate(String startDate) throws InterruptedException {
		log.info("********************Enter the Author LastName********************");

		StartDate.click();
		Thread.sleep(3000);
		selectdate.click();
		Thread.sleep(5000);

	}

	public void enterEndDate(String endDate) throws InterruptedException {
		log.info("********************Enter the Author LastName********************");

		EndDate.click();
		Thread.sleep(4000);
		selectenddate.click();
		Thread.sleep(3000);
	}

	public void enterEventTime(String eventTime) throws InterruptedException {
		log.info("********************Enter the Author LastName********************");

		EventTime.click();
		Thread.sleep(3000);
		eventtime.click();
		Thread.sleep(3000);
		AMPMtime.click();
		Thread.sleep(3000);
	}

	public void enterAddress1(String address1) throws InterruptedException {
		log.info("********************Click on Setting save********************");
		Address1.sendKeys(address1);

	}

	public void enterAddress2(String address2) throws InterruptedException {
		log.info("********************Click on Setting save********************");
		Address2.sendKeys(address2);
	}

	public void enterCity(String city) throws InterruptedException {
		log.info("********************Click on Setting save********************");
		City.sendKeys(city);
	}
	public void enterState(String state) throws InterruptedException {
		log.info("********************Click on Setting save********************");
		State.sendKeys(state);
	}
	public void enterZipcode(String zipcode) throws InterruptedException {
		log.info("********************Click on Setting save********************");
		Zipcode.sendKeys(zipcode);
	}
	public void enterCountry(String country) throws InterruptedException {
		log.info("********************Click on Setting save********************");
		Country.sendKeys(country);
	}
}
