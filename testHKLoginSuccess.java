package SmokeTests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testHKLoginSuccess {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "D:\\folder H\\BristleCone\\chromedriver.exe");
		
		driver=new ChromeDriver();
		//open browser
		
		driver.get("https://the-internet.herokuapp.com/login");
		
		WebElement pwd = driver.findElement(By.id("password"));
		WebElement usr = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		
		
		usr.sendKeys("tomdddsmith");
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
			 	Date date = new Date();
		      SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy hh:mm:ss");
		       String str = formatter.format(date);
		       String filename =  "d://herokuapp_loginfailure" + str + ".jpg";
			//Call take screenshot function
	          takeSnapShot(driver,filename);
	        
			
			System.out.println("Login unsuccessful");
		}
		//driver.close();
		
	}

	/**
     * This function will take screenshot
     * @param webdriver
     * @param fileWithPath
     * @throws Exception     *      */
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
       //Move image file to new destination
         File DestFile=new File(fileWithPath);
      //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }

}
