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

public class Blogs {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	private Logger log = LogHelper.getLogger(Blogs.class);
	boolean verifyDetails = false;

	@FindBy(id = "title")
	WebElement Title;

	@FindBy(id = "parent_category")
	WebElement BlogCategory;

	@FindBy(id = "author_first_name")
	WebElement AuthorFirstName;

	@FindBy(id = "author_last_name")
	WebElement AuthorLastName;

	@FindBy(xpath = "//*[@id='status']")
	WebElement Status;
	
	@FindBy(id ="publish_date")
	WebElement PublishDate;
	
	@FindBy(xpath ="//*[@id='DataTables_Table_0']/tbody/tr[1]/td[7]/a")
	WebElement editbutton;
	
	@FindBy(xpath = "//body[@id='tinymce']")
	WebElement Description;
	
	@FindBy(id = "meta_title")
	WebElement Metatitle;
	
	@FindBy(id = "meta_desc")
	WebElement MetaDescription;

	@FindBy(xpath = "//input[@type='file']")
	WebElement Image;

	@FindBy(xpath = "//*[@id='main_image_alt']")
	WebElement ImageAlt;

	public Blogs(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void enterFirstName(String title) {
		log.info("********************Enter the First Name********************");
		Title.clear();
		Title.sendKeys(title);
	}

	public void enterBlogCategory(String blogCategory) {
		log.info("********************Enter the Last Name********************");
		BlogCategory.sendKeys(blogCategory);
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
		Thread.sleep(8000);
//		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('class')",
//				driver.findElement(By.xpath("//*[@id='frmaddedit']/div[2]/div/div[9]/div[1]")));
		Thread.sleep(10000);
		System.out.println("before click===================");
		Image.sendKeys(image);
		Thread.sleep(10000);

	}

	public void enterImageAlt(String imageAlt) {
		log.info("********************Enter the Image Alt********************");

		ImageAlt.sendKeys(imageAlt);

	}


}
