package tests;
 
//import org.junit.Ignore;
//import org.junit.Test;
//import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Ignore;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.HomePage;
import pageObjects.LoginPage;
 
public class LoginTests extends BaseTest {
 
	 
	@FindBy(how = How.ID, using = "password")
	public WebElement password;
	
    @Test
//    public void invalidLoginTest_InvalidUserNameInvalidPassword () throws Exception {
    public void invalidLoginTest_InvalidUserNameInvalid () throws Exception {
        //*************PAGE METHODS WITH JAVA GENERICS********************
        //Open N11 HomePage
        //Initialize elements by using PageFactory
        page.GetInstance(HomePage.class).goToHomePage();
 
        //Chain of Invocation (Go to Login Page and then LoginToN11)
        page.GetInstance(HomePage.class).
                goToLoginPage().loginToGmailInvalidUser("SSSonu31312321312r@swtestacademy.com");
//                goToLoginPage().loginToGmailInvalidUser("asdadasdsa@sdfsdfsdf.com");
//                goToLoginPage().loginToGmailInvalidUser("");

        //*************ASSERTIONS***********************
        Thread.sleep(5000); //It is better to use explicit wait here.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='dEOOab RxsGPe']")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dEOOab RxsGPe']/div")));
        page.GetInstance(LoginPage.class).verifyLoginUserName("Couldn't find your Google Account");
    }
 
//    @Ignore
//    @Test
//    public void invalidLoginTest_EmptyUserEmptyPassword () throws Exception {
//        //*************PAGE METHODS WITH JAVA GENERICS********************
//        //Open N11 HomePage
//        page.GetInstance(HomePage.class).goToHomePage();
//
//        //Method Chaining (Go to Login Page and then LoginToN11)
//        page.GetInstance(HomePage.class).goToLoginPage().loginToGmail("","");
//
//        //*************ASSERTIONS***********************
//        //Thread.sleep(500); //It is better to use explicit wait here.
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Lütfen e-posta adresinizi girin.']")));
//        page.GetInstance(LoginPage.class).verifyLoginUserName("Lütfen e-posta adresinizi girin.");
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Bu alanın doldurulması zorunludur.']")));
//        page.GetInstance(LoginPage.class).verifyLoginPassword("Bu alanın doldurulması zorunludur.");
//    }
}