package com.flipkart.pages;

import com.util.DriverHelper;
import com.util.Session;

public class FlipkartWelcomePage {
    String loginPopupClose_button, electronics, mobiles;

    public FlipkartWelcomePage(){
        if (Session.isCss()){
            loginPopupClose_button = "[class = '_2AkmmA _29YdH8']";
            electronics = "ul[class = '_114Zhd'] > li:nth-child(1)";
            mobiles = "a[title = 'Mobiles']";
        }else if (Session.isXpath()){
            loginPopupClose_button = "//*[@class = '_2AkmmA _29YdH8']";
            electronics = "//*[@class = '_1QZ6fC _3Lgyp8' and contains(text(), 'Electronics')]";
            mobiles = "//*[@title = 'Mobiles']";
        }
    }



    DriverHelper dh = new DriverHelper();

    public String getTitleOfThePage() {
        return dh.getTitle();
    }

    public FlipkartWelcomePage clickOnCloseButton() {
        dh.waitForElementToBeClickable(loginPopupClose_button);
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
