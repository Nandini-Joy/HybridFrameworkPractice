package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test(groups= {"Sanity","Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("*** Starting TC_001_AccountRegistration ********");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelePhone(randomeNumeric());
		
		String password = randomeAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPwd(password);
		regpage.clickPolicy();
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMessage();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		logger.info("***** Ending TC_001_AccountRegistration *******");
		
	}

}
