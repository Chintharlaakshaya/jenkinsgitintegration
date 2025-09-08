package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoveWishlist {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By wishlistLink = By.linkText("Wishlist"); // Link to open wishlist
    private By removeButton = By.xpath("//table[@class='cart']/tbody/tr[1]/td[last()]/button[contains(@class,'remove-btn')]");
    private By emptyWishlistMessage = By.cssSelector(".order-summary-content"); // Empty wishlist message

    public RemoveWishlist(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Actions
    public void openWishlist() {
        driver.findElement(wishlistLink).click();
    }

    public void clickRemoveButton() {
    	   wait.until(ExpectedConditions.visibilityOfElementLocated(removeButton));
           driver.findElement(removeButton).click();
    }

    public String getEmptyWishlistMessage() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(emptyWishlistMessage));
        return driver.findElement(emptyWishlistMessage).getText();
    }
}
