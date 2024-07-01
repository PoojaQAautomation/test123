package Baseclasspack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	
	static{
		
		FileInputStream file;   // this code is for reading and loading in property file
		try {
//			file = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\Com.kia\\src\\test\\java\\Propertyfilepack");
			
			file = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/Propertyfilepack/Env.properties");
			// "user.dir" ==>hamare workspace ke current project ko refrence krta hai
			
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			}catch(IOException e){
				e.printStackTrace();
				
			}
		}
		
		
	   //browser initialize code
		public void launchapplications(){
		String	browserName= prop.getProperty("browser");
		
//		if(browserName.equals("Chrome")) {
//			driver = new ChromeDriver(); 
//		}
//		else if(browserName.equals("ff"))
//		{
//			driver = new FirefoxDriver();
//			
//		}else if(browserName.equals("edge")){
//			driver = new EdgeDriver();
//		}
		
		
		
		// generic code for browser intialization:
		
//		switch(browserName){
//		case "Chrome":
//			driver = new ChromeDriver();
//		break;
//			
//		case "ff":
//			driver = new FirefoxDriver();
//			break;
//			
//		case "Edge":
//			driver = new EdgeDriver();
//				break;	
//		}
		
		
		// code to open brwser in incognito mode
		switch(browserName){
		case "Chrome":
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--incognito");
			driver = new ChromeDriver(option);
		    break;
			
		case "ff":
			FirefoxOptions ffoptions = new FirefoxOptions();
			ffoptions.addArguments("--incognito");
			driver = new FirefoxDriver(ffoptions);
			break;
			
		case "Edge":
			EdgeOptions edgeoptions = new EdgeOptions();
			edgeoptions.addArguments("--incognito");
			driver = new EdgeDriver(edgeoptions);
				break;	
		}
		
		
		//generic code
		driver.get(prop.getProperty("url"));
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		}


public void clearAndEnterText(WebElement ele, String value) {  //when enter value in two text box in that time WebElement and value will change thatswhy we write webelement and value, here and ele is a variable 
	  ele.clear();
	  ele.sendKeys(value);
	  
  }
   // two types of click of read it 1. javaScript executer click 2. normal click (which we use to click on any webElement).
  
  public void clickOnElement(WebElement ele) // when we enter value in two text box that time webElement will be change of text field thatwhy we write here Weelement and ele is a variable.
  {
	  
	 try {              // if normal click is not working then should be click by javaScript executer click. 
		 ele.click();
	 }
	 catch(Exception e){
		 JavascriptExecutor js = (JavascriptExecutor )driver;
		 js.executeScript("arguments[0],click();", ele);
	 }
	  
  }
  
  public void waitForElement(WebElement ele) {
	  WebDriver wait;
	  
	  WebDriverWait Wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  Wait.until(ExpectedConditions.visibilityOf(ele));
  }
  
  
  public void elementToBeclickable(WebElement ele) {
	  WebDriverWait Wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  Wait.until(ExpectedConditions.elementToBeClickable(ele));
	  
  }
  
  // generic code for alertpopup
           public void HandleAlertPopup(String method)
            {
        	   Alert a = driver.switchTo().alert();
        	   
        	   switch(method) {
        	   case "select":
        	      a.accept();
        	      break;
        	   
        	   case "cancel":
        		   a.dismiss();
        		   break;
        	   }
        	   
               	}
  
  ///genric code for selectdropdown
  
  public void selectDropdown(WebElement ele,  String value, String type) {
	  Select s = new Select(ele);
	  
	  switch(type){
	  case "visibletext":
	      s.selectByVisibleText("c++");
	  break;
	  
	  case "selectindex":
		  s.selectByIndex(2);
		  break;
		  
	  case "selectvalue":
	      s.selectByValue("java");
		 break;
	  }
	  
	  }
  
  //swtich window dropdown genric code
  
  public void SwitchWindow(String title) {
	  
	 Set<String> allwindow = driver.getWindowHandles();
	  for(String s : allwindow) {
		  driver.switchTo().window(s);
		  String actualtitle= driver.getTitle();
		  
		  if(actualtitle.equals(title)) {
			  
			  break;
		  }
		}
	 }
  
  
  
  //select value from dropdown using boostrap
  
  public void  SelectBootstrapDropdown(List<WebElement>list,String Value) {
	  
	  for(WebElement ele :list) {
		  String actualvalue = ele.getText();
		  if(actualvalue.equals(Value)) {
			  ele.click();
			  break;
		  }
	  }
	  
  }
  
  // switch frames
  public void SwitchFrame(String value) {
	  driver.switchTo().frame(value);
  }
  
  
  // Mousehover genric code
  public void MouseHover(WebElement ele) {
	  Actions a = new Actions(driver);
	  a.moveToElement(ele).build().perform();
	  
  }
  
  //genric code of text ko get karne ka
  public String getvalue (WebElement ele) {
	 String value = ele.getText();
	 return value;
  }
  
  
  
  
  // genric code to get the title 
  public String Gettitle() {
	 return driver.getTitle();
  }
  
  // Explicit wait genric code
  
  public void WaitforElement(WebElement ele,int timeout) {
	  WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(timeout));
	  w.until(ExpectedConditions.visibilityOf(ele));
	  
  }
  
  public void WaitforElementclickable(WebElement ele,int timeout) {
	  WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(timeout));
	  w.until(ExpectedConditions.elementToBeClickable(ele));
  }
  
  
  public void WaitforAlertPopup(int timeout) {
	  WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(timeout));
	  w.until(ExpectedConditions.alertIsPresent());
  }
  
}


