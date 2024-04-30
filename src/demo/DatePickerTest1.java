package demo;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DatePickerTest1 {
	
	String url = "https://www.globalsqa.com/demo-site/datepicker/";
	
	//Set the day that you want to pick here like 10, 22, 30 etc
	String day = "1";
	
	public DatePickerTest1() {
		System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox2/geckodriver.exe");
	}
	
	
	WebDriver driver = new FirefoxDriver();
	
	public void launchSite() {
		driver.get(url);
		driver.manage().window().maximize();
		WebElement frameElement = driver.findElement(By.cssSelector("div[rel-title='Simple Date Picker'] iframe.demo-frame"));
		driver.switchTo().frame(frameElement);
	}

	public void pickDate() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("input#datepicker")).click();
		//To pick the current day
		//driver.findElement(By.cssSelector("table.ui-datepicker-calendar a.ui-state-highlight")).click();
		
		//To pick next month and a date 
		driver.findElement(By.xpath("//span[contains(@class,'ui-icon-circle-triangle-e')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+day+"')]")).click();
		
		//Next button locators
		//-- //span[contains(@class,'ui-icon-circle-triangle-e')]
		//-- //span[contains(text(),'Next')]
		
	}
	public static void main(String[] args) throws InterruptedException {
		
		DatePickerTest1 datePick = new DatePickerTest1();
		datePick.launchSite();
		datePick.pickDate();
	}

}
