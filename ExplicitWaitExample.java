package code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExample {
	static WebDriver driver;
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  System.setProperty ("webdriver.chrome.driver","d:\\seleniu\\chromedriver.exe" );
		  WebDriver driver = new ChromeDriver(); 
		  
		  driver.get("file:///C:/Users/Lenovo/Desktop/sample.html");
		
		  
		  WebElement username=driver.findElement(By.id("userid"));
		  
		  WebElement password = driver.findElement(By.id("pwd"));
		  
		  
	      enterValues(driver,username,10,"Exp wait user");
	      enterValues(driver,password,5,"pwdvalue");
	      
	      //clickOn(driver,forgotlink,6);
	      
		  

	}

/* No explicit keyword or method
 * implicit and explicit waits should not be used together as the wait time will be increased
 * specific to element
 * dynamic in nature
 */
	
	public static void enterValues(WebDriver driver,WebElement element,int time,String val)
	{
		
		new WebDriverWait(driver,time)
		.until(ExpectedConditions.visibilityOf(element));
  	
		element.sendKeys(val);
		
		
	}

	
	public static void clickOn(WebDriver driver,WebElement element,int timeout)
	{
		
		  new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));
		   element.click();
	}
	
}