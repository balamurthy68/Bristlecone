package DataDriven;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//How to read excel files using Apache POI
public class excelReader {

	static XSSFCell s_custid;
	static XSSFCell s_custname;
	static WebDriver driver;	



	public static void main (String [] args) throws IOException, InterruptedException{
		String exePath = "D:\\folder H\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", exePath);

		WebElement txt_email,lnk_logout;

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// open the browser with the url
		//driver.get("http://demowebshop.tricentis.com/");

		//I have placed an excel file 'Test.xlsx' in my D Driver 
		FileInputStream fis = new FileInputStream("D:\\Test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		System.out.println(sheet.getLastRowNum());
		int rowcount = sheet.getLastRowNum();
		for (int i = 1; i < rowcount +1; i ++) {
			s_custid = sheet.getRow(i).getCell(0);
			s_custname = sheet.getRow(i).getCell(1);
			display(s_custid,s_custname);
		}
		//String cellval = cell.getStringCellValue();

	}	
	static void display(XSSFCell s_custid2,XSSFCell s_custname2) throws InterruptedException

	{

		System.out.println("Custid is:" + s_custid2 + " Custname is : " + s_custname2);

		String p1 = s_custid2.toString();	
		String p2 = s_custname2.toString();
		/*
			driver.findElement(By.linkText("Log in")).click();

		    driver.findElement(By.id("Email")).sendKeys(p1);

		    driver.findElement(By.id("Password")).sendKeys(p2);

		    Thread.sleep(2000);
		 */

		//driver.navigate().to("http://demowebshop.tricentis.com");

	}


}



