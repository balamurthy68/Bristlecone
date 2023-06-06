package testNGCode;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testHomeEbay {
  
	static WebDriver driver;
	
	
	  @BeforeTest
	  public void openDriver () {
		  
		    
			System.setProperty("webdriver.chrome.driver", "D:\\folder H\\BristleCone\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.get("https://sellglobal.ebay.in/seller-center/");
		  
	  }
	
	  @AfterTest
	  public void closeDriver () {
		
		  driver.close();
	  }
	@Test
  public void chkTitle() {
		
		String title = driver.getTitle();
		
		Assert.assertEquals(true,title.contains("eBay"));		
  }
	
	@Test
	public void chkListingLinkAvailable() {
		
		boolean chk;
		
		try {
			driver.findElement(By.partialLinkText("Bristlecone"));
			chk = true;
		
		}
		catch (NoSuchElementException err) 
		{
		    chk = false;
		}
		
		Assert.assertEquals(chk, true);
	}
	
}
