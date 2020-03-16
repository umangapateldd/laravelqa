package com.runners.FAQ;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.base.TestBase;
import com.basicactions.LogHelper;
import com.pages.adminpages.HomePage;
import com.pages.commonpages.LoginPage;
import com.utilities.ReadPropFile;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class FAQAddEditDeleteSaveContinueButton {
	@CucumberOptions(features = { "src/test/resources/com/features" }, glue = { "com.stepdifinations", "com.runners" },
			tags={"@FAQAddSaveContinue or @FAQEditSaveContinue or @FAQDelete"},
//			tags={"@blogAdd"},
			plugin = { "pretty", "html:target/cucumber",
					"json:target/cucumber.json" }, monochrome = true, dryRun = false, strict = true)
	public class runner extends AbstractTestNGCucumberTests {

		public WebDriver driver;
		TestBase testBase;
		ReadPropFile readPropFile;
		LoginPage loginPage;
		HomePage homePage;

		Logger log = LogHelper.getLogger(runner.class);
	}

}
