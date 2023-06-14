package Steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class searchSteps {

	static WebDriver driver;

	@After
	public static void closeall()
	{
		driver.close();
		
	}
	@Before
	public static void beforeall()
	{
		System.setProperty("webdriver.chrome.driver", "d://folder H//BristleCone//chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		// Launching the browser
		driver=new ChromeDriver(opt);

	}
	@Given("the browser has to open here")
	public void the_browser_has_to_open_here() {
	    // Write code here that turns the phrase above into concrete actions

		System.out.println("This is the very first line to execute");
	}


@Given("website is open")
public void website_is_open() {
    // Write code here that turns the phrase above into concrete actions
    

	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://advantageonlineshopping.com");
}


@When("I enter a search keyword")
public void i_enter_a_search_keyword() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("entering a search word "+ driver.getTitle());
	driver.manage().window().maximize();
	driver.findElement(By.id("menuSearch")).click();

}


    // Write code here that turns the phrase above into concrete actions
@When("press enter key {string}")
public void press_enter_key(String string) {
	System.out.println("search keyword is "+ string);
	driver.findElement(By.id("autoComplete")).sendKeys(string + Keys.ENTER);


}

@Then("validate search results")
public void validate_search_results() {
    // Write code here that turns the phrase above into concrete actions

	boolean success;
	try {

		WebElement noOfItems = ((WebDriver) driver).findElement(By.xpath("//a[@class=\"titleItemsCount ng-binding\"]"));
		success=true;
		System.out.println(noOfItems.getText());
		//Add the first item listed to cart
	    WebElement firstImage = ((WebDriver) driver).findElement(By.xpath("//*[@class=\"product ng-scope\"][1]/img//parent::a"));
		firstImage.click();
		driver.findElement(By.name("save_to_cart")).click();

		
	}catch (NoSuchElementException e) {

		System.out.println("Search term did not fetch results");
		success=false;
		driver.close();
	}
	//search is successful
	
	Assert.assertEquals(success,true);
	}




}
