package com.hogai.webtest;

import org.testng.annotations.Test;

public class BasicTest {
  
	@Test
	public void passTest() {
		
		System.out.println("Page Title is: "+ wd.getTitle());
		
	  }
	
	
}
