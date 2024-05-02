package demo;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDatePickerTest {
	
	String url = "https://www.globalsqa.com/demo-site/datepicker/";
	
	String day = "8";
	
	public DropDownDatePickerTest() {
		System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox2/geckodriver.exe");
	}
	
	
	WebDriver driver = new FirefoxDriver();
	
	public void launchSite() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("DropDown DatePicker")).click();
		WebElement frameElement = driver.findElement(By.cssSelector("div[rel-title='DropDown DatePicker'] iframe.demo-frame"));
		driver.switchTo().frame(frameElement);
	}

	public void pickDate() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("input#datepicker")).click();
		//To pick the current day
		//driver.findElement(By.cssSelector("table.ui-datepicker-calendar a.ui-state-highlight")).click();
		
		//Find how many months are there 
		List<WebElement> elements= driver.findElements(By.cssSelector("select.ui-datepicker-month > option"));
		System.out.println(elements.size());
		
		//Find a WebElement which point to the Select tag and pass the WebElement to the Select class constructor
		WebElement monthDropDown = driver.findElement(By.cssSelector("select.ui-datepicker-month"));
		Select select = new Select(monthDropDown);
		select.selectByIndex(0);
		select.selectByValue("11");
		select.selectByVisibleText("Aug");
		driver.findElement(By.xpath("//a[contains(text(),'"+day+"')]")).click();
		
	}
	public static void main(String[] args) throws InterruptedException {
		
		DropDownDatePickerTest datePick = new DropDownDatePickerTest();
		datePick.launchSite();
		datePick.pickDate();
	}

}
