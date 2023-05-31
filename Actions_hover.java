package SmokeTests;

 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
 
public class Actions_hover {
 
 public static WebDriver driver;
 
 public static void main(String[] args) throws InterruptedException {
	 
	
		System.setProperty("webdriver.chrome.driver", "D:\\folder H\\BristleCone\\chromedriver.exe");
		driver=new ChromeDriver();
	 // Launch the URL 
        driver.get("http://demoqa.com/menu/");
        System.out.println("demoqa webpage Displayed");
        
    	//Maximise browser window
	 driver.manage().window().maximize();
	    
	//Adding wait 
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        //Instantiate Action Class        
        
		Actions actions = new Actions(driver);
        //Retrieve WebElement 'Main Item 2' to perform mouse hover 
    	WebElement menuOption = driver.findElement(By.xpath("//a[contains(text(),\"Main Item 2\")]"));
    	
    	//Mouse hover menuOption 'Main Item 2'
    	actions.moveToElement(menuOption).perform();
    	
    	
    	System.out.println("Done Mouse hover on 'Main item 2' from Menu");
    	Thread.sleep(1000);
    	//Now Select 'SUB SUB LIST' from sub menu which has got displayed on mouse hover of 'Music'
    	WebElement subMenuOption = driver.findElement(By.xpath("//a[contains(text(),\"SUB SUB LIST\")]")); 
    	//Mouse hover menuOption 'SUB SUB LIST'
    	actions.moveToElement(subMenuOption).perform();
    	System.out.println("Done Mouse hover on 'SUB SUB LIST' from Menu");
    	
    	 
    	//driver.close();
 }
 
}
 

