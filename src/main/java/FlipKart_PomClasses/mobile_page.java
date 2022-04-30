package FlipKart_PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mobile_page 
{
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div/div[3]/a/div[1]/div/img") private WebElement MobileIcon;
	@FindBy (xpath = "/html/body/div/div/div[3]/div[2]/div[2]/div[1]/div/div/div/div[1]/div/div[2]/div/a/div/img") private WebElement pocoMobile;
	
	public mobile_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Click_mobileIcon() 
	{
		MobileIcon.click();
	}
	
	public void click_pocoMobile() 
	{
		pocoMobile.click();
	}

}
