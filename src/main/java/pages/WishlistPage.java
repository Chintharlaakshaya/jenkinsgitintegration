/*package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {
    WebDriver driver;

    // Locators
    By wishlistHeader = By.cssSelector("div.page-title h1");
    By wishlistTable = By.cssSelector("table.cart"); // Wishlist is a table like cart
    By productNameInWishlist = By.cssSelector("table.cart td.product a");

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeader() {
        return driver.findElement(wishlistHeader).getText();
    }

    public boolean isProductInWishlist(String expectedName) {
        String actualName = driver.findElement(productNameInWishlist).getText();
        return actualName.contains(expectedName);
    }
}*/

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {

    private WebDriver driver;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    private By wishlistHeader = By.cssSelector("div.page-title h1");
    private By wishlistProductName = By.cssSelector("table.wishlist-table .product-name a");

    public String getWishlistHeader() {
        return driver.findElement(wishlistHeader).getText();
    }

    public String getWishlistProductName() {
        return driver.findElement(wishlistProductName).getText();
    }
}

