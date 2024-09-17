package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import driverfactory.FactoryDriver;
import io.cucumber.java.en.*;
import pageclasses.HomePage;
import pageclasses.LoginPage;
import pageclasses.SearchPage;

public class LoginTest {
	
	WebDriver driver;
	LoginPage lp;
	SearchPage sp;
	
	@Given("open application url")
	public void open_application_url() {
	   driver=FactoryDriver.getDriver();
	   driver.get("http://www.tutorialsninja.com/demo/");
	 }
	
	@Given("go to login page")
	public void go_to_login_page() {
		HomePage hp=new HomePage(driver);
		hp.MyAccount();
		lp=hp.GotoLoginPage();
		//driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/span[1]")).click();
		//driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]/a")).click();
	 }
	
	@When("enter emailid {string}")
	public void enter_valid_emailid(String emailid) {
		lp.enterEmailid(emailid);
		//driver.findElement(By.id("input-email")).sendKeys(emailid);
	}
	
	@When("enter password {string}")
	public void enter_valid_password(String password) {
		lp.enterPassword(password);
		//driver.findElement(By.id("input-password")).sendKeys(password);
	}
	
	@When("click on signin button")
	public void click_on_signin_button() {
		sp=lp.clickingSigninButton();
		//driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/form/input")).click();
	  }
	
	@Then("user should be able to login")
	public void user_should_be_able_to_login() {
		boolean expectedTextAfterlogin=sp.loginsuccesfulconfirmation();
	  // boolean expectedTextAfterlogin=driver.findElement(By.xpath("//a[normalize-space()='Edit your account information']")).isDisplayed();
	   Assert.assertTrue(expectedTextAfterlogin);
	}
	
	@Then("user should Not be able to login and proper warning text should displayed")
	public void invalidLogin() {
		  String expectedTextAfterlogin=driver.findElement(By.xpath("//*[@id='account-login']/div[1]")).getText();
		  String ActualText="Warning: No match for E-Mail Address and/or Password.";
		  Assert.assertEquals(expectedTextAfterlogin,ActualText);
	  }
	
	@When("^enter emailid (.*) for multiple users$")
	public void emailid_for_multiple_users(String emailid) {
		lp.enterEmailid(emailid);
		System.out.println("executing for multiple sets of users email");
	 }
	
	@And("^enter password (.*) for multiple users$")
	public void enter_password_for_multiple_users(String password) {
		lp.enterPassword(password);
		System.out.println("executing for multiple sets of users password");
	 }
       }