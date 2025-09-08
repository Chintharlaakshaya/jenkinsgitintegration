package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmptyWishlist {

    private WebDriver driver;

    // Locator for the empty wishlist message
    private By emptyWishlistMessage = By.cssSelector("div.no-data");

    // Locator for Wishlist link
    private By wishlistLink = By.linkText("Wishlist");

    public EmptyWishlist(WebDriver driver) {
        this.driver = driver;
    }

    public void openWishlist() {
        driver.findElement(wishlistLink).click();
    }

    public String getEmptyWishlistMessage() {
        return driver.findElement(emptyWishlistMessage).getText();
    }

    public boolean isWishlistEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyWishlistMessage));
        return driver.findElement(emptyWishlistMessage).getText().contains("The wishlist is empty!");
    }
}
