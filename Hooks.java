package org.test.amazon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
	
	static WebDriver driver;
	
	public Hooks() {
		beforeMethod();
	}
	
	public void beforeMethod() {
		
		String driverToRun = ""; 
		
		try {
			FileReader reader = new FileReader("TestDefaults.property");
			Properties p = new Properties();
			
			p.load(reader);
			
			driverToRun = p.get("driver").toString();
		} catch (FileNotFoundException e) {
			System.out.println("test default property file not present in project");
		} catch (IOException e) {
			System.out.println("test default property file not present in project");
		}
		
		switch(driverToRun) {
		
		case "chrome" :
			System.setProperty("webdriver.chrome.driver","C:\\WorkSpace\\TestAmazonProject\\drivers\\chromedriver.exe");
			
			driver = new ChromeDriver(); 
			break;
			
		case "firefox" :
			// enter firefox initilization code
			break;
			
			default :
				break;
		
		}
		
		
	}

	@After
	public void afterMethod() {
		driver.quit();
	}
}
