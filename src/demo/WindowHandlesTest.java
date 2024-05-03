package demo;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;

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
String addtoCartXpath = "//div[@data-index='4']//div[contains(@class,'puis-list-col-right')]//button[@id='a-autoid-2-announce']";

WebDriver driver = new FirefoxDriver();
String parentWindow;
Set<String> windowHandles = new LinkedHashSet<>();
Set<String> windowTitle = new LinkedHashSet<>();
	public void launchAmazonSite() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		windowHandles = driver.getWindowHandles();
		String title = driver.getTitle();
		windowTitle.add(title);
		
	}
	
	public void searchAndNavigate(String searchText) {
		driver.findElement(By.id(searchBarID)).clear();
		driver.findElement(By.id(searchBarID)).sendKeys(searchText);
		driver.findElement(By.id(searchIconID)).click();
		driver.findElement(By.xpath(firstSearchResult)).click();
		windowHandles = driver.getWindowHandles();
			String title = driver.getTitle();
			windowTitle.add(title);
		
	}
	public void moveToEachWindow() {
		for (String string : windowHandles) {
			driver.switchTo().window(string);
			String title = driver.getTitle();
			windowTitle.add(title);
		}
		
		
	}
	
	public void getAllWindowHandles() {
		windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			System.out.println(string);
		}
		
		for (String string : windowTitle) {
			System.out.println(string);
		}
	}
	
	public static void main(String[] args) {
	
		WindowHandlesTest amz = new WindowHandlesTest();
		amz.launchAmazonSite();
		amz.searchAndNavigate("iphone");
		amz.searchAndNavigate("Samsung");
		amz.moveToEachWindow();
		amz.getAllWindowHandles();

	}

}
