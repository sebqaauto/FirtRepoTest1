package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OctTwoNineDemo {

// First - Set the path for the driver file 
	//Intialise my driver object so that it can communicate to browser driver to browsers
	// Find my locators
	// Interact with the locators or web elements
	
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox/geckodriver");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("sebastianselvarajaug89@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Aug9962335682#");
		driver.findElement(By.xpath("//button[@data-testid='royal_login_button']")).click();
		
		

	}

}
