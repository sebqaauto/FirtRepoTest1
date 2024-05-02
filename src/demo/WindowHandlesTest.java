package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class WindowHandlesTest {
	
	public WindowHandlesTest() {
		
		System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox2/geckodriver");
	
}

String url = "https://www.amazon.in/";
String searchBarID = "twotabsearchtextbox";
String searchIconID = "nav-search-submit-button";
String firstSearchResult = "//div[@data-index='3']//div[contains(@class,'puis-list-col-left')]";

WebDriver driver = new FirefoxDriver();

	public void launchAmazonSite() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id(searchBarID)).sendKeys("Samsung");
		driver.findElement(By.id(searchIconID)).click();
		driver.findElement(By.xpath(firstSearchResult)).click();
		driver.close();
		
	}
	
	
	public static void main(String[] args) {
	
		WindowHandlesTest amz = new WindowHandlesTest();
		amz.launchAmazonSite();

	}

}
