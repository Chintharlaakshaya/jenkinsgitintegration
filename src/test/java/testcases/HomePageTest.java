/*package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ConfigReader;

public class HomePageTest extends BaseTest {

	@Test
	public void verifyHomePageTitle() {
	    driver.get(ConfigReader.getProperty("url")); // Ensure homepage is loaded
	    String actualTitle = driver.getTitle();
	    System.out.println("Actual Title: " + actualTitle);
	    Assert.assertTrue(actualTitle.contains("nopCommerce demo store"), 
	                      "Home page title does not contain expected text!");
	}


    @Test
    public void testMyAccountLinkVisible() {
        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isMyAccountVisible(), "❌ My Account link not visible on homepage!");
    }

    @Test
    public void verifyNavigationToComputersCategory() {
        HomePage home = new HomePage(driver);
        home.goToComputers();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("computers"), "❌ Navigation to Computers failed!");
    }

    @Test
    public void testSearchFunctionality() {
        HomePage home = new HomePage(driver);
        home.search("Laptop");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("search"), "❌ Search did not work properly!");
    }

    @Test
    public void verifyNavigationToWishlist() {
        HomePage home = new HomePage(driver);
        home.goToWishlist();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("wishlist"), "❌ Navigation to Wishlist failed!");
    }
}*/

package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ConfigReader;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageTitle() {
        driver.get(ConfigReader.getProperty("url")); // Ensure homepage is loaded
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertTrue(actualTitle.contains("nopCommerce demo store"),
                "❌ Home page title does not contain expected text!");
    }

    @Test
    public void testMyAccountLinkVisible() {
        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isMyAccountVisible(), "❌ My Account link not visible on homepage!");
    }

    @Test
    public void verifyNavigationToComputersCategory() {
        HomePage home = new HomePage(driver);
        home.goToComputers();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("computers"), "❌ Navigation to Computers failed!");
        Assert.assertTrue(home.getPageHeaderText().contains("Computers"), "❌ Page header mismatch!");
    }

    @Test
    public void verifyNavigationToElectronicsCategory() {
        HomePage home = new HomePage(driver);
        home.goToElectronics();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("electronics"), "❌ Navigation to Electronics failed!");
        Assert.assertTrue(home.getPageHeaderText().contains("Electronics"), "❌ Page header mismatch!");
    }

    @Test
    public void verifyNavigationToBooksCategory() {
        HomePage home = new HomePage(driver);
        home.goToBooks();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("books"), "❌ Navigation to Books failed!");
        Assert.assertTrue(home.getPageHeaderText().contains("Books"), "❌ Page header mismatch!");
    }

    @Test
    public void testSearchFunctionality() {
        HomePage home = new HomePage(driver);
        home.search("Laptop");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("search"), "❌ Search did not work properly!");
    }

    @Test
    public void verifyNavigationToWishlist() {
        HomePage home = new HomePage(driver);
        home.goToWishlist();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("wishlist"), "❌ Navigation to Wishlist failed!");
    }

    @Test
    public void verifyNavigationToNews() {
        HomePage home = new HomePage(driver);
        home.goToNews();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("news"), "❌ Navigation to News failed!");
        Assert.assertTrue(home.getPageHeaderText().contains("News"), "❌ Page header mismatch!");
    }

    @Test
    public void verifyFeaturedProductsCount() {
        HomePage home = new HomePage(driver);
        int count = home.getFeaturedProductsCount();
        System.out.println("Number of featured products: " + count);
        Assert.assertTrue(count > 0, "❌ No featured products found on homepage!");
    }
}

