package io.cucumber.zaidan.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import io.cucumber.zaidan.locators.DashboardPageLocator;
import io.cucumber.zaidan.utils.Driver;

public class DashboardPageAction {

    private DashboardPageLocator dashboardPageLocator;
    private WebDriverWait wait;

    public DashboardPageAction() {
        this.dashboardPageLocator = new DashboardPageLocator();
        PageFactory.initElements(Driver.getDriver(), dashboardPageLocator);
        this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }

    public boolean isAtDashboardBendahara() {
        wait.until(ExpectedConditions.visibilityOf(dashboardPageLocator.pageTitle));
        String titleText = dashboardPageLocator.pageTitle.getText();
        return titleText != null && titleText.contains("Dasbor - Bendahara");
    }

    public String getPageTitle() {
        wait.until(ExpectedConditions.visibilityOf(dashboardPageLocator.pageTitle));
        return dashboardPageLocator.pageTitle.getText().trim();
    }

    public List<String> getSidebarMenuItems() {
        wait.until(ExpectedConditions.visibilityOfAllElements(dashboardPageLocator.sidebarItems));
        return dashboardPageLocator.sidebarItems.stream()
                .map(item -> item.getText().trim())
                .collect(Collectors.toList());
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPageLocator.logoutButton));
        dashboardPageLocator.logoutButton.click();
    }

    public void clickLogoutConfirmationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPageLocator.logoutConfirmationButton));
        dashboardPageLocator.logoutConfirmationButton.click();
    }
}
