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

	@FindBy(id = "first_name")
	WebElement FirstName;

	@FindBy(id = "last_name")
	WebElement LastName;

	@FindBy(id = "position")
	WebElement Position;

	@FindBy(id = "linkedin")
	WebElement Linkedin;

	@FindBy(xpath = "//*[@id='status']")
	WebElement Status;

	@FindBy(id = "meta_title")
	WebElement Metatitle;

	@FindBy(id = "meta_desc")
	WebElement MetaDescription;

	@FindBy(id = "short_bio")
	WebElement ShortBio;

	@FindBy(xpath = "//body[@id='tinymce']")
	WebElement Description;

	@FindBy(xpath = "//body[@id='tinymce']")
	WebElement AdditionalBio;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[7]/a")
	WebElement editbutton;

//	@FindBy(xpath = "//input[@type='file']")
	@FindBy(xpath = "//input[@type='file']")
	WebElement Image;

	@FindBy(xpath = "//*[@id='image_alt']")
	WebElement ImageAlt;

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
		LastName.clear();
		LastName.sendKeys(lastname);
	}

	public void enterPosition(String position) {
		log.info("********************Enter the Position********************");
		Position.clear();
		Position.sendKeys(position);
	}

	public void enterLinkedin(String linkdin) {
		log.info("********************Enter the Linkedin********************");
		Linkedin.clear();
		Linkedin.sendKeys(linkdin);
	}

	public void enterStatus(String status) {
		log.info("********************Enter the Status********************");
		Status.click();
		Status.sendKeys(status);
	}

	public void enterShortBio(String shortBio) {
		log.info("********************Enter the Short Bio********************");
		ShortBio.clear();
		ShortBio.sendKeys(shortBio);
	}

	public void ClickonEditbutton() {
		log.info("********************Click on Edit button********************");
		editbutton.click();
	}

	public void enterAdditionalBio(String additionalBio) throws InterruptedException {
		log.info("********************Enter the Additional Bio ********************");
		driver.switchTo().frame("additional_bio_ifr");
		AdditionalBio.sendKeys(additionalBio);
		driver.switchTo().defaultContent();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='meta_title']")));
		Thread.sleep(2000);
	}

	public void enterImage(String image) throws InterruptedException {
		log.info("********************Enter the Image********************");
		Image.sendKeys(FilesPaths.EXTRA_FILES_FOLDER + image);
		Thread.sleep(5000);
	}

	public void enterImageAlt(String imageAlt) {
		log.info("********************Enter the Image Alt********************");

		ImageAlt.sendKeys(imageAlt);

	}

}
