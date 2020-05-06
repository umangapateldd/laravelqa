package com.stepdifinations;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.basicactions.LogHelper;
import com.basicactions.WaitHelper;
import com.pages.frontpages.Frontblog;
import com.pages.frontpages.Frontfaq;
import com.pages.frontpages.Frontourteam;
import com.pages.frontpages.Frontpages;
import com.pages.frontpages.Fronttestimonial;
import com.runners.HookHelper;
import com.utilities.CommonFunc;
import com.utilities.ReadPropFile;

import io.cucumber.java.en.Then;

public class FrontStepDefination {
	WebDriver driver;

	TestBase testBase;
	ReadPropFile readPropFile;
	WaitHelper waitHelper;
	CommonFunc commonFunc;
	Frontblog frontblog;
	Frontfaq frontfaq;
	Frontourteam frontourteam;
	Fronttestimonial fronttestimonial;
	Frontpages frontpages;
	CommonWhenStepDefinations commonWhenStepDefinations;
	private Logger log = LogHelper.getLogger(FrontStepDefination.class);

	public FrontStepDefination() {
		driver = HookHelper.driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		commonFunc = new CommonFunc(driver);
		frontblog = new Frontblog(driver);
		fronttestimonial = new Fronttestimonial(driver);
		frontfaq = new Frontfaq(driver);
		frontourteam = new Frontourteam(driver);
		frontpages = new Frontpages(driver);
		commonWhenStepDefinations = new CommonWhenStepDefinations();
	}

	@Then("Verify Testimonial in front side")
	public void Verify_Testimonial_in_front_side() throws Throwable {
		fronttestimonial.verifyTestimonialtitle();
	}

	@Then("Verify Blog in front side")
	public void Verify_Blog_in_front_side() throws Throwable {
		frontblog.verifyBlogtitle();
	}

	@Then("Verify FAQ in front side")
	public void Verify_FAQ_in_front_side() throws Throwable {
		frontfaq.verifyFAQtitle();
	}

	@Then("Verify Our team in front side")
	public void Verify_Our_team_in_front_side() throws Throwable {
		frontourteam.verifyOurteamtitle();
	}

	@Then("Open front side and compare pages title with admin list")
	public void Verify_Page_in_front_side() throws Throwable {
		frontpages.verifypagestitle();
	}

}