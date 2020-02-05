package com.flipkart.pages;

import com.util.DriverHelper;

public class FlipkartWelcomePage {

    String loginPopupClose_button = "//*[@class = '_2AkmmA _29YdH8']",
            electronics = "//*[@class = '_1QZ6fC _3Lgyp8' and contains(text(), 'Electronics')]",
            mobiles = "//*[@title = 'Mobiles']";

    DriverHelper dh = new DriverHelper();

    public String getTitleOfThePage() {
        return dh.getTitle();
    }

    public FlipkartWelcomePage clickOnCloseButton() {
        dh.click(loginPopupClose_button);
        return this;
    }

    public FlipkartWelcomePage hoverOnElectronics() {
        dh.hoverOnElement(electronics);
        return this;
    }

    public FlipkartWelcomePage clickOnMobiles() {
        dh.waitForElementToBeClickable(mobiles);
        dh.click(mobiles);
        return this;
    }
}
