package testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pom_Page.kite_LoginPage1;
import Pom_Page.kite_loginPage2;
import Pom_Page.kite_loginPage3;
import common.commonFunction;
import dataProviders.ConfigFileReader;

public class TC1_ValidateUserProfile extends commonFunction
{
	ExtentReports extent;
	ExtentSparkReporter reporter;
	ExtentTest test;
	WebDriver driver;
	ConfigFileReader reader = new ConfigFileReader();
	
	@BeforeMethod
	public void reportInitialisation() 
	{	
		extent = new ExtentReports();
		reporter = new ExtentSparkReporter("target/Spark/TC1_ValidateUserProfile.html");
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Project", "Liteforex");
		extent.setSystemInfo("Module", "login");
		extent.setSystemInfo("Tester", "Ravi");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void TC1_ValidateUserProfile_test()
	{	
		test = extent.createTest("TC1_ValidateUserProfile");
		
		System.setProperty("webdriver.chrome.driver", reader.getDriverPath());
		driver = new ChromeDriver();
		test.info("browser open");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(reader.getImplicitlyWait(),TimeUnit.SECONDS);
		
		//driver.get("https://kite.zerodha.com/");
		driver.navigate().to(reader.getApplicationUrl());
		test.info("url open");
		
		kite_LoginPage1 login1 = new kite_LoginPage1(driver);
		login1.enterUN();
		test.info("username enter");
		login1.enterPSW();
		test.info("password enter");
		login1.clickOnLoginBtn();
		test.info("login clicked");
		
		kite_loginPage2 login2 = new kite_loginPage2(driver);
		login2.enterPIN();
		test.info("pin enter");
		login2.clickOn_continueBtn();
		test.info("continue clicked");
		
		kite_loginPage3 login3 = new kite_loginPage3(driver);
		String profilename = login3.getProfileName();
		test.info("profile name get");
		
		SoftAssert soft = new SoftAssert();
		
		soft.assertEquals(profilename, reader.getUserId());
	}
	
	@AfterMethod
	public void flushReport(ITestResult reult) throws IOException
	{
		File path = new File("target");
		if(ITestResult.SUCCESS == reult.getStatus())
		{
			path = commonFunction.screenshot(driver, reult);
		}
		
		if(path != null)
		{
			test.addScreenCaptureFromPath(path.getAbsolutePath());
			test.info("screenshot added on sucessful");
			driver.close();
			driver.quit();
			extent.flush();
		}
		else
		{
			throw new RuntimeException("path is null");
		}
		
		
	}

}
