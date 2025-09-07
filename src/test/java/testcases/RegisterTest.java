/*package testcases;

import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.RegisterPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class RegisterTest  {
	 WebDriver driver;
	    RegisterPage registerPage;

	    // Generate random email each run (avoid duplicate email error)
	    //UUID = Universally Unique Identifier.
	    private String randomEmail() {
	        return "user_" + UUID.randomUUID().toString().substring(0,5) + "@demo.com";
	    }

	    @BeforeMethod
	    public void setUp() {
	        ConfigReader.loadConfig();
	        driver = DriverFactory.initDriver(ConfigReader.getProperty("browser"));
	        driver.get(ConfigReader.getProperty("url") + "register");
	        registerPage = new RegisterPage(driver);
	    }

	    @Test
	    public void validRegistrationTest() {
	        String email = randomEmail(); // dynamic email
	        ConfigReader.loadConfig(); // reload to update

	        registerPage.selectGender("male");
	        registerPage.enterFirstName("John");
	        registerPage.enterLastName("Doe");
	        registerPage.enterEmail(email);
	        registerPage.enterPassword("Test@123");
	        registerPage.clickRegister();

	        String msg = registerPage.getSuccessMessage();
	        Assert.assertTrue(msg.contains("Your registration completed"),
	                "❌ Registration failed");
	        

	        // Save the generated email for Login test
	        utils.EmailStorage.saveEmail(email);

	        System.out.println("✅ Registered successfully with: " + email);
	    }

	    @AfterMethod
	    public void tearDown() {
	        DriverFactory.quitDriver();
	    }

}*/

package testcases;

import java.util.UUID;
import org.testng.Assert;
import org.testng.annotations.Test;

import testcases.BaseTest;
import pages.RegisterPage;
import utils.ConfigReader;
import utils.EmailStorage;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage;

    // Generate random email each run
    private String randomEmail() {
        return "user_" + UUID.randomUUID().toString().substring(0,5) + "@demo.com";
    }

    @Test
    public void validRegistrationTest() {
        // Navigate to register page (URL still comes from config)
        driver.get(ConfigReader.getProperty("url") + "register");

        registerPage = new RegisterPage(driver);

        String email = randomEmail();

        registerPage.selectGender("male");
        registerPage.enterFirstName("John");
        registerPage.enterLastName("Doe");
        registerPage.enterEmail(email);
        registerPage.enterPassword("Test@123");
        registerPage.clickRegister();

        String msg = registerPage.getSuccessMessage();
        Assert.assertTrue(msg.contains("Your registration completed"),
                "❌ Registration failed");

        // Save email for login test
        EmailStorage.saveEmail(email);

        System.out.println("✅ Registered successfully with: " + email);
    }
}

