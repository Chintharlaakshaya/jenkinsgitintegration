package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {
    public static WebDriver driver;

    @BeforeSuite
    public void suiteSetUp() {
        ConfigReader.loadConfig();
        driver = DriverFactory.initDriver(ConfigReader.getProperty("browser"));
        driver.get(ConfigReader.getProperty("url"));
    }
    
    public WebDriver getDriver() {
        return driver;
    }
    	

    @AfterSuite
    public void suiteTearDown() {
        DriverFactory.quitDriver();
    }
}

