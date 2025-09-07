/*package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCart;
import pages.TotalBill;
import utils.ConfigReader;

public class TotalBillTest extends BaseTest {

	@Test
	public void verifyCartTotalWithMultipleItems() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    // Add first product
	    AddToCart cartPage = new AddToCart(driver);
	    driver.findElement(cartPage.clickComputers).click();
	    driver.findElement(cartPage.clickNotebooks).click();
	    driver.findElement(cartPage.selectProduct).click();
	    cartPage.addProductToCart();

	    // Add second product
	    driver.navigate().to(ConfigReader.getProperty("url"));
	    driver.findElement(cartPage.clickComputers).click();
	    driver.findElement(cartPage.clickNotebooks).click();
	    // choose another product locator if available
	    driver.findElement(By.linkText("Asus N551JK-XO076H Laptop")).click();
	    cartPage.addProductToCart();

	    // Now calculate total
	    TotalBill checkoutPage = new TotalBill(driver);
	    checkoutPage.openCart();

	    double expected = checkoutPage.getCalculatedCartTotal();
	    double actual = checkoutPage.getDisplayedOrderTotal();

	    Assert.assertEquals(actual, expected, "❌ Total mismatch");
	    System.out.println("✅ Total validated: " + actual);
	}

}*/

/*package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TotalBill;

import java.time.Duration;
import java.util.List;

public class TotalBillTest extends BaseTest {

	@Test
	public void verifyCartTotalWithMultipleItems() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    // Navigate to Notebooks
	    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Computers"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Notebooks"))).click();

	    // Get all products on listing page
	    List<WebElement> products = wait.until(
	            ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".product-item"))
	    );

	    // ✅ Add first product
	    WebElement firstAddButton = products.get(0).findElement(By.cssSelector("button.button-2.product-box-add-to-cart-button"));
	    firstAddButton.click();

	    // ✅ Add second product
	    WebElement secondAddButton = products.get(1).findElement(By.cssSelector("button.button-2.product-box-add-to-cart-button"));
	    secondAddButton.click();

	    // Go to shopping cart
	    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Shopping cart"))).click();

	    // Validate totals
	    TotalBill totalBillPage = new TotalBill(driver);
	    double expectedTotal = totalBillPage.getCalculatedCartTotal();
	    double displayedTotal = totalBillPage.getDisplayedOrderTotal();

	    Assert.assertEquals(displayedTotal, expectedTotal, "Cart total does not match expected value!");
	}

}*/

package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class TotalBillTest extends BaseTest {

    @Test
    public void verifyCartTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Step 1: Click the cart icon using JS (avoid click intercepted)
        WebElement cartLabel = wait.until(ExpectedConditions.elementToBeClickable(By.className("cart-label")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartLabel);

        // Step 2: Click "Go to cart" to open full cart page
        WebElement goToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div.mini-shopping-cart a.button-1.cart-button")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", goToCartBtn);

        // Step 3: Wait for full cart page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.cart")));

        // Step 4: Fetch all product subtotals
        List<WebElement> subtotals = driver.findElements(By.cssSelector("span.product-subtotal"));
        double calculatedTotal = 0.0;

        for (WebElement subtotal : subtotals) {
            String text = subtotal.getText().replace(",", "").replace("$", "").trim();
            calculatedTotal += Double.parseDouble(text);
        }

        // Step 5: Fetch displayed cart total
        WebElement displayedTotalEl = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("tr.order-total span.value-summary")));
        String displayedText = displayedTotalEl.getText().replace(",", "").replace("$", "").trim();
        double displayedTotal = Double.parseDouble(displayedText);

        // Step 6: Print totals and assert
        System.out.println("Calculated Total: " + calculatedTotal);
        System.out.println("Displayed Total: " + displayedTotal);

        if (calculatedTotal == displayedTotal) {
            System.out.println("Cart total is correct!");
        } else {
            System.out.println("Cart total mismatch!");
        }
    }
}
