/*package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.SearchPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class SearchProductTest {

    WebDriver driver;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        ConfigReader.loadConfig();
        driver = DriverFactory.initDriver(ConfigReader.getProperty("browser"));
        driver.get(ConfigReader.getProperty("url"));
        searchPage = new SearchPage(driver);
    }

   /* @Test
    public void searchProductTest() {
        String productName = "Build your own computer";

        searchPage.enterSearchText(productName);
        searchPage.clickSearchButton();

        Assert.assertTrue(searchPage.isProductDisplayed(productName),
               "Product not displayed in search results");

        // Optionally, click the product to go to details page
        searchPage.clickProduct(productName);
    }
    
    @Test
    public void searchProductTest() {
        String productName = "Build your own computer";

        searchPage.searchProduct(productName);
        searchPage.openFirstResult();

        // Now you're on the product details page
        Assert.assertTrue(driver.getTitle().contains(productName),
                "❌ Product page not opened for: " + productName);
    }


    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
} */

package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.SearchPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class SearchProductTest {

    WebDriver driver;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        ConfigReader.loadConfig();
        driver = DriverFactory.initDriver(ConfigReader.getProperty("browser"));
        driver.get(ConfigReader.getProperty("url"));
        searchPage = new SearchPage(driver);
    }

   /* @Test
    public void searchProductTest() {
        String productName = "Build your own computer";

        searchPage.enterSearchText(productName);
        searchPage.clickSearchButton();

        Assert.assertTrue(searchPage.isProductDisplayed(productName),
               "Product not displayed in search results");

        // Optionally, click the product to go to details page
        searchPage.clickProduct(productName);
    }*/
    
    @Test
    public void searchProductTest() {
        String productName = "Build your own computer";

        searchPage.searchProduct(productName);
        searchPage.openFirstResult();

        // Now you're on the product details page
        Assert.assertTrue(driver.getTitle().contains(productName),
                "❌ Product page not opened for: " + productName);
        System.out.println("Search Successfully done");
    }


    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}



