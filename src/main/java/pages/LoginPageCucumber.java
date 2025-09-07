package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageCucumber {
    private WebDriver driver;

    // Locators
    private By myAccountLink = By.linkText("My account");
    private By welcomeMessage = By.cssSelector(".header-links .account");

    public LoginPageCucumber(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Just checks if user is logged in
    public boolean isMyAccountVisible() {
        return driver.findElement(myAccountLink).isDisplayed();
    }

    public boolean isWelcomeMessageDisplayed() {
        return driver.findElement(welcomeMessage).isDisplayed();
    }
}
