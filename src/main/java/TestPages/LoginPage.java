package TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;  

public class LoginPage extends TestBase{
	
	//Page FActory OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	// Initialization for page Driver
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions to be performed in the page
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pw ) {
		try{
			Thread.sleep(5000);
			
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		return new HomePage();
	
	}
}

