package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoSundayOct {
	
	//Identify the locators 
	public String email_Id="email";
	public String password_Id="pass";
	public String login_Xpath = "//button[@data-testid='royal_login_button']";
	public String Url = "https://www.facebook.com/";
	
	//Test data 
		String emailID = "sebastianselvarajaug89@gmail.com";
		String passwordText = "Aug9962335682#";
	
	//Set the path for the driver file - and check if the browser version and driver versions are compatible
	public DemoSundayOct() {
		System.setProperty("webdriver.chrome.driver", "/Users/Sebastian/Documents/chromedriver_mac_arm64/chromedriver");
		System.out.println("Hello I'm from the Constructor");
	}
	
	//Instantiate the WebDriver 
	WebDriver driver = new ChromeDriver();

	//Use the WebDriver driver object to launch and control the browser 
	public void launchFB() {
		driver.get(Url);
		driver.findElement(By.id(email_Id)).sendKeys(emailID);
		driver.findElement(By.id(password_Id)).sendKeys(passwordText);
		driver.findElement(By.xpath(login_Xpath)).click();
		
	}
	
	public static void main(String[] args) {
		
		DemoSundayOct object = new DemoSundayOct();
		
		object.launchFB();
	}

}