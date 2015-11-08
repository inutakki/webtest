package com.hogai.webtest.search;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hogai.webtest.utility.WebTestSSUtil;


public class BasicTest {
	
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
        else if(browser.equalsIgnoreCase("htmlUnit"))
        {
      	  System.setProperty("webdriver.ie.driver", "C:\\SeleniumDriver\\IEDriverServer.exe");
      	  wd = new HtmlUnitDriver();
        }
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get(baseURL);
        //wd.manage().window().maximize();

      }
	
	
	@Test(description = "Page Title Match")
	public void getTitlePassTest() {
		WebTestSSUtil.captureScreenshot(wd, "getTitleTestSS");
		Assert.assertTrue(wd.getTitle().equalsIgnoreCase("Google"), "PageTitle Mismatches");
	}
	
	@Test(description = "Page Title Mismatch")
	public void getTitleFailTest() {
		WebTestSSUtil.captureScreenshot(wd, "getTitleTestSS");
		Assert.assertTrue(wd.getTitle().equalsIgnoreCase("NotGoogle"), "PageTitle Mismatch");
	}
	
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

	
}
