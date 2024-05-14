package demo;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

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
	
	public void launchAmazonSiteWithActions() {
		driver.get(url);
		driver.manage().window().maximize();
		//Actions Class provides methods to perform mouse and keyboard events
		Actions action = new Actions(driver);
		//Action is a functional interface it has only one abstract method which is perform()
		Action act;
		//action.moveToElement(driver.findElement(By.id(searchBarID))).click().keyDown(Keys.SHIFT).sendKeys("iphone").keyDown(Keys.SHIFT).click().build().perform();
		WebElement dealElement = driver.findElement(By.xpath("//h2[contains(text(),'Today’s Deals')]"));
		//action.scrollByAmount(897,776).build().perform();
		//action.moveToElement(dealElement).click().build().perform();
		Point point = dealElement.getLocation();
		//action.moveToElement(dealElement, point.x, point.y).build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",dealElement);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",dealElement);
	}
	
	public void testWebElements() {
		driver.get(url);
		driver.manage().window().maximize();
		String elementText = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		System.out.println(elementText);
		
		String tagName = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getTagName();
		System.out.println(tagName);
		String className = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getAttribute("class");
		System.out.println(className);
		String backgroundColor= driver.findElement(By.cssSelector("div.nav-search-submit")).getCssValue("background-color");
		System.out.println(backgroundColor);
		Dimension object = driver.findElement(By.cssSelector("div.nav-search-submit")).getSize();
		System.out.println(object.width + " * "+ object.height);
		
		Point object2 = driver.findElement(By.cssSelector("div.nav-search-submit")).getLocation();
		System.out.println(object2.x + " * "+ object2.y);
		
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

	public static void main(String[] args) throws IOException {
		MultipleTabsTest test = new MultipleTabsTest();
		//test.launchAmazonSite();
		//test.testWebElements();
		//test.launchAmazonSiteWithActions();
		test.launchAmazonSite2();
		
	}
	
	public void takeSnap(String snapName) throws IOException {
		String fileName = snapName+".jpg";
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File("/Users/Sebastian/Desktop/EclipseWorkSpace/PageObjectsTest/DemoWebShop/"+fileName));
	}
	
	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
		
	}
	
	public void launchAmazonSite2() throws IOException {
		driver.get(url);
		driver.manage().window().maximize();
		String title = getPageTitle();
		takeSnap(title);
	}

}
