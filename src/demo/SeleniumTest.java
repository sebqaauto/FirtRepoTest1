package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
	
	//Identify the locators
	
	public String email_ID="email";
	public String password_ID="pass";
	public String loginButton_XPath="//button[@data-testid='royal_login_button']";
	
	//Test data 
		String emailID = "sebastianselvarajaug89@gmail.com";
		String passwordText = "Aug9962335682#";
	
	//Set path of the driver
	public SeleniumTest() {
		
		System.out.println("Hi I'm from the constructor");
		
		System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox/geckodriver");
		
	}
	
	//Launch a browser 
	
	WebDriver driver = new FirefoxDriver();
	
	
	public void launchFBPage() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id(email_ID)).sendKeys(emailID);
		driver.findElement(By.id(password_ID)).sendKeys(passwordText);
		driver.findElement(By.xpath(loginButton_XPath)).click();
		driver.close();
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeleniumTest obj = new SeleniumTest();
		
		obj.launchFBPage();
		obj.email_ID = "";
		

	}

}
