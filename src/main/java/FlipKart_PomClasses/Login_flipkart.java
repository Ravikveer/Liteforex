package FlipKart_PomClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dataProviders.ConfigFileReader;

public class Login_flipkart 
{
	ConfigFileReader reader = new ConfigFileReader();
	
	@FindBy (xpath = "//button[@class='_2KpZ6l _2doB4z']") private WebElement close_PopupBtn;
	@FindBy (xpath = "//a[@class='_1_3w1N']") private WebElement loginBtn;
	@FindBy (xpath = "//input[@class='_2IX_2- VJZDxU']") private WebElement userid;
	@FindBy (xpath =  "//input[@class='_2IX_2- _3mctLh VJZDxU']") private WebElement password;
	@FindBy (xpath =   "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']") private WebElement loginBtn_main;
	@FindBy (xpath = "(//div[@class='exehdJ'])[1]") private WebElement verify_user;
	@FindAll (@FindBy (xpath = "//ul[@class='pO9syL undefined']/li")) 
		private List<WebElement> profile_options;
	@FindBy (xpath = "(//div[@class='exehdJ'])[1]") private WebElement userclick;
	
	public Login_flipkart(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Click_close_popupBtn() 
	{
		close_PopupBtn.click();
	}
	
	public void Click_loginBtn() 
	{
		loginBtn.click();
	}
	
	public void enter_userid() 
	{
		userid.sendKeys(reader.getfk_userid());
	}
	
	public void enter_password() 
	{
		password.sendKeys(reader.getfk_password());
	}
	
	public void click_loginbtnmain()
	{
		loginBtn_main.click();
	}
	
	public String get_username() 
	{
		return verify_user.getText();
	}
	
	public void click_profileoptions(WebDriver driver) 
	{
		Actions action = new Actions(driver);
		action.moveToElement(userclick).click().build().perform();
	}
	
	public WebElement click_profile() 
	{
		return userclick;
	}
	
	public List<WebElement> get_profileOptions()
	{
		return profile_options;
	}

}
