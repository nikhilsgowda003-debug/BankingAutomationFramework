package com.nikhil.banking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nikhil.banking.base.BasePage;
import com.nikhil.banking.utils.WaitUtils;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//p[contains(@class,'alert-content-text')]")
    WebElement errorMessage;

    public void login(String user, String pass) {

        WaitUtils.waitForElement(By.name("username"));

        username.clear();
        username.sendKeys(user);

        password.clear();
        password.sendKeys(pass);

        loginButton.click();
    }

    public String getErrorMessage() {

        WaitUtils.waitForElement(
                By.xpath("//p[contains(@class,'alert-content-text')]"));

        return errorMessage.getText();
    }
}