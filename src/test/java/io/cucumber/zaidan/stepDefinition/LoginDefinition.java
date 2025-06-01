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

import java.util.List;

public class LoginDefinition {
    private LoginPageAction loginPageAction;
    private DashboardPageAction dashboardPageAction;

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

    @Then("Pengguna diarahkan ke halaman dashboard bendahara")
    public void penggunaDiarahkanKeHalamanDashboardBendahara() {
        dashboardPageAction = new DashboardPageAction();
        boolean isAtDashboard = dashboardPageAction.isAtDashboardBendahara();
        assertTrue(isAtDashboard, "Pengguna tidak diarahkan ke dashboard bendahara");
    }

    @And("Judul halaman yang tampil adalah {string}")
    public void judulHalamanYangTampilAdalah(String expectedTitle) {
        String actualTitle = dashboardPageAction.getPageTitle(); 
        assertEquals("Judul halaman tidak sesuai", expectedTitle, actualTitle);
    }

    @And("Menu navigasi samping menampilkan daftar berikut:")
    public void menuNavigasiSampingMenampilkanDaftarBerikut(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedItems = dataTable.asList();
        List<String> actualItems = dashboardPageAction.getSidebarMenuItems(); 

        // Validasi persis urutan dan isi
        assertEquals("Menu navigasi tidak sesuai", expectedItems, actualItems);
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
