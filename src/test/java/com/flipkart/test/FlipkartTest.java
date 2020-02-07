package com.flipkart.test;

import com.base.BaseTest;
import com.flipkart.pages.FlipkartWelcomePage;
import com.flipkart.pages.MobilesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlipkartTest extends BaseTest {
    @Test
    public void applyingFilter() {
        /**
         * Asserting page title
         */
        FlipkartWelcomePage welcomePage = new FlipkartWelcomePage();
        Assert.assertEquals(welcomePage.getTitleOfThePage(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!",
                "Home page title is not matching");
        /**
         * Closing the logon popup
         * Hover on the Electronics
         * Clicking on the mobiles link
         */
        welcomePage.clickOnCloseButton()
                .hoverOnElectronics()
                .clickOnMobiles();
        /**
         * Assert mobiles page title
         */
        MobilesPage mp = new MobilesPage();
        Assert.assertEquals(mp.getPageTitle(), "Mobile Phones: Buy Mobiles Online at Best Prices in India",
                "Mobiles page title is not matching");
        /**
         * Selecting the RAM size
         * Asserting the applied Filter
         */
        mp.selectRamSize();
        //Assert.assertTrue(mp.isSelectedRamShowedUnderFilters(), "Selected RAM is not showing under filters");
        Assert.assertEquals(mp.getFilterText(), "6 GB & Above", "Applied filter is not showing under filters");
    }
}
