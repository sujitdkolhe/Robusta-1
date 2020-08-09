package com.urbanladder.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.config.Constants;

public class StudyPage {
	@FindBy(css = "#topnav_wrapper>ul>li:nth-child(6)")
	private WebElement hoverOnStudy;
	
	@FindBy(xpath = "//*[@id=\"topnav_wrapper\"]/ul/li[6]/div/div/ul/li[1]/div/a")
	private WebElement hoverOnStudy_Tables;
	
	// This is to Initializing the page Objects
	public StudyPage() {
		PageFactory.initElements(Constants.driver, this);
	}
	
	// This method is to check visibility of 'Living' menu title
		public boolean visibility_StudyMenuTitle() {
			Constants.isDisplay = hoverOnStudy.isDisplayed();
			return Constants.isDisplay;
		}
		
		// This method is to check visibility of 'Sofa Set' sub-menu title
		public boolean visibility_Study_TablesSubMenuTitle() {
			Constants.isDisplay = hoverOnStudy_Tables.isDisplayed();
			return Constants.isDisplay;
		}

		   //This method is to check Text of 'Sofa Set' sub-menu title
			public String  getStudy_TablesSubMenuText() {
				return hoverOnStudy_Tables.getText();

		}

}
