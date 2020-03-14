package com.runners.Users;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.base.TestBase;
import com.basicactions.LogHelper;
import com.pages.adminpages.HomePage;
import com.pages.commonpages.LoginPage;
import com.utilities.ReadPropFile;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class UserAddEditDeleteSaveButton {

	@CucumberOptions(features = { "src/test/resources/com/features" }, glue = { "com.stepdifinations",
			"com.runners" },
//			tags = { "@userAdd or @userEdit or @userDelete" },
//			tags = { "@blogAdd or @blogEdit or @blogStatus or @blogAddSaveandContinue or @blogEditSaveandContinue or @blogSettings or @blogFront" },
			tags = { "@ourteam or @ourteamEdit or @ourteam1 or @ourteamDelete or @ourteamAddSaveandContinue or @ourteam11" },
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