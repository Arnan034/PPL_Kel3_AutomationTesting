package io.cucumber.zaidan.locators;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class DashboardPageLocator {

    @FindBy(xpath = "/html/body/div[2]/main/div/div[1]/div/div/div[2]/button")
    public WebElement logoutButton;

    @FindBy(xpath = "/html/body/div[4]/div[2]/button[2]")
    public WebElement logoutConfirmationButton;

    // Judul halaman di dashboard 
    @FindBy(xpath = "/html/body/div[2]/main/div/div[1]/div/div/div[1]/h1")
    public WebElement pageTitle;

    // Menu navigasi sidebar (list)
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/div") 
    public List<WebElement> sidebarItems;
}
