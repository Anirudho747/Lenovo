package Gnrl;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class prodFlow {
	 
  WebDriver driver;
	 
  @BeforeClass
  public void beforeclass() {
	  System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\new Driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.lenovo.com/in/en/pc");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(52,TimeUnit.SECONDS);
  }
   
  @Test(priority=1,enabled=true)
  public void add_2_cart() {
	  WebElement Smartdev = driver.findElement(By.xpath("//a[@data-name='PC & TABLETS']//following::a[@data-name='Smart Devices'][1]"));
	  Smartdev.click();
	  WebElement smarter = driver.findElement(By.xpath("//div[@class='m-espotRedesign__textcontainer']"));
	  WebElement Disp7 = driver.findElement(By.xpath("//img[@alt='Lenovo Smart Display 7']"));
	  JavascriptExecutor js = (JavascriptExecutor)driver; 
	  js.executeScript("arguments[0].scrollIntoView", smarter);
	  Disp7.click();
	  try
	  {
	  WebElement Pop_up = driver.findElement(By.xpath("//div[@id='closeStickySMB']"));
  	  Pop_up.click();
	  }catch (Exception e)
	  {
		  System.out.println("pop-up not displayed");
	  }
  	  //driver.findElement(By.xpath("//div[@class='close-lnv-call-center']")).click();
  	  WebElement A2C = driver.findElement(By.xpath("//button[@id='addToCartButtonTop']"));
  	  A2C.click();
	  
	 
      for(int i=0; i<=7;i++)
      { try{
		     driver.findElement(By.xpath("//a[@data-name='PC & TABLETS']//following::a[@data-name='Smart Devices'][1]")).click();
		     break;
		  }
		  catch(Exception e){
		     System.out.println(e.getMessage());
		  } }
      
	  WebElement Disp10 = driver.findElement(By.xpath("//img[@alt='Lenovo Smart Display 10']"));
  	  Disp10.click();

	 // WebElement A2C = driver.findElement(By.xpath("//button[@id='addToCartButtonTop']"));
  	  for(int i=0;i<=7;i++)
  	    {
  		  try {
  	           driver.findElement(By.xpath("//button[@id='addToCartButtonTop']")).click();
  	           break;
  	          }     
  		  catch(Exception e)
	  				{
  	    	         System.out.println(e.getMessage());
	  				}
         }
  }
    
  @Test(priority=2,enabled=false)
  public void add_2_cart_2() {
	  WebElement Smartdev = driver.findElement(By.xpath("//a[@data-name='PC & TABLETS']//following::a[@data-name='Smart Devices'][1]"));
	  WebDriverWait wait = new WebDriverWait(driver,61);
      wait.until(ExpectedConditions.elementToBeClickable(Smartdev));
  	  Smartdev.click();
  	  WebElement smarter = driver.findElement(By.xpath("//div[@class='m-espotRedesign__textcontainer']"));
  	  JavascriptExecutor js = (JavascriptExecutor)driver;
  	  js.executeScript("arguments[0].scrollIntoView", smarter);
  	  WebElement Disp10 = driver.findElement(By.xpath("//img[@alt='Lenovo Smart Display 10']"));
  	  Disp10.click();
  	  driver.findElement(By.xpath("//div[@class='close-lnv-call-center']")).click();
	  WebElement A2C = driver.findElement(By.xpath("//button[@id='addToCartButtonTop']"));
  	  A2C.click();
  }
  
  @Test(priority=3,enabled=false)
  public void compare() {
	  WebElement Smartdev = driver.findElement(By.xpath("//a[@data-name='PC & TABLETS']//following::a[@data-name='Smart Devices'][1]"));
	  Smartdev.click();
	  WebElement smarter = driver.findElement(By.xpath("//div[@class='m-espotRedesign__textcontainer']"));
	  WebElement Disp7 = driver.findElement(By.xpath("//img[@alt='Lenovo Smart Display 7']"));
	  JavascriptExecutor js = (JavascriptExecutor)driver; 
	  js.executeScript("arguments[0].scrollIntoView", smarter);
	  Disp7.click();
	  
	  try
	  {
	  WebElement Pop_up = driver.findElement(By.xpath("//div[@id='closeStickySMB']"));
  	  Pop_up.click();
	  }catch(Exception e)
	  {
		  System.out.println("Pop-up not present");
	  }
	  finally	
	  {
  	  driver.findElement(By.xpath("//div[@class='close-lnv-call-center']")).click();
  	  WebDriverWait wait = new WebDriverWait(driver,88); 
  	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//label[starts-with(@for,'ZA')]"))));
  	  WebElement compare = driver.findElement(By.xpath("//label[starts-with(@for,'ZA')]"));
  	  compare.click();
	  }
  }
  
  @Test(priority=4,enabled=false)
  public void compare2() {
	  driver.get("https://www.lenovo.com/in/en/pc");
	  WebElement Smartdev = driver.findElement(By.xpath("//a[@data-name='PC & TABLETS']//following::a[@data-name='Smart Devices'][1]"));
	  WebDriverWait wait = new WebDriverWait(driver,61);
      wait.until(ExpectedConditions.elementToBeClickable(Smartdev));
  	  Smartdev.click();
  	  WebElement smarter = driver.findElement(By.xpath("//div[@class='m-espotRedesign__textcontainer']"));
  	  JavascriptExecutor js = (JavascriptExecutor)driver;
  	  js.executeScript("arguments[0].scrollIntoView", smarter);
  	  WebElement Disp10 = driver.findElement(By.xpath("//img[@alt='Lenovo Smart Display 10']"));
  	  Disp10.click();
  	  driver.findElement(By.xpath("//div[@class='close-lnv-call-center']")).click();
  	  WebDriverWait wait2 = new WebDriverWait(driver,88); 
 	  wait2.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//label[starts-with(@for,'ZA')]"))));
  	  WebElement compare = driver.findElement(By.xpath("//label[starts-with(@for,'ZA')]"));
	  compare.click();
	  WebElement cmpr_Item = driver.findElement(By.xpath("//button[@class=\"button-called-out compare-landingpage-action\"]"));
	  cmpr_Item.click();
  }

  @Test(priority=5,enabled=false)
  public void Quantity_DeliveryAddress() throws InterruptedException {
	  WebElement Smartdev = driver.findElement(By.xpath("//a[@data-name='PC & TABLETS']//following::a[@data-name='Smart Devices'][1]"));
	  Smartdev.click();
	  WebElement smarter = driver.findElement(By.xpath("//div[@class='m-espotRedesign__textcontainer']"));
	  WebElement Disp7 = driver.findElement(By.xpath("//img[@alt='Lenovo Smart Display 7']"));
	  JavascriptExecutor js = (JavascriptExecutor)driver; 
	  js.executeScript("arguments[0].scrollIntoView", smarter);
	  Disp7.click();
	  
	  try
	  {	  
	  WebElement Pop_up = driver.findElement(By.xpath("//div[@id='closeStickySMB']"));
  	  Pop_up.click();
	  }catch (Exception e)
	  {
		  System.out.println("pop-up not displayed");
	  }finally
	  {
	  driver.findElement(By.xpath("//div[@class='close-lnv-call-center']")).click();
  	  WebElement A2C = driver.findElement(By.xpath("//button[@id='addToCartButtonTop']"));
  	  A2C.click();	
  	  WebElement QtyDD = driver.findElement(By.xpath("//div[@class='qtyHeader']"));
  	  QtyDD.click();
  	  WebDriverWait wait = new WebDriverWait(driver,727);
  	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#updateCartForm0 > div > ul > li.more-number"))));
  	  WebElement Qty6  = driver.findElement(By.cssSelector("#updateCartForm0 > div > ul > li.more-number"));
  	  Qty6.click();
  	  Thread.sleep(3000);
  	  WebElement QtyDD2 = driver.findElement(By.cssSelector("#updateCartForm0 > div > div > span"));
  	  String amnt = QtyDD2.getText();
  	  System.out.println("Amount "+amnt);
  	  WebElement Pincode = driver.findElement(By.id("pinCode"));
  	  WebElement Chk_pincode = driver.findElement(By.id("cart-summary-pinCode-button"));
  	  Pincode.sendKeys("600901");
  	  Chk_pincode.click();
  	  String msg = driver.findElement(By.cssSelector("#ajaxCallResponseMessage")).getAttribute("title");  	  
  	  Thread.sleep(7000);
  	  System.out.println("Msg1"+msg);
   	  Thread.sleep(2500);
  	  Pincode.clear();
  	  Pincode.sendKeys("736101");
	  Chk_pincode.click();
	  msg = driver.findElement(By.cssSelector("#pinCode_message_content")).getText();
	  Thread.sleep(4300);
	  System.out.println("Msg1"+msg);
	  }
  }
 
  @Test(priority=6,enabled=false)
  public void Login() throws InterruptedException {
	//  Thread.sleep(5000);
	  WebElement Account = driver.findElement(By.xpath("//input[@id = 'inputSearchText']//preceding::a[@data-id=\"Account\"][4]"));
	  Account.click();
	  WebElement Crt_Accnt = driver.findElement(By.xpath("//a[@class='button-called-out signInModule-createAccount-button']"));
	  Crt_Accnt.click();
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
	  Email_address.sendKeys("Arjun@mbt.com");
	  
	  Email_address_2.clear();
	  Email_address_2.sendKeys("Arjun@mbt.com");
	  
	  First_Name.clear();
	  First_Name.sendKeys("Arjun");
	  Reporter.log("Hi");
	  Last_Name.clear();
	  Last_Name.sendKeys("Mahabharatha");
	  
	  Password.clear();
	  Password.sendKeys("abcdefg@1234567");
	  
	  Password_2.clear();
	  Password_2.sendKeys("abcdefg@1234567");
	  
	  T_and_C.click();
	  
	  Create_Accnt.click();
  }
  
  @AfterClass
  public void afterClass() {
	 }
  
   

}

