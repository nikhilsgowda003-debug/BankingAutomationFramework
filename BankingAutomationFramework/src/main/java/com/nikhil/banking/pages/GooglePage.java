package com.nikhil.banking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nikhil.banking.base.BasePage;

public class GooglePage extends BasePage {

    public GooglePage(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    WebElement searchBox;

    public void search(String text) {

        searchBox.sendKeys(text);
    }
}