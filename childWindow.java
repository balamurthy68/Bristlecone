package SmokeTests;

//import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class childWindow{
	//@Test
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\folder H\\BristleCone\\chromedriver.exe");
		// To open browser
		driver = new ChromeDriver();
		// To maximize browser
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/browser-windows");

        // Open new window by clicking the button
         driver.findElement(By.id("windowButton")).click();


         //Get handles of the windows
         String mainWindowHandle = driver.getWindowHandle();
         
         Set<String> allWindowHandles = driver.getWindowHandles();
         Iterator<String> iterator = allWindowHandles.iterator();

         // Here we will check if child window has other child windows and will fetch the heading of the child window
         while (iterator.hasNext()) {
             String ChildWindow = iterator.next();
                 if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                 driver.switchTo().window(ChildWindow);
                 WebElement text = driver.findElement(By.id("sampleHeading"));
                 System.out.println("Heading of child window is " + text.getText());
             }
         }

      	}
}
