package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;
 
public class BasePage extends PageGenerator {
 
    public BasePage(WebDriver driver) {
        super(driver);
    }
 
    //If we need we can use custom wait in BasePage and all page classes
    WebDriverWait wait = new WebDriverWait(this.driver,20);
 
    //Click Method by using JAVA Generics (You can use both By or Webelement)
    public <T> void click (T elementAttr) {
        if(elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).click();
        } else {
            ((WebElement) elementAttr).click();
        }
    }
 
    //Write Text by using JAVA Generics (You can use both By or Webelement)
    public <T> void writeText (T elementAttr, String text) {
        if(elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).sendKeys(text);
        } else {
            ((WebElement) elementAttr).sendKeys(text);
        }
    }
 
    //Read Text by using JAVA Generics (You can use both By or Webelement)
    public <T> String readText (T elementAttr) {
        if(elementAttr.getClass().getName().contains("By")) {
            return driver.findElement((By) elementAttr).getText();
        } else {
            return ((WebElement) elementAttr).getText();
        }
    }
 
    //Close popup if exists
    public void handlePopup (By by) throws InterruptedException {
        List<WebElement> popup = driver.findElements(by);
        if(!popup.isEmpty()){
            popup.get(0).click();
            Thread.sleep(200);
        }
    }

    public void waitForElement (WebElement element) throws Exception {
        if(WrapsElement.class.isAssignableFrom(element.getClass()))
            driver = ((WrapsDriver)((WrapsElement)element).getWrappedElement()).getWrappedDriver();
        else
            driver = ((WrapsDriver)element).getWrappedDriver();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By)driver));
    }
    
    public void checkPageTitle (String expectedPageTitle) throws Exception {
    	String actualTitle = driver.getCurrentUrl();
    	Assert.assertEquals("Page title expected and found: ", expectedPageTitle, actualTitle);
    }
}