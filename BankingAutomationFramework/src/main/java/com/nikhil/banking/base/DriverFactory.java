package com.nikhil.banking.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.nikhil.banking.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static void initDriver(String browser) {

        WebDriver localDriver;

        switch (browser.toLowerCase()) {

        case "chrome":

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            if ("true".equalsIgnoreCase(
                    ConfigReader.getProperty("headless"))) {

                options.addArguments("--headless=new");
            }

            localDriver = new ChromeDriver(options);
            break;

        case "edge":

            WebDriverManager.edgedriver().setup();
            localDriver = new EdgeDriver();
            break;

        case "firefox":

            WebDriverManager.firefoxdriver().setup();
            localDriver = new FirefoxDriver();
            break;

        default:

            System.out.println("Invalid Browser. Launching Chrome...");

            WebDriverManager.chromedriver().setup();
            localDriver = new ChromeDriver();
        }

        localDriver.manage().window().maximize();

        driver.set(localDriver);
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();
            driver.remove();
        }
    }
}