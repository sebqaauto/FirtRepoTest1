package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertsTest {

	String url = "https://demoqa.com/alerts";
	
	public AlertsTest() {
		System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox2/geckodriver");
	}
	
	WebDriver driver = new FirefoxDriver();
	public void launchSite() {
		driver.get(url);
		driver.manage().window().maximize();
		WebElement alertButton = driver.findElement(By.id("alertButton"));
		WebElement confirmButton = driver.findElement(By.id("confirmButton"));
		WebElement promtButton = driver.findElement(By.id("promtButton"));
		alertButton.click();
		String str = driver.switchTo().alert().getText();
		System.out.println(str);
		driver.switchTo().alert().accept();
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", confirmButton);//scrollIntoView(true)
		
		confirmButton.click();
		str = driver.switchTo().alert().getText();
		System.out.println(str);
		driver.switchTo().alert().dismiss();
		
		promtButton.click();
		str = driver.switchTo().alert().getText();
		System.out.println(str);
		driver.switchTo().alert().sendKeys("Sending some keys to PromptAlert");
		driver.switchTo().alert().accept();
		
		
		
	}
	
	public static void main(String[] args) {
		AlertsTest alert = new AlertsTest();
		alert.launchSite();

	}

}
