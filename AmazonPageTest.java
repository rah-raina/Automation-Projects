package org.test.amazon;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AmazonPageTest extends BasePage{

	
	
	WebDriver driver;
	
	public AmazonPageTest () {
		this.driver = Hooks.driver;
		PageFactory.initElements(this.driver,this);
	}
	
	

	@Test
	public void openUrl() {
		HomePage hp = new HomePage();
		driver.get("https://www.amazon.in/");
		searchAmazon(hp);
		
	}
	
	public void searchAmazon(HomePage hp){
		hp.searchBox.sendKeys("Bag");
		
		explicitWaitForWebElement(hp.suggestionsTemplate,3000);
		
		List<WebElement> allSuggestions = 	hp.suggestionsTemplate.findElements(By.xpath("//div[@class='s-suggestion']"));
		
		List<String> getSuggestionText = new ArrayList<String>();
		
		for(WebElement e : allSuggestions) {
			getSuggestionText.add(e.getText());
		}
		
		System.out.println(getSuggestionText);
	}
	
}
