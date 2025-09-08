package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {

    private WebDriver driver;

    private By productName = By.cssSelector(".product-name a"); // First product in cart

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }
}
