package testNGCode;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class chkEbayTimeFormat {
	static WebDriver driver;
	
	@BeforeClass 
	  public void openDriver () {
		  
		    
			System.setProperty("webdriver.chrome.driver", "D:\\folder H\\BristleCone\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("https://ofr.ebay.com/ws/eBayISAPI.dll?EbayTime");
		  
	  }
	  
	
  @Test
  public void chkPacificTimeFormat() {
	  WebElement pacific = driver.findElement(By.xpath("//*[contains(text(),\"Pacific Time\")]"));
	  WebElement Alaskatime = driver.findElement(with(By.tagName("font")).below(pacific));

	  
	  Pattern word = Pattern.compile("[0-9]{2}:[0-9]{2}:[0-9]{2}");
	  Matcher sentence = word.matcher(Alaskatime.getText());
	   
	    boolean matchFound = sentence.find();
	   
	    Assert.assertEquals(matchFound, true);
	    
  }
}
