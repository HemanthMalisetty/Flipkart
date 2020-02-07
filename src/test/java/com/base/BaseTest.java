package com.base;

import com.util.LocalDriverManager;
import com.util.Session;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    public WebDriver driver = null;

    @BeforeTest
    @Parameters({"browser", "domain", "css", "xpath"})
    public void beforeMethod(@Optional("chrome") String browser, @Optional("https://www.flipkart.com") String url, @Optional("false") boolean css, @Optional("false") boolean xpath) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--disable-notifications");
                driver = new ChromeDriver(ops);
                break;
            case "ff":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().arch32().setup();
                driver = new InternetExplorerDriver();
                break;
        }
        LocalDriverManager.setWebDriver(driver);
        driver = LocalDriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(url);
        Session.setCss(css);
        Session.setXpath(xpath);
        System.out.println("Browser name : " + browser);
        System.out.println("Navigating to : " + url);
        if (Session.isXpath()){
            System.out.println("Executing using Xpath");
        }else if (Session.isCss()){
            System.out.println("Executing using CSS");
        }

    }
    @AfterTest
    public void afterMethod() {
        LocalDriverManager.getDriver().quit();
    }
}
