package com.stepdifinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.pages.adminpages.HomePage;
import com.pages.commonpages.LoginPage;
import com.runners.HookHelper;
import com.utilities.CommonFunc;
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

	@Given("^Login as Admin and Go to \"([^\"]*)\" Module$")
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

	@Given("^Open Front site and Go to \"([^\"]*)\" Module$")
	public void Open_Front_site_and_Go_to_Testimonials_Module(String menuTitle) throws Throwable {
		String url = "http://laravelcms.devdigdev.com/";
		driver.get(url);
		List<WebElement> menu = driver.findElements(By.xpath("//*[@id='navbarNavAltMarkup']/ul/li/a"));

		int count = menu.size();
		for (int i = 1; i <= count; i++) {
			String m1 = driver.findElement(By.xpath("//*[@id='navbarNavAltMarkup']/ul/li[" + i + "]/a")).getText();
			

			if (m1.equalsIgnoreCase(menuTitle)) {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='navbarNavAltMarkup']/ul/li[" + i + "]/a")).click();
				Thread.sleep(4000);
				break;
			}
		}
	}
}