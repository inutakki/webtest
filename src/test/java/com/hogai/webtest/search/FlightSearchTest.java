package com.hogai.webtest.search;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;
import java.util.Date;
import java.io.File;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

import com.relevantcodes.extentreports.Chart;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import static org.openqa.selenium.OutputType.*;

public class FlightSearchTest {
    
	WebDriver wd;

	// Pre-test setup
    @BeforeMethod
    @Parameters({"browserName", "baseURL"})
    public void setUp(String browser, String baseURL) throws Exception {

        // Parallel test case in different browsers
        if(browser.equalsIgnoreCase("firefox"))
        {
      	  wd = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("IE"))
        {
      	  System.setProperty("webdriver.ie.driver", "C:\\SeleniumDriver\\IEDriverServer.exe");
      	  wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get(baseURL);
        wd.manage().window().maximize();

      }
    
    // Data Source - proxy for FlightSearchInputDP class
    @DataProvider(name = "FlightSearchInputDP")
    public Object[][] createData1() {
     //return new Object[][] { { "ATL", "BOM" }, { "BOS", "BOM" }, { "SFO", "BOM" }};
     return new Object[][] { { "ATL", "BOM" }};
    }
    
    // Search for Flights and Check Results
    @Test(dataProvider = "FlightSearchInputDP")
    public void flightSearchTest(String departCityIn, String arriveCityIn) throws InterruptedException {

        Thread.sleep(5000);
       

        
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(WebDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
    



    
}
