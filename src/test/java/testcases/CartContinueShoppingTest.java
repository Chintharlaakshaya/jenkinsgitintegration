package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartContinueShoppingTest extends BaseTest {

    @Test
    public void verifyContinueShoppingButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Step 1: Click first product
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".product-item .product-title a")
        ));
        firstProduct.click();

        // Step 2: Wait until Add to Cart button is visible (handle input/button variations)
        WebElement addToCartButton = null;
        try {
            addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("input[value='Add to cart']")
            ));
        } catch (Exception e) {
            // fallback for button type
            addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Add to cart')]")
            ));
        }

        // Step 3: Click Add to Cart
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);

        // Step 4: Wait for Continue Shopping button
        WebElement continueShoppingBtn = null;
        try {
            continueShoppingBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("input[value='Continue shopping']")
            ));
        } catch (Exception e) {
            continueShoppingBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Continue shopping')]")
            ));
        }

        // Step 5: Click Continue Shopping
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueShoppingBtn);

        // Step 6: Verify URL contains category or products
        wait.until(ExpectedConditions.urlContains("category"));
        String currentUrl = driver.getCurrentUrl();
        System.out.println("URL after Continue Shopping: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("category") || currentUrl.contains("products"),
                "Continue Shopping did not navigate back to product listing page");
    }
}
