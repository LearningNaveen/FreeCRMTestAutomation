package TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase; 

public class HomePage extends TestBase{

	LoginPage loginpage;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(), \"Contacts\")]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(), \"Deals\")]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(), \"Tasks\")]")
	WebElement tasksLink;
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsPage() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksPage() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
}
