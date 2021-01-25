package com.pages.adminpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.ExcelHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
import com.utilities.CommonXpath;
import com.utilities.FilesPaths;

public class Homesliders {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	CommonXpath commonXpath;
	private Logger log = LogHelper.getLogger(Homesliders.class);
	boolean verifyDetails = false;

	public Homesliders(WebDriver driver) {
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

	public void enterOverlayText(String overlaytxt) {
		log.info("********************Enter the Title********************");
		commonXpath.slider_overlay_Text.clear();
		commonXpath.slider_overlay_Text.sendKeys(overlaytxt);
	}

	public void enterImageAlt(String imagealt) {
		log.info("********************Enter the Title********************");
		commonXpath.Slider_ImageAlt.clear();
		commonXpath.Slider_ImageAlt.sendKeys(imagealt);
	}
	
	public void selectDisplaySlider(String displaySlider) {
		log.info("********************Enter the Status********************");
		dropDownHelper.selectByVaule(commonXpath.DisplaySlider, displaySlider);
	}

	public void ClickonEditbutton() {
		log.info("********************Click on Edit button********************");

		List<WebElement> img = driver.findElements(By.xpath("//*[@id='main']/div[3]//form/div/div[2]/div/div/div"));
		int numofimg = img.size();
		System.out.println("Img size =" + numofimg);
		String Text = ExcelHelper.getData(1, 2);

	}
}
