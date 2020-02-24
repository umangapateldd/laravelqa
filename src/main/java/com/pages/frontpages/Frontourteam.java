package com.pages.frontpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.ExcelHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
import com.utilities.FilesPaths;

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
		ExcelHelper.readDataFromXLS(FilesPaths.excel_data_file_name, CommonVariables.ourteam);
		String linkdin = ExcelHelper.getData(1, 3);

		List<WebElement> ele = driver.findElements(By.xpath("//*[@id='team']/div/div[2]/div"));
		int count = ele.size();
		System.out.println("element size= " + count);
		boolean ourteamVal = false;

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
					ourteamVal = true;
					break;
				}
			} else if (membercount > 0) {
				if (driver.findElement(By.xpath("//*[@id='team']/div/div[2]/div[" + i + "]/div/div/h5")).getText()
						.equals(CommonVariables.txtSearchCmnVar)) {
					System.out.println("Verify the value = " + driver
							.findElement(By.xpath("//*[@id='team']/div/div[2]/div[" + i + "]/div/div/h5")).getText());
					driver.findElement(By.xpath("//*[@id='team']/div/div[2]/div[" + i + "]/div/div/div[1]")).getText();
					System.out.println("Verify the position value ="
							+ driver.findElement(By.xpath("//*[@id='team']/div/div[2]/div[" + i + "]/div/div/div[1]"))
									.getText());
//					System.out.println("check value of size " + driver
//							.findElements(By.xpath("//*[@id='team']/div/div[2]/div[" + i + "]/div/div/div[2]/a/span"))
//							.size());

					System.out.println("Linkdin value for Excel =" + linkdin.isEmpty());

					if (linkdin.isEmpty()) {
						System.out.println("Linkdin value is not found in Excel sheet");

						if (driver
								.findElements(
										By.xpath("//*[@id='team']/div/div[2]/div[" + i + "]/div/div/div[2]/a/span"))
								.size() > 0) {

							Thread.sleep(2000);
							System.out.println("Linkdin icon is found");
							assert false;

						} else {
							assert true;
						}
					} else {
						if (driver
								.findElements(
										By.xpath("//*[@id='team']/div/div[2]/div[" + i + "]/div/div/div[2]/a/span"))
								.size() > 0) {

							Thread.sleep(2000);
							System.out.println("Linkdin icon is found");
							assert true;

						} else {
							assert false;
						}
					}
				}

				ourteamVal = true;
				break;

			} else {
				assert false;
			}
		}
		if (ourteamVal == true) {
			System.out.println("IF CONIDITION IS TRUE");

		} else {
			assert false;
		}
	}
}
