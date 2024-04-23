package demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SundayDemo2 {

	public String url = "https://artoftesting.com/samplesiteforselenium";
	
	// capturing locators
	public String radioButtonMale_Id= "male";
	
	public String radioButtonFemale_Id= "female";
	
	public String checkBoxAutomation_className ="Automation";
	
	public String checkBoxPerformance_className ="Performance";
	
	public String dropdownIcon_Id ="testingDropdown";
	
	public String generateAlretBox_xpath ="//button[text()='Generate Alert Box']";
	
	
	//Instantiating the driver using FirefoxFox driver class 
		WebDriver driver = new FirefoxDriver();
		
	public SundayDemo2() {
			//setting the path and driver to be used for launching the browser 
			System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox/geckodriver");
			System.out.println("I'm from the constructor");

		}
	
	public void launchDemoSite() {
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void handleAlert() {
		
		driver.findElement(By.xpath(generateAlretBox_xpath)).click();
		
		Alert alertObject = driver.switchTo().alert();
		
		System.out.println(alertObject.getText());
		
		alertObject.accept();
		
//		driver.close();
//		driver.quit();
	}
	
	public void interactWithRadioButtons() {
		
		driver.findElement(By.id(radioButtonMale_Id)).click();
		driver.findElement(By.id(radioButtonFemale_Id)).click();
		driver.findElement(By.className(checkBoxAutomation_className)).click();
		driver.findElement(By.className(checkBoxPerformance_className)).click();
	}
	
	public void interactWithDropDowns() {
		
		WebElement element = driver.findElement(By.id(dropdownIcon_Id));
		
		Select selectObject = new Select(element);
		
		//selectObject.selectByIndex(3);
		//selectObject.selectByValue("Performance");
		selectObject.selectByVisibleText("Manual Testing");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SundayDemo2 demo2 = new SundayDemo2();
		demo2.launchDemoSite();
		demo2.interactWithRadioButtons();
		demo2.interactWithDropDowns();
		demo2.handleAlert();

	}

}
