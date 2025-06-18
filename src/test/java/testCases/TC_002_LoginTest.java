package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity", "Master"})// if need to put more than 1 group name just ut flower bracket and split the group name by using comma and 
	//if want to use single group name like Sanity no need to put flower bracket
	public void verify_Login()
	{
		logger.info("**** Starting TC_002_LoginTest****");
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail("nandinitest54@gmail.com");
		//lp.setEmail(email1);
		lp.setPassword("Test$123");
		//lp.setPassword(password1);
		lp.clickLogin();
		
	/*	//MyAccount
		MyAccountPage macc= new MyAccountPage(driver);
		
		boolean targetpage=macc.isMyAccountPageExist();
		
		Assert.assertEquals(targetpage, true);
		
		*/
		//Logout
		
		logger.info("**** Loggingout *****");
		LogOutPage lg=new LogOutPage(driver);
		lg.click_Logout();
		lg.click_Continue();
		
		logger.info("*** Ending TC_002_LoginTest****");
		
	}
	

}
