package com.stepdifinations;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.basicactions.LogHelper;
import com.basicactions.WaitHelper;
import com.runners.HookHelper;
import com.utilities.CommonFunc;
import com.utilities.ReadPropFile;

public class FrontStepDefination {
	WebDriver driver;

	TestBase testBase;
	ReadPropFile readPropFile;
	WaitHelper waitHelper;
	CommonFunc commonFunc;
	CommonWhenStepDefinations commonWhenStepDefinations;
	private Logger log = LogHelper.getLogger(FrontStepDefination.class);
	
	public FrontStepDefination() {
		driver = HookHelper.driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		commonFunc = new CommonFunc(driver);
		commonWhenStepDefinations = new CommonWhenStepDefinations();
	}

	@Then("^Verify Testimonial in front side$")
	public void 
}
