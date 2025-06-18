package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	String repName;
	public void onStart(ITestContext testContext)
	{
		String timeStamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time 
		repName="Test-Report-" + timeStamp + ".html";
		sparkReporter =new ExtentSparkReporter(".\\reports\\" + repName); //specify location 
		
		sparkReporter.config().setDocumentTitle("opencart Automation Report");//Title of report
		sparkReporter.config().setReportName("opencart Functional Testing");//name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		String os=testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating", os);
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty())
		{
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
	
	}
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); //to display groups in report
		test.log(Status.PASS, result.getName()+ "got successfully executed");
	}
		
	public void OnTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+"got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String impPath=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(impPath);
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
	}
	
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+ "got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
		
		String pathOfExtentReport =System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport =new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(IOException e)
		{
		   e.printStackTrace();
		}
		

	
	/*
	//If you want send email automatically to team as soon as testing completes
	 * 
	 * Just try 1 or 2 times dont go beyond that gmail will be blocked if using your own email
	 
	try {
		URL url = new URL ("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);// Convert the report to URL format 
		
		//Create the email message	
		ImageHtmlEmail email=new ImageHtmlEmail(); // type 'java email' in maven repository and add the dependant in pom
		email.setDataSourceResolver(new DataSourceUrlResolver(url));
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("nandiniece5@gmail.com", "password"));//give your own email address and password	
		email.setSSLOnConnect(true);
		email.setFrom("nandiniece5@gmail.com"); //Sender
		email.setSubject("Test Results");
		email.setMsg("Please find Attached Report ....."); //Email Body
		email.addTo("nandiniece5@gmail.com"); //Receiver, you can add multiple email id's
		email.attach(url, "extent report" , "Please check report...");
		email.send();  //Send the email
				
	}
	catch(Exception e)
	{
		e.printStackTrace();
	} */
	}  
}
