package com.utilities;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;

public class CommonFunc {

	WebDriver driver;
	CommonVariables commonVariables;
	DropDownHelper dropDownHelper;
	private Logger log = LogHelper.getLogger(CommonFunc.class);

	public CommonFunc(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonVariables = new CommonVariables(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void checkElementAvailable(List<WebElement> xpathListElement) {
		int tmp = 1;
		long t = System.currentTimeMillis();
		long end = t + 40000;

		do {
			if (System.currentTimeMillis() > end) {
				System.out.println("timeout");
				tmp = 1;
			}

			if (xpathListElement.size() > 0) {
				tmp = 0;
			} else {
				tmp = 1;
			}

		} while (tmp == 1);
	}

	public void checkElementAvailableWithAttributeCompare(List<WebElement> xpathListElement, WebElement xpath,
			String attributeName, String attributeValue) {
		int tmp = 1;
		long t = System.currentTimeMillis();
		long end = t + 40000;

		do {
			if (System.currentTimeMillis() > end) {
				System.out.println("timeout");
				tmp = 1;
			}

			if (xpathListElement.size() > 0 && xpath.getAttribute(attributeName).equals(attributeValue)) {
				tmp = 0;
			} else {
				tmp = 1;
			}

		} while (tmp == 1);
	}

	public void clickonmenuondashboard(String menuTitle) throws InterruptedException {
		List<WebElement> menu = driver.findElements(By.xpath("//*[@id='main']/div[2]/div/div/div/a"));

		int count = menu.size();
		for (int i = 1; i <= count; i++) {
			String m1 = driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div/div[" + i + "]/a")).getText();
			System.out.println("Value test" + m1);
			if (m1.equals(menuTitle)) {
				System.out.println("Menu text is match");

				Thread.sleep(6000);
				driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div/div[" + i + "]/a")).click();
				Thread.sleep(5000);
				break;
			}
		}
	}

	public void searchRecord(String searchText, String xpath) throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='search-btn']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@id='search']")).sendKeys(searchText);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='btnsearch']")).click();
		Thread.sleep(4000);
		if (driver.findElement(By.xpath(xpath)).getText().equalsIgnoreCase(searchText)) {
			System.out.println("User detail match "
					+ driver.findElement(By.xpath(xpath)).getText());
			Thread.sleep(3000);
		}

	}
}