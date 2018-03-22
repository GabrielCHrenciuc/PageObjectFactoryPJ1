package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.HomePage;


public class GoogleTest extends BaseTest {	

	public String url = "https://www.google.ro/";
	
    @Test
    public void goToGooglePageCheckPageTitle () throws Exception {  
        page.GetInstance(HomePage.class).goToSpecificPage(url);   
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));       
        page.GetInstance(HomePage.class).checkPageTitle(url);
    }

}
