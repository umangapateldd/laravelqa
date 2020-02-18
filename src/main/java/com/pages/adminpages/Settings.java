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

public class Settings {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	private Logger log = LogHelper.getLogger(Pages.class);
	boolean verifyDetails = false;

	@FindBy(id = "app_name")
	WebElement AppName;

	@FindBy(id = "footer_title_for_admin")
	WebElement FooterTitleforAdmin;

	@FindBy(xpath = "//*[@id='status']")
	WebElement Status;
	
	@FindBy(xpath = "//*[@id='site-config-heading-1']/h5/a")
	WebElement FrontEndSettings;
	
	@FindBy(id = "site_title")
	WebElement Sitetitle;

	@FindBy(id = "tagline")
	WebElement Tagline;
	
	@FindBy(xpath = "//*[@id='btnsave']")
	WebElement Save;
	
	@FindBy(id = "copyright_text")
	WebElement Copyrighttext;
	
	@FindBy(id = "meta_description_for_front")
	WebElement Meta_description_for_front;
	
	@FindBy(xpath = "//*[@id='records_per_page']")
	WebElement NoofRecordsperPage;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[7]/a")
	WebElement editbutton;


	public Settings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void enterAppName(String appName) {
		log.info("********************Enter the Author Name********************");
		AppName.clear();
		AppName.sendKeys(appName);
	}
	
	public String getAppName()
	{
		return AppName.getText();
	}

	public void enterNoofRecordsperPage(String noofRecordsperPage) {
		log.info("********************Enter the Status********************");
		dropDownHelper.selectVisibleText(NoofRecordsperPage, noofRecordsperPage);
	
	}

	public void ClickonEditbutton() {
		log.info("********************Click on Edit button********************");
		editbutton.click();
	}
	
	public void ClickonSavebutton() {
		log.info("********************Click on Save button********************");
		Save.click();
	}
	public void ClickonFrontEndSettings() {
		log.info("********************Click on Save button********************");
		FrontEndSettings.click();
	}

	public void enterFooterTitleforAdmin(String footerTitleforAdmin) throws InterruptedException {
		log.info("********************Enter the Description********************");
		FooterTitleforAdmin.clear();
		FooterTitleforAdmin.sendKeys(footerTitleforAdmin);
		Thread.sleep(2000);
	}

	public void enterSiteTitle(String sitetitle) {
		log.info("********************Enter the Meta Title********************");
        Sitetitle.clear();
		Sitetitle.sendKeys(sitetitle);
	}

	public void enterTagline(String tagline) {
		log.info("********************Enter the Meta Description********************");
        Tagline.clear();
		Tagline.sendKeys(tagline);
	}
	
	public void enterCopyrighttext(String copyrighttext) {
		log.info("********************Enter the Meta Description********************");
		Copyrighttext.clear();
		Copyrighttext.sendKeys(copyrighttext);
	}
	public void enterMetadescriptionforfront(String metadescriptionforfront) {
		log.info("********************Enter the Meta Description********************");
		Meta_description_for_front.clear();
		Meta_description_for_front.sendKeys(metadescriptionforfront);
	}

}
