package stepdefinitions;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import driverfactory.FactoryDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageclasses.HomePage;
import pageclasses.LoginPage;
import pageclasses.RegisterPage;
import util.ConfigReader;

public class RegisterTest {
	WebDriver driver;
	RegisterPage rp;
	
	@Given("go to register page")
	public void go_to_register_page() {
	   driver=FactoryDriver.getDriver();
	   HomePage hp=new HomePage(driver);
	   //RegisterPage rp=new RegisterPage(driver);
	   hp.MyAccount();
	   rp= hp.GotoRegisterPage();
		//driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/span[1]")).click();
	  // driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[1]/a")).click();	
	}
	
	@And ("enter emailidwithtimestamp")
	public void enter_emailid() {
		//RegisterPage rp=new RegisterPage(driver);
		rp.enterrandommailid();
		//driver.findElement(By.id("input-email")).sendKeys(ConfigReader.mailidwithtimestamp());
		
	}
	
	/*public String mailidwithtimestamp() {
		Date d=new Date();
		String timestampdate=d.toString().replace(" ","_").replace(":","_");
		return "pramesh"+timestampdate+"@gmail.com";
	}*/
	
	@When("enter duplicate emailid {string}")
	public void enter_duplicate_emailid(String emailid) {
		rp.enterduplicateEmailid(emailid);
		//driver.findElement(By.id("input-email")).sendKeys(emailid);
	}
	
	@Given("fill all the mandatory fields as below")
	public void fill_all_the_mandatory_fields_as_below(DataTable dataTable) {
		
		List<Map<String,String>> dataMap=dataTable.asMaps(String.class,String.class);
		rp.enterFirstName(dataMap.get(0).get("firstname"));
		rp.enterLastName(dataMap.get(0).get("lastname"));
		rp.enterTelephoneNumber(dataMap.get(0).get("telephone"));
		rp.enterPassword(dataMap.get(0).get("password"));
		rp.EnterconfirmPassword(dataMap.get(0).get("confirmpassword"));
		
		
		//driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get(0).get("firstname"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get(0).get("lastname"));
		//driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get(0).get("telephone"));
		//driver.findElement(By.id("input-password")).sendKeys(dataMap.get(0).get("password"));
		//driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get(0).get("confirmpassword"));
	}
	
	@Given("click policy checkbox")
	public void click_policy_checkbox() {
		rp.policyCheckBox();
		//driver.findElement(By.xpath("//input[@name='agree']")).click();
	}
	
	@Given("click on continue button")
	public void click_on_continue_button() {
		rp.continuewithregistration();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}
	
	@Then("register successful message displayed")
	public void register_successful_message_displayed() {
		String expectedText=rp.registrationConfirmationText();
		//String expectedText=driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
		String actualText="Your Account Has Been Created!";
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Then("duplicate email warning message should displayed")
	public void duplicate_email_warning_message() {
		String expectedText=rp.AlreadyRegisteredEmailText();
	//String expectedText=driver.findElement(By.xpath("//*[@id='account-register']/div[1]")).getText();
	String actualText="Warning: E-Mail Address is already registered!";
	Assert.assertEquals(actualText, expectedText);
		
	}
}

/*
@FindBy(xpath="//*[@id='account-register']/div[1]")
private WebElement alreadyregisteredmessagetext;
@FindBy(xpath="//*[@id='account-register']/div[1]")
private WebElement policyWarningMessage;
AlreadyRegisteredMailMessage=Warning: E-Mail Address is already registered!
PrivacyPolicyWarning=Warning: You must agree to the Privacy Policy!
*/