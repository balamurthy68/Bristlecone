package SmokeTests;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import org.testng.annotations.Test;

public class TakeScreenshot {

    //@Test

    //public void TakeScreenShot() throws Exception{
     public static void main(String[] args) throws Exception {
     	WebDriver driver ;
     	System.setProperty("webdriver.chrome.driver", "D:\\folder H\\BristleCone\\chromedriver.exe");
     	driver = new ChromeDriver();
        //goto url
         driver.get("https://the-internet.herokuapp.com/broken_images");
        //Call take screenshot function
          takeSnapShot(driver, "d://herokuapp_brokenimages.jpg");
          //driver.findElement(By.linkText("Log in")).click();          
          takeSnapShot(driver, "d://webshopLogafterlogin.jpg");
          driver.close();
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
