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

public class Ourteam {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	CommonXpath commonXpath;
	private Logger log = LogHelper.getLogger(Ourteam.class);
	boolean verifyDetails = false;


	public Ourteam(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		commonXpath = new CommonXpath(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void enterFirstName(String firstname) {
		log.info("********************Enter the First Name********************");
		commonXpath.FirstName.clear();
		commonXpath.FirstName.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		log.info("********************Enter the Last Name********************");
		commonXpath.LastName.clear();
		commonXpath.LastName.sendKeys(lastname);
	}

	public void enterPosition(String position) {
		log.info("********************Enter the Position********************");
		commonXpath.Position.clear();
		commonXpath.Position.sendKeys(position);
	}

	public void enterLinkedin(String linkdin) {
		log.info("********************Enter the Linkedin********************");
		commonXpath.Linkedin.clear();
		commonXpath.Linkedin.sendKeys(linkdin);
	}

	public void enterStatus(String status) {
		log.info("********************Enter the Status********************");
		commonXpath.Status.click();
		commonXpath.Status.sendKeys(status);
	}

	public void enterShortBio(String shortBio) {
		log.info("********************Enter the Short Bio********************");
		commonXpath.ShortBio.clear();
		commonXpath.ShortBio.sendKeys(shortBio);
	}

	public void ClickonEditbutton() {
		log.info("********************Click on Edit button********************");
		commonXpath.editbutton.click();
	}

	public void enterAdditionalBio(String additionalBio) throws InterruptedException {
		log.info("********************Enter the Additional Bio ********************");
		driver.switchTo().frame("additional_bio_ifr");
		commonXpath.AdditionalBio.sendKeys(additionalBio);
		driver.switchTo().defaultContent();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='meta_title']")));
		Thread.sleep(2000);
	}

	public void enterImage(String image) throws InterruptedException {
		log.info("********************Enter the Image********************");
		commonXpath.Image.sendKeys(FilesPaths.EXTRA_FILES_FOLDER + image);
		Thread.sleep(5000);
	}

	public void enterImageAlt(String imageAlt) {
		log.info("********************Enter the Image Alt********************");

		commonXpath.ImageAlt.sendKeys(imageAlt);

	}

}
