package io.cucumber.zaidan.locators;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocator {
    
    @FindBy(name = "username")
    public WebElement usernameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    public WebElement loginButton;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div/div[2]/div/p")
    public WebElement errorMessage;
}
