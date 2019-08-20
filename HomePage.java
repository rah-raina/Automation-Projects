package org.test.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage  {
	
	
	WebDriver driver ; 
	
	public HomePage () {
		this.driver = Hooks.driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(xpath="//div[@id='suggestions-template']")
	WebElement suggestionsTemplate;

	
}
