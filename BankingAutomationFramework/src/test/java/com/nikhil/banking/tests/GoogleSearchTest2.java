package com.nikhil.banking.tests;

import org.testng.annotations.Test;

import com.nikhil.banking.base.BaseTest;
import com.nikhil.banking.base.DriverFactory;
import com.nikhil.banking.pages.GooglePage;
import com.nikhil.banking.utils.ConfigReader;

public class GoogleSearchTest2 extends BaseTest {

    @Test
    public void secondSearchTest() {

        DriverFactory.getDriver().get(
                ConfigReader.getProperty("url"));

        GooglePage googlePage =
                new GooglePage(DriverFactory.getDriver());

        googlePage.search("Parallel Testing");
    }
}
