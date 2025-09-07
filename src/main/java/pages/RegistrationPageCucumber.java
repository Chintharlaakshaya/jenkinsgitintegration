package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageCucumber {
    private WebDriver driver;

    // Locators
    private By registerLink = By.linkText("Register");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By successMessage = By.className("result");

    public RegistrationPageCucumber(WebDriver driver) {
        this.driver = driver;
    }

    public void goToRegistrationPage() {
        driver.findElement(registerLink).click();
    }

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void enterConfirmPassword(String cpwd) {
        driver.findElement(confirmPassword).sendKeys(cpwd);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
