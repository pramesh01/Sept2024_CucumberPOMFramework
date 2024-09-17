package driverfactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FactoryDriver {
	
	public static WebDriver driver=null;
	public static void launchBrowser(String bName) {
		
		if(bName.equalsIgnoreCase(bName)) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			}
			else if(bName.equalsIgnoreCase(bName)){
				driver=new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	    }
	
	//method for getting driver everywhere u want.
	  public static WebDriver getDriver() {
		 return driver;
	 }
         }
