package org.test.amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Hooks  {
	
	WebDriver driver ; 
	
	public BasePage () {
		this.driver = Hooks.driver;
		PageFactory.initElements(this.driver,this);
	}
	
	
	
	public void implicitWaitForElement() {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	
	public void explicitWaitForWebElement(WebElement element, int timeOutInMilliSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInMilliSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void explicitWaitForByElement(By element, int timeOutInMilliSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInMilliSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		
	}
	
	/*
	public WebDriver getDriver() {
		return this.driver;
	}*/
}
