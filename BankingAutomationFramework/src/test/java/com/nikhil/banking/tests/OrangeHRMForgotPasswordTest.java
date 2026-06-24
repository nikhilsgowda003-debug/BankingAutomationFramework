package com.nikhil.banking.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nikhil.banking.base.BaseTest;
import com.nikhil.banking.base.DriverFactory;
import com.nikhil.banking.utils.ConfigReader;

public class OrangeHRMForgotPasswordTest extends BaseTest {

    @Test
    public void forgotPasswordTest() {

        DriverFactory.getDriver().get(
                ConfigReader.getProperty("url"));

        String currentUrl =
                DriverFactory.getDriver()
                             .getCurrentUrl();

        System.out.println(
                "Current URL = " + currentUrl);

        Assert.assertTrue(
                currentUrl.contains("auth"));
    }
}