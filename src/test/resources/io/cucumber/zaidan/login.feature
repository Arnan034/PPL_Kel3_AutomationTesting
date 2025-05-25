Feature: Login

    Background:
        Given User telah membuka browser
        And User navigasi ke login page dengan url "http://ptbsp.ddns.net:6882"
        And User tidak sedang login

    Scenario: Periksa apakah login tidak berhasil dengan kredensial yang tidak valid. Nama pengguna tidak terdaftar
        When User memasukan form username dengan "indra" dan password "admin123"
        And User melakukan klik tombol login
        Then User harus dapat melihat pesan pemberitahuan "Incorrect username or password, please try again!"

    Scenario: Periksa apakah login tidak berhasil dengan kata sandi tidak valid, kata sandinya salah
        When User memasukan form username dengan "admin" dan password "admin12"
        And User melakukan klik tombol login
        Then User harus dapat melihat pesan pemberitahuan "Incorrect username or password, please try again!"