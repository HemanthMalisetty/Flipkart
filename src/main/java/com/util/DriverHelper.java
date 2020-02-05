package com.util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverHelper {
    WebDriver driver = LocalDriverManager.getDriver();
    private WebDriverWait webDriverWait = new WebDriverWait(driver, 30);


    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public WebElement findElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public void click(String xpath) {
        findElement(xpath).click();
    }

    public void click(By by, String message) {
        message = "can't click " + by + " at " + by;
        String finalMessage = message;
        new WebDriverWait(driver, 5).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    driver.findElement(by).click();
                } catch (WebDriverException e) {
                    return false;
                }
                return true;
            }

            @Override
            public String toString() {
                return finalMessage;
            }
        });
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void waitForElementToBeClickable(String xpath) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public void waitForElementToBeVisible(String xpath) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public boolean isDisplayed(String xpath) {
        if (driver.findElements(By.xpath(xpath)).size() > 0) {
            return driver.findElement(By.xpath(xpath)).isDisplayed();
        } else {
            return false;
        }
    }

    public void hoverOnElement(String xpath) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(By.xpath(xpath))).build().perform();
    }
}
