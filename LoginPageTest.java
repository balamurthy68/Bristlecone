package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginPageTest {
	static WebDriver driver;
	LoginPage l;
	
	@BeforeTest
	public void beforeAll ()
	{
		System.setProperty("webdriver.chrome.driver", "d://folder h//bristlecone//chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
	
		l  = new LoginPage(driver);
	}
	
	@Test
 
  public void titleTest() {
      
      
	  boolean titlechk = l.chkTitle("The Internet");
	  
	  Assert.assertEquals(titlechk, true);
  
  }
	
	@Test
	public void asecurityChk()
	{
		String pwdtype = l.isPasswordMasked();
		System.out.println(pwdtype);
		
		Assert.assertEquals(pwdtype, "password");
	}
@Test	
 public void doLogin()
 {
	 l.setUserCredentials("tomsmith", "SuperSecretPassword!");
	 l.clickLogin();
	 
 }
	
@Test
public void chkFooter()
{
	boolean chkFooter;
	
	chkFooter = l.isFooter("Elemental Selenium");
	
	Assert.assertEquals(chkFooter, true);
}
	
}
