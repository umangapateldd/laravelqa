package com.runners;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.base.TestBase;
import com.basicactions.LogHelper;
import com.pages.adminpages.HomePage;
import com.pages.commonpages.LoginPage;
import com.utilities.ReadPropFile;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class RunnerClass {

	@CucumberOptions(features = { "src/test/resources/com/features" }, glue = { "com.stepdifinations", "com.runners" },
//			tags={"@Smoke, @navigation"},
//			tags={"@smoke_ops"},
			plugin = { "pretty", "html:target/cucumber",
					"json:target/cucumber.json" }, monochrome = true, dryRun = false)
	public class runner extends AbstractTestNGCucumberTests {

		public WebDriver driver;
		TestBase testBase;
		ReadPropFile readPropFile;
		LoginPage loginPage;
		HomePage homePage;

		Logger log = LogHelper.getLogger(runner.class);
	}
}