package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddToWishlistPage;
import utils.DriverFactory;

import java.time.Duration;

public class WishListTesting extends BaseTest {
    //WebDriver driver;
    AddToWishlistPage addToWishlistPage;
    WebDriverWait wait;

   /* @BeforeMethod
    public void setUp() {
        driver = DriverFactory.initDriver("chrome");
        driver.get("https://demo.nopcommerce.com/");
        addToWishlistPage = new AddToWishlistPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }*/

    @Test
    public void addSamsungGalaxyToWishlistTest() {
    	driver.get("https://demo.nopcommerce.com/"); // optional (refresh home)

        addToWishlistPage = new AddToWishlistPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // Navigate to Electronics → Cell Phones
        driver.findElement(addToWishlistPage.clickElectronics).click();
        driver.findElement(addToWishlistPage.clickCellPhones).click();

        // Select Samsung Galaxy product
        driver.findElement(addToWishlistPage.selectProduct).click();

        // Add product to wishlist
        addToWishlistPage.addProductToWishlist();

        // Wait for success message
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToWishlistPage.getSuccessMessageLocator()));

        // Verify success message
        String message = addToWishlistPage.getSuccessMessage();
        Assert.assertTrue(message.contains("The product has been added to your wishlist"),
                "❌ Product not added to wishlist! Message: " + message);

        System.out.println("✅ Samsung Galaxy added to wishlist successfully!");
    }

   /* @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }*/
}
