package io.cucumber.zaidan.StepDefinition;

import io.cucumber.java.en.*;

public class Login {

    @Given("User telah membuka browser")
    public void user_telah_membuka_browser() {
        System.out.println("Browser dibuka");
    }

    @And("User navigasi ke login page dengan url {string}")
    public void user_navigasi_ke_login_page(String url) {
        System.out.println("Navigasi ke: " + url);
    }

    @And("User tidak sedang login")
    public void user_tidak_sedang_login() {
        System.out.println("User tidak login");
    }

    @When("User memasukan form username dengan {string} dan password {string}")
    public void user_memasukkan_username_dan_password(String username, String password) {
        System.out.println("Username: " + username + ", Password: " + password);
    }

    @And("User melakukan klik tombol login")
    public void user_melakukan_klik_tombol_login() {
        System.out.println("Klik tombol login");
    }

    @Then("User harus dapat melihat pesan pemberitahuan {string}")
    public void user_melihat_pesan(String pesan) {
        System.out.println("Verifikasi pesan: " + pesan);
    }
}
