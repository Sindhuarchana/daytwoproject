package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclassforproject {
public static WebDriver driver;
	
	public static WebDriver LaunchBrowser(String bname)
	{
		switch(bname)
		{
		case "chrome":
			System.out.println("inidecrome");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("fir");
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println("edge");
			break;
			
			default:
				System.out.println("invalid browser name");
		}
		return driver;
		
	}
	
		
	
	
	public static void urlLaunch(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	
		
	 public static void implicitlyWait(int a)
	 {
		 driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
		 
	 }
	 
	
	
	 public static void sendkeys(WebElement e,String value)
	 {
		 e.sendKeys(value);
	 }
	 
	 
	 public static void click1(WebElement e)
	 {
		 e.click();
	 }
	 
	 public static String getcurrentUrl()
	 {
		 String currentUrl = driver.getCurrentUrl();
		return currentUrl;
		 
	 }
	 
	 public static String getTitle()
	 {
		 String title = driver.getTitle();
		return title;
		 
	 }
	 
	 public static String getText(WebElement e)
	 {
		 String text = e.getText();
		return text;
		 
	 }
	 
	 public static String getAttribute(WebElement e)
	 {
		 String attribute = e.getAttribute("value");
		return attribute;
		 
	 }
	 
	 public static String getAttribute2(WebElement e)
	 {
		 
		 System.out.println(e);
		 String attribute = e.getAttribute("innerTML");
		 System.out.println(attribute);
		return attribute;
	 }
	 
	 
	 
	 public static void moveToElement(WebElement e)
	 {
		 Actions a=new Actions(driver);
		a.moveToElement(e).perform();
	 }
	 
	 public static void dragAndDrop(WebElement src,WebElement tar)
	 {
		 Actions a=new Actions(driver);
		 a.dragAndDrop(src, tar).perform();
	 }
	 
	 
	 public static void SelectByIndex(WebElement e,int a)
	 {
		 Select s=new Select(e);
		  s.selectByIndex(a);
		 
	 }
	 
	 public static void SelectByvalue(WebElement e,String a)
	 {
		 Select s=new Select(e);
		 s.selectByValue(a);
	 }
	 
	 public static void selectByVisibleText(WebElement e,String a)
	 {
		 Select s=new Select(e);
		 s.selectByVisibleText(a);
		 
	 }
	 
	 public static void listdropdown(List<WebElement> e,String a) {
	 
	 for(int i=0;i<=e.size()-1;i++)
		{
			if(e.get(i).getText().contains(a)) {
				e.get(i).click();
				break;
			}
		}
		
	}
	
	 
	 public static void contextClick(WebElement e)
	 {
		 Actions a=new Actions(driver);
		a.contextClick(e).perform();
	 }
	 
	 
	 public static void doubleClick(WebElement e)
	 {
		 Actions a=new Actions(driver);
		 a.doubleClick(e).perform();
	 }
	 
	 
	 public static void alertaccept()
	 {
		 Alert q1 = driver.switchTo().alert();
		q1.accept();
	 }
	 
	 public static void alertdismiss()
	 {
		 Alert q2=driver.switchTo().alert();
		 q2.dismiss();
	 }
	 public static void Robot(int x) throws AWTException
	 {
		 Robot r=new Robot();
		 
		 for(int i=0;i<x;i++)
		 {
			 r.keyPress(KeyEvent.VK_DOWN);
		        r.keyRelease(KeyEvent.VK_DOWN);
		 }
		 
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);
	 }
	 
	 
	 
	 
	 
	 
	public static File getScreenshotAs_web_element(WebElement b)
	{
		File a1 = b.getScreenshotAs(OutputType.FILE);
		return a1;
	}
	
	public static File getScreenshotAs_full(TakesScreenshot b)
	{
		File a1 = b.getScreenshotAs(OutputType.FILE);
		return a1;
	}
	
	public static void click(WebElement b)
	{
		b.click();
	}
	
	public static void save(File b) throws IOException
	{
		String timestamp = new SimpleDateFormat("yyyymmdd_HHmmss").format(Calendar.getInstance().getTime());
		File destfile = new File("C:\\Users\\DELL\\eclipse-workspace\\SeleniumTwo\\screenshot\\intrwqstn-"+timestamp+".png");
	    FileUtils.copyFile(b, destfile);
	}
		
	public static void JavascriptExecutor(WebElement e,String s)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','s')", e);
	}
    public static void JavascriptExecutorclick(WebElement e)
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click()", e);
    }
    
    public static void scrollDown(WebElement sd)
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true)", sd);
    }
    
    
    public static void scrollup(WebElement su)
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(false)", su);
    }
    
    public static void WindowHandles(int a)
    {
    	Set<String> allid = driver.getWindowHandles();
    	
		int count=1;
			for(String eachid:allid)
			{
				if(count==a)
				{
					driver.switchTo().window(eachid);
				}
				count++;
		
			}}
    
    
    		
    public static void quit()
    {
    	
    driver.quit();
    
    
    
    
    
    
    
    
}
    
    


	

}


