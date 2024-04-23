package demo;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;


public class MagnetoTest {
    
    public String url = "https://magento.softwaretestingboard.com/what-is-new.html";
    
    //Instantiate the driver;
    WebDriver driver = new FirefoxDriver();
    
    public MagnetoTest(){
        System.setProperty("webdriver.gecko.driver", "\\Users\\Sebastian\\Documents\\FireFox\\geckodriver");
        System.out.print("The driver is set");
    }
    
    //Find the locators
    public String productWithSize_S = "//a[contains(text(),'Gobi HeatTec')]/parent::strong/following-sibling::div[@class='swatch-opt-446']//div[@class='swatch-attribute size']/div//div[@option-label='S']";
    public String lumaText = "//h2[contains(text(),'Luma')]";
    public String colorXpath="//a[contains(text(),'Gobi HeatTec')]/parent::strong/following-sibling::div[@class='swatch-opt-446']//div[@class='swatch-attribute color']/div/div";

    List<WebElement> colors = new ArrayList<WebElement>();

    public void launchAndPerform(){

        driver.get(url);
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath(lumaText));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        if(driver.findElement(By.xpath(productWithSize_S)).isDisplayed() ){
            driver.findElement(By.xpath(productWithSize_S)).click();
        }

        colors = driver.findElements(By.xpath(colorXpath));
        if(colors.size()>0){
            for (WebElement element1: colors) {
                element1.click();
            }
        }

        WebElement moveTo = driver.findElement(By.xpath(productWithSize_S));
        Actions action = new Actions(driver);
        action.moveToElement(moveTo).perform();



    }

    public static void main(String [] arg){

        MagnetoTest magnetoTest = new MagnetoTest();
        magnetoTest.launchAndPerform();
    }
    
}
