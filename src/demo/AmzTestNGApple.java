package demo;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import demo.AmazonPage;

public class AmzTestNGApple {
	
	WebDriver driver;
	AmazonPage amz;
	//For Creating ExtentReports these 2 classes are required
	ExtentSparkReporter reporter;
	ExtentReports extent;
	
	private AmzTestNGApple() {
		reporter = new ExtentSparkReporter("/Users/Sebastian/Desktop/EclipseWorkSpace/demo/AutomationDemo/results.html");
		reporter.config().setReportName("Amazon Automation Test");
		//Attach the ExtentSparkReporter Object to the ExtentReports Object
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	public void setUpDriver() {
	driver = new FirefoxDriver();
	amz = new AmazonPage(driver);
	}
	
	String url = "https://www.amazon.in/";
	String searchText1 ="iphone";
	String searchText2 ="iPad";
	String searchText3 ="iMac";
	
	public void launchSite(String url) {
	extent.createTest("launchSite");
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	extent.flush();
	}
	
	public void searchAndAddiPhone(String searchText) {
	extent.createTest("searchAndAddiPhone");
	amz.productSearch(searchText);
	System.out.println(searchText+ " is completed at "+System.currentTimeMillis());
	extent.flush();
	}
	
	
	public void searchAndAddiPad(String searchText) {
	extent.createTest("searchAndAddiPad");
	amz.productSearch(searchText);
	System.out.println(searchText+ " is completed at "+System.currentTimeMillis());
	extent.flush();
	}
	
	public void searchAndAddiMac(String searchText) {
		extent.createTest("searchAndAddiMac");
		amz.productSearch(searchText);
		System.out.println(searchText+ " is completed at "+System.currentTimeMillis());
		extent.flush();
		}
	
	public static void main(String []args) {
		AmzTestNGApple amz = new AmzTestNGApple();
		amz.setUpDriver();
		amz.launchSite(amz.url);
		amz.searchAndAddiPhone(amz.searchText1);
		amz.searchAndAddiPad(amz.searchText2);
		amz.searchAndAddiMac(amz.searchText3);
		
	}

}
