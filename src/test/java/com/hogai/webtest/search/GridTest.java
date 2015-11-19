
package com.hogai.webtest.search;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hogai.webtest.utility.WebTestSSUtil;


public class GridTest {

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	 
	WebDriver wd;
	String baseURL = "http://www.google.com";
	
	@BeforeTest
	@Parameters({"browserName", "baseURL"})
	public void setUp() throws MalformedURLException {

		Date date = new Date();
		System.out.println("Setting up Tests Run: " + dateFormat.format(date) + "\n");
		
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.LINUX);
		wd = new RemoteWebDriver(new URL("http://ec2-52-33-33-99.us-west-2.compute.amazonaws.com:4444//wd/hub"), cap);

	}

	@Test(description = "Page Title Match1")
	@Parameters({"browserName", "baseURL"})
	public void PassTest1() throws InterruptedException {
		
		Date dateBegin = new Date();
		System.out.println("PassTest1 Start: " + dateFormat.format(dateBegin));
		
		wd.get(baseURL);
		Assert.assertTrue(wd.getTitle().equalsIgnoreCase("Google"), "PageTitle Matches");
		Thread.sleep(8000);
		
		Date dateEnd = new Date();
		System.out.println("PassTest1 End: " + dateFormat.format(dateEnd));
	}
	
	@Test(description = "Page Title Match2")
	@Parameters({"browserName", "baseURL"})
	public void PassTest2() throws InterruptedException {
		
		Date dateBegin = new Date();
		System.out.println("PassTest2 Start: " + dateFormat.format(dateBegin));
		
		wd.get(baseURL);
		Assert.assertTrue(wd.getTitle().equalsIgnoreCase("Google"), "PageTitle Matches");
		Thread.sleep(4000);
		
		Date dateEnd = new Date();
		System.out.println("PassTest2 End: " + dateFormat.format(dateEnd));
	}
	
	@Test(description = "Page Title Match3")
	@Parameters({"browserName", "baseURL"})
	public void PassTest3() throws InterruptedException {
		
		Date dateBegin = new Date();
		System.out.println("PassTest3 Start: " + dateFormat.format(dateBegin));
		
		wd.get(baseURL);
		Assert.assertTrue(wd.getTitle().equalsIgnoreCase("Google"), "PageTitle Matches");
		Thread.sleep(1000);
		
		Date dateEnd = new Date();
		System.out.println("PassTest3 End: " + dateFormat.format(dateEnd));
	}
	
	@Test(description = "Page Title Mismatch", enabled = true)
	@Parameters({"browserName", "baseURL"})
	public void getTitleFailTest() {
		
		Date dateBegin = new Date();
		System.out.println("FailTest Start: " +dateFormat.format(dateBegin));
		
		wd.get(baseURL);
		Assert.assertTrue(wd.getTitle().equalsIgnoreCase("NotGoogle"), "PageTitle Mismatches");
		
		Date dateEnd = new Date();
		System.out.println("FailTest End: " + dateFormat.format(dateEnd)); // Should not output
	}
	
	
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

	
}

