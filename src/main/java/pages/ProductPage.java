package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By firstAddToCartButton = By.xpath("(//input[contains(@id,'add-to-cart-button')])[1]");
    private By cartNotification = By.cssSelector(".bar-notification.success .content");
    private By shoppingCartLink = By.linkText("Shopping cart");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Click the first "Add to Cart" button
    public void clickFirstAddToCart() {
        driver.findElement(firstAddToCartButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartNotification));
    }

    // Check if the success notification appears
    public boolean isNotificationDisplayed() {
        return driver.findElement(cartNotification).isDisplayed();
    }

    // Navigate to Shopping Cart
    public void goToShoppingCart() {
        driver.findElement(shoppingCartLink).click();
    }
}
