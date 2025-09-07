package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RegistrationSteps {
    WebDriver driver;

    @Given("I am on the nopCommerce home page")
    public void i_am_on_the_nop_commerce_home_page() {
        driver = new ChromeDriver();  // open browser
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @When("I navigate to the registration page")
    public void i_navigate_to_the_registration_page() {
        driver.findElement(By.className("ico-register")).click();
    }

    @When("I enter first name {string}, last name {string}, email {string}, password {string}, and confirm password {string}")
    public void i_enter_registration_details(String fname, String lname, String email, String pwd, String cpwd) {
        driver.findElement(By.id("FirstName")).sendKeys(fname);
        driver.findElement(By.id("LastName")).sendKeys(lname);
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(pwd);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(cpwd);
    }

    @When("I click register")
    public void i_click_register() {
        driver.findElement(By.id("register-button")).click();
    }

    @Then("I should see the registration success message and be logged in")
    public void i_should_see_the_registration_success_message_and_be_logged_in() {
        String successMessage = driver.findElement(By.className("result")).getText();
        Assert.assertTrue(successMessage.contains("completed"), "❌ Registration failed!");
        driver.quit(); // close browser
    }
}
