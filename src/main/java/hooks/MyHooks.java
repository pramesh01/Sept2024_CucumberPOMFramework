package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverfactory.FactoryDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ConfigReader;

public class MyHooks {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		Properties prop=ConfigReader.initializeProperties();
		FactoryDriver.launchBrowser(prop.getProperty("browser"));
		driver=FactoryDriver.getDriver();
	  }
	
	@After
	public void teardown(Scenario scenario) {
		String scenarioName=scenario.getName().replaceAll(" ","_");
		if(scenario.isFailed()) {
			byte[] srcDest=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcDest,"image/png",scenarioName);
		}
		driver.quit();
		
	}
}
