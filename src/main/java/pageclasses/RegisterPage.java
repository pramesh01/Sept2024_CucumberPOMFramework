package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ConfigReader;

public class RegisterPage {
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement first_nameTextField;
	@FindBy(id="input-lastname")
	private WebElement last_nameTextField;
	@FindBy(id="input-email")
	private WebElement emailTextField;
	@FindBy(id="input-telephone")
	private WebElement telephoneTextField;
	@FindBy(id="input-password")
	private WebElement passwordTextField;
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmTextField;
	@FindBy(xpath="//input[@name='agree']")
	private WebElement policyCheckBox;
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	@FindBy(xpath="//*[@id='content']/h1")
	private WebElement registrationconfirmationmessagetext;
	@FindBy(xpath="//*[@id='account-register']/div[1]")
	private WebElement alreadyregisteredmessagetext;
	@FindBy(xpath="//*[@id='account-register']/div[1]")
	private WebElement policyWarningMessage;
	
	
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterFirstName(String fName) {
		first_nameTextField.sendKeys(fName);	
	}
	public void enterLastName(String lName) {
		last_nameTextField.sendKeys(lName);	
	}
	public void enterEmailid(String email) {
		emailTextField.sendKeys(email);	
	}
	public void enterTelephoneNumber(String phoneno) {
		telephoneTextField.sendKeys(phoneno);	
	}
	public void enterPassword(String password) {
		passwordTextField.sendKeys(password);	
	}
	public void EnterconfirmPassword(String confirmPassword) {
		passwordConfirmTextField.sendKeys(confirmPassword);	
	}
	public void policyCheckBox() {
		policyCheckBox.click();
	}
	public void continuewithregistration() {
		continueButton.click();
	}
	
	public String registrationConfirmationText() {
		String confirmessageafterregistration=registrationconfirmationmessagetext.getText();
	    return confirmessageafterregistration;
	}
	
	public String AlreadyRegisteredEmailText() {
		String duplicateEmailidWarning=alreadyregisteredmessagetext.getText();
	    return duplicateEmailidWarning;
	}
	
	public String PolicyUnconfirmationtext() {
		String policyWarning=policyWarningMessage.getText();
	    return policyWarning;
	}
	
	public void enterrandommailid() {
		emailTextField.sendKeys(ConfigReader.mailidwithtimestamp());
	}

	public void enterduplicateEmailid(String duplicateemailid) {
		emailTextField.sendKeys(duplicateemailid);	
	}
	
}
