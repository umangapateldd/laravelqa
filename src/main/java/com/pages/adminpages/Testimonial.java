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

public class Testimonial {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	private Logger log = LogHelper.getLogger(Testimonial.class);
	boolean verifyDetails = false;

	@FindBy(id = "client_name")
	WebElement AuthorName;

	@FindBy(id = "url")
	WebElement URL;

	@FindBy(xpath = "//*[@id='status']")
	WebElement Status;

	@FindBy(xpath = "//body[@id='tinymce']")
	WebElement Description;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[7]/a")
	WebElement editbutton;

	@FindBy(xpath = "/html/body/nav/ul/li[6]/div/a[2]")
	WebElement Settingmenu;

	@FindBy(xpath = "//*[@id='field_testimonial_title_display']")
	WebElement Settingfield;

	@FindBy(xpath = "//*[@id='btnsave']")
	WebElement Settingsave;

	public Testimonial(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void enterAuthorName(String authorName) {
		log.info("********************Enter the Author Name********************");
		AuthorName.clear();
		AuthorName.sendKeys(authorName);
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
		driver.switchTo().frame("description_ifr");
		Description.sendKeys(description);
		driver.switchTo().defaultContent();
	}

	public void entersettingfield(String settingfield) {
		log.info("********************Enter the Author LastName********************");
		
        
		dropDownHelper.selectVisibleText(Settingfield, settingfield);
	}

	public void ClickonSettingmenu() throws InterruptedException {
		log.info("********************Click on Setting Menu********************");
		Thread.sleep(2000);
		Settingmenu.click();
		Thread.sleep(2000);
	}

	public void ClickonSettingsave() throws InterruptedException {
		log.info("********************Click on Setting save********************");
		Settingsave.click();
		Thread.sleep(2000);
	}

}
