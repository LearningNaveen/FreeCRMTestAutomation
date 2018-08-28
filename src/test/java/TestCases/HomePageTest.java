package TestCases;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestBase.TestBase;
import TestPages.ContactsPage;
import TestPages.HomePage;
import TestPages.LoginPage;
import Utilities.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "HomePage Title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		testutil.switchToFrame();
		boolean result = homepage.verifyCorrectUserName();
		Assert.assertTrue(result);
	}
	
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testutil.switchToFrame();
		contactspage = homepage.clickOnContactsLink();
	}
	
	@AfterClass
	public void teadDown() {
		driver.quit();
	}
}
