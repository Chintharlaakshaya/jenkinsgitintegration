/*package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    // ===== Top Menu Locators =====
    private By computersMenu = By.linkText("Computers");
    private By electronicsMenu = By.linkText("Electronics");

    // ===== Header Locators =====
    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.cssSelector("button[type='submit']");
    private By wishlistLink = By.linkText("Wishlist");
    private By myAccountLink = By.linkText("My account");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== Navigation Methods =====
    public void goToComputers() {
        driver.findElement(computersMenu).click();
    }

    public void goToElectronics() {
        driver.findElement(electronicsMenu).click();
    }

    public void goToWishlist() {
        driver.findElement(wishlistLink).click();
    }

    // ===== Header Actions =====
    public void search(String text) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(text);
        driver.findElement(searchButton).click();
    }

    // ===== Validation =====
    public boolean isMyAccountVisible() {
        return driver.findElement(myAccountLink).isDisplayed();
    }
}*/

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    // ===== Top Menu Locators =====
    private By computersMenu = By.linkText("Computers");
    private By electronicsMenu = By.linkText("Electronics");
    private By booksMenu = By.linkText("Books");

    // ===== Header Locators =====
    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.cssSelector("button[type='submit']");
    private By wishlistLink = By.linkText("Wishlist");
    private By myAccountLink = By.linkText("My account");

    // ===== Featured Products =====
    private By featuredProducts = By.cssSelector("div.product-item");

    // ===== News =====
    private By newsLink = By.linkText("New online store is open!");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== Navigation Methods =====
    public void goToComputers() {
        driver.findElement(computersMenu).click();
    }

    public void goToElectronics() {
        driver.findElement(electronicsMenu).click();
    }

    public void goToBooks() {
        driver.findElement(booksMenu).click();
    }

    public void goToWishlist() {
        driver.findElement(wishlistLink).click();
    }

    public void goToNews() {
        driver.findElement(newsLink).click();
    }

    // ===== Header Actions =====
    public void search(String text) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(text);
        driver.findElement(searchButton).click();
    }

    // ===== Validation Methods =====
    public boolean isMyAccountVisible() {
        return driver.findElement(myAccountLink).isDisplayed();
    }

    public int getFeaturedProductsCount() {
        return driver.findElements(featuredProducts).size();
    }

    public String getPageHeaderText() {
        return driver.findElement(By.cssSelector("div.page-title h1")).getText().trim();
    }
}


