package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelePhone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtPasswordConfirm;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//div[@class='col-sm-9']/child::h1[1]") WebElement msgConfirmation;
	@FindBy(xpath="//input[@name='agree']") WebElement chkdPolicy;
	
	
	public void setFirstName(String FirstName)
	{
		txtFirstName.sendKeys(FirstName);
	}
	public void setLastName(String LastName)
	{
		txtLastName.sendKeys(LastName);
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setTelePhone(String TelePhone)
	{
		txtTelePhone.sendKeys(TelePhone);
	}
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	public void setConfirmPwd(String ConfirmPwd)
	{
		txtPasswordConfirm.sendKeys(ConfirmPwd);
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	public void clickPolicy()
	{
		chkdPolicy.click();
	}
    public String getConfirmationMessage()
    {
	   try {
	   return(msgConfirmation.getText());
	   }
	   catch(Exception e)
	   {
		 return(e.getMessage());
	   }
    }
}
