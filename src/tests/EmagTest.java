package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.HomePage;

public class EmagTest extends BaseTest {

public String url = "https://m.emag.ro/";
	
    @Test
    public void goToGooglePageCheckPageTitle () throws Exception {  
        page.GetInstance(HomePage.class).goToSpecificPage(url);   
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Inapoi in site")));       
        page.GetInstance(HomePage.class).checkPageTitle(url);
    }

}
