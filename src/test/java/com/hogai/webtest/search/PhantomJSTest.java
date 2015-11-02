package com.hogai.webtest.search;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hogai.webtest.utility.WebTestSSUtil;


public class PhantomJSTest {
	
	
	@Test
	public void getTitleTest() {
 
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);  
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Users\\mpujari"
        		+ "\\workspace\\webtest\\src\\test\\"
				+ "resources\\phantomjs-2.0.0-windows\\bin\\phantomjs.exe");
        WebDriver wd = new PhantomJSDriver(caps); 
        
        wd.get("http://www.google.com");
		
		System.out.println(wd.getTitle());
		
		WebTestSSUtil.captureScreenshot(wd, "getTitleTestSS");
		
		// RemoteWebDriver does not implement the TakesScreenshot class
        // if the driver does have the Capabilities to take a screenshot
        // then Augmenter will add the TakesScreenshot methods to the instance
        //WebDriver augmentedDriver = new Augmenter().augment(wd);
        //File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);

	}
	
    @AfterMethod
    public void tearDown() {
        //wd.quit();
    }

	
}
