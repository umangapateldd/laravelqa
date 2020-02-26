package com.pages.adminpages;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

	@FindBy(xpath = "//*[@id='status']")
	WebElement gridStatus;

	@FindBy(xpath = "//*[@id='status']/option[3]")
	WebElement Statusoption;

	@FindBy(xpath = "//*[@id='btnsearch']")
	WebElement Searchbutton;

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

	public void Admintitle() throws InterruptedException {
		log.info("********************Enter the Admin title********************");
		
		driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/thead/tr/th[4]")).click();
		Thread.sleep(2000);

		List<WebElement> Admintitle = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr/td[4]/a"));
		int count = Admintitle.size();

		for (int i = 1; i <= count; i++) {

			String title = driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr[" + i + "]/td[4]/a"))
					.getText();
			CommonVariables.strArray.add(title);
			
//			Collections.sort(strArray);
//			Assert.assertTrue(strArray.equals(title));
//			String title = driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr[" + i + "]/td[4]/a"))
//					.getText();
			System.out.println("value of admin title = " + driver
					.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr[" + i + "]/td[4]/a")).getText());
//			CommonVariables.pagetitle = title;

//			System.out.println("Admin commvariable = " + CommonVariables.pagetitle);

		}

		System.out.println(CommonVariables.strArray);
	}

	public void Searchfilters() throws InterruptedException {
		log.info("********************Search filters********************");
		driver.findElement(By.xpath("//*[@id='search-btn']")).click();
		Thread.sleep(3000);
		gridStatus.click();
		Thread.sleep(2000);
		Statusoption.click();
		Thread.sleep(2000);
		Searchbutton.click();
		Thread.sleep(4000);

	}
}