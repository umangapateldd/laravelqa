package com.pages.frontpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.pages.adminpages.Blogs;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;

public class Frontblog {

	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	private Logger log = LogHelper.getLogger(Blogs.class);
	boolean verifyDetails = false;

	public Frontblog(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void verifyBlogtitle() {
		log.info("********************Enter the Title********************");

		List<WebElement> ele = driver
				.findElements(By.xpath("/html/body/main/div/div/div[1]/div[1]/div/div/div[2]/h3/a"));
		int count = ele.size();
		System.out.println("element size= " + count);
		System.out.println("Varible value1 = " + CommonVariables.txtSearchCmnVar);
		System.out.println("xpath1 ="
				+ driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[1]/div/div/div[2]/h3/a")).getText());

		for (int i = 1; i <= count; i++) {
			System.out.println("Varible value = " + CommonVariables.txtSearchCmnVar);
			System.out.println("xpath =" + driver
					.findElement(By.xpath("/html/body/main/div/div/div[1]/div[1]/div[" + i + "]/div/div[2]/h3/a"))
					.getText());

			if (driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[1]/div[" + i + "]/div/div[2]/h3/a"))
					.getText().trim().equals(CommonVariables.txtSearchCmnVar)) {

				driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[1]/div[" + i + "]/div/div[2]/h3/a"))
						.click();
				System.out.println("Blog Detail section is open");

				break;
			}
		}
//		    String adminvalue = " Author |" +CommonVariables.adminauthor;
//			System.out.println("author xpath = " +driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[1]/div[1]/ul/li[1]")).getText());
//			System.out.println("admin value = " +adminvalue);
		if (driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[1]/div[1]/ul/li[1]")).getText().trim()
				.equals("Author | " + CommonVariables.adminauthor)) {
			System.out.println("Value match : "
					+ driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[1]/div[1]/ul/li[1]")).getText());
		}

		System.out.println("date xpath = "
				+ driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[1]/div[1]/ul/li[2]")).getText());
		System.out.println("date value = " + CommonVariables.publishdate);
		if (driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[1]/div[1]/ul/li[2]")).getText().trim()
				.equals("Date | " + CommonVariables.publishdate)) {
			System.out.println("Value match : "
					+ driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[1]/div[1]/ul/li[2]")).getText());
		} else {
			assert false;
		}
	}
}
