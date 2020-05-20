package Gnrl;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Login {
	
	WebDriver driver;
	
	 @BeforeMethod
	  public void beforeMethod() {
	 
		 System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\new Driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.lenovo.com/in/en/pc");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(52,TimeUnit.SECONDS);
		 WebElement Account = driver.findElement(By.xpath("//input[@id = 'inputSearchText']//preceding::a[@data-id=\"Account\"][4]"));
		 Account.click();
		 WebElement Crt_Accnt = driver.findElement(By.xpath("//a[@class='button-called-out signInModule-createAccount-button']"));
		 Crt_Accnt.click();
		  
	 }

	
	
  @Test(dataProvider = "dp")
  public void f(String Email,String Email2,String First,String Last,String Psswrd,String Psswrd2) {
	  
	  WebElement Email_address = driver.findElement(By.id("register.email"));
	  WebElement Email_address_2 = driver.findElement(By.id("register.chkEmail"));
	  WebElement First_Name = driver.findElement(By.id("register.firstName"));
	  WebElement Last_Name = driver.findElement(By.id("register.lastName"));
	  WebElement Password = driver.findElement(By.id("password"));
	  WebElement Password_2 = driver.findElement(By.id("register.checkPwd"));
	  WebElement T_and_C = driver.findElement(By.id("register.acceptterms"));
	  WebElement Create_Accnt = driver.findElement(By.xpath("//button[@class='button-called-out signUpForm-submitButton']"));
	  
	  driver.findElement(By.xpath("//div[@class='close-lnv-call-center']")).click();
	  
	  Email_address.clear();
	  Email_address.sendKeys(Email);
	  
	  Email_address_2.clear();
	  Email_address_2.sendKeys(Email2);
	  
	  First_Name.clear();
	  First_Name.sendKeys(First);
	  
	  Last_Name.clear();
	  Last_Name.sendKeys(Last);
	  
	  Password.clear();
	  Password.sendKeys(Psswrd);
	  
	  Password_2.clear();
	  Password_2.sendKeys(Psswrd2);
	  
	  T_and_C.click();
	  
	  Create_Accnt.click();
  
  }

  @DataProvider
  public Object[][] dp() throws IOException {
   FileInputStream FIS = new FileInputStream("D:\\Progs\\Combo2.xlsx"); 
   XSSFWorkbook wb = new XSSFWorkbook(FIS); 
   XSSFSheet sheet = wb.getSheetAt(0);
   XSSFCell Cell;
   
   int rc = sheet.getLastRowNum()-sheet.getFirstRowNum();
   int rowcount = sheet.getLastRowNum()+1;
   
   String [][]result = new String [rowcount][6];
   
   for(int i=0,i1=0;i<rc;i++,i1++)
   {
	   Row row = sheet.getRow(i);
	   for(int j=0,j1=0;j<row.getLastCellNum();j++,j1++)
	   {
		   //Cell = sheet.getRow(i).getCell(j);
		   Cell = sheet.getRow(j).getCell(j,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		   Cell.setCellType(CellType.STRING);
		   String sdata = Cell.getStringCellValue();
		   Reporter.log("Hi");
		   result[i1][j1] = sdata;
		   System.out.println(result[i1][j1]);
	   }
   }
   wb.close();
   FIS.close();
   
   return result;
  }
  
      @AfterMethod
      public void afterMethod() {
      }
  
  
}
