package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.PageGenerator;
 
public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator page;
 
    @Before
    public void setup () {
        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();
 
        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,15);
 
        //Maximize Window
        driver.manage().window().maximize();
 
        //Instantiate the Page Class
        page = new PageGenerator(driver);
    }

//    @Test
//    public void goToHomePage () {
//        HomePage hp = new HomePage(driver);
//        hp.goToHomePage();
//    }
 
    @After
    public void teardown () {
        driver.quit();
    }
}
