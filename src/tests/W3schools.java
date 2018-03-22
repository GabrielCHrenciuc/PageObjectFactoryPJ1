package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.HomePage;

public class W3schools extends BaseTest{
public String url = "https://www.w3schools.com/";
	
    @Test
    public void goToGooglePageCheckPageTitle () throws Exception {  
        page.GetInstance(HomePage.class).goToSpecificPage(url);   
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Learn HTML")));       
        page.GetInstance(HomePage.class).checkPageTitle(url);
    }

}
