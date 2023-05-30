package SmokeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testHKLoginSuccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "D:\\folder H\\BristleCone\\chromedriver.exe");
		
		driver=new ChromeDriver();
		//open browser
		
		driver.get("https://the-internet.herokuapp.com/login");
		
		WebElement pwd = driver.findElement(By.id("password"));
		WebElement usr = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		
		
		usr.sendKeys("tomsmith");
		pwd.sendKeys("SuperSecretPassword!");
		
		//Test step:Check if password field is masked
		
		if(pwd.getAttribute("type").equals("password"))
		{
			
			System.out.println("Password masked");
		}
		
		
		
		//click on submit button
		WebElement submitbtn = driver.findElement(By.cssSelector("#login > button"));
		
		submitbtn.click();
		
		String msg = driver.findElement(By.id("flash")).getText();
		if (msg.contains("You logged into")) {
			System.out.println("Login success");
		}
		else
		{
			System.out.println("Login Failed");
		}
		
		
		
		//Find if Logout link is present
		try {
			driver.findElement(By.partialLinkText("Log")).click();
		}
		catch
		(NoSuchElementException e)
		{
			System.out.println("Login unsuccessful");
		}
		//driver.close();
		
	}

}
