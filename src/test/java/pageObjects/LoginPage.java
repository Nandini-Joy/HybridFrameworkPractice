package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
	  super(driver);
	}

	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmailAddress;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@value='Login']") WebElement btnLogin;
	
	public void setEmail(String email1)
	{
		txtEmailAddress.sendKeys(email1);
	}
	public void setPassword(String password1)
	{
		txtPassword.sendKeys(password1);
	}
	public void clickLogin()
	{
		btnLogin.click();
	}
}
