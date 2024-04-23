package demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OctSundayDemo {
	
	//Capture Url and Locators 
	
	public String url = "https://www.facebook.com/";
	
	public String email_ID = "email";
	
	public String password_ID = "pass";
	
	public String loginButton_Xpath = "//button[@data-testid='royal_login_button']";
	
	public String eyeIcon_Xpath = "//div[@id='passContainer']/div/a/div/div";
	
	//Test data 
	String emailID = "sebastianselvarajaug89@gmail.com";
	String passwordText = "Aug9962335682#";
	
	
	// Instatiate the Webdriver using Fire fox driver
	WebDriver driver = new ChromeDriver();
	
	
	public OctSundayDemo() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/Sebastian/Documents/chromedriver_mac_arm64/chromedriver");
		
		//"webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox"
		
		//"webdriver.chrome.driver", "/Users/Sebastian/Documents/chromedriver_mac_arm64/chromedriver"
		
		System.out.println("Hello from the Constructor");
	}
	
	public static void main(String []a) {
				
		OctSundayDemo object = new OctSundayDemo();
		System.out.println("Hello Selenium");
		object.launchFB();
		object.loginToFB();
		
	}
	
	
	public void launchFB() {
		
		driver.get(url);
		
	}
	
	public void loginToFB() {
		
		driver.findElement(By.id(email_ID)).sendKeys(emailID);
		driver.findElement(By.id(password_ID)).sendKeys(passwordText);
		driver.findElement(By.xpath(eyeIcon_Xpath)).click();
		driver.findElement(By.xpath(loginButton_Xpath)).click();
		driver.close();
		
	}

}
