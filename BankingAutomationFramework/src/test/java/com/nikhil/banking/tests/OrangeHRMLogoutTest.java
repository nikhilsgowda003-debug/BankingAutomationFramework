package com.nikhil.banking.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nikhil.banking.base.BaseTest;
import com.nikhil.banking.base.DriverFactory;
import com.nikhil.banking.pages.DashboardPage;
import com.nikhil.banking.pages.LoginPage;
import com.nikhil.banking.utils.ConfigReader;
import com.nikhil.banking.utils.ExcelUtils;

public class OrangeHRMLogoutTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return ExcelUtils.getLoginData();
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username,
                          String password) {

        DriverFactory.getDriver().get(
                ConfigReader.getProperty("url"));

        LoginPage loginPage =
                new LoginPage(
                        DriverFactory.getDriver());

        loginPage.login(username, password);

        DashboardPage dashboard =
                new DashboardPage(
                        DriverFactory.getDriver());

        Assert.assertTrue(
                dashboard.getPageTitle()
                         .contains("OrangeHRM"));

        dashboard.logout();
    }
}