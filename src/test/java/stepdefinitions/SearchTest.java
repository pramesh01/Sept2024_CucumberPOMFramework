package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import driverfactory.FactoryDriver;
import io.cucumber.java.en.*;

public class SearchTest {
	WebDriver driver;
	@When("enter text {string} in text area")
	public void enter_text_in_text_area(String enteredText) {
		driver=FactoryDriver.getDriver();
		driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys(enteredText);
	}
	@When("click ENTER button or click on search icon")
	public void click_enter_button_or_click_on_search_icon() {
		driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys(Keys.ENTER);
	}
	@Then("item should not be found")
	public void item_should_not_be_found() {
		 boolean expectedText=driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).isDisplayed();
		  Assert.assertTrue(expectedText);
	}
	@Then("Search result should be displayed")
	public void search_result_should_be_displayed() {
	  boolean expectedText=driver.findElement(By.xpath("//*[@id='search']/input")).isDisplayed();
	  Assert.assertTrue(expectedText);
	}
}