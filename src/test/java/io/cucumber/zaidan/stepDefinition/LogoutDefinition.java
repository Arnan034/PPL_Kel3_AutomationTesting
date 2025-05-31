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

    @And("User enters username {string}")
    public void userMemasukkanUsername(String username){
        loginPageAction.inputUsername(username);
    }

    @And("Enters password {string}")
    public void userMemasukkanPassword(String password){
        loginPageAction.inputPassword(password);
    }

    @And("Clicks on login button")
    public void userMengklikTombolLogin(){loginPageAction.clickLoginButton();}

    @And("User navigates to Dashboard page")


    @When("User clicks on logout button")

    @And("Clicks on logout confirmation pop up button")

    @Then("User should navigated to the Login page")
}