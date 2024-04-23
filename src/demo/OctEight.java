package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OctEight {
	
	//Declare all the locators
	public String email_ID="email";
	public String password_ID="pass";
	public String loginButton_Xpath="//button[@data-testid='royal_login_button']";
	
	//Test data 
		String emailID = "sebastianselvarajaug89@gmail.com";
		String passwordText = "Aug9962335682#";
	
	// Setting the path for the browser driver 
	public OctEight() {
		
		System.out.println("Hi I'm from the OctEightConstructor");
		System.setProperty("webdriver.chrome.driver", "/Users/Sebastian/Documents/chromedriver_mac_arm64/chromedriver");
	}
	
	//Instantiate the browser driver
	WebDriver driver = new ChromeDriver();
	
	public void launchFB() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id(email_ID)).sendKeys(emailID);
		driver.findElement(By.id(password_ID)).sendKeys(passwordText);
		//driver.findElement(By.xpath(loginButton_Xpath)).click();
		
		
	}

	public static void main(String[] args) {
		
		OctEight obj = new OctEight();
		
		obj.launchFB();

	}

}
