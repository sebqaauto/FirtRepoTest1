package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateDemo {
	
	String URL = "https://kwerystage.unileversolutions.com/Saml2/SignIn?ReturnUrl=%2fus-en";
	String userName = "KWR.Test09@unileverpp.com";
	String password = "HereYouGo@26402";
	String GTIN = "00079400587596";
	String emailInputField ="//input[@type='email']";
	String nextButton = "//input[@type='submit']";
	String passwordInputField = "//input[@type='password']";
	String submitButton = "//button[@type='submit']";
	String searchField = "//input[@type='text']";
	
	
//Initiate Chrome Driver
			
ChromeDriver driver = new ChromeDriver();
	
	public AutomateDemo() {
		
		//Set the path for the ChromeDriver
		System.setProperty("webdriver.chrome.driver", "/Users/Sebastian/Documents/chromedriver_mac_arm64/chromedriver");
		
	}

	public static void main(String[] args) {
	
		AutomateDemo auto = new AutomateDemo();
		auto.launchKweryApp();
		auto.signIn();
		auto.searchProduct();
		
	}
	
	public void launchKweryApp() {
	
		driver.get(URL);
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	
	public void signIn() {
		
		
		driver.findElement(By.xpath(emailInputField)).sendKeys(userName);
		driver.findElement(By.xpath(nextButton)).click();
		driver.findElement(By.xpath(passwordInputField)).sendKeys(password);
		driver.findElement(By.xpath(nextButton)).click();
		
	}
	
	public void searchProduct() {
		driver.findElement(By.xpath(searchField)).sendKeys(GTIN);
		driver.findElement(By.xpath(submitButton)).click();
		
	}

}
