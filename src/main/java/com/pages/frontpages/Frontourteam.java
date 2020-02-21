package com.pages.frontpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;

public class Frontourteam {

	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	private Logger log = LogHelper.getLogger(Frontourteam.class);
	boolean verifyDetails = false;

	public Frontourteam(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void verifyOurteamtitle() throws InterruptedException {
		log.info("********************Enter the Title********************");

		List<WebElement> ele = driver.findElements(By.xpath("//*[@id='team']/div/div[2]/div"));
		int count = ele.size();
		System.out.println("element size= " + count);

		for (int i = 1; i <= count; i++) {
			List<WebElement> memberlink = driver
					.findElements(By.xpath("//*[@id='team']/div/div[2]/div[" + i + "]/div/div/h5/a"));
			int memberlinkcount = memberlink.size();
			System.out.println("memberlinkcount  size= " + memberlinkcount);

			List<WebElement> member = driver
					.findElements(By.xpath("//*[@id='team']/div/div[2]/div[" + i + "]/div/div/h5"));
			int membercount = member.size();
			System.out.println("emembercount size= " + membercount);

			if (memberlinkcount > 0) {
				System.out.println("Member is open with short bio");
				if (driver.findElement(By.xpath("//*[@id='team']/div/div[2]/div[" + i + "]/div/div/h5/a")).getText()
						.equals(CommonVariables.txtSearchCmnVar)) {
					System.out.println("Verify the value = " + driver
							.findElement(By.xpath("//*[@id='team']/div/div[2]/div[" + i + "]/div/div/h5/a")).getText());
					driver.findElement(By.xpath("//*[@id='team']/div/div[2]/div[" + i + "]/div/div/h5/a")).click();
					Thread.sleep(2000);
					System.out.println("Detail screen is open");

					break;
				} 
			} else if (membercount > 0) {
				if (driver.findElement(By.xpath("//*[@id='team']/div/div[2]/div[" + i + "]/div/div/h5")).getText()
						.equals(CommonVariables.txtSearchCmnVar)) {
					System.out.println("Verify the value = " + driver
							.findElement(By.xpath("//*[@id='team']/div/div[2]/div[" + i + "]/div/div/h5")).getText());
					driver.findElement(By.xpath("//*[@id='team']/div/div[2]/div[" + i + "]/div/picture/img")).click();
					System.out.println("Click on Image");

					break;
				} 
			}
		}
	}
}