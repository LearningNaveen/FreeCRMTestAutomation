package TestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase; 

public class ContactsPage extends TestBase{
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//td[contains(text(), \"Contacts\")]")
	WebElement contactsLabel;
	
	//@FindBy(xpath="//a[text()='test2 test2']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")
	//WebElement contactsLabel;
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
}
