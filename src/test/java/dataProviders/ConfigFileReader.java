package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader 
{

	private Properties properties;
	private final String propertyFilePath= "C:\\Users\\Shrisha\\eclipse-workspace_realtime\\Liteforex\\Config\\Configuation.properties";


	public ConfigFileReader()
	{
		BufferedReader reader;
		try 
		{
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try 
			{
				properties.load(reader);
				reader.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}


	public String getDriverPath()
	{
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}

	public long getImplicitlyWait() 
	{		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}

	public String getApplicationUrl() 
	{
		String homeUrl = properties.getProperty("homeUrl");
		if(homeUrl != null) return homeUrl;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getUserId() 
	{
		String userId = properties.getProperty("userId");
		if(userId != null) return userId;
		else throw new RuntimeException("userId not specified in the Configuration.properties file.");
	}

	public String getPassword() 
	{
		String password =  properties.getProperty("password");
		if(password != null) return password;
		else throw new RuntimeException("password not specified in the Configuration.properties file.");
	}

	public String getPin()
	{
		String pin = properties.getProperty("pin");
		if(pin != null) return pin;
		else throw new RuntimeException("pin not specified in the Configuration.properties file.");
	}
	
	public String getFK_url()
	{
		String fk_url = properties.getProperty("fk_link");
		if(fk_url != null) return fk_url;
		else throw new RuntimeException("URL not specified in the Configuration.properties file.");
	}
	
	public String getfk_userid()
	{
		String fk_userid = properties.getProperty("fk_user");
		if(fk_userid != null) return fk_userid;
		else throw new RuntimeException("user not specified in the Configuration.properties file.");
	}
	
	public String getfk_password()
	{
		String fk_password = properties.getProperty("fk_password");
		if(fk_password != null) return fk_password;
		else throw new RuntimeException("password not specified in the Configuration.properties file.");
	}
}