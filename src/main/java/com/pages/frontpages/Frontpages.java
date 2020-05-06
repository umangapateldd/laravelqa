package com.pages.frontpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.pages.adminpages.Blogs;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;

public class Frontpages {

	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	private Logger log = LogHelper.getLogger(Blogs.class);
	boolean verifyDetails = false;

	public Frontpages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void verifypagestitle() throws InterruptedException {
		log.info("********************verify the Title********************");

		System.out.println("value = " + CommonVariables.strArray.get(0));

		List<WebElement> pagetitlelist = driver.findElements(By.xpath("//*[@id='navbarNavAltMarkup']/ul/li[2]/div/a"));

		int count = pagetitlelist.size();
		System.out.println("Page count := " + count);

		System.out.println("Page Title = "
				+ driver.findElement(By.xpath("//*[@id='navbarNavAltMarkup']/ul/li[2]/div/a[1]")).getText());
		Thread.sleep(5000);

		int ar = 0;
		for (int i = 1; i <= count; i++) {
			String pagetitle = driver.findElement(By.xpath("//*[@id='navbarNavAltMarkup']/ul/li[2]/div/a[" + i + "]"))
					.getText();
			System.out.println("value of page title = " + pagetitle);

			if (pagetitle.equals(CommonVariables.strArray.get(ar))) {
				Thread.sleep(1000);
				System.out.println("Page title match = " + driver
						.findElement(By.xpath("//*[@id='navbarNavAltMarkup']/ul/li[2]/div/a[" + i + "]")).getText());
				Thread.sleep(4000);				
			} else {
				System.out.println("Page title is not match");
			}
			ar++;
		}

	}
}