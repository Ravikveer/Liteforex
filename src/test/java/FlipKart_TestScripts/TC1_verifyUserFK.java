package FlipKart_TestScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import FlipKart_PomClasses.Login_flipkart;
import dataProviders.ConfigFileReader;

public class TC1_verifyUserFK 
{
	ExtentReports extent;
	ExtentSparkReporter report;
	ExtentTest test;
	WebDriver driver;
	ConfigFileReader reader = new ConfigFileReader();

	@BeforeMethod
	public void IntitialiseReport() 
	{	
		extent = new ExtentReports();
		report = new ExtentSparkReporter("target/Spark/TC1_verifyUserFK.html");
		extent.attachReporter(report);

		extent.setSystemInfo("Tester", "Ravi");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testScript_verifyUser() throws InterruptedException
	{
		test = extent.createTest("testScript_verifyUser");

		System.setProperty("webdriver.chrome.driver", reader.getDriverPath());
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(reader.getFK_url());
		test.info("application opened");

		Login_flipkart FKLogin = new Login_flipkart(driver);

		FKLogin.Click_close_popupBtn();
		FKLogin.Click_loginBtn();
		FKLogin.enter_userid();
		FKLogin.enter_password();
		FKLogin.click_loginbtnmain();
		test.info("login sucessful");

		Thread.sleep(3000);
		String expected_userName = FKLogin.get_username();
		String actual_userName = "Ravi";
		System.out.println(expected_userName);

		Assert.assertEquals(actual_userName, expected_userName,"username not matched");
		test.info("user validated");

		
		Actions action = new Actions(driver);
		action.moveToElement(FKLogin.click_profile()).build().perform();
		Thread.sleep(3000);

		//List<WebElement> list_options = driver.findElements(By.xpath("//ul[@class='pO9syL undefined']/li"));
		List<WebElement> list_options = FKLogin.get_profileOptions();

		for(WebElement option:list_options)
		{
			System.out.println("hi");
			String expected_Text = option.getText();
			String actual_Text = "Logout";
			if(actual_Text.equalsIgnoreCase(expected_Text))
			{
				//driver.findElement(By.xpath("//div[text()='Logout']")).click();
				option.click();
				test.info("logout sucessful");
			}
		}
	}

	@AfterMethod
	public void flush_report() 
	{
		driver.close();
		extent.flush();

	}

}
