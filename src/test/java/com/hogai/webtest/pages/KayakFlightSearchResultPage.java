package com.hogai.webtest.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class KayakFlightSearchResultPage {

	// Element lookups

	@FindBy(xpath = "html/body/div[3]/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div[1]/span[1]")
	private WebElement originInputTextResult;

	@FindBy(xpath = "html/body/div[3]/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div[1]/span[3]")
	private WebElement destinationInputTextResult;
	
	@FindBy(xpath = "html/body/div[3]/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div[3]/span")
	private WebElement startDateInputCalResult;
	
	@FindBy(xpath = "html/body/div[3]/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div[5]/span")
	private WebElement backDateInputCalResult;

	// Check Flight Search Result
	public boolean checkFlightResult (String originInput, String destinationInput) {
				
        if (!originInputTextResult.getText().contains(originInput)) 
        { Assert.fail("verifyElementValue OriginCity failed"); return false;}
        else if (!destinationInputTextResult.getText().contains(destinationInput)) 
        { Assert.fail("verifyElementValue OriginCity failed"); return false;}
        
        // ToDO - Input Dates need to be formatted to use method input parameters for date verification format values here
        else if (!startDateInputCalResult.getText().contains("Oct 21")) 
        { Assert.fail("verifyElementValue DestinationCity failed"); return false;}
        else if (!backDateInputCalResult.getText().contains("Nov 30")) 
        { Assert.fail("verifyElementValue DestinationCity failed");return false;}
        
        else return true;
    }

}

