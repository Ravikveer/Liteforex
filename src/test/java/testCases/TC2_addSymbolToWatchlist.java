package testCases;

import java.lang.management.OperatingSystemMXBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pom_Page.kite_LoginPage1;
import Pom_Page.kite_loginPage2;
import dataProviders.ConfigFileReader;
import watchlist.addSymbol_IntoWatchlist;

public class TC2_addSymbolToWatchlist 
{
	@Test
	public void TC2_addSymbolToWatchlist_test()
	{
		ConfigFileReader reader = new ConfigFileReader();
		System.setProperty("webdriver.chrome.driver", reader.getDriverPath());
		
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();

		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get(reader.getApplicationUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(reader.getImplicitlyWait(),TimeUnit.SECONDS);
		
		kite_LoginPage1 login1 = new kite_LoginPage1(driver);
		kite_loginPage2 login2 = new kite_loginPage2(driver);
		addSymbol_IntoWatchlist symbol = new addSymbol_IntoWatchlist(driver);
		
		login1.enterUN();
		login1.enterPSW();
		login1.clickOnLoginBtn();
		
		login2.enterPIN();
		login2.clickOn_continueBtn();
		
		symbol.enterSymbol();
		List<WebElement> list = symbol.getListOfSymbols();
		
		SoftAssert soft = new SoftAssert();
		
		soft.assertEquals(symbol.getExchangerName(), "NSE");
		String exchanger = symbol.getExchangerName();
		
		for(WebElement element:list)
		{
			String expectedTest = element.getText();
			String actualText = "INFY";
			soft.assertEquals(element.getText(), "INFY");	
			//System.out.println(symbol.getExchangerName());
			//System.out.println(element.getText());
			if(exchanger.equalsIgnoreCase("NSE") && expectedTest.equalsIgnoreCase("INFY"))
			{
			symbol.click_addsymbol(driver);
			System.out.println("symbol added sucessfully");
			break;
			}
		}
		
		driver.close();
	}

}
