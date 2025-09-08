package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddToCart {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    public By clickComputers = By.linkText("Computers");
    public By clickNotebooks = By.linkText("Notebooks");
    public By selectProduct = By.xpath("//h2[@class='product-title']/a[contains(text(),'Apple MacBook Pro')]");

    private By addToCartButton = By.cssSelector("button[id^='add-to-cart-button']"); // works for any product
    private By successMessage = By.cssSelector(".bar-notification.success p");

    public AddToCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Click Add to Cart button with wait
    public void addProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    // Get success message after waiting for it to appear
    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }
}
