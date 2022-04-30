package common;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

public class commonFunction 
{
	public static File	 screenshot(WebDriver driver,ITestResult result) throws IOException
	{
		LocalDateTime time = LocalDateTime.now();
		String timestamp = time.toString().replace(":", "_").replace(" ", "_");
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("./Screenshot/"+result.getName()+"_"+timestamp+".png");
		if(destination.exists())
		{
			destination.delete();
		}
		FileHandler.copy(source, destination);
		return destination;
	}

}
