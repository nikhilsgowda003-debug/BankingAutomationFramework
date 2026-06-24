package com.nikhil.banking.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nikhil.banking.base.BaseTest;
import com.nikhil.banking.base.DriverFactory;
import com.nikhil.banking.pages.DashboardPage;
import com.nikhil.banking.pages.LoginPage;
import com.nikhil.banking.utils.ConfigReader;

public class OrangeHRMLoginTest extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {

        DriverFactory.getDriver().get(
                ConfigReader.getProperty("url"));

        LoginPage loginPage =
                new LoginPage(
                        DriverFactory.getDriver());

        loginPage.login(
                "Admin",
                "admin123");

        DriverFactory.getDriver().manage().timeouts()
        .implicitlyWait(java.time.Duration.ofSeconds(10));

        DashboardPage dashboard =
                new DashboardPage(
                        DriverFactory.getDriver());

        String title =
        dashboard.getPageTitle();

System.out.println("Title = " + title);

Assert.assertEquals(
        title,
        "OrangeHRM");
    }
}