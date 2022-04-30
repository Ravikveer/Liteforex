package Pom_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dataProviders.ConfigFileReader;

public class kite_loginPage3 
{
	ConfigFileReader reader = new ConfigFileReader();
	@FindBy (xpath = "//span[@class='user-id']") private WebElement profileName;
	
	public kite_loginPage3(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getProfileName() 
	{
		return profileName.getText();
	}

}
