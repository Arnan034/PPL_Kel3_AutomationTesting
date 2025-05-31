package io.cucumber.zaidan.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.zaidan.actions.LoginPageAction;
import io.cucumber.zaidan.utils.Driver;
import static org.junit.Assert.assertEquals;

public class LoginDefinition {
    private LoginPageAction loginPageAction;

    @Given("User telah membuka browser")
    public void userTelahMembukaBrowser() {
        Driver.setUpDriver();
        loginPageAction = new LoginPageAction();
    }

    @And("User navigasi ke login page dengan url {string}")
    public void userNavigasiKeLoginPage(String url) {
        Driver.openUrl(url);
    }

    @When("User memasukan form username dengan {string} dan password {string}")
    public void userMemasukanFormUsernameDanPassword(String username, String password) {
        loginPageAction.inputUsername(username);
        loginPageAction.inputPassword(password);
    }

    @And("User melakukan klik tombol login")
    public void userMelakukanKlikTombolLogin() {
        loginPageAction.clickLoginButton();
    }

    @Then("User harus dapat melihat pesan pemberitahuan {string}")
    public void userHarusDapatMelihatPesanPemberitahuan(String expectedMessage) {
        String actualMessage = loginPageAction.getErrorMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Browser ditutup")
    public void browserDitutup() {
        Driver.closeDriver();
    }
}
