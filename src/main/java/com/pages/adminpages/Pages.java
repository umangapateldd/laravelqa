package com.pages.adminpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
import com.utilities.CommonXpath;

public class Pages {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	CommonXpath commonXpath;
	private Logger log = LogHelper.getLogger(Pages.class);
	boolean verifyDetails = false;


	public Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		commonXpath = new CommonXpath(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void enterTitle(String title) {
		log.info("********************Enter the Author Name********************");
		commonXpath.Title.clear();
		commonXpath.Title.sendKeys(title);
	}

	public void enterStatus(String status) {
		log.info("********************Enter the Status********************");
		dropDownHelper.selectByVaule(commonXpath.Status, "1");
	}

	public void ClickonEditbutton() {
		log.info("********************Click on Edit button********************");
		commonXpath.Pageseditbutton.click();
	}

	public void enterPageContent(String pageContent) throws InterruptedException {
		log.info("********************Enter the Description********************");
		driver.switchTo().frame("description_ifr");
		commonXpath.PageContent.sendKeys(pageContent);
		driver.switchTo().defaultContent();

		Thread.sleep(2000);
	}

	public void enterMetaTitle(String metaTitle) {
		log.info("********************Enter the Meta Title********************");

		commonXpath.MetaTitle.sendKeys(metaTitle);
	}

	public void enterMetaDescription(String metaDescription) {
		log.info("********************Enter the Meta Description********************");

		commonXpath.MetaDescription.sendKeys(metaDescription);
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

			System.out.println("value of admin title = " + driver
					.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr[" + i + "]/td[4]/a")).getText());

		}

		System.out.println(CommonVariables.strArray);
	}

	public void Searchfilters() throws InterruptedException {
		log.info("********************Search filters********************");
		driver.findElement(By.xpath("//*[@id='search-btn']")).click();

		dropDownHelper.selectByVaule(commonXpath.gridStatus, "1");
		
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
		commonXpath.Searchbutton.click();
	}
}