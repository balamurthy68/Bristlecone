package general;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jsExecutor {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "d://folder H//Bristlecone//chromedriver.exe");
        driver = new ChromeDriver();

		driver.get("https://www.ebay.com/");
		
		driver.manage().window().maximize();
		JavascriptExecutor j = (JavascriptExecutor) driver;
	
		j.executeScript("window.scrollBy(0,1000)");
		
		
		
		//click on a button login 
		/*
		String javascript = "document.getElementById('login').click()";      
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;        
		jsExecutor.executeScript(javascript);  
		
		*/
		
	}
}
