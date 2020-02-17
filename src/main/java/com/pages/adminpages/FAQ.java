package com.pages.adminpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;

public class FAQ {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	private Logger log = LogHelper.getLogger(FAQ.class);
	boolean verifyDetails = false;

	@FindBy(xpath ="//*[@id='question']")
	WebElement Question;

	@FindBy(xpath = "//*[@id='status']")
	WebElement Status;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[6]/a")
	WebElement editbutton;

	@FindBy(xpath = "//body[@id='tinymce']")
	WebElement Answer;


	public FAQ(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void enterQuestion(String question) {
		log.info("********************Enter the Title********************");
		Question.clear();
		Question.sendKeys(question);
	}

	public void enterStatus(String status) {
		log.info("********************Enter the Status********************");
		Status.click();
		Status.sendKeys(status);
	}

	public void ClickonEditbutton() throws InterruptedException {
		log.info("********************Click on Edit button********************");
		Thread.sleep(3000);
		editbutton.click();
		System.out.println("click on edit");
	}
	

	public void enterAnswer(String answer) throws InterruptedException {
		log.info("********************Enter the Description********************");
		driver.switchTo().frame("answer_ifr");
		Answer.sendKeys(answer);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}

	
}
