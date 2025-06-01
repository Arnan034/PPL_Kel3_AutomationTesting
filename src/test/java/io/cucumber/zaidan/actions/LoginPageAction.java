package io.cucumber.zaidan.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;

import io.cucumber.zaidan.locators.LoginPageLocator;
import io.cucumber.zaidan.utils.Driver;

public class LoginPageAction {
    
    private LoginPageLocator loginPageLocator;
    private WebDriverWait wait;

    public LoginPageAction() {
        // Initialize the locator for the login page
        this.loginPageLocator = new LoginPageLocator();
        
        // Use PageFactory to initialize the elements in the locator
        PageFactory.initElements(Driver.getDriver(), loginPageLocator);
        this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }

    public void inputUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(loginPageLocator.usernameInput));
        loginPageLocator.usernameInput.clear();
        loginPageLocator.usernameInput.sendKeys(username);
    }

    public void inputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(loginPageLocator.passwordInput));
        loginPageLocator.passwordInput.clear();
        loginPageLocator.passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPageLocator.loginButton));
        loginPageLocator.loginButton.click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(loginPageLocator.errorMessage));
        return loginPageLocator.errorMessage.getText();
    }

    public boolean isLoginPageDisplayed() {
        try {
            return wait.until(ExpectedConditions.urlToBe("http://ptbsp.ddns.net:6882/login"));
        } catch (TimeoutException e) {
            return false;
        }
    }
}
