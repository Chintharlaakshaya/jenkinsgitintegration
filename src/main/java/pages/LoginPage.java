package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.cssSelector("button.login-button");
    private By myAccount = By.linkText("My account");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String useremail) {
    	 driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(useremail);
    }

    public void enterPassword(String userpassword) {
    	 driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(userpassword);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    
    public boolean isMyAccountVisible() {
        return driver.findElement(myAccount).isDisplayed();
    }

}
