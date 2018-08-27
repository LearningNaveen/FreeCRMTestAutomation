package TestPages;

import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;
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
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		driver.manage().timeouts().pageLoadTimeout(5 , TimeUnit.SECONDS);
		return new HomePage();
	}
}
