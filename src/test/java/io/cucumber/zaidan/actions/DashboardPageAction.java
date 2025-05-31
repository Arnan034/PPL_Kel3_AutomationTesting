package io.cucumber.zaidan.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import io.cucumber.zaidan.locators.DashboardPageLocator;
import io.cucumber.zaidan.utils.Driver;

public class DashboardPageAction {

    private DashboardPageLocator dashboardPageLocator;
    private WebDriverWait wait;

    public DashboardPageAction() {

        this.dashboardPageLocator = new DashboardPageLocator;
        PageFactory.initElements(Driver.getDriver(), dashboardPageLocator);
        this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }

    public void clickLogoutButton(){
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPageLocator.logoutButton));
        dashboardPageLocator.logoutButton.click();
    }

    public void clickLogoutConfirmationButton(){
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPageLocator.logoutConfirmationButton));
        dashboardPageLocator.logoutConfirmationButton.click();
    }
}