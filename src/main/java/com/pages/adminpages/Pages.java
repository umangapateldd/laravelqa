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

public class Pages {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	private Logger log = LogHelper.getLogger(Pages.class);
	boolean verifyDetails = false;

	@FindBy(id = "title")
	WebElement Title;

	@FindBy(id = "url")
	WebElement URL;

	@FindBy(xpath = "//*[@id='status']")
	WebElement Status;

	@FindBy(xpath = "//*[@id='tinymce']")
	WebElement PageContent;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[7]/a")
	WebElement editbutton;

	@FindBy(id = "meta_title")
	WebElement Metatitle;

	@FindBy(id = "meta_desc")
	WebElement MetaDescription;

	public Pages(WebDriver driver) {
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

	public void enterStatus(String status) {
		log.info("********************Enter the Status********************");
		Status.click();
		Status.sendKeys(status);
	}

	public void ClickonEditbutton() {
		log.info("********************Click on Edit button********************");
		editbutton.click();
	}

	public void enterPageContent(String pageContent) throws InterruptedException {
		log.info("********************Enter the Description********************");
		driver.switchTo().frame("description_ifr");
		PageContent.sendKeys(pageContent);
		driver.switchTo().defaultContent();

		Thread.sleep(2000);
	}

	public void enterMetaTitle(String metaTitle) {
		log.info("********************Enter the Meta Title********************");

		Metatitle.sendKeys(metaTitle);
	}

	public void enterMetaDescription(String metaDescription) {
		log.info("********************Enter the Meta Description********************");

		MetaDescription.sendKeys(metaDescription);
	}

}
