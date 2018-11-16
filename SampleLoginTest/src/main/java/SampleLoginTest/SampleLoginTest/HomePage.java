package SampleLoginTest.SampleLoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePage 
{
	public RemoteWebDriver driver = null;
	
	public HomePage(RemoteWebDriver driver) 
	{
		super();
		this.driver = driver;
	}
	
	public void clickOnCalender() throws InterruptedException 
	{
		Thread.sleep(5000);
		driver.switchTo().frame(1);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='crmcalendar']")).click();
	}	
}

