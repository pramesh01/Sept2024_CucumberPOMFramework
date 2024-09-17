package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='search']/input")
	private WebElement searchTextboxfield;
	
	@FindBy(css="div[class='caption'] h4 a")
	private WebElement searchTextResult;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	private WebElement logOutlink;
	
	@FindBy(css="div[id='content'] h1")
	private WebElement logoutText;
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/a/span[1]")
	private WebElement afterloginMyaccountbreadcrumblink;
	
	@FindBy(linkText="Edit your account information")
	private WebElement editinformationoptiontext;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	 }
	
	public void enterTextinSearchField(String entertextdata) {
		searchTextboxfield.sendKeys(entertextdata);
		
	   }
	public void clickEnterAfterText() {
		searchTextboxfield.sendKeys(Keys.ENTER);
		
	   }
	
	public String getTextAfterSearch() {
		String resutTExtData=searchTextResult.getText();
		return resutTExtData;
		
	 }
	
	public String veryfyLogoutText() {
		String textmessageafterlogout=logoutText.getText();
		return textmessageafterlogout;
	}
	
	public void clickingonMyAccountforlogout() {
		afterloginMyaccountbreadcrumblink.click();
	}
	
	 public void LogOut() {
		 logOutlink.click();
	 }
	 public boolean loginsuccesfulconfirmation() {
			boolean displayText=driver.findElement(By.linkText("Edit your account information")).isDisplayed();
		    return displayText;
		}
       }
