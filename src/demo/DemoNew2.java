package demo;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoNew2 {
	public String url = "https://www.amazon.in/s?k=one+plus&rh=n%3A1389432031&ref=nb_sb_noss";
	public String input_Id= "twotabsearchtextbox";
	public String searchIcon_Id ="nav-search-submit-button";
	public String productXpath = "(//div[@data-component-type='s-search-result'])[1]";
	public String productTitle_Xpath ="//div[@id='titleSection']/h1/span";
	public String productTitle_Str;
	
	WebDriver driver = new FirefoxDriver();
	
	public DemoNew2() {
	System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox/geckodriver");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}
	
	public void launchAmz() {
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath(productXpath)).click();
	}
	
	public void manageWindowHandles() {
		
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();
		
		for(String s : allWindowHandles) {
			
			System.out.println(s);
			
		}
		
		driver.switchTo().window(mainWindowHandle);
		while(iterator.hasNext()) {
			System.out.println("I'm the mainwindow "+mainWindowHandle);
			String childWindow = iterator.next();
			if(!mainWindowHandle.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				productTitle_Str = driver.findElement(By.xpath(productTitle_Xpath)).getText();
				System.out.println("I'm the child Window "+childWindow);
				System.out.println("I'm the child Window with product "+productTitle_Str);
			}
		}
		driver.switchTo().window(mainWindowHandle);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DemoNew2 demo = new DemoNew2();
		
		demo.launchAmz();
		demo.manageWindowHandles();

	}

}
