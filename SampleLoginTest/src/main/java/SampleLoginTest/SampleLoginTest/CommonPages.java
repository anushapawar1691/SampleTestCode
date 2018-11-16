package SampleLoginTest.SampleLoginTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class CommonPages {
	public static RemoteWebDriver driver;

	@BeforeClass
	  public void start() throws InterruptedException
	 {
	   ChromeOptions options = new ChromeOptions();
	   options.addArguments("chrome.switches","--disable-extensions");
	   System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
	   driver = new ChromeDriver(options);
	   driver.manage().window().maximize();
	   Thread.sleep(5000);
	  }

	
	public void end() throws InterruptedException {
		driver.quit();
	}

	public void login(String user, String pwd) throws InterruptedException 
	{
		String UserName = user;
		String Password = pwd;
		
		RemoteWebElement username = (RemoteWebElement) driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.clear();
		username.sendKeys(UserName);
		Thread.sleep(2000);
		
		RemoteWebElement password = (RemoteWebElement) driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.clear();
		password.sendKeys(Password);
		Thread.sleep(2000);
		
		RemoteWebElement submitButton = (RemoteWebElement) driver
				.findElement(By
						.xpath("//input[@class='btn btn-small']"));
		submitButton.click();			

	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	if(ITestResult.FAILURE==result.getStatus())
		{
			try 
			{
				TakesScreenshot ts=(TakesScreenshot)driver;
				File source=ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));
	 
				System.out.println("Screenshot taken");
			} 
			catch (Exception e)
			{
	 
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 	 
	 
		}
	driver.quit();
	}
}
