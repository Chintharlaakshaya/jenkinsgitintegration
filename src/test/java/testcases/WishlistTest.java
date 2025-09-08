package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import org.openqa.selenium.By;

public class WishlistTest extends BaseTest {

    private HomePage home;

    @BeforeMethod
    public void setUpTest() {
        driver.get("https://demo.nopcommerce.com/");
        home = new HomePage(driver);
    }

    @Test
    public void testAddProductToWishlist() {
        // Step 1: Search product
        home.search("Build your own computer");

        // Step 2: Click Add to Wishlist button from search result
        driver.findElement(By.cssSelector(".product-box-add-to-cart-button[onclick*='addwishlist']")).click();

        // Step 3: Navigate to wishlist
        home.goToWishlist();

        // Step 4: Verify product is in wishlist
        String wishlistText = driver.findElement(By.cssSelector("table.wishlist-table")).getText();
        Assert.assertTrue(wishlistText.contains("Build your own computer"), "❌ Product not found in wishlist!");
    }
}
