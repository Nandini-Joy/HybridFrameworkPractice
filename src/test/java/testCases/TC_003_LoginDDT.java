package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class, groups="DataDriven")
	public void verify_loginDDT(String email, String password, String exp) throws InterruptedException
	{
		logger.info("****** Starting TC_003_LoginDDT *******");
		try {
		//HomePage
		HomePage hm=new HomePage(driver);
		hm.clickMyAccount();
		hm.clickLogin();
		
		//LoginPage
		LoginPage lg=new LoginPage(driver);
		lg.setEmail(email);
		lg.setPassword(password);
		lg.clickLogin();
		
		//LogOut
		LogOutPage log=new LogOutPage(driver);
		
		
		//MyAccount Page
		MyAccountPage ma=new MyAccountPage(driver);
		boolean targetpage=ma.isMyAccountPageExist();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				log.click_Logout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				log.click_Logout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
			}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("****** Finished TC_003_LoginDDT *******");
	}
		}
	


