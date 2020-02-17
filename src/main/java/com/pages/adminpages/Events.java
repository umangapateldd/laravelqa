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
	
	@FindBy(xpath = "//*[@id='zipcode']")
	WebElement Zipcode;
	
	@FindBy(xpath = "//*[@id='country']")
	WebElement Country;
	
	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[7]/a")
	WebElement editbutton;

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

	public void enterStartDate(String startDate) {
		log.info("********************Enter the Author LastName********************");
		
        StartDate.sendKeys(startDate);
	}
	
	public void enterEndDate(String endDate) {
		log.info("********************Enter the Author LastName********************");
		
		EndDate.sendKeys(endDate);
	}
	
	public void enterEventTime(String eventTime) {
		log.info("********************Enter the Author LastName********************");
		
		EventTime.sendKeys(eventTime);
	}


	public void ClickonSettingsave() throws InterruptedException {
		log.info("********************Click on Setting save********************");
		Settingsave.click();
		Thread.sleep(2000);
	}

}


