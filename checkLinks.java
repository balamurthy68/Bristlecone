package SmokeTests;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "D:\\folder H\\BristleCone\\chromedriver.exe");
		
		driver=new ChromeDriver();
		//open browser
		
		driver.get("file:///D:/sample.html");
	
		List <WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("There are " + links.size()  + "links in the page");
		
		for (int i=0;i < links.size();i++)
		{
			System.out.println(links.get(i).getText());
		
			//call the http checker code here and send the url attribute value 
			validateLink(links.get(i).getAttribute("href"));
			
		}
	}	

		//The below function validateLink(String urlLink) verifies any broken links and return the server status. 
			public static void validateLink(String urlLink) {
		     //Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis
		     try {
					//Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
					URL link = new URL(urlLink);
					// Create a connection using URL object (i.e., link)
					HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
				
					//Set the timeout for 2 seconds
					httpConn.setConnectTimeout(2000);
					//connect using connect method
					
					httpConn.connect();
					//use getResponseCode() to get the response code. 
						if(httpConn.getResponseCode()== 200) {	
							System.out.println("Ok for " + urlLink+" - "+httpConn.getResponseMessage());
						}
						if(httpConn.getResponseCode()== 404) {
							System.out.println("Broken link " + urlLink+" - "+httpConn.getResponseMessage());
						}
					}
					//getResponseCode method returns = IOException - if an error occurred connecting to the server. 
				catch (Exception e) {
					//e.printStackTrace();
					System.err.println("Broken link " + urlLink+ " " + e.getCause());
					
				}
		 } 

	}


