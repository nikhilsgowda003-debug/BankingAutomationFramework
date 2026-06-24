package com.nikhil.banking.tests;

import com.nikhil.banking.utils.ScreenshotUtils;
import com.nikhil.banking.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import com.nikhil.banking.utils.ExcelUtils;

//import org.testng.Assert;

import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import com.nikhil.banking.base.BaseTest;
import com.nikhil.banking.base.DriverFactory;
import com.nikhil.banking.pages.GooglePage;

public class LoginTest extends BaseTest {
        private static final Logger log =
        LogManager.getLogger(LoginTest.class);
        @DataProvider(name = "searchData")
public Object[][] searchData() {

    return ExcelUtils.getTestData();
}

@Test(dataProvider = "searchData")
public void openGoogle(String searchText)
        throws InterruptedException{

    log.info("Opening Google");

    DriverFactory.getDriver().get(ConfigReader.getProperty("url"));

    GooglePage googlePage = new GooglePage(DriverFactory.getDriver());

    log.info("Searching text");

    System.out.println("Search Text = " + searchText);

    googlePage.search((searchText));

    SoftAssert softAssert = new SoftAssert();

    String title = DriverFactory.getDriver().getTitle();

    System.out.println("Title = " + title);

    softAssert.assertTrue(
        title.contains("Google"),
        "Google title validation failed");

    softAssert.assertAll();
        log.info("Taking screenshot");

    ScreenshotUtils.captureScreenshot("GoogleSearch");

    log.info("Screenshot captured successfully");

    //Assert.fail("Retry Testing");

    DriverFactory.getDriver().manage().timeouts()
        .implicitlyWait(java.time.Duration.ofSeconds(10));
    }
}