package com.nikhil.banking.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nikhil.banking.base.BasePage;
import com.nikhil.banking.utils.WaitUtils;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement profileMenu;

    @FindBy(linkText = "Logout")
    WebElement logoutLink;

    public String getPageTitle() {

        return driver.getTitle();
    }

    public void logout() {

        WaitUtils.waitForElement(
                By.xpath("//span[@class='oxd-userdropdown-tab']"));

        profileMenu.click();

        WaitUtils.waitForElement(
                By.linkText("Logout"));

        logoutLink.click();
    }
}