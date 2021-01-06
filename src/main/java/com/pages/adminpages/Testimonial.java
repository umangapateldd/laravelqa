package com.pages.adminpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.basicactions.DropDownHelper;
import com.basicactions.ExcelHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
import com.utilities.CommonXpath;
import com.utilities.FilesPaths;

public class Testimonial {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	CommonXpath commonXpath;
	private Logger log = LogHelper.getLogger(Testimonial.class);
	boolean verifyDetails = false;

	public Testimonial(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		commonXpath = new CommonXpath(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void enterAuthorName(String authorName) {
		log.info("********************Enter the Author Name********************");
		commonXpath.AuthorName.clear();
		commonXpath.AuthorName.sendKeys(authorName);
	}

	public void enterURL(String url) {
		log.info("********************Enter the URL********************");
		commonXpath.URL.clear();
		commonXpath.URL.sendKeys(url);
	}

	public void enterStatus(String status) {
		log.info("********************Enter the Status********************");
		dropDownHelper.selectByVaule(commonXpath.Status, "1");

	}

	public void ClickonEditbutton() {
		log.info("********************Click on Edit button********************");
		commonXpath.Testimonialeditbutton.click();
	}

	public void enterDescription(String description) throws InterruptedException {
		log.info("********************Enter the Additional Bio ********************");
		driver.switchTo().frame("description_ifr");
		commonXpath.Description.sendKeys(description);
		driver.switchTo().defaultContent();
	}

	public void entersettingfield(String settingfield) {
		log.info("********************Enter the Author LastName********************");
		WebElement dropdown = driver.findElement(By.xpath("//*[@id='field_testimonial_title_display']"));
		
		if(settingfield.equalsIgnoreCase("no")) {
			dropDownHelper.selectVisibleText(dropdown, "No");
		}else {
			dropDownHelper.selectVisibleText(dropdown, "Yes");
		}
	}

	public void ClickonSettingmenu() throws InterruptedException {
		log.info("********************Click on Setting Menu********************");
		Thread.sleep(2000);
		System.out.println("2222222222222222222");
		commonXpath.Settingmenu.click();
		Thread.sleep(2000);
	}

	public void ClickonSettingsave() throws InterruptedException {
		log.info("********************Click on Setting save********************");
		commonXpath.Settingsave.click();
		Thread.sleep(2000);
	}

	public void selectImage(String image) throws InterruptedException {
		log.info("********************Select the Image********************");
		commonXpath.Image.sendKeys(FilesPaths.EXTRA_FILES_FOLDER + image);
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");
	}

}
