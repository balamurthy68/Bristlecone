package SmokeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
public class KeyboardActions{
   public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\folder H\\BristleCone\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
      
		driver.get("file:///D:/sample.html");
      
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
      // move to the element, press shift and then enter the letters then //perform() to execute the       action
      
		Actions a = new Actions(driver);
      driver.findElement(By.name("TXTNAME")).clear();
      
       
      
      a.moveToElement(driver.findElement(By.name("TXTNAME"))).click()
    		  .keyDown(Keys.SHIFT)
    		  .sendKeys("abcd")
    		  .build().perform();
     }
}
