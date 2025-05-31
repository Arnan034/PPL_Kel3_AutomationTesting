Feature: Login

    Background:
        Given User telah membuka browser
        And User navigasi ke login page dengan url "http://ptbsp.ddns.net:6882"

    Scenario: Login berhasil menggunakan kredensial valid sebagai peran "bendahara"
        When Pengguna memasukkan username "bendahara"
            And Pengguna memasukkan password "admin123"
            And Pengguna menekan tombol login
        Then Pengguna diarahkan ke halaman dashboard bendahara
            And Judul halaman yang tampil adalah "Dasbor - Bendahara"
            And Menu navigasi samping menampilkan daftar berikut:
            | Dasbor                      |
            | Tagihan Siswa               |
            | Transaksi Penerimaan Dana   |
            | Pengaturan Notifikasi       |
            | Status Pembayaran           |
            | Rekapitulasi                |
            | Progres Transaksi Penerimaan Dana |

    @InvalidCredentials
    Scenario Outline: Login tidak berhasil dengan kredensial yang tidak valid, "<description>"
        When User memasukan form username dengan "<username>" dan password "<password>"
        And User melakukan klik tombol login
        Then User harus dapat melihat pesan pemberitahuan "Username atau password salah"

        Examples:
        | username   | password   | description                    |
        | indra      | admin123   | Username tidak terdaftar      |
        | admin      | admin12    | Password salah                |
 