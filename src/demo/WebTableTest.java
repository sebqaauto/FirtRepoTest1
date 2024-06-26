package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTableTest {
	
	public WebTableTest() {
		System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox2/geckodriver");
	}
	
	List<String> userName = new ArrayList<>();
	List<String> emailIDs = new ArrayList<>();
	TreeMap<String, String> userMap = new TreeMap<>();
	
	WebDriver driver = new FirefoxDriver();
	
	//Use this variable to pass a specific email address dynamically to an xpath locator
	String emailAddress = "monica@dezlearn.com";
	
	public void launchWebTable() throws InterruptedException {
		driver.get("https://www.dezlearn.com/webtable-example/");
		driver.manage().window().maximize();
	List<WebElement> tablesRows=driver.findElements(By.xpath("//table/tbody/tr"));
	List<WebElement> tableColumns = driver.findElements(By.xpath("//table/tbody/tr[2]/td"));
	System.out.println("The total number of rows and columns are "+tablesRows.size()+ " -- "+tableColumns.size());
	
	//Find all the users and get their text from the table and store it inside a List of Strings
	List<WebElement> users = driver.findElements(By.cssSelector("tr>td:nth-child(1)"));
	for (WebElement webElement : users) {
		String str = webElement.getText();
		userName.add(str);
	}
	
	List<WebElement> emailids = driver.findElements(By.cssSelector("tr>td:nth-child(2)"));
	for (WebElement webElement : emailids) {
		String str = webElement.getText();
		emailIDs.add(str);
	}
	
	for (String str : userName) {
		System.out.println(str);
	}
	
	for (String str : emailIDs) {
		System.out.println(str);
	}
	
	for (int i = 0; i <userName.size() ; i++) {
		userMap.put(userName.get(i),emailIDs.get(i));
	}
	
	for (Entry<String, String> entry :userMap.entrySet() ) {
		System.out.println(entry.getKey()+ " --"+entry.getValue());
		System.out.println(entry);
	}
	//Interact with the comments input text field
	List<WebElement> comments = driver.findElements(By.cssSelector("tr>td:nth-child(6)>input"));
	
	for (WebElement webElement : comments) {
		
		webElement.sendKeys("Sample Test Comment");
	}
	
	//Interact with the check boxes  tr>td:nth-child(4)>input
	List<WebElement> premiumCheckboxes = driver.findElements(By.cssSelector("tr>td:nth-child(4)>input"));
	for (WebElement webElement : premiumCheckboxes) {
		
		webElement.click();
	}
	
	// To pick a locator based on another locator Ex: based an on email address, select the check box for that user's email alone
	driver.findElement(By.xpath("//td[text()='"+emailAddress+"']/following-sibling::td[1]/input")).click();
	}
	
	public static void main(String[] args) {
		
		WebTableTest table = new WebTableTest();
		try {
			table.launchWebTable();
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}

}
