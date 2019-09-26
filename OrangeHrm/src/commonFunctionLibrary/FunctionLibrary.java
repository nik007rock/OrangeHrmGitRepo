package commonFunctionLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.PropertyFileUtil;

public class FunctionLibrary 
{
    public static WebDriver startBrowser(WebDriver driver) throws Throwable
    {
    	if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("Firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver", ".\\CommonJarFiles\\geckodriver.exe");
    		driver = new FirefoxDriver();
    		driver.manage().deleteAllCookies();
    		
    	}
    	if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("Chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver", ".\\CommonJarFiles\\chromedriver.exe");
    		driver = new ChromeDriver();
    		driver.manage().deleteAllCookies();
    	}
    	
    	return driver;
    }
    public static void openApplication(WebDriver driver) throws Throwable
    {
      driver.manage().window().maximize();
      driver.get(PropertyFileUtil.getValueForKey("URL"));
    }
    
    public static void typeAction(WebDriver driver,String locatorType,String locatorValue,String TestData) throws Throwable
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatorValue)).sendKeys(TestData);
		}
		if(locatorType.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(locatorValue)).sendKeys(TestData);
		}
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(locatorValue)).sendKeys(TestData);
		}
	
	}
     public static void clickAction(WebDriver driver,String locatorType,String locatorValue) 
	 {
		 if(locatorType.equalsIgnoreCase("Id"))
		 {
			 driver.findElement(By.id(locatorValue)).click();
		 }
		 else if(locatorType.equalsIgnoreCase("name"))
		 {
			 driver.findElement(By.name(locatorValue)).click();
		 }
		 else if(locatorType.equalsIgnoreCase("xpath"))
		 {
			 driver.findElement(By.xpath(locatorValue)).click();
		 }
	 }

}
