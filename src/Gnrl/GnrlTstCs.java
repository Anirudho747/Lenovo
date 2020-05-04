package Gnrl;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GnrlTstCs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\new Driver\\chromedriver.exe");
		
		
		GnrlTstCs gt = new GnrlTstCs();
		//gt.lcHomepage();
		//gt.prodcount();
		//gt.Srchprod();
		//gt.Filters();
		//gt.PriceSorting();
		//gt.CategoryPage();
		gt.Filter_Sort_on_Cat();
}
	
	@SuppressWarnings("unused")
	public void lcHomepage()
	{
		String base = "https://www.lenovo.com/in/en/";
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.lenovo.com/in/en/pc");
		try
		{
		List<WebElement> lnks = driver.findElements(By.tagName("a"));
		System.out.println(lnks.size());
		for(WebElement w:lnks)
		{
			String lnk = w.getAttribute("href");
			if(lnk.isEmpty())
			{
				System.out.println("Empty Link");
				continue;
			}
			else if(lnk==null)
			{
				System.out.println("Null Link");
				continue;
			}
			else if (!lnk.startsWith(base))
			{
				System.out.println("Link redirects outside domain");
				continue;
			}
				else
				System.out.println(lnk);
			    continue;
		}
	}	
		catch(Exception e)
		{
			System.out.println(e.toString());
		}		
		finally {
			driver.close();
		}

	}
	
	public void prodcount()

	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.lenovo.com/in/en?Redirect=False");
		try {
			WebElement PC = driver.findElement(By.xpath("//a[@data-name='PC & TABLETS']"));
			PC.click();
			WebElement Buy_In_Ur_City = driver.findElement(By.xpath("//a[@title='Buy in Your City']"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)",Buy_In_Ur_City);
		
			List<WebElement> trendingLaptops = driver.findElements(By.xpath("//div[@class='m-productCode__image']"));
			int TrendingLP = trendingLaptops.size();
			System.out.println("Laptops in trending "+TrendingLP);
			
			
			WebElement Best_Seller = driver.findElement(By.xpath("//a[@data-tab-title='Best Sellers']"));
			driver.manage().timeouts().implicitlyWait(1600,TimeUnit.SECONDS);
			Best_Seller.click();
			List<WebElement> B_S_Laptops = driver.findElements(By.xpath("//div[@class='m-productCode__image']"));
			int BSLP = B_S_Laptops.size();
			BSLP=BSLP-TrendingLP;
			System.out.println("Laptops in Best Selling "+BSLP);
			
			WebElement For_work = driver.findElement(By.xpath("//a[@data-tab-title='FOR WORK']"));
			For_work.click();
			List<WebElement> forworkassets = driver.findElements(By.xpath("//div[@class='m-productCode__image']"));
			int FWLP = forworkassets.size();
			FWLP=FWLP-BSLP-TrendingLP;
			System.out.println("Laptops in for-work "+FWLP);
			
			WebElement For_home = driver.findElement(By.xpath("//a[@data-tab-title='FOR HOME']"));
			For_home.click();
			List<WebElement> forhomeassets = driver.findElements(By.xpath("//div[@class='m-productCode__image']"));
			int FHLP = forhomeassets.size();
			FHLP=FHLP-FWLP-BSLP-TrendingLP;
			System.out.println("Laptops in for-home "+FHLP);
			
			WebElement For_gaming = driver.findElement(By.xpath("//a[@data-tab-title='FOR GAMING']"));
			For_gaming.click();
			List<WebElement> forgameassets = driver.findElements(By.xpath("//div[@class='m-productCode__image']"));
			int FGLP = forgameassets.size();
			FGLP=FGLP-FHLP-FWLP-BSLP-TrendingLP;
			System.out.println("Laptops in for-game "+FGLP);
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		finally {
			driver.close();
		}
	}

    public void Srchprod() throws InterruptedException
{
	WebDriver driver = new FirefoxDriver();
	driver.get("https://www.lenovo.com/in/en/pc");
	
	WebElement Srchbox = driver.findElement(By.id("inputSearchText"));
	Srchbox.sendKeys("Laptop for coding");
	WebElement SrchBtn = driver.findElement(By.xpath("//button[@class='m-searchRd__submit mfe']"));
	SrchBtn.click();
    driver.manage().timeouts().implicitlyWait(3400, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//div[@class='close-lnv-call-center']")).click();
	List<WebElement> ProdList = driver.findElements(By.xpath("//div[@class=\"o-productGridLayout__summary\"]"));
	System.out.println("List1 "+ProdList.size());
	
	WebElement Solutions = driver.findElement(By.xpath("//span[text()='Search Results']//following::div[@class=\"o-mainFooter__footerLinksColumn medium-4 large-2\"][6]"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)", Solutions);
	WebElement LoadMore = driver.findElement(By.xpath("//span[text()='Search Results']//following::button[@class='a-button m-loadMore__button a-loadButton'][1]"));
	LoadMore.click();
	Thread.sleep(2500);
	List<WebElement> ProdList2 = driver.findElements(By.xpath("//div[@class=\"o-productGridLayout__summary\"]"));
	System.out.println("List2 "+ProdList2.size());
	WebDriverWait wait100 = new WebDriverWait(driver,700);
	wait100.until(ExpectedConditions.elementToBeClickable(LoadMore));
	LoadMore.click();
	Thread.sleep(2500);
	List<WebElement> ProdList3 = driver.findElements(By.xpath("//div[@class=\"o-productGridLayout__summary\"]"));
	System.out.println("List3 "+ProdList3.size());
	JavascriptExecutor js1 = (JavascriptExecutor)driver;
	js1.executeScript("arguments[0].scrollIntoView(true)", Solutions);
	LoadMore.click();
	Thread.sleep(2500);
	List<WebElement> ProdList4 = driver.findElements(By.xpath("//div[@class=\"o-productGridLayout__summary\"]"));
	System.out.println("List4 "+ProdList4.size());
	}

    public void Filters() throws InterruptedException
    {
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.lenovo.com/in/en/pc");
    	
    	driver.manage().window().maximize();
    	WebElement Srchbox = driver.findElement(By.id("inputSearchText"));
    	Srchbox.sendKeys("Laptop for coding");
    	WebElement SrchBtn = driver.findElement(By.xpath("//button[@class='m-searchRd__submit mfe']"));
    	SrchBtn.click();
        driver.manage().timeouts().implicitlyWait(3400, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//div[@class='close-lnv-call-center']")).click();
    	driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
        WebElement Showmore1 = driver.findElement(By.xpath("//h4[text()='FILTER BY']//following::span[@class='o-expandableMenu__maxFilter'][1]"));
    	Showmore1.click();
    	driver.findElement(By.xpath("//label[@class='o-expandableMenu__checkboxIcon float-left ' and @name='8GB']")).click();
    	driver.manage().timeouts().implicitlyWait(700,TimeUnit.SECONDS);
    	
    	WebDriverWait wait7 = new WebDriverWait(driver,511);
    	wait7.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//label[@class='o-expandableMenu__checkboxIcon float-left ' and @name='Windows 10 Home']")))));
    	WebElement win10 = driver.findElement(By.xpath("//label[@class='o-expandableMenu__checkboxIcon float-left ' and @name='Windows 10 Home']"));    	
        win10.click();
    	
    	WebElement ScreenRes = driver.findElement(By.xpath("//span[@class='o-expandableHeading__name' and @data-term='Screen Resolution']"));
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	
    	js.executeScript("arguments[0].scrollIntoView()",ScreenRes);
    	
    	WebDriverWait wait100 = new WebDriverWait(driver,511);
    	wait100.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//h4[text()='FILTER BY']//following::span[@class='o-expandableMenu__maxFilter'][5]"))));
    	WebDriverWait wait101 = new WebDriverWait(driver,511);
    	wait101.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//h4[text()='FILTER BY']//following::span[@class='o-expandableMenu__maxFilter'][5]")))));
    	WebElement Showmore5 = driver.findElement(By.xpath("//h4[text()='FILTER BY']//following::span[@class='o-expandableMenu__maxFilter'][5]"));
    	Showmore5.click();
    	driver.findElement(By.xpath("//label[@class='o-expandableMenu__checkboxIcon float-left ' and @name='39.62cms (15.6)']")).click();
    }

    public void PriceSorting() throws InterruptedException

    {
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	String p="";
    	driver.get("https://www.lenovo.com/in/en/pc");
    	try
    	{
    	WebElement Srchbox = driver.findElement(By.id("inputSearchText"));
    	Srchbox.sendKeys("Laptop for coding");
    	WebElement SrchBtn = driver.findElement(By.xpath("//button[@class='m-searchRd__submit mfe']"));
    	SrchBtn.click();
        driver.manage().timeouts().implicitlyWait(3400, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//div[@class='close-lnv-call-center']")).click();
    	driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
    	Select sorter = new Select(driver.findElement(By.xpath("//select[@class='m-sortView__section']")));
    	sorter.selectByIndex(2);
    	Thread.sleep(2500);
    	List<WebElement> prc = driver.findElements(By.xpath("//span[@class=\"m-price__value\"]")); 
    	LinkedList<String> txt = new LinkedList<String>();
    	LinkedList<String> txt2 = new LinkedList<String>();
    	//System.out.println(prc.size());
    	for(WebElement wm:prc)
    	{
    	    p = wm.getText();
    	    if(!p.isEmpty())
    	    {
    	    p=p.substring(1);
    		txt.add(p);
    	    }
    	    else
    	    	continue;
 		}
    	txt2.addAll(txt);
    	Collections.sort(txt);   	
        int trker=0;
    	Iterator rev = txt.descendingIterator();
    	Iterator rev2 = txt2.iterator();
    	while(rev.hasNext())
    	{
    		while(rev2.hasNext())
    		{
    		if(rev.next()!=rev2.next())
    		{
    			trker=1;
    			System.out.println(rev.next());
    			System.out.println(rev2.next());
    			break;
    		}
    		}
    		
    	}
    	
    	if(trker==0) {
    		System.out.println("Proper Sorting Done");	
    	}
    	else
    		System.out.println("Incorrect Sorting Done");
    	}catch(Exception e)
    	{
    		System.out.println(e.toString());
    	}
    	finally
    	{
    		driver.close();
    	}
    	}

    public void CategoryPage()
    {
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	int p=0;
    	try
    	{
    	driver.get("https://www.lenovo.com/in/en/pc");
    	WebElement Monitor = driver.findElement(By.xpath("//a[@data-name='PC & TABLETS']//following::span[text()='Monitors'][1]")); 
    	Actions actn = new Actions(driver);
    	actn.moveToElement(Monitor).build().perform();;
    	WebElement Monitors_for_home = driver.findElement(By.xpath("//a[@title='Monitors for Home']"));
    	Monitors_for_home.click();
    	WebElement Pop_up = driver.findElement(By.xpath("//div[@id='closeStickySMB']"));
    	Pop_up.click();
        WebElement ScreenType = driver.findElement(By.xpath("//span[@id='Type_2']"));
    	String screencount = (ScreenType.getText());
    	screencount = screencount.substring(11,13);
    	int sc = Integer.parseInt(screencount); 
    	//System.out.println(screencount);
    	System.out.println(sc);
    	List Moncount = driver.findElements(By.xpath("//img[@class='accessoriesList-media-image qa_acc_list_gallery lazy lazyLoadAfterDOMInteractive']"));
    	p=p+Moncount.size();
    	driver.findElement(By.xpath("//div[@class='close-lnv-call-center']")).click();
    	WebElement nextPage = driver.findElement(By.xpath("//a[text()=2]"));
    	nextPage.click();
    	WebDriverWait wait1 = new WebDriverWait(driver,52);
    	List Moncount2 = driver.findElements(By.xpath("//img[@class='accessoriesList-media-image qa_acc_list_gallery lazy lazyLoadAfterDOMInteractive']"));
    	wait1.until(ExpectedConditions.visibilityOfAllElements(Moncount2));
    	//wait1.until(ExpectedConditions.elementToBeClickable((By) driver.findElements(By.xpath("//img[@class='accessoriesList-media-image qa_acc_list_gallery lazy lazyLoadAfterDOMInteractive']"))));
    	p=p+Moncount2.size();
    	System.out.println(p);
    	if(p==sc)
    		System.out.println("Count Matches");
    	}catch(Exception e)
    	{
    		System.out.println(e.toString());
    	}
    	finally
    	{
    		driver.close();
    	}
    }

    public void Filter_Sort_on_Cat() throws InterruptedException
    {
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	int p=0;
    	driver.get("https://www.lenovo.com/in/en/pc");
    	WebElement Monitor = driver.findElement(By.xpath("//a[@data-name='PC & TABLETS']//following::span[text()='Monitors'][1]")); 
    	Actions actn = new Actions(driver);
    	actn.moveToElement(Monitor).build().perform();;
    	WebElement Monitors_for_home = driver.findElement(By.xpath("//a[@title='Monitors for Home']"));
    	Monitors_for_home.click();
     	WebElement Pop_up = driver.findElement(By.xpath("//div[@id='closeStickySMB']"));
    	Pop_up.click();
    	driver.findElement(By.xpath("//div[@class='close-lnv-call-center']")).click();
    	WebElement price = driver.findElement(By.xpath("//h3[@data-term='Price']"));
    	price.click();
    	WebElement Low_price_Range = driver.findElement(By.xpath("//h3[@data-term='Price']//following::input[@id='facetInput'][1]"));
    	Low_price_Range.click();
    	Thread.sleep(2000);
    	WebElement sorter = driver.findElement(By.xpath("//button[@data-id='sortOptions1']"));
    	sorter.click();
    	WebElement Price_High = driver.findElement(By.xpath("//label[text()='Sort by:']//following::span[4]"));
    	Price_High.click();
    	List<WebElement> Sales_price = driver.findElements(By.xpath("//dd[@potentialdistype='SALESPRICE']"));
    	LinkedList<String> txt = new LinkedList<String>();
    	LinkedList<String> txt2 = new LinkedList<String>();
    	for(WebElement we:Sales_price)
    	{
    		String s=we.getText();
    		s= s.substring(1);
    		txt.add(s);
    	}
    	txt2.addAll(txt);
    	Collections.sort(txt);
        int trker=0;
    	Iterator rev = txt.descendingIterator();
    	Iterator rev2 = txt2.iterator();
    	while(rev.hasNext())
    	{
    		while(rev2.hasNext())
    		{
    		if(!(rev.next().equals(rev2.next())))
    		{
    			trker=1;
    			System.out.println("text1 "+rev.next());
    			System.out.println("text2 "+rev2.next());
    			break;
    		}
    		}
    		
    	}
    	
    	if(trker==0) {
    		System.out.println("Proper Sorting Done");	
    	}
    	else {
    		System.out.println("Incorrect Sorting Done");
    	}    	
    }
    }
