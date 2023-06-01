package SmokeTests;




import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class AlertsTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		String exePath = "d://chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", "D:\\folder H\\BristleCone\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//customer name = name=cusid
		driver.get("file:///D://alerts.html");
		
		// click the alert button
		/*
		WebElement btn_Alert = driver.findElement(By.xpath("//*[@id=\"btnAlert\"]"));
		btn_Alert.click();
		
		driver.switchTo().alert().accept();
		
		*/
		
		
		//click the Show confirm box button
		
		WebElement btn_Confirm = driver.findElement(By.id("btnconfirm"));
		btn_Confirm.click();
		//displays Confirmed
		//driver.switchTo().alert().accept();
		
		//displays Rejected
		driver.switchTo().alert().dismiss();
		
		/*
		
		WebElement btn_Prompt= driver.findElement(By.id("btnPrompt"));
		btn_Prompt.click();
		
		
		driver.switchTo().alert().sendKeys("Sending from selenium code");
		Thread.sleep(5000);
		
		String s=driver.switchTo().alert().getText();
		System.out.println(s);
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		
		
		driver.switchTo().alert().sendKeys("SELENIUM");
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		String msg="Prompt dismissed";
		//click on Show prompt
		System.out.println(msg);
		
		
		System.out.println(driver.findElement(By.id("output")).getText());
		*/
		
	    //driver.quit();
		
	}

}
