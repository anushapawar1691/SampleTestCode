package SampleLoginTest.SampleLoginTest;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import SampleLoginTest.SampleLoginTest.*;

public class SampleTestCase extends CommonPages
{
	HomePage home=null;
	Logger log = Logger.getLogger(SampleTestCase.class.getName());
	
	String title=null;
	
	 @Test
	  public void SampleLoginTestCase() throws InterruptedException
	  {			 
		 driver.get("https://www.freecrm.com/");
		 login("anushapawar","Welcome@1");
		 
		 home=new HomePage(driver);
		 title=driver.getTitle(); 
		 System.out.println("Title = "+title);	
		 Thread.sleep(10000);
		 home.clickOnCalender();
		 
		 Thread.sleep(5000);
		 boolean status= driver.findElement(By.xpath("//input[@value='<= Show Calendar for Selected User']")).isDisplayed();
		 
		 Assert.assertTrue(status, "Date has not click from calender");
		 Assert.assertEquals(title, "CRMPRO","Title doesn't match");
		 
		 end();
		 
		 
	  }
}
