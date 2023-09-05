import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class firsttest {
	static WebDriver driver;
	
	

	public static void main(String[] args) throws Throwable  {
		
		try {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ASU\\Desktop\\Seleniumdriver\\chromedriver.exe");
		
		bulder ob= new bulder();

		driver=new ChromeDriver();
        String baseUrl = "https://www.google.com/";

			driver.get(baseUrl);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.navigate().refresh();

	        WebElement but= driver.findElement(By.xpath(ob.getAb()));
	        highLightElement(but);
	        
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        but.isDisplayed();
	        but.click();
	        but.sendKeys("Buy ipod");
	        but.sendKeys(Keys.RETURN);
	        driver.manage().window().maximize();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	       
	        js.executeScript("window.scrollBy(0,400)");
	      
	        WebElement Amazon= driver.findElement(By.xpath(ob.getSt()));
	  
	        highLightElement(Amazon);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        Amazon.click();
	        js.executeScript("window.scrollBy(0,5000)");
	        JavascriptExecutor jse = (JavascriptExecutor)driver;
	        jse.executeScript("window.open()");
	                
	        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	                driver.switchTo().window(tabs.get(0));
	                
	        driver.get(baseUrl);
        
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		
	
	}
	public static void highLightElement(WebElement element){ 
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');",element);
	}
	

}
