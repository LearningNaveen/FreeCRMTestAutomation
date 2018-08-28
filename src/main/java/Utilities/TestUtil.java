package Utilities;

import TestBase.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUTS = 5;
	public static long IMPLICIT_WAIT = 5; 
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
}
