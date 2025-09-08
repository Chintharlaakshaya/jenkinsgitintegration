package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewsletterTest extends BaseTest {

    @Test
    public void verifyNewsletterSubscription() throws InterruptedException {
        // Step 1: Enter email
        WebElement emailBox = driver.findElement(By.id("newsletter-email"));
        emailBox.sendKeys("testemail1@example.com");

        // Step 2: Click subscribe
        driver.findElement(By.id("newsletter-subscribe-button")).click();

        // Step 3: Wait for the result
        Thread.sleep(3000); // simple wait, or use WebDriverWait if needed

        // Step 4: Get the result text
        WebElement resultMsg = driver.findElement(By.id("newsletter-result-block"));
        String message = resultMsg.getText();
        System.out.println("Subscription message: " + message);

        // Step 5: Assert the success message
        Assert.assertTrue(message.contains("Thank you") || message.contains("successfully"), "Newsletter subscription failed!");
    }
}
