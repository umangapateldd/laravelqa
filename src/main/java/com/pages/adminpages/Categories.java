package com.pages.adminpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
import com.utilities.CommonXpath;
import com.utilities.FilesPaths;

public class Categories {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	CommonXpath commonXpath;
	private Logger log = LogHelper.getLogger(Categories.class);
	boolean verifyDetails = false;

	public Categories(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		commonXpath = new CommonXpath(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void enterTitle(String title) {
		log.info("********************Enter the Title********************");
		commonXpath.Title.clear();
		commonXpath.Title.sendKeys(title);
	}

	public void enterStatus(String status) {
		log.info("********************Enter the Status********************");
		dropDownHelper.selectByVaule(commonXpath.Status, "1");
	}

	public void ClickonEditbutton() throws InterruptedException {
		log.info("********************Click on Edit button********************");
		Thread.sleep(3000);
		commonXpath.Categorieseditbutton.click();
		System.out.println("click on edit");
	}

	public void enterDescription(String description) throws InterruptedException {
		log.info("********************Enter the Description********************");
		driver.switchTo().frame("description_ifr");
		commonXpath.Description.sendKeys(description);
		driver.switchTo().defaultContent();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='meta_title']")));
		Thread.sleep(2000);
	}

	public void enterImage(String image) throws InterruptedException {
		log.info("********************Enter the Image********************");
		Thread.sleep(3000);
		commonXpath.Image.sendKeys(FilesPaths.EXTRA_FILES_FOLDER + image);
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");

	}

	public void enterImageAlt(String imageAlt) throws InterruptedException {
		log.info("********************Enter the Image Alt********************");
		commonXpath.ImageAlt.sendKeys(imageAlt);
		Thread.sleep(2000);

	}

	public void enterMetaTitle(String metaTitle) {
		log.info("********************Enter the Meta Title********************");

		commonXpath.Metatitle.sendKeys(metaTitle);

	}

	public void enterMetaDescription(String metaDescription) {
		log.info("********************Enter the Meta Description********************");

		commonXpath.categories_metadesc.sendKeys(metaDescription);

	}
}
