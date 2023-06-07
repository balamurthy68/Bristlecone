package DataDriven;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.vimalselvam.cucumber.listener.Reporter;

public class DataProviderExample {

	private static WebDriver driver;

 @DataProvider(name = "Authentication")
  public static Object[][] credentials() {

        return new Object[][] { { "tomsmith", "SuperSecretPassword!" }, { "testuser_2", "Test@123" }};

  }

  // Here we are calling the Data Provider object with its Name

  @Test(dataProvider = "Authentication")

  public void loginSuccessTest(String sUsername, String sPassword) {

	    String exePath = "d://folder H//BristleCone//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
	
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.get("https://the-internet.herokuapp.com/login");
    
      driver.findElement(By.id("username")).sendKeys(sUsername);

      driver.findElement(By.id("password")).sendKeys(sPassword);

      driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();

      try {
      if (driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).isDisplayed()) {
    	  Assert.assertEquals(true,true);
    	  driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
  
      }
      
      }
      catch (NoSuchElementException e)
      {
    	  Assert.assertEquals(true,false);
    	    
    	    Reporter.addScenarioLog("Failed login******************");
      }
      
      
      driver.quit();

  }

}