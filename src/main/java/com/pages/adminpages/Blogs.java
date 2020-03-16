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

public class Blogs {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	CommonXpath commonXpath;
	private Logger log = LogHelper.getLogger(Blogs.class);
	boolean verifyDetails = false;

	public Blogs(WebDriver driver) {
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

	public void selectBlogCategory(String blogCategory) throws InterruptedException {
		log.info("********************Select the Blog Categories********************");
		dropDownHelper.selectByVaule(commonXpath.BlogCategory, "1");
	}

	public void enterAuthorFirstName(String AuthorfirstName) {
		log.info("********************Enter the Author FirstName********************");
		commonXpath.AuthorFirstName.clear();
		commonXpath.AuthorFirstName.sendKeys(AuthorfirstName);
	}

	public void enterAuthorLastName(String AuthorlastName) {
		log.info("********************Enter the Author LastName********************");
		commonXpath.AuthorLastName.clear();
		commonXpath.AuthorLastName.sendKeys(AuthorlastName);
	}

	public void enterFieldblog(String fieldblog) {
		log.info("********************Enter the Author LastName********************");
		commonXpath.Fieldblog.clear();
		commonXpath.Fieldblog.sendKeys(fieldblog);
	}

	public void selectStatus(String status) {
		log.info("********************Enter the Status********************");
		dropDownHelper.selectByVaule(commonXpath.Status, "1");
	}

	public void enterPublishDate() throws InterruptedException {
		log.info("********************Enter the Publish Date********************");
		commonXpath.PublishDate.click();
		commonXpath.Blogselectdate.click();
		commonXpath.selecttime.click();
		commonXpath.time.click();
	}

	public String getPublishdate() {
		log.info("********************Get Publish Date********************");
		return commonXpath.date.getText().trim();
	}

	public void ClickonEditbutton() {
		log.info("********************Click on Edit button********************");
		commonXpath.Blogeditbutton.click();
	}

	public void ClickonSettingmenu() throws InterruptedException {
		log.info("********************Click on Setting Menu********************");
		commonXpath.BlogSettingmenu.click();
	}

	public void ClickonSettingsave() throws InterruptedException {
		log.info("********************Click on Setting Save Button********************");
		commonXpath.Settingsave.click();
	}

	public void enterDescription(String description) throws InterruptedException {
		log.info("********************Enter the Description********************");
		driver.switchTo().frame("description_ifr");
		commonXpath.Description.sendKeys(description);
		driver.switchTo().defaultContent();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='meta_title']")));
	}

	public void selectImage(String image) throws InterruptedException {
		log.info("********************Select the Image********************");
		commonXpath.Image.sendKeys(FilesPaths.EXTRA_FILES_FOLDER + image);
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
	}

	public void enterImageAlt(String imageAlt) throws InterruptedException {
		log.info("********************Enter the Image Alt********************");
		commonXpath.BlogImageAlt.sendKeys(imageAlt);
	}

	public void enterMetaTitle(String metaTitle) {
		log.info("********************Enter the Meta Title********************");

		commonXpath.Metatitle.sendKeys(metaTitle);

	}

	public void enterMetaDescription(String metaDescription) {
		log.info("********************Enter the Meta Description********************");

		commonXpath.MetaDescription.sendKeys(metaDescription);

	}
}