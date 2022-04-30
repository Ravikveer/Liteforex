package FlipKart_TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import FlipKart_PomClasses.Login_flipkart;
import FlipKart_PomClasses.mobile_page;
import dataProviders.ConfigFileReader;

public class TC2_PocoMobileList 
{
	@SuppressWarnings("deprecation")
	@Test
	public void TC2_PocoMobileList_test() throws InterruptedException 
	{
		ConfigFileReader reader = new ConfigFileReader();
		
		System.setProperty("webdriver.chrome.driver", reader.getDriverPath());
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(reader.getFK_url());
		

		Login_flipkart FKLogin = new Login_flipkart(driver);

		FKLogin.Click_close_popupBtn();
		FKLogin.Click_loginBtn();
		FKLogin.enter_userid();
		FKLogin.enter_password();
		FKLogin.click_loginbtnmain();
		
		mobile_page MP = new mobile_page(driver);
		Thread.sleep(2000);
		MP.Click_mobileIcon();
		Thread.sleep(2000);
		MP.click_pocoMobile();
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
