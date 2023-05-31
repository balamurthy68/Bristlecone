package code;

/*
//  Selenium Web Driver has borrowed the idea of implicit waits from Watir.

The implicit wait will tell to the web driver to wait for certain amount of time before it throws
 a "No Such Element Exception". The default setting is 0. Once we set the time, web driver will 
 wait for that time before throwing an exception.

In the below example we have declared an implicit wait with the time frame of 10 seconds.
 It means that if the element is not located on the web page within that time frame, it will throw an exception.

To declare implicit wait:
Syntax:
driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
*/
	
	import java.util.concurrent.TimeUnit;
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.testng.annotations.Test;

public class ImplicitwaitExample {
	WebDriver driver;
	@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		    System.setProperty ("webdriver.chrome.driver","chromedriver.exe" );
		    WebDriver driver = new ChromeDriver(); 
		    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			String eTitle = "Selenium Learning";
			String aTitle = "" ;
			// launch Chrome and redirect it to the Base URL
			driver.get("file:///C:/Users/Lenovo/Desktop/sample.html" );
			//Maximizes the browser window
			driver.manage().window().maximize() ;
			//get the actual value of the title
			aTitle = driver.getTitle();
			//compare the actual title with the expected title
			if (aTitle.equals(eTitle))
			{
			System.out.println( "Test Passed") ;
			}
			else {
			System.out.println( "Test Failed" );
			}
			//close browser
			driver.close();
		}
		}

	
	
	


