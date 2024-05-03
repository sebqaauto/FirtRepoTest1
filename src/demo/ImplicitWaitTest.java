package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplicitWaitTest {
	String url = "https://demowebshop.tricentis.com/";
	
public ImplicitWaitTest() {
		
		System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox2/geckodriver");
	
}
WebDriver driver = new FirefoxDriver();

public void launchSite() {
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//div[@id='nivo-slider']//div[contains(text(),'Tricentis Academy')]/preceding-sibling::img/preceding-sibling::a[1]")).click();
	
	
}

	public static void main(String[] args) {
		
		ImplicitWaitTest test = new ImplicitWaitTest();
		test.launchSite();
	}

}
