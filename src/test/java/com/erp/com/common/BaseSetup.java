package com.erp.com.common;

import com.erp.com.listeners.TestListener;
import erp.com.constants.ConstantGlobal;
import erp.com.driver.DriverManager;
import erp.com.helpers.SystemHelpers;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class BaseSetup {
    //  private static WebDriver driver;


    @Parameters({"BROWSER"})
    public WebDriver createDriver(@Optional("chrome") String browserName) {
        // PropertyConfigurator.configure(SystemHelpers.getCurrentDir()+"src/main/resources/log4j.properties");
        WebDriver driver = setupBrowser(browserName);
        DriverManager.setDriver(driver);
        return driver;
    }

    //Viết hàm trung gian để lựa chọn Browser cần chạy với giá trị tham số "browser" bên trên truyền vào
    public WebDriver setupBrowser(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    // Viết các hàm khởi chạy cho từng Browser đó
    private WebDriver initChromeDriver() {
        WebDriver driver;
        System.out.println("Launching Chrome browser...");
        //WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        if (ConstantGlobal.HEADLESS == true) {
//            options.addArguments("--remote-allow-origins=*");
//            options.addArguments("--headless");
//            options.addArguments("--window-size=1920,1080");
//        }
//        else {
//            options.addArguments("--remote-allow-origins=*");
//            //options.addArguments("--headless");
//            options.addArguments("--window-size=1920,1080");
//        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initEdgeDriver() {
        WebDriver driver;
        System.out.println("Launching Edge browser...");
        //WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
        if (ConstantGlobal.HEADLESS == true) {
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        }

        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initFirefoxDriver() {
        WebDriver driver;
        System.out.println("Launching Firefox browser...");
        //WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        if (ConstantGlobal.HEADLESS == true) {
            options.addArguments("--headless");
            options.addArguments("window-size=1800,900");
        }

        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }


    public void closeDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }

}