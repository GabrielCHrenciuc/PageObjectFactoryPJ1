package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	// *********Constructor*********
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// *********Page Variables*********
	String baseURL = "https://www.google.com/gmail/about/";

	// *********Web Elements By Using Page Factory*********
	@FindBy(how = How.CSS, using = "a.gmail-nav__nav-link.gmail-nav__nav-link__sign-in")
	public WebElement goToGmail;

	// *********Page Methods*********
	// Go to Homepage
	public void goToHomePage() {
		driver.get(baseURL);
	}
	
	// Go to specific page - based on provided URL
	public void goToSpecificPage(String url) {
		driver.get(url);
	}

	// Go to LoginPage
	public LoginPage goToLoginPage() {
		click(goToGmail);
		// I want to chain LoginPage's methods so I return LoginPage by initializing its
		// elements
		return new PageFactory().initElements(driver, LoginPage.class);
	}
}
