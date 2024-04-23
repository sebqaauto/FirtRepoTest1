package demo;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DdTest {
	
	public String Url = "https://artoftesting.com/samplesiteforselenium";
	
	public String sourceElement_Id = "myImage";
	
	public String destinationElement_Id = "targetDiv";
	
	WebDriver driver = new FirefoxDriver();
	
	public DdTest() {
		//Set the path of browser driver - @here use ChromeDriver
				System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox/geckodriver");
				System.out.println("Hello I'm from the Constructor you need not call me !");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void testDragandDrop() {
		driver.get(Url);
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.id(destinationElement_Id));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement source = driver.findElement(By.id(sourceElement_Id));
		WebElement destination = driver.findElement(By.id(destinationElement_Id));
		Actions action = new Actions(driver);
		
		action.dragAndDrop(source, destination).build().perform();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DdTest ddtest = new DdTest();
		
		ddtest.testDragandDrop();
		
	}

}
