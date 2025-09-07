package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToWishlistPage;
import pages.RemoveWishlist;

import testcases.BaseTest;

import java.time.Duration;

public class RemoveFromWishlistTest extends BaseTest {

    @Test
    public void removeItemFromWishlistTest() {
        RemoveWishlist wishlistPage = new RemoveWishlist(driver);
        AddToWishlistPage addPage = new AddToWishlistPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        // Open Wishlist
        wishlistPage.openWishlist();

        // If wishlist is empty, add an item
        if (driver.getPageSource().contains("Your wishlist is empty!")) {
            addPage.clickElectronics();
            addPage.clickCellPhones();
            addPage.selectProduct();
            addPage.addProductToWishlist();

            // Wait for success message
            wait.until(ExpectedConditions.visibilityOfElementLocated(addPage.getSuccessMessageLocator()));
         // Open wishlist again
            wishlistPage.openWishlist();
        }
        
     // Wait for table to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.cart")));

     // Wait for the remove button inside the table
        By removeButton = By.cssSelector("table.cart tbody tr td button.remove-btn");
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));

        // Click remove
        driver.findElement(removeButton).click();
        // Wait for empty wishlist message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".order-summary-content")));

        // Verify wishlist is empty
        String message = wishlistPage.getEmptyWishlistMessage();
        Assert.assertTrue(message.contains("Your wishlist is empty!"),
                "❌ Wishlist is not empty! Message: " + message);

        System.out.println("✅ Item removed from wishlist successfully!");
    }
}
