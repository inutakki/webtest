package com.hogai.webtest.utility;

import java.io.File;import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebTestSSUtil 
{
	public static void captureScreenshot(WebDriver wd,String screenshotName)
	{
		try 
		{
			TakesScreenshot ts=(TakesScreenshot)wd;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
			System.out.println("Screenshot Successful");
		} 
		catch (Exception e)
		{
			System.out.println("Screenshot Capture Exception: "+e.getMessage());
		} 
	}
}
