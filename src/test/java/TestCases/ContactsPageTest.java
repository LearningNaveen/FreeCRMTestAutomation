package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestBase.TestBase;
import TestPages.ContactsPage;
import TestPages.HomePage;
import TestPages.LoginPage;
import Utilities.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		loginpage = new LoginPage();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
		testutil.switchToFrame();
		contactspage = homepage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactspage.verifyContactsLabel(), "Contacts Lable is missing on the page");
	}
	
	
	@Test(priority=2)
	public void selectContactsTest() {
		contactspage.selectContactsByName("test2 test2");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest() {
		contactspage.selectContactsByName("ui uiii");
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
