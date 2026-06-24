package com.nikhil.banking.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.nikhil.banking.base.DriverFactory;

public class ScreenshotUtils {

    public static void captureScreenshot(String fileName) {

        TakesScreenshot ts =
                (TakesScreenshot) DriverFactory.getDriver();

        File source =
                ts.getScreenshotAs(OutputType.FILE);

        File destination =
                new File("screenshots/" + fileName + ".png");

        try {

            FileUtils.copyFile(source, destination);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String captureScreenshotForReport(String fileName) {

        try {

            TakesScreenshot ts =
                    (TakesScreenshot) DriverFactory.getDriver();

            File source =
                    ts.getScreenshotAs(OutputType.FILE);

            String path =
                    "screenshots/" + fileName + ".png";

            File destination =
                    new File(path);

            FileUtils.copyFile(source, destination);

            return destination.getAbsolutePath();

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }
}