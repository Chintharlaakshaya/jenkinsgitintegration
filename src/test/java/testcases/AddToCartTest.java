package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.ShoppingCartPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void testAddProductToCart() {
        HomePage home = new HomePage(driver);

        // Navigate to "Computers" → "Desktops" (or any category)
        home.goToComputers();

        // Assume we click on first product manually (or you can add a method for that)
        ProductPage product = new ProductPage(driver);
        product.clickFirstAddToCart();

        // Verify notification appears
        Assert.assertTrue(product.isNotificationDisplayed(), "❌ Add to Cart notification not displayed!");

        // Go to Shopping Cart and verify product
        product.goToShoppingCart();
        ShoppingCartPage cart = new ShoppingCartPage(driver);
        String name = cart.getProductName();
        System.out.println("Product in cart: " + name);
        Assert.assertTrue(name.length() > 0, "❌ No product found in shopping cart!");
    }
}
