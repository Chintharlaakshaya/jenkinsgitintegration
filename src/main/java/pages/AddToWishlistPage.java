package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToWishlistPage {

    private WebDriver driver;

    // Locators
    public By clickElectronics = By.linkText("Electronics");
    public By clickCellPhones = By.linkText("Cell phones");
    public By selectProduct = By.linkText("Samsung Galaxy S24 256GB");
    private By addToWishlistButton = By.id("add-to-wishlist-button-22");
    private By successMessage = By.cssSelector(".bar-notification.success");

    public AddToWishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void addProductToWishlist() {
        driver.findElement(addToWishlistButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    // Getter for successMessage locator (so test can use it in wait)
    public By getSuccessMessageLocator() {
        return successMessage;
    }
    
 // 🔹 New methods to navigate and select product
    public void clickElectronics() {
        driver.findElement(clickElectronics).click();
    }

    public void clickCellPhones() {
        driver.findElement(clickCellPhones).click();
    }

    public void selectProduct() {
        driver.findElement(selectProduct).click();
    }
}
