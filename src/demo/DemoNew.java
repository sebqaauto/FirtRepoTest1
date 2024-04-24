package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoNew {
	
	//Locators are here 
	String email = "email";
	String password = "pass";
	String LoginButton = "//button[@data-testid='royal_login_button']";
	String seeMoreLink = "//span[contains(text(),'See more')]";
	
	//Test data 
	String emailID = "";
	String passwordText = "";
	
	//Initiate a browser driver - @here use FireFoxDriver
	
	WebDriver driver = new FirefoxDriver();
	
	//WebDriver driver2 = new FirefoxDriver();
	
	public DemoNew() {
		
		//Set the path of browser driver - @here use ChromeDriver
		System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox/geckodriver");
		System.out.println("Hello I'm from the Constructor you need not call me !");
	}
	
	public void launchFB() {
		
		//Launch the web application under test 
		driver.get("https://www.facebook.com/");
		//driver.manage().window().setSize(new Dimension(320, 680));
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("pass")).sendKeys("");
		//driver.findElement(By.name("login")).click();
//		String title = driver.getTitle();
//		if(title.equals("Facebook")){
//			System.out.println("The title is present "+title);
//		}else {
//			System.out.println("The title Facebook is not present "+title);
//		}
		String attr = driver.findElement(By.name("login")).getAttribute("data-testid");
		System.out.println(attr);
		
		Dimension dimension = driver.findElement(By.name("login")).getSize();
		System.out.println(dimension.width+ " "+dimension.height);
		
		
//		driver.findElement(By.id(email)).sendKeys(emailID);
//		driver.findElement(By.id(password)).sendKeys(passwordText);
//		driver.findElement(By.xpath(LoginButton)).click();
//		driver.findElement(By.xpath(seeMoreLink)).isDisplayed();
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		
		//driver.close();
		
		
	}
	
	public static void main(String []str) {
		
		
			DemoNew fb = new DemoNew();	
			
			fb.launchFB();
			//fb.launchDemoBlaze();
			
				
				
	}
	
	
	public void launchDemoBlaze() {
		driver.get("https://www.demoblaze.com/");
		setBrowserDimension();
		//driver.manage().window().maximize();
		String pageTitle = driver.getTitle();
		System.out.println(driver.getCurrentUrl());
		System.out.println("The page tile is :: "+pageTitle);
		if(pageTitle.equals("STORE")) {
			System.out.println("The page has expected title "+ pageTitle);
		}
		else {
			System.out.println("The page doesn't have expected title "+ pageTitle);
		}
	}
	
	public void setBrowserDimension() {
		int width = 1440;
		int height = 900;
		Dimension dimension = new Dimension(width, height);
		driver.manage().window().setSize(dimension);
	}

}
