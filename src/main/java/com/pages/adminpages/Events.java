package com.pages.adminpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
import com.utilities.CommonXpath;

public class Events {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	CommonXpath commonXpath;
	private Logger log = LogHelper.getLogger(Events.class);
	boolean verifyDetails = false;

	public Events(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		commonXpath = new CommonXpath(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void enterTitle(String title) {
		log.info("********************Enter the Author Name********************");
		commonXpath.Title.clear();
		commonXpath.Title.sendKeys(title);
	}

	public void enterURL(String url) {
		log.info("********************Enter the URL********************");
		commonXpath.URL.clear();
		commonXpath.URL.sendKeys(url);
	}
	
	public void enterRecurrence(String recurrence) {
		log.info("********************Enter the URL********************");
		commonXpath.Recurrence.sendKeys(recurrence);
	}


	public void enterStatus(String status) {
		log.info("********************Enter the Status********************");
		dropDownHelper.selectByVaule(commonXpath.Status, "1");
	}

	public void ClickonEditbutton() {
		log.info("********************Click on Edit button********************");
		commonXpath.Eventeditbutton.click();
	}

	public void enterDescription(String description) throws InterruptedException {
		log.info("********************Enter the Additional Bio ********************");
		commonXpath.EventDescription.sendKeys(description);
	}

	public void enterStartDate(String startDate) throws InterruptedException {
		log.info("********************Enter the Author LastName********************");

		commonXpath.StartDate.click();
		Thread.sleep(3000);
		commonXpath.selectdate.click();
		Thread.sleep(5000);

	}

	public void enterEndDate(String endDate) throws InterruptedException {
		log.info("********************Enter the Author LastName********************");

		commonXpath.EndDate.click();
		Thread.sleep(4000);
		commonXpath.selectenddate.click();
		Thread.sleep(3000);
	}

	public void enterEventTime(String eventTime) throws InterruptedException {
		log.info("********************Enter the Author LastName********************");

		commonXpath.EventTime.click();
		Thread.sleep(3000);
		commonXpath.eventtime.click();
		Thread.sleep(3000);
		commonXpath.AMPMtime.click();
		Thread.sleep(3000);
	}

	public void enterAddress1(String address1) throws InterruptedException {
		log.info("********************Click on Setting save********************");
		commonXpath.Address1.sendKeys(address1);

	}

	public void enterAddress2(String address2) throws InterruptedException {
		log.info("********************Click on Setting save********************");
		commonXpath.Address2.sendKeys(address2);
	}

	public void enterCity(String city) throws InterruptedException {
		log.info("********************Click on Setting save********************");
		commonXpath.City.sendKeys(city);
	}
	public void enterState(String state) throws InterruptedException {
		log.info("********************Click on Setting save********************");
		commonXpath.State.sendKeys(state);
	}
	public void enterZipcode(String zipcode) throws InterruptedException {
		log.info("********************Click on Setting save********************");
		commonXpath.Zipcode.sendKeys(zipcode);
	}
	public void enterCountry(String country) throws InterruptedException {
		log.info("********************Click on Setting save********************");
		commonXpath.Country.sendKeys(country);
	}
}
