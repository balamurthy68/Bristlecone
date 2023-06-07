package DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class ExcelToDataProvider {
	static WebDriver driver;
	static WebElement usr;
	static WebElement pwd;

 
    String xlFilePath = "d:\\Test.xlsx";
    String sheetName = "Sheet1";
    ExcelApiTest eat = null;
     
    @Test(dataProvider = "userData")
    public void fillUserForm(String userName, String passWord)
    {
       System.out.println("UserName: "+ userName);
       System.out.println("PassWord: "+ passWord);
       System.out.println("*********************");
       
       Reporter.log("Username is: ****" + userName + " Password:" + passWord);
       
       
        usr.sendKeys(userName);
		pwd.sendKeys(passWord);
	
		//click on submit button
		WebElement submitbtn = driver.findElement(By.cssSelector("#login > button"));
		
		submitbtn.click();
		
		String msg = driver.findElement(By.id("flash")).getText();
	
		boolean isSuccess = false;
		if (msg.contains("You logged into")) {
			
			isSuccess=true;
		}
		else
		{
			System.out.println("Login Failed");
			isSuccess=false;
			//Take screenshot with username and password as the filename ex: tom_super070623_11-18.jpg
		}
		
		Assert.assertEquals(true,isSuccess);
		
	
		
		//driver.close();
		
	} 
     
    @DataProvider(name="userData")
    public Object[][] userFormData() throws Exception
    {
        Object[][] data = testData(xlFilePath, sheetName);
        return data;
    }
     
    
    	
	@BeforeTest
   public void openDriver() {
	// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\folder H\\BristleCone\\chromedriver.exe");
		
		driver=new ChromeDriver();
		//open browser
			
			
   }
	@BeforeMethod
	
	public void init()
	{
		    driver.get("https://the-internet.herokuapp.com/login");
			pwd = driver.findElement(By.id("password"));
			usr = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		
	}

    //User defined function/method.
    public Object[][] testData(String xlFilePath, String sheetName) throws Exception
    {
        Object[][] excelData = null;
        eat = new ExcelApiTest(xlFilePath);
        int rows = eat.getRowCount(sheetName);
        int columns = eat.getColumnCount(sheetName);
                 
        excelData = new Object[rows-1][columns];
         
        for(int i=1; i<rows; i++)
        {
            for(int j=0; j<columns; j++)
            {
                excelData[i-1][j] = eat.getCellData(sheetName, j, i);
                
                System.out.println("j:" + j  + "i:" + i);
            }
             
        }
        return excelData;
    }
}