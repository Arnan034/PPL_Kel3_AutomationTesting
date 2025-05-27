Feature: Login

    Background:
        Given User telah membuka browser
        And User navigasi ke login page dengan url "http://ptbsp.ddns.net:6882"
        And User tidak sedang login
    
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

    Scenario: Periksa apakah login tidak berhasil dengan kredensial yang tidak valid. Nama pengguna tidak terdaftar
        When User memasukan form username dengan "indra" dan password "admin123"
        And User melakukan klik tombol login
        Then User harus dapat melihat pesan pemberitahuan "Incorrect username or password, please try again!"

    Scenario: Periksa apakah login tidak berhasil dengan kata sandi tidak valid, kata sandinya salah
        When User memasukan form username dengan "admin" dan password "admin12"
        And User melakukan klik tombol login
        Then User harus dapat melihat pesan pemberitahuan "Incorrect username or password, please try again!"
 