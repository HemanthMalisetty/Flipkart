package com.flipkart.pages;

import com.util.DriverHelper;

public class MobilesPage {
    String ram = "//*[contains(text(), '6 GB & Above')]/preceding-sibling::div",
            filter = "//*[contains(text(), 'Filters')]/ancestor::*[@class = 'xeGmCJ D_NGuZ']//*[text() = '6 GB & Above']";

    DriverHelper dh = new DriverHelper();

    public MobilesPage selectRamSize() {
        dh.waitForElementToBeClickable(ram);
        dh.click(ram);
        return this;
    }

    public String getPageTitle() {
        dh.waitForElementToBeVisible(ram);
        return dh.getTitle();
    }
    public boolean isSelectedRamShowedUnderFilters(){
        dh.waitForElementToBeVisible(filter);
        return dh.isDisplayed(filter);
    }
}
