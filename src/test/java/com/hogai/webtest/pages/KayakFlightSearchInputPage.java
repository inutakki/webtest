package com.hogai.webtest.pages;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.Chart;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class KayakFlightSearchInputPage {

	// Element lookups
	@FindBy(id = "origin")
	private WebElement originInputText;
	
	@FindBy(id = "destination")
	private WebElement destinationInputText;
	
	@FindBy(id = "travel_dates-start-display")
	private WebElement startDateInputText;

	@FindBy(css = "span.r9-datepicker-icon.r9-icon-calendar-depart")
	private WebElement departDateInputText;
	
	@FindBy(id = "travel_dates-end-wrapper")
	private WebElement returnDateInputText;

	@FindBy(xpath = "//div[@id='datepicker']/div[4]/span[2]/span[2]/span[5]/span[2]/span")
	private WebElement backDateInputCal;
	
	@FindBy(id = "fdimgbutton")
	private WebElement submitButton;

	// Search Flights Terms
	public void searchFlight (String originInput, String destinationInput, 
			String departDateInput, String returnDateInput) {
		
		if (originInputText.isDisplayed()) {
			originInputText.click();
			originInputText.clear();
			originInputText.sendKeys(originInput);          
			} else {Assert.fail("Origin Input"+ originInput + "Failed");}

		if (destinationInputText.isDisplayed()) {
			destinationInputText.click();
			destinationInputText.clear();
			destinationInputText.sendKeys(destinationInput);
			} else {Assert.fail("Destination Input"+ destinationInput + "Failed");}
		
		departDateInputText.click();
		returnDateInputText.click();
		backDateInputCal.click();
        //wd.findElement(By.id("travel_dates-start-display")).click();
        
		if (destinationInputText.isDisplayed()) { 
			submitButton.click(); 
			}

    }


}

