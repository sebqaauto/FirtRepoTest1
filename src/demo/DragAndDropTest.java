package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {

	public DragAndDropTest() {
		System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox2/geckodriver");
	}
	
	String url = "https://www.globalsqa.com/demo-site/draganddrop/";
	String imagXpath = "//img[@alt='The peaks of High Tatras']";
	String trashID = "trash";
	
	WebDriver driver = new FirefoxDriver();
	
	public void launchDragDropSite() {
		driver.get(url);
		driver.manage().window().maximize();
		WebElement frameElement = driver.findElement(By.xpath("//iframe[contains(@class,'demo-frame')][1]"));
		driver.switchTo().frame(frameElement);
		WebElement source = driver.findElement(By.xpath(imagXpath));
		WebElement destination = driver.findElement(By.id(trashID));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
	}

	public static void main(String[] args) {
	
		DragAndDropTest drag = new DragAndDropTest();
		drag.launchDragDropSite();
	}

}
