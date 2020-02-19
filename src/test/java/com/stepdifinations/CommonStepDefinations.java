package com.stepdifinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.pages.adminpages.HomePage;
import com.pages.commonpages.LoginPage;
import com.runners.HookHelper;
import com.utilities.CommonFunc;
import com.utilities.ReadPropFile;

import io.cucumber.java.en.Given;

public class CommonStepDefinations {

	WebDriver driver;
	TestBase testBase;
	ReadPropFile readPropFile;
	LoginPage loginPage;
	HomePage homePage;
	CommonFunc commonFunc;

	public CommonStepDefinations() {
		driver = HookHelper.driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
	}

	@Given("Login as Admin and Go to {string} Module")
	public void user_on_admin_dashboard_page(String moduleName) throws Throwable {
		testBase = new TestBase();
		readPropFile = new ReadPropFile();
		driver.get(readPropFile.readProp().getProperty("url"));

		// Mail Send Functionality

//		String gmailEmail = "gmailEmail";
//		String gmailPassword = "gmailPassword";
//		String emailTo = "abc@yopmail.com, xyz@yopmail.com, pqr@yopmail.com";
//		String emailSubject = "emailSubject";
//		String emailBodyContent = "emailBodyContent";
//		String[] attachmentWithExtension = { "C:\\Users\\Vivek Bhatt\\Pictures\\c4611_sample_explain.pdf",
//				"C:\\Users\\Vivek Bhatt\\Pictures\\image.png" };

//		MailSend m = new MailSend();

		// Mail Send without Attachment
//		m.mailSend(gmailEmail, gmailPassword, emailTo, emailSubject, emailBodyContent);

		// Mail Send with Attachment
//		m.mailSend(gmailEmail, gmailPassword, emailTo, emailSubject, emailBodyContent, attachmentWithExtension);

//		ExcelHelper.createExcel("abc", "xyz");
//		ExcelHelper.closeNewlyCreatedExcel();

		loginPage = new LoginPage(driver);
		homePage = loginPage.login(readPropFile.readProp().getProperty("username"),
				readPropFile.readProp().getProperty("password"));
		commonFunc.clickonmenuondashboard(moduleName);
		Thread.sleep(1000);

	}

}
