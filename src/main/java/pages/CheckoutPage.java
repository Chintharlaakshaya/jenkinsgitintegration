package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By productRows = By.cssSelector("table.cart tbody tr");
    private By unitPriceCol = By.cssSelector("td.unit-price span");
    private By quantityCol = By.cssSelector("td.quantity input");
    private By subTotalCol = By.cssSelector("td.subtotal span");
    private By grandTotal = By.xpath("//label[text()='Total:']/following-sibling::span/strong");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Wait until cart table is visible
    private void waitForCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productRows));
    }

    // Validate each row: UnitPrice × Quantity == Subtotal
    public boolean validateRowCalculations() {
        waitForCart();
        List<WebElement> rows = driver.findElements(productRows);

        for (WebElement row : rows) {
            double unitPrice = parsePrice(row.findElement(unitPriceCol).getText());
            int qty = Integer.parseInt(row.findElement(quantityCol).getAttribute("value").trim());
            double subTotal = parsePrice(row.findElement(subTotalCol).getText());

            if (Math.abs(unitPrice * qty - subTotal) > 0.01) {
                return false; // mismatch found
            }
        }
        return true;
    }

    // Calculate total by summing all row subtotals
    public double calculateItemsTotal() {
        waitForCart();
        List<WebElement> rows = driver.findElements(productRows);
        double sum = 0.0;

        for (WebElement row : rows) {
            double subTotal = parsePrice(row.findElement(subTotalCol).getText());
            sum += subTotal;
        }
        return sum;
    }

    // Get displayed grand total at bottom
    public double getDisplayedGrandTotal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(grandTotal));
        return parsePrice(driver.findElement(grandTotal).getText());
    }

    // Helper method to parse price strings like "$3,600.00" → 3600.00
    private double parsePrice(String priceText) {
        String clean = priceText.replaceAll("[^0-9.]", "").trim();
        return Double.parseDouble(clean);
    }
}
