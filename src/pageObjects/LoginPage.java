package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
 
public class LoginPage extends BasePage {
 
    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
    }
 
    //*********Web Elements by using Page Factory*********
    @FindBy(how = How.CSS, using = "input[type='email']")
    public WebElement username;
    
    @FindBy(how = How.CSS, using = "span[class='RveJvd snByac']")
    public WebElement nextButton;
 
    @FindBy(how = How.CSS, using = "input[type='password']")
    public WebElement password;
 
//    @FindBy(how = How.ID, using = "loginButton")
//    public WebElement loginButton;
 
    @FindBy(how = How.XPATH, using = "//div[@class='dEOOab RxsGPe']/div")
    public WebElement errorMessageUsernameOrPassword;
 
//    @FindBy(how = How.CLASS_NAME, using = "dEOOab RxsGPe")
//    public WebElement errorMessagePassword;
 
 
    //*********Page Methods*********
    public void loginToGmail (String pusername, String ppassword) throws Exception {
        //Enter Username(Email)
        writeText(username,pusername);
        //Enter Password
        click(nextButton);
        Thread.sleep(9000);
        writeText(password, ppassword);
//        waitForElement(nextButton);
        //Click Login Button
        click(nextButton);
    }

    public void loginToGmailInvalidUser (String pusername) throws Exception {
//        Thread.sleep(5000);
        //Enter Username(Email)
        writeText(username,pusername);
//        Thread.sleep(5000);
       //Click Next Button
        click(nextButton);
        Thread.sleep(50000);
        writeText(username,pusername);
        click(nextButton);
    }
 
    //Verify Username Condition
    public void verifyLoginUserName (String expectedText) {
        Assert.assertEquals(expectedText, readText(errorMessageUsernameOrPassword));
    }
 
    //Verify Password Condition
    public void verifyLoginPassword (String expectedText) {
        Assert.assertEquals(expectedText, readText(errorMessageUsernameOrPassword));
    }
}