package com.stepdifinations;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.basicactions.LogHelper;
import com.pages.adminpages.HomePage;
import com.pages.adminpages.UsersPage;
import com.runners.HookHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;

import io.cucumber.java.en.When;

public class CommonWhenStepDefinations {

	WebDriver driver;
	HomePage homePage;
	UsersPage usersPage;
	CommonFunc commonFunc;
	private Logger log = LogHelper.getLogger(CommonWhenStepDefinations.class);

	public CommonWhenStepDefinations() {
		driver = HookHelper.driver;
		homePage = new HomePage(driver);
		commonFunc = new CommonFunc(driver);
	}

	@When("user navigate to {string} page")
	public void user_navigate_to_page(String menuType) throws Throwable {
		System.out.println("menuType = " + menuType);
		switch (menuType) {
		case "Users":
			homePage.clickOnUsersMenu();
			commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
					"style", "display: none;");
			usersPage = new UsersPage(driver);
			break;
		default:
			log.error(menuType + " is not defined");
		}
	}
}
