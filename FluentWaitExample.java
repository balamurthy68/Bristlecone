package code;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

//com.google.common_1.0.0.201004262004.jar file to be downloaded from
//http://www.java2s.com/Code/JarDownload/com.google/com.google.common.source_1.0.0.201004262004.jar.zip

import com.google.common.base.Function;


public class FluentWaitExample {
	//@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		
		String exePath = "d://seleniu/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();	  
		String workingDir = System.getProperty("user.dir");
		driver.get(workingDir + "\\src\\main\\java\\code\\fluentWaitExample.html");


		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(10, TimeUnit.MILLISECONDS);
		wait.withTimeout(5000, TimeUnit.MILLISECONDS);
    
		
		//A Function is a general interface which requires the class to define the following method.

     	Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver arg0) {
				WebElement element = arg0.findElement(By.id("dynamicColor"));
				String color = element.getCssValue("color");
				System.out.println("The button text has color :" + color);
				//if color equals yellow return true
				if (color.equals("rgba(255, 255, 0, 1)")) { 
					    System.out.println("Button text colour changed to yellow");
						return true;
				}
				return false;
			
			}
		};

		wait.until(function);
	}
}

