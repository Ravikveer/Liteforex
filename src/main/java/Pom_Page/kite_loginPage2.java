package Pom_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dataProviders.ConfigFileReader;

public class kite_loginPage2 
{
	@FindBy (id = "pin") private WebElement PIN;
	@FindBy (xpath = "//button[@class='button-orange wide']") private WebElement ContinueBtn;
	ConfigFileReader reader = new ConfigFileReader();
	
	public kite_loginPage2(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterPIN() 
	{
		PIN.sendKeys(reader.getPin());
	}
	
	public void clickOn_continueBtn() 
	{
		ContinueBtn.click();
	}

}
