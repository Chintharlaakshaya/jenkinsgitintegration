package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddToCart;
import utils.DriverFactory;

public class CartTest extends BaseTest {
	//WebDriver driver;
    AddToCart addToCartPage;

    /*@BeforeMethod
    public void setUp() {
        driver = DriverFactory.initDriver("chrome"); // initializes driver
        // DriverFactory.setDriver(driver); // <-- REMOVE this line
        driver.get("https://demo.nopcommerce.com/");
        addToCartPage = new AddToCart(driver);
    }*/

    @Test
    public void addAppleMacBookToCartTest() throws InterruptedException {
    	driver.get("https://demo.nopcommerce.com/");
        // Navigate to home page
        // Navigate through categories
        AddToCart cartPage = new AddToCart(driver);
        driver.findElement(cartPage.clickComputers).click();   // Click "Computers"
        driver.findElement(cartPage.clickNotebooks).click();   // Click "Notebooks"
        driver.findElement(cartPage.selectProduct).click();    // Select "Apple MacBook Pro 13-inch"
        

        // Add product to cart
        cartPage.addProductToCart();
       /* try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        // Verify success message
        String message = cartPage.getSuccessMessage();
        Assert.assertTrue(message.contains("The product has been added to your shopping cart"),
                "❌ Product not added to cart! Message: " + message);

        System.out.println("✅ Apple MacBook Pro added to cart successfully!");
    }
   /* @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }*/
}