package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage extends BasePage{
	public LogOutPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logout_loc;
	@FindBy(xpath="//a[normalize-space()='Continue']") WebElement continue_loc;
	
	public void click_Logout()
	{
		logout_loc.click();
	}
	public void click_Continue()
	{
		continue_loc.click();
	}
}
