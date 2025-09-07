/*package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TotalBill {
    WebDriver driver;

    // Locators
    private By cartLink = By.linkText("Shopping cart");
    private By cartRows = By.cssSelector("table.cart tbody tr"); // all rows
    By orderTotal = By.xpath("//table[@class='cart-total']//tr[last()]//span[@class='value-summary']");


    public TotalBill(WebDriver driver) {
        this.driver = driver;
    }
    
    public void openCart() {
        driver.findElement(cartLink).click();
    }


 // Get subtotal for each product row
    public double getProductSubtotal(WebElement row) {
        String subtotalText = row.findElement(By.cssSelector("span.product-subtotal")).getText();
        return Double.parseDouble(subtotalText.replace("$", "").trim());
    }

    // Calculate total from all products
    public double getCalculatedCartTotal() {
        List<WebElement> rows = driver.findElements(cartRows);
        double total = 0.0;
        for (WebElement row : rows) {
            total += getProductSubtotal(row);
        }
        return total;
    }

    // Get total displayed on site
    public double getDisplayedOrderTotal() {
        String totalText = driver.findElement(
            By.xpath("//table[@class='cart-total']//tr[last()]//span[@class='value-summary']")
        ).getText();
        totalText = totalText.replace("$", "").replace(",", "").trim();
        return Double.parseDouble(totalText);
    }

}*/

