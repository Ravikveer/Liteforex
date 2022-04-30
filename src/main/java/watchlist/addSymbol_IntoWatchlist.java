package watchlist;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addSymbol_IntoWatchlist 
{
	@FindBy (xpath = "//input[@icon='search']") private WebElement SerchBox;
	@FindBy (xpath = "//span[@class='icon icon-plus']") private WebElement AddSymbol;
	@FindAll (@FindBy(xpath = "//div/li//span")) private List<WebElement> ExchangerSymbol;
	@FindAll(@FindBy (xpath = "//span[@class='tradingsymbol']")) private List<WebElement> listOfSymbols;
	@FindAll(@FindBy (xpath = "(//div/li//span[@class='exchange'])/span[@class='company']")) private List<WebElement> listOfCompanys;
	@FindBy (xpath = "((//div/li//span[@class='exchange'])//span[@class='exchange-tag text-label text-label-outline NSE'])") private WebElement NSE;

	
	public addSymbol_IntoWatchlist(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterSymbol() 
	{
		SerchBox.sendKeys("INFY");
	}
	
	public void clickAddAymbol() 
	{
		AddSymbol.click();
	}
	
	public List<WebElement> getListOfSymbols() 
	{
		return listOfSymbols;	
	}
	
	public String getExchangerName() 
	{
		return NSE.getText(); 
	}
	
	public void click_addsymbol(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//li[@class='search-result-item selected']"))).build().perform();
		AddSymbol.click();
	}

}
