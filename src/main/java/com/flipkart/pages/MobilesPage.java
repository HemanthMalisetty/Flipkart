package com.flipkart.pages;

import com.util.DriverHelper;
import com.util.Session;

public class MobilesPage {
    String ram, filter;

    public MobilesPage(){
        if (Session.isCss()){
            ram = "[title = '6 GB & Above']";
            filter = "[class = '_3UZZGt']";
        }else if (Session.isXpath()){
            ram = "//*[@title = '6 GB & Above']";
            filter = "//*[@class = '_3UZZGt']";
        }
    }

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
    /*public boolean isSelectedRamShowedUnderFilters(){
        dh.waitForElementToBeVisible(filter, "css");
        return dh.isDisplayed(filter);
    }*/

    public String getFilterText(){
        dh.waitForElementToBeVisible(filter);
        return dh.getText(filter);
    }
}
