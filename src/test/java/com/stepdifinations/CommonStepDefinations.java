package com.stepdifinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.basicactions.ExcelHelper;
import com.pages.adminpages.HomePage;
import com.pages.commonpages.LoginPage;
import com.runners.HookHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
import com.utilities.FilesPaths;
import com.utilities.ReadPropFile;

import cucumber.api.java.en.Given;

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

	@Given("^Login as Admin and Go to Users Module$")
	public void user_on_admin_dashboard_page() throws Throwable {
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
		commonFunc.clickonmenuondashboard("Users");
		Thread.sleep(5000);
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.users);
//		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name,CommonVariables.users);
//		String url = ExcelHelper.getData(1,0);
//		driver.get(url);
//		commonFunc = new CommonFunc(driver);
//		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
//				"style", "display: none;");
	}

}
