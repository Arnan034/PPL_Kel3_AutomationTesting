package io.cucumber.zaidan.locators;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class DashboardPageLocator {

    @FindBy(xpath = "/html/body/div[2]/main/div/div[1]/div/div/div[2]/button")
    public WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"radix-:r1f:\"]/div[2]/button[2]")
    public WebElement logoutConfirmationButton;
}