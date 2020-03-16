package com.pages.adminpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
import com.utilities.CommonXpath;

public class FAQ {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	CommonXpath commonXpath;
	private Logger log = LogHelper.getLogger(FAQ.class);
	boolean verifyDetails = false;


	public FAQ(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		commonXpath = new CommonXpath(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void enterQuestion(String question) {
		log.info("********************Enter the Title********************");
		commonXpath.Question.clear();
		commonXpath.Question.sendKeys(question);
	}

	public void enterStatus(String status) {
		log.info("********************Enter the Status********************");
		dropDownHelper.selectByVaule(commonXpath.Status, "1");
	}

	public void ClickonEditbutton() throws InterruptedException {
		log.info("********************Click on Edit button********************");
		Thread.sleep(3000);
		commonXpath.FAQeditbutton.click();
		System.out.println("click on edit");
	}
	

	public void enterAnswer(String answer) throws InterruptedException {
		log.info("********************Enter the Description********************");
		driver.switchTo().frame("answer_ifr");
		commonXpath.Answer.sendKeys(answer);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}

	
}
