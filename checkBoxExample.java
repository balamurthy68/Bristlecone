package SmokeTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class checkBoxExample {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "D:\\folder H\\BristleCone\\chromedriver.exe");
		
		driver=new ChromeDriver();
		//implicit wait 10 seconds till any element interaction is happening before a nosuchelement exception is thrown
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//open browser
		
		driver.get("file:///D:/sample.html");
	
		//driver.findElement(By.xpath("//input[@value=\"Bike\"]")).click();
		List <WebElement> chklist = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
		chklist.get(1).click();
		chklist.get(2).click();
		//Print the third option in the list of check boxes
		System.out.println(chklist.get(2).isSelected());

	//Fluent wait example
		Wait wait = new FluentWait(driver)
				.withTimeout(1, TimeUnit.HOURS)
				.pollingEvery(10, TimeUnit.MINUTES)
				.ignoring(Exception.class);

				WebElement foo=wait.until(new Function<driver, WebElement>() {
				public WebElement apply(driver) {
				return driver.findElement(By.id("foo"));
				}
				});
	
	
	}

}
