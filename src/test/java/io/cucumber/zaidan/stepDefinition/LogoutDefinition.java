package io.cucumber.zaidan.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.zaidan.actions.DashboardPageAction;
import io.cucumber.zaidan.actions.LoginPageAction;
import io.cucumber.zaidan.utils.Driver;
import static org.junit.Assert.assertEquals;

public class LogoutDefinition {

    private LoginPageAction loginPageAction;
    private DashboardPageAction dashboardPageAction;


    @Given("User navigated to Login page")
    public void userTelahMembukaLoginPage() {
        Driver.setUpDriver();
        loginPageAction = new LoginPageAction();
        Driver.openUrl("http://ptbsp.ddns.net:6882");
    }
}