package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	@FindBy(id="input-email")
	private WebElement email_field;
	
	@FindBy(id="input-password")
	private WebElement password_field;
	
	@FindBy(xpath="//*[@id='content']/div/div[2]/div/form/input")
	private WebElement signlink;
	
	@FindBy(xpath="//*[@id='account-login']/div[1]")
	private WebElement textMessageOnwrongCredential;
	
	
	//*[@id='account-login']/div[1]
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailid(String emailText) {
		email_field.sendKeys(emailText);
	}
	
	public void enterWrongEmailid(String wrongEmailText) {
		//String textmessage=Utilities.generateEmailwithtimeStamp();
		email_field.sendKeys(wrongEmailText);
	}
	
	public void enterPassword(String PasswordText) {
		password_field.sendKeys(PasswordText);
	}
	
	public SearchPage clickingSigninButton() {
		signlink.click();
		return new SearchPage(driver);
		
	}
	
	public String textmessageOnInvalidCredentials() {
		String displayText=textMessageOnwrongCredential.getText();
	    return displayText;
	}
      }
