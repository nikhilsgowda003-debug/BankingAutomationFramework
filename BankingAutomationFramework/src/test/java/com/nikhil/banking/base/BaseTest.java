package com.nikhil.banking.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {

        DriverFactory.initDriver(browser);
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}