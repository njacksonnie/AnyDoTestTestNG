package Resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base 
{
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
	prop = new Properties();
	FileInputStream fis = new FileInputStream("/Users/niloymazumder/Documents/IdeaProjects/Java/AnyDo/src/main/java/Resources/data.properties");
	prop.load(fis);

	String browserName = prop.getProperty("browser");

	if(browserName.contains("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "/Users/niloymazumder/Documents/IdeaProjects/WebDriver/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		driver = new ChromeDriver(options);
	}
	else if(browserName.contains("safari"))
	{
		driver = new SafariDriver();
	}

	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	return driver;
	}
	
	

}
