package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutomateWebPage {

public static void main(String[] args) {

	
	//Set the path of browser driver - @here use ChromeDriver
		
	System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox/geckodriver");
		
	//Initiate a browser driver - @here use ChromeDriver
	
		WebDriver driver = new FirefoxDriver();
	
		//Launch the web application under test 
	
		//driver.get("https://magento.softwaretestingboard.com/");
		driver.get("https://www.demoblaze.com/");
		
		driver.manage().window().maximize();
		String pageTitle = driver.getTitle();
		System.out.println(driver.getCurrentUrl());
		System.out.println("The page tile is :: "+pageTitle);
		if(pageTitle.equals("STORE")) {
			System.out.println("The page has expected title "+ pageTitle);
		}
		else {
			System.out.println("The page doesn't have expected title "+ pageTitle);
		}
//		driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Create an Account')]")).click();
//		driver.findElement(By.id("firstname")).sendKeys("FirstTest2");
//		driver.findElement(By.id("lastname")).sendKeys("LastTest2");
//		driver.findElement(By.id("email_address")).sendKeys("Test1.last211@test.com");
//		driver.findElement(By.id("password")).sendKeys("Test1.last2123");
//		driver.findElement(By.id("password-confirmation")).sendKeys("Test1.last2123");
//		driver.findElement(By.xpath("//button[@class='action submit primary']")).click();
		//driver.close();
	
	///Users/Sebastian/Documents/chromedriver-mac-arm64/chromedriver
	}
	
}


