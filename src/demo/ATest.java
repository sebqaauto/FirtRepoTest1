package demo;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class ATest {
	
	public String Url = "https://artoftesting.com/samplesiteforselenium";

	public String generateAlertButton_xpath = "//button[contains(text(),'Generate Alert Box')]";
	public String radioButtonXpath = "//form//input[@id='male']";
	public String checkBox = "//input[@value='Automation']";
	
	WebDriver driver = new FirefoxDriver();
	
	public ATest() {
		System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox/geckodriver");
		System.out.println("Hello I'm from the Constructor you need not call me !");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void alertTest() {
		driver.get(Url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath(radioButtonXpath)).click();
		driver.findElement(By.xpath(checkBox)).click();
		
		System.out.println(driver.findElement(By.xpath(checkBox)).getText());
		
		
		WebElement element = driver.findElement(By.id("dblClkBtn"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		driver.findElement(By.xpath(generateAlertButton_xpath)).click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		alert.accept();
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ATest atest = new ATest();
		atest.alertTest();

	}

}
