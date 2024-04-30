package demo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CountTheLinks {
	
	String url ="https://demowebshop.tricentis.com/simple-computer";
	
	public CountTheLinks() {
		System.setProperty("webdriver.gecko.driver", "/Users/Sebastian/Documents/FireFox2/geckodriver.exe");
	}
	
	WebDriver driver = new FirefoxDriver();
	public void launchSite() {
	driver.get("https://demowebshop.tricentis.com/simple-computer");
	//Store all the anchor tag > href webelements in a List of webelements
	List<WebElement> linkElements = driver.findElements(By.xpath("//a[@href]"));
	//Create a List of type String to store all the hyperlinks
	List<String> hyperlinks = new ArrayList<>();
	//Print the size of the List which has all webelements related to anchor tag
	System.out.println(linkElements.size());
	//Get the hyperlinks(urls) value from the href attribute and store it in a List of Strings
	for (WebElement webElement : linkElements) {
		String str = webElement.getAttribute("href");
		hyperlinks.add(str);	
	}
	//Iterate through the String list to print all its values(which are hyperlinks)
	for (String string : hyperlinks) {
		System.out.println("Link is -- "+string);
	}
	//Try to navigate to a specific hyperlink that is stored in the List of String, by getting a specific link from the list
	String tempUrl = hyperlinks.get(2);
	driver.navigate().to(tempUrl);
	}

	public static void main(String[] args) {
		CountTheLinks count = new CountTheLinks();
		count.launchSite();
	}

}
