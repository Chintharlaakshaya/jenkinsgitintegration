package testcases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmptyWishlist;
import pages.WishlistPage;
import testcases.BaseTest;

public class CheckWishlistEmptyTest extends BaseTest {

    @Test
    public void verifyWishlistIsEmptyForFreshSession() {
        EmptyWishlist wishlistPage = new EmptyWishlist(driver);

        // Open wishlist
        wishlistPage.openWishlist();

        // Check if wishlist is empty
        boolean empty = wishlistPage.isWishlistEmpty();

        // Assert
        Assert.assertTrue(empty, "❌ Wishlist is NOT empty for a fresh session!");
        System.out.println("✅ Wishlist is empty for a fresh session, test passed.");
    }
}
