package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/a/span[1]")
	private WebElement myAccountHeader;
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/ul/li[2]/a")
	private WebElement loginLink;
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/ul/li[1]/a")
	private WebElement registerLink;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void MyAccount() {
		myAccountHeader.click();
	}
	
    public LoginPage GotoLoginPage() {
    	loginLink.click();
    	return new LoginPage(driver);
    	
	 }
    public RegisterPage GotoRegisterPage() {
    	registerLink.click();
    	return new RegisterPage(driver);
    	
	 }
	

}
