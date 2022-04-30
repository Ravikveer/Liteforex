package Pom_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dataProviders.ConfigFileReader;

public class kite_LoginPage1 
{
	@FindBy(id = "userid") private WebElement UN;
	@FindBy(id = "password") private WebElement PSW;
	@FindBy(xpath = "//button[@class='button-orange wide']") private WebElement LoginBtn;
	ConfigFileReader fileReader = new ConfigFileReader();
	
	public kite_LoginPage1(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUN() 
	{
		UN.sendKeys(fileReader.getUserId());
	}
	
	public void enterPSW() 
	{
		PSW.sendKeys(fileReader.getPassword());
	}
	
	public void clickOnLoginBtn() 
	{
		LoginBtn.click();
	}
}
