package com.pages.adminpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;

public class Category {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	private Logger log = LogHelper.getLogger(Category.class);
	boolean verifyDetails = false;

	@FindBy(id = "title")
	WebElement Title;

	@FindBy(xpath = "//*[@id='status']")
	WebElement Status;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[6]/a")
	WebElement editbutton;

	@FindBy(xpath = "//body[@id='tinymce']")
	WebElement Description;

	@FindBy(id = "meta_title")
	WebElement Metatitle;

	@FindBy(id = "meta_description")
	WebElement MetaDescription;

	@FindBy(xpath = "//input[@type='file']")
	WebElement Image;

	@FindBy(xpath = "//*[@id='image_alt']")
	WebElement ImageAlt;

	public Category(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void enterTitle(String title) {
		log.info("********************Enter the Title********************");
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
	

	public void enterDescription(String description) throws InterruptedException {
		log.info("********************Enter the Description********************");
		driver.switchTo().frame("description_ifr");
		Description.sendKeys(description);
		driver.switchTo().defaultContent();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='meta_title']")));
		Thread.sleep(2000);
	}

	public void enterImage(String image) throws InterruptedException {
		log.info("********************Enter the Image********************");
		Thread.sleep(8000);
		Image.sendKeys(image);
		Thread.sleep(10000);

	}

	public void enterImageAlt(String imageAlt) throws InterruptedException {
		log.info("********************Enter the Image Alt********************");

		ImageAlt.sendKeys(imageAlt);
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
