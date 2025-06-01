package io.cucumber.zaidan.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.zaidan.actions.DashboardPageAction;
import io.cucumber.zaidan.actions.LoginPageAction;
import io.cucumber.zaidan.utils.Driver;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void userDiarahkanKePageDashboard(){
        dashboardPageAction = new DashboardPageAction();
        boolean isAtDashboard = dashboardPageAction.isAtDashboardBendahara();
        assertTrue(isAtDashboard, "Pengguna tidak diarahkan ke dashboard bendahara");
    }

    @When("User clicks on logout button")
    public void userMengklikTombolLogout(){
        dashboardPageAction.clickLogoutButton();
        try {
            Thread.sleep(2000); // Jeda 2 detik (2000 milidetik)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("Clicks on logout confirmation pop up button")
    public void userMengklikTombolKonfirmasiLogout(){dashboardPageAction.clickLogoutConfirmationButton();}

    @Then("User should navigated to the Login page")
    public void userKembaliKeLoginPage(){assertTrue(loginPageAction.isLoginPageDisplayed());}
}