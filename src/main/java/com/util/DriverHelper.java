package com.util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverHelper {
    WebDriver driver = LocalDriverManager.getDriver();
    private WebDriverWait webDriverWait = new WebDriverWait(driver, 30);


    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public WebElement findElement(String locator) {
        WebElement element = null;
        if (locator.startsWith("/") || locator.startsWith("//")){
             element = driver.findElement(By.xpath(locator));
        }else {
            element = driver.findElement(By.cssSelector(locator));
        }
        return element;
    }

    public void click(String xpath) {
        findElement(xpath).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void waitForElementToBeClickable(String locator) {
        if (locator.startsWith("/") || locator.startsWith("//")){
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        }else {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
        }

    }

    public void waitForElementToBeVisible(String locator) {
        if (locator.startsWith("/") || locator.startsWith("//")){
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        }else {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
        }
    }

    public boolean isDisplayed(String xpath) {
        if (driver.findElements(By.xpath(xpath)).size() > 0) {
            return driver.findElement(By.xpath(xpath)).isDisplayed();
        } else {
            return false;
        }
    }

    public void hoverOnElement(String locator) {
        Actions actions = new Actions(driver);
        if (locator.startsWith("/") || locator.startsWith("//")){
            actions.moveToElement(findElement(By.xpath(locator))).build().perform();
        }else {
            actions.moveToElement(findElement(By.cssSelector(locator))).build().perform();
        }
    }

    public String getText(String locator){
        String returnText = null;
        if (locator.startsWith("/") || locator.startsWith("//")){
            returnText = findElement(locator).getText();
        }else {
            returnText = findElement(locator).getText();
        }
        return returnText;
    }

}
