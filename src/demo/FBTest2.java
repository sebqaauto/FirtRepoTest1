package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FBTest2 {
	
	public FBTest2() {
		System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox/geckodriver");
		
	}
	WebDriver driver = new FirefoxDriver();
	
	public void launchFB() {
		//Launch the web application under test 
				driver.get("https://www.facebook.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));//Global wait
	}
	
	public void createNewAccount() throws InterruptedException {
		long startingTime;
		long currentTime;
		startingTime = System.currentTimeMillis();
		driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
		//Thread.sleep(3000);
	
		
		//Use WebDriverWait for object synchronisation - Local wait
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
		
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
		fluentWait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(100)).ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
		
		driver.findElement(By.name("firstname")).sendKeys("My User First Name");
		currentTime = System.currentTimeMillis()-startingTime;
		System.out.println(currentTime);
		driver.findElement(By.name("lastname")).sendKeys("My User Last Name"); 
		driver.findElement(By.name("reg_email__")).sendKeys("9988776655");
		driver.findElement(By.name("reg_passwd__")).sendKeys("My_OldPassword_12");
	}
	
	public static void main(String[] args) throws InterruptedException {
	
		FBTest2 fb = new FBTest2();
		fb.launchFB();
		fb.createNewAccount();

	}

}
