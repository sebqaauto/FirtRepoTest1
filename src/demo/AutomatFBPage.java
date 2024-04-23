package demo;

import java.util.ArrayList;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomatFBPage {
	
	//Instantiate the driver Firefox browser 
	
	WebDriver driver = new FirefoxDriver();
	
	
	//Locators 
	
	String SelectText_xPath ="//div[@class='main-header']//parent::div";
	
	String SelectMenu_ID = "oldSelectMenu";
	
	//Test Data 
	String urlQA = "https://demoqa.com/select-menu";
	String SelectTextExpected = "Select Menu";
	String SelectTextActual;
	
	ArrayList<String> optionsList = new ArrayList<>();
	
	
	public AutomatFBPage() {
		//Locate the driver file 
		System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox/geckodriver");
		System.out.println("I'm from the Constructor ");
	}
	
	
	public void launchDemoQa() {
		
		
		driver.get(urlQA);
		
		driver.manage().window().maximize();
		
		//Locate the Web elements
		
		
	driver.findElement(By.xpath(SelectText_xPath)).isDisplayed();
	
		
		SelectTextActual= driver.findElement(By.xpath(SelectText_xPath)).getText();
		
	if(SelectTextActual == SelectTextExpected) {
			System.out.println(SelectTextActual + " works as expected");		}
	else {
			System.out.println(SelectTextActual + " doesn't work as expected");
		}
		
		
		//driver.quit();
		
		
	}
	
	
	public void selectDropDown() {
		
		Select select = new Select(driver.findElement(By.id(SelectMenu_ID)));
		
		//select.selectByIndex(1);
		
		//select.selectByValue("4");
		
		select.selectByVisibleText("Magenta");
		
	
		
		
	}

	public static void main(String[] args) {

		
		// Create the object for the Class
		
		AutomatFBPage fb = new AutomatFBPage();
		
		fb.launchDemoQa();
		fb.selectDropDown();
		
		
	

	}
	
	
	
	
	

}
