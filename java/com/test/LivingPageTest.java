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

import com.aventstack.extentreports.Status;
import com.config.Constants;
import com.config.Keywords;
import com.urbanladder.pages.LivingPage;
import com.utility.PropertyUtility;

public class LivingPageTest {
	LivingPage livingpage;
	String LivingPagePropertyPath = "src\\main\\resources\\LivingPage.properties";
	String LivingPageJsonPath = "src/main/resources/LivingPageItems.json";

	@BeforeTest
	public void openBrowser() {
		Keywords.openBrowser("Chrome");
		Keywords.launchURL(PropertyUtility.getProperty("ApplicationURL", LivingPagePropertyPath));
		String expectedUrl = Constants.driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, "https://www.urbanladder.com/");
		// Keywords.maximizeBrowser();
		Keywords.loggerInfo("Open browser ,Entering appliction url and maximizing browser");
		Keywords.sleep();
		Keywords.clickOnElement("CSS", PropertyUtility.getProperty("StatingPop_up", LivingPagePropertyPath));
		livingpage = new LivingPage();
	}

	@Test(priority = 1)
	public void livingMenuDisplay() {
		livingpage.visibilityOfLivingMenuLink();
		Assert.assertTrue(true);
		Keywords.hoverOnElement("CSS", PropertyUtility.getProperty("LivingMenu", LivingPagePropertyPath));
		Keywords.loggerInfo("Verify 'Living' Menu is visible or not");
	}

	@Test(priority = 2)
	public void get_Sofa_set_SubmenuText() {
		Constants.actual = livingpage.getSofa_SetSubMenuText();
		Constants.expected = "Sofa Set";
		Assert.assertEquals(Constants.actual, Constants.expected);
		Keywords.loggerInfo("Verify actual 'Sofa Set' text");
	}

	@Test(priority = 3)
	public void get_Sofa_set_SubMenuList() {
		List<WebElement> list = Constants.driver.findElements(
				By.cssSelector(PropertyUtility.getProperty("Sofa_Set_SubMenu_List", LivingPagePropertyPath)));
		Constants.actualList = new ArrayList<String>();
		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext()) {
			Constants.actualList.add(itr.next().getText());
		}
		System.out.println("Actual Sofa Set List :-" + Constants.actualList);
		Keywords.readJsonFile(LivingPageJsonPath, "Sofa Set");
		Assert.assertEquals(Constants.actualList, Constants.expectedList);
		Keywords.loggerInfo("verify 'Sofa set' sub Menu List(Items) from Living Menu");
		// test = extent.createTest("tc_3 verifying items present in 'Your Lists");
		// test.log(Status.INFO, "verifing in 'Your Lists' items as per expected");
	}

	@Test(priority = 4)
	public void get_Sofa_cum_Bed_SubmenuText() {
		Constants.actual = livingpage.getSofa_cum_BedSubMenuText();
		Constants.expected = "Sofa cum Bed";
		Assert.assertEquals(Constants.actual, Constants.expected);
		Keywords.loggerInfo("Verify actual 'Sofa cum Bed' text");
	}

	@Test(priority = 5)
	public void get_Sofa_cum_Bed_SubMenuList() {
		List<WebElement> Sofa_cum_Bedlist = Constants.driver.findElements(
				By.cssSelector(PropertyUtility.getProperty("Sofa_cum_Bed_SubMenu_List", LivingPagePropertyPath)));
		Constants.actualList = new ArrayList<String>();
		Iterator<WebElement> itr = Sofa_cum_Bedlist.iterator();
		while (itr.hasNext()) {
			Constants.actualList.add(itr.next().getText());
		}
		System.out.println("Actual Sofa cum Bed List:-" + Constants.actualList);
		Keywords.readJsonFile(LivingPageJsonPath, "Sofa cum Bed");
		Assert.assertEquals(Constants.actualList, Constants.expectedList);
		Keywords.loggerInfo("verify 'Sofa cum Bed' sub Menu List(Items) from Living Menu");
		// test = extent.createTest("tc_3 verifying items present in 'Your Lists");
		// test.log(Status.INFO, "verifing in 'Your Lists' items as per expected");
	}

	@Test(priority = 6)
	public void get_Chair_SubMenuText() {
		Constants.actual = livingpage.getChairSubMenuText();
		Constants.expected = "Chair";
		Assert.assertEquals(Constants.actual, Constants.expected);
		Keywords.loggerInfo("Verify actual 'Chair' text");
	}

	@Test(priority = 7)
	public void get_Chair_SubMenuList() {
		List<WebElement> Chairlist = Constants.driver.findElements(
				By.cssSelector(PropertyUtility.getProperty("Chair_SubMenu_List", LivingPagePropertyPath)));
		Constants.actualList = new ArrayList<String>();
		Iterator<WebElement> itr = Chairlist.iterator();
		while (itr.hasNext()) {
			Constants.actualList.add(itr.next().getText());
		}
		System.out.println(("Actual chair List :-" + Constants.actualList));
		Keywords.readJsonFile(LivingPageJsonPath, "Chairs");
		Assert.assertEquals(Constants.actualList, Constants.expectedList);
		Keywords.loggerInfo("verify 'Chair' sub Menu List(Items) from Living Menu");
		// test = extent.createTest("tc_3 verifying items present in 'Your Lists");
		// test.log(Status.INFO, "verifing in 'Your Lists' items as per expected");
	}

	@Test(priority = 8)
	public void get_Tables_SubMenuText() {
		Constants.actual = livingpage.getTablesSubMenuText();
		Constants.expected = "Tables";
		Assert.assertEquals(Constants.actual, Constants.expected);
		Keywords.loggerInfo("Verify actual 'Tables' text");
	}

	@Test(priority = 10)
	public void get_Storage_SubMenuText() {
		Constants.actual = livingpage.getStorageSubMenuText();
		Constants.expected = "Storage";
		Assert.assertEquals(Constants.actual, Constants.expected);
		Keywords.loggerInfo("Verify actual 'Storage' text");
	}

	@Test(priority = 12)
	public void get_Balcony_And_Outdoor_SubMenuText() {
		Constants.actual = livingpage.getBalcony_And_OutdoorSubMenuText();
		Constants.expected = "Balcony & Outdoor";
		Assert.assertEquals(Constants.actual, Constants.expected);
		Keywords.loggerInfo("Verify actual 'Balcony & Outdoor' text");
	}

	@AfterTest
	public void close_Window_And_quiteDriver() {
		Keywords.closeBrowser();
		Keywords.quiteDriver();
	}

}
