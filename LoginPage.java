package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
	
	 WebDriver driver;
	
	 By username=By.id("username");
	 By password=By.id("password");
	 By loginbtn = By.cssSelector("#login > button > i");
	 By footer = By.linkText("Elemental Selenium");
	//Constructor
	public LoginPage(WebDriver p_driver)
	{
		this.driver = p_driver;
	}
	
	//getter and setter methods
	
	public void setUserCredentials(String un,String pw)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		
	}
	
	public void clickLogin()
	{
		driver.findElement(loginbtn).click();
	}
	
	public boolean chkTitle(String expTitle)
	{
		return driver.getTitle().contains(expTitle);
	}
	
	public boolean isFooter(String expFooterText)
	{
		return driver.findElement(footer).getText().contains(expFooterText);
		
	}
	
	public String isPasswordMasked()
	{
		
		
		return (driver.findElement(password).getAttribute("type"));
	}
}


