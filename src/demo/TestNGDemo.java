package demo;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNGDemo {
	int width = 600; int height = 400; 

	//Invoke a constructor to set the path for driver
	TestNGDemo(){
	System.setProperty("webdriver.chrome.driver", "/Users/Sebastian/Documents/chromedriver_mac_arm64/chromedriver");
	}

	WebDriver driver = new ChromeDriver();
	
	@Parameters({"URL","HomePageTitle"})
	@Test
	public void launchPageAndVerifyTitle(String url, String ExpectedTitle) {
		
	driver.get(url);
		
		//driver.manage().window().maximize();
		Dimension newDimension = new Dimension(768, 689);
		driver.manage().window().setSize(newDimension);
		System.out.println(driver.getCurrentUrl());
		String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl, url);
        
        System.out.println("Web Page Expected Title is "+ ExpectedTitle);
		System.out.println("Web Page Title is "+ driver.getTitle());
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
		System.out.println("Hello From TestNG");

	}
	
	@Parameters({"firstName","lastName", "email", "password", "confirmPassword"})
	@Test
	public void lauchPageAndCreateAccount(String fName, String lName, String email, String password, String confirmPswd) {
		
		System.out.println("Hello! from Hello Launch - TestNG");
		
		driver.get("https://magento.softwaretestingboard.com/");
		
		Dimension newDimension = new Dimension(768, 689);
		driver.manage().window().setSize(newDimension);
		
		
		driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Create an Account')]")).click();
		driver.findElement(By.id("firstname")).sendKeys(fName);
		driver.findElement(By.id("lastname")).sendKeys(lName);
		driver.findElement(By.id("email_address")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("password-confirmation")).sendKeys(confirmPswd);
		driver.findElement(By.xpath("//button[@class='action submit primary']")).click();
		

	}
	
	@AfterSuite
	public void closeBrowser() {
		//driver.quit();
		
	}
	
	////input[@type='submit']
	//input[@type='password']
	
	
	
	
//	driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Create an Account')]")).click();
//	driver.findElement(By.id("firstname")).sendKeys("FirstTest2");
//	driver.findElement(By.id("lastname")).sendKeys("LastTest2");
//	driver.findElement(By.id("email_address")).sendKeys("Test1.last211@test.com");
//	driver.findElement(By.id("password")).sendKeys("Test1.last2123");
//	driver.findElement(By.id("password-confirmation")).sendKeys("Test1.last2123");
//	driver.findElement(By.xpath("//button[@class='action submit primary']")).click();


}
