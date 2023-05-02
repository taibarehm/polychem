package Stepdefenation;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.runtime.Timeout;
import gettersetter.clientserver;


public class Login {

	WebDriver driver= new ChromeDriver();
	clientserver s1= new clientserver();
	public Login() {
		// TODO Auto-generated constructor stub
		
		try {
			String filename=System.getProperty("user.dir")+ "//config.properties";
			InputStream ku= new FileInputStream(filename);
			Properties opp = new Properties();
			opp.load(ku);
			String st=opp.getProperty("driver");
			//System.getProperty("webdriver.chrome.driver","C:\\Users\\ASU\\Desktop\\Seleniumdriver\\chromedriver.exe");
			System.getProperty("webdriver.chrome.driver",st);
			
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
	} 
		
	
	

	@Given("^open google with helpof url$")
	public void open_google_with_helpof_url() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.get("https://www.google.com/");
		
	}

	@Given("^search intragram$")
	public void search_intragram() throws Throwable {
	   
		
		String Xpath1=s1.getXpath();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		WebElement thn = driver.findElement(By.xpath(Xpath1)); 
		
		 thn.isDisplayed();
		 thn.click();
		 thn.sendKeys("https://www.instagram.com/");
		 thn.sendKeys(Keys.RETURN);
	    
	}

	




	@When("^I complete action open first url$")
	public void i_complete_action_open_first_url() throws Throwable {
		String Xpath1=s1.getQt();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		WebElement thn = driver.findElement(By.xpath(Xpath1)); 
		 thn.isDisplayed();
		 thn.sendKeys(Keys.RETURN);
	    
	}



}
