package com.stepdifinations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.basicactions.ExcelHelper;
import com.pages.adminpages.HomePage;
import com.pages.commonpages.LoginPage;
import com.runners.HookHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
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
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));

		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		Given givenann = (Given) CommonStepDefinations.class.getMethod(methodName, String.class).getAnnotations()[0];
		CommonVariables.step.add("=================");
		CommonVariables.step.add(givenann.value().replace("{string}", moduleName));

		commonFunc.verifythesheetname(moduleName);

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

		String excelval = ExcelHelper.getData(2, 0);
		String excelans = ExcelHelper.getData(3, 0);
		String ans1 = "yes";
		String ans2 = "no";
		String value = "Testing allow";

		System.out.println("Excel value 3 =" + excelval);
		System.out.println("Excel value 4 =" + excelans);
		System.out.println("String ans1 =" + ans1);
		System.out.println("String ans1 =" + ans2);
		System.out.println("String ans1 =" + value);

		if (value.equalsIgnoreCase(excelval)) {
			if (excelans.equalsIgnoreCase(ans1)) {
				System.out.println("Testing allow condition is true");
				assert true;
			} else if (excelans.equalsIgnoreCase(ans2)) {
				System.out.println("Testing allow condition is false");
				assert false;
			}

		}
		commonFunc.clickonmenuondashboard(moduleName);
		commonFunc.checkElementAvailableWithAttributeCompare(CommonVariables.elementList, CommonVariables.element,
				"style", "display: none;");

		CommonVariables.stepResult.add("=================");
		CommonVariables.stepResult.add("Pass");

	}

	@Given("Open Front site and Go to {string} Module")
	public void Open_Front_site_and_Go_to_Testimonials_Module(String menuTitle) throws Throwable {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		Given givenann = (Given) CommonStepDefinations.class.getMethod(methodName, String.class).getAnnotations()[0];
		CommonVariables.step.add(givenann.value().replace("{string}", menuTitle));

		System.out.println("menuTitle = " + menuTitle);
		String url = "http://laravelcms-qa.devdigdev.com/";
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
		CommonVariables.stepResult.add("Pass");
	}
}