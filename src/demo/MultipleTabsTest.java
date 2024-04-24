package demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultipleTabsTest {

	public MultipleTabsTest() {
		
			System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox2/geckodriver");
		
	}
	
	String url = "https://www.amazon.in/";
	String searchBarID = "twotabsearchtextbox";
	String searchIconID = "nav-search-submit-button";
	String iphoneElementXpath = "//span[contains(text(),'Apple iPhone 15 Pro (1 TB) - White Titanium')]";
	
	WebDriver driver = new FirefoxDriver();
	
	
	public void launchAmazonSite() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id(searchBarID)).sendKeys("Apple iphone 1TB");
		driver.findElement(By.id(searchIconID)).click();
		driver.findElement(By.xpath(iphoneElementXpath)).click();
		driver.close();
		
	}
	
	public void testWebElements() {
		driver.get(url);
		driver.manage().window().maximize();
		boolean result=driver.findElement(By.id(searchBarID)).isDisplayed();
		System.out.println("The value of boolean is "+result);
		if(result) {
			driver.findElement(By.id(searchBarID)).sendKeys("Apple iphone 1TB");
			driver.findElement(By.id(searchBarID)).clear();
			driver.findElement(By.id(searchBarID)).sendKeys("Macbook pro 1TB");
			
		}
		boolean search =driver.findElement(By.id(searchIconID)).isEnabled();
		
		System.out.println("The value of Search boolean is "+search);
		driver.close();

	}

	public static void main(String[] args) {
		MultipleTabsTest test = new MultipleTabsTest();
		//test.launchAmazonSite();
		test.testWebElements();
		
	}

}
