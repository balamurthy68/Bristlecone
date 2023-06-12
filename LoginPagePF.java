package PFPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPagePF {
	
	 WebDriver driver;
	
	
	 @FindBy (id ="username") private WebElement username;
	 @FindBy (id="password") private WebElement password;
	 @FindBy(className="radius") private WebElement loginbtn;
	 @FindBy(linkText="Elemental Selenium") WebElement footer;
	 
	//Constructor
	public LoginPagePF(WebDriver p_driver)
	{
		this.driver = p_driver;
		PageFactory.initElements(driver, this);
	}
	
	//getter and setter methods
	
	public void setUserCredentials(String un,String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		
	}
	
	public void clickLogin()
	{
		loginbtn.click();
		
	}
	
	public boolean chkTitle(String expTitle)
	{
		return driver.getTitle().contains(expTitle);
	}
	
	public boolean isFooter(String expFooterText)
	{
	
		boolean isF;
		isF = footer.getText().contains(expFooterText);
		return isF;
		
		
	}
	
	public String isPasswordMasked()
	{
		
		return password.getAttribute("type");
		
		}
	
	//getter method for footer
	
	public boolean isFooterPresent ()
	{
		boolean isFooterthere;
		try {
			footer.getText();
			isFooterthere = true;
		}
		catch (NoSuchElementException e)
		{
			
			isFooterthere=false;
			System.out.println("Footer cannot be found.");
		}
		
		return isFooterthere;
		
		
	}
	
}


