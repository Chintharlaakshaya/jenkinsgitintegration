/*package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.EmailStorage;

public class LoginTest {
	 WebDriver driver;
	 LoginPage loginPage;

	    @BeforeMethod
	    public void setUp() {
	    	  // Load config
	        ConfigReader.loadConfig();
	        
	        // Init browser from config
	        driver = DriverFactory.initDriver(ConfigReader.getProperty("browser"));
	       // driver = DriverFactory.initDriver("chrome");
	        
	        // Open URL from config
	        driver.get(ConfigReader.getProperty("url") + "login");
	        //driver.get("https://demo.nopcommerce.com/login");
	        loginPage = new LoginPage(driver);
	    }

	    @Test
	    public void validLoginTest() {
	    	String email=EmailStorage.getEmail();
	        //loginPage.enterEmail("testuser@demo.com");
	       // loginPage.enterPassword("Test@123");
	    	loginPage.enterEmail(email);
	    	//loginPage.enterEmail(ConfigReader.getProperty("email"));
	        loginPage.enterPassword(ConfigReader.getProperty("password"));
	        loginPage.clickLogin();

	        Assert.assertTrue(loginPage.isMyAccountVisible(),
	                "❌ Login failed with email: " + email);
	        System.out.println("✅ Login successful with email: " + email);
	    }
	    

	    @AfterMethod
	    public void tearDown() {
	        DriverFactory.quitDriver();
	    }

}*/

package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testcases.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;
import utils.EmailStorage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void validLoginTest() {
        // Navigate to login page
        driver.get(ConfigReader.getProperty("url") + "login");

        loginPage = new LoginPage(driver);

        String email = EmailStorage.getEmail(); // from RegisterTest

        loginPage.enterEmail(email);
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isMyAccountVisible(),
                "❌ Login failed with email: " + email);
        System.out.println("✅ Login successful with email: " + email);
    }
}
