package com.nikhil.banking.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nikhil.banking.base.BaseTest;
import com.nikhil.banking.base.DriverFactory;
import com.nikhil.banking.pages.LoginPage;
import com.nikhil.banking.utils.ConfigReader;

public class OrangeHRMNegativeLoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() {

        DriverFactory.getDriver().get(
                ConfigReader.getProperty("url"));

        LoginPage loginPage =
                new LoginPage(
                        DriverFactory.getDriver());

        loginPage.login(
                "Admin",
                "wrongpassword");

        String actualMessage =
                loginPage.getErrorMessage();

        System.out.println(
                "Error Message = " +
                actualMessage);

        Assert.assertEquals(
                actualMessage,
                "Invalid credentials");
    }
}