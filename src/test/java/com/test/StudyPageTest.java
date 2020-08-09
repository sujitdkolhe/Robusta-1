package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.config.Constants;
import com.config.Keywords;
import com.urbanladder.pages.LivingPage;
import com.urbanladder.pages.StudyPage;
import com.utility.PropertyUtility;

public class StudyPageTest {
	StudyPage studysage;
	@BeforeTest					
	public void openBrowser() {
		Keywords.openBrowser("Chrome");
		Keywords.launchURL(PropertyUtility.getProperty("ApplicationURL"));
		String expectedUrl = Constants.driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, "https://www.urbanladder.com/");
		// Keywords.maximizeBrowser();
		Keywords.loggerInfo("Open browser ,Entering appliction url and maximizing browser");
		Keywords.sleep(10000);
		Keywords.clickOnElement("CSS", PropertyUtility.getProperty("StatingPop_up"));
		studysage = new StudyPage();

	}
	@Test(priority=1)
	public void studyMenuDisplay(){
		studysage.visibility_StudyMenuTitle();
		Assert.assertTrue(true);
		Keywords.hoverOnElement("CSS", PropertyUtility.getProperty("StudyMenu"));
		Keywords.loggerInfo("Verify 'Study' Menu is visible or not");

	}
	@Test(priority=2)
	public void studyTablesSubmenu_Display() {
		studysage.visibility_Study_TablesSubMenuTitle();
		Assert.assertTrue(true);
		Keywords.loggerInfo("Verify 'Study_Tables' subMenu visible or not");
	}
	@Test(priority=3)
	public void getStudyTablesSubmenuText() {
		Constants.actual=studysage.getStudy_TablesSubMenuText();
		Constants.expected="Study Tables";
		Assert.assertEquals(Constants.actual,Constants.expected);
		Keywords.loggerInfo("Verify 'Study Tables' text");
	}
	@Test(priority=4)
	public void getStudyTablesItems() {
		List<WebElement> list = Constants.driver.findElements(By.xpath(PropertyUtility.getProperty("Study_Tables_SubMenu")));
		Constants.actualList = new ArrayList<String>();
		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext()) {
			Constants.actualList.add(itr.next().getText());
		}
		System.out.println("Actual List:-"+Constants.actualList);
		Keywords.readJsonFile("src\\main\\resources\\StudyPageItems.json", "Study Tables");
		Assert.assertEquals(Constants.actualList,Constants.expectedList);
		
				// Keyword.loggerInfo("verifing in 'Your Lists' items from Account & Lists
		// tool");
		// test = extent.createTest("tc_60 verifying items present in 'Your Lists");
		// test.log(Status.INFO, "verifing in 'Your Lists' items as per expected");

	}
	@AfterTest
	public void close_Window_And_quiteDriver() {
		Keywords.closeBrowser();
		Keywords.quiteDriver();
	}

}
