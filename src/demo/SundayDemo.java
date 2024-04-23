package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SundayDemo {
	
	//Instantiating the driver using FirefoxFox driver class 
	WebDriver driver = new FirefoxDriver();
	
	public String url ="https://www.facebook.com/";
	
	//Capture the locators as String variables 
	public String emai_Id = "email";
	
	public String password_Id ="pass";
	
	public String loginButton_xpath = "//button[@data-testid='royal_login_button']";
	
	//Test data 
	String emailID = "sebastianselvarajaug89@gmail.com";
	String passwordText = "Aug9962335682#";
	
	
	public SundayDemo() {
		//setting the path and driver to be used for launching the browser 
		System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox/geckodriver");
		System.out.println("I'm from the constructor");

	}
	


	public void launchFaceBook() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id(emai_Id)).sendKeys(emailID);
		driver.findElement(By.id(password_Id)).sendKeys(passwordText);
		driver.findElement(By.xpath(loginButton_xpath)).click();
		driver.close();
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SundayDemo demo = new SundayDemo();
		
		demo.launchFaceBook();

	}

}
