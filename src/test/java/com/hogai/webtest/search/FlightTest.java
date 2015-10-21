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

import com.hogai.webtest.pages.KayakFlightSearchInputPage;
import com.hogai.webtest.pages.KayakFlightSearchResultPage;
import com.relevantcodes.extentreports.Chart;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import static org.openqa.selenium.OutputType.*;

public class FlightTest {
    
	WebDriver wd;
	public static final ExtentReports extent = ExtentReports.get(FlightSearchTest.class); 
	static String reportLocation = "report\\";

	
	/* Pre-suite report setup here */
	@BeforeSuite
	public static void beforeTestSuite(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		extent.init(reportLocation + "TestReport.html", true, DisplayOrder.BY_OLDEST_TO_LATEST);
		extent.config().documentTitle("KayakFlightSearch Test Report " + dateFormat.format(cal.getTime()));
		extent.config().reportHeadline("KayakFlightSearch Test Report " + dateFormat.format(cal.getTime()));
		extent.config().reportTitle("KayakFlightSearch Release 2.6.SP4 Deployment Test Report");
		extent.config().chartTitle(Chart.TEST, "KayakFlightSearch Test Cases Run Chart");
		extent.config().chartTitle(Chart.TEST_SET, "KayakFlightSearch Test Scripts Run Chart");
		extent.config().displayCallerClass(false);
		extent.config().useExtentFooter(false);
	} 
	
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
     //return new Object[][] { { "ATL", "BOM" }, { "BOS", "BOM" }, { "SFO", "BOM" }}; // use for 3 iterations
     return new Object[][] { { "ATL", "BOM" }};
    }
    
    // Search for Flights and Check Results
    @Test(dataProvider = "FlightSearchInputDP")
    public void flightSearchTest(String departCityIn, String arriveCityIn) throws InterruptedException {

		// Create a new Kayak Search Input Page
        KayakFlightSearchInputPage searchInputPage = 
        		PageFactory.initElements(wd, KayakFlightSearchInputPage.class);
    	
    	// Input Search Term(s). Datepicker control variables ToDo
		searchInputPage.searchFlight(departCityIn, arriveCityIn, "", "");
        
        
		// Create a new Kayak Search Result Page
    	KayakFlightSearchResultPage searchResultPage = 
    			PageFactory.initElements(wd, KayakFlightSearchResultPage.class);
    	
    	// Verify Input Search Term(s) on the Kayak Search Result Page
    
        if (!searchResultPage.checkFlightResult(departCityIn, arriveCityIn))
        { Assert.fail("Verify Search Flight failed");}
        
		extent.log(LogStatus.PASS, "KayakFlightSearchTest Successfully Completed");
	  	extent.endTest();
        
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
