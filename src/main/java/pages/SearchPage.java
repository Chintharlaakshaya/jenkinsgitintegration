/*package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.cssSelector("button[type='submit'][class*='search-box-button']");
    private By productTitles = By.cssSelector(".product-title a");

    // Enter product name in search box
    public void enterSearchText(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
    }

    // Click search button
    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    // Check if product exists in search results
    public boolean isProductDisplayed(String productName) {
        List<WebElement> products = driver.findElements(productTitles);
        return products.stream().anyMatch(p -> p.getText().equalsIgnoreCase(productName));
    }

    // Click on a product from search results
    public void clickProduct(String productName) {
        List<WebElement> products = driver.findElements(productTitles);
        products.stream()
                .filter(p -> p.getText().equalsIgnoreCase(productName))
                .findFirst()
                .ifPresent(WebElement::click);
    }
}*/
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    WebDriver driver;

    By searchBox = By.id("small-searchterms");
    By searchButton = By.cssSelector("button[type='submit']");
    By firstResult = By.cssSelector(".product-title a");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public void openFirstResult() {
        driver.findElement(firstResult).click();
    }
}

