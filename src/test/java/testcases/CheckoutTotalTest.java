package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;

public class CheckoutTotalTest extends BaseTest {

    @Test
    public void verifyCheckoutTotals() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // ✅ Step 1: Row-level validation (UnitPrice × Qty == Subtotal)
        boolean rowValid = checkoutPage.validateRowCalculations();
        Assert.assertTrue(rowValid, "❌ Row-level calculation mismatch found!");

        // ✅ Step 2: Calculate sum of all row subtotals
        double calculatedTotal = checkoutPage.calculateItemsTotal();

        // ✅ Step 3: Get displayed grand total
        double displayedTotal = checkoutPage.getDisplayedGrandTotal();

        // ✅ Step 4: Compare
        Assert.assertEquals(calculatedTotal, displayedTotal,
                "❌ Mismatch between calculated total and displayed grand total!");

        System.out.println("✅ Checkout totals verified: " +
                "Row-wise OK | Calculated Total = " + calculatedTotal +
                " | Displayed Total = " + displayedTotal);
    }
}
