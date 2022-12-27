package DB;

import java.sql.*;
import java.lang.String;

import Auth.*;
import Views.Menu;

public class Create extends Conn {

    String DB_URL = getConfig()[0];
    String USER = getConfig()[1];
    String PASS = getConfig()[2];

    /**
       Method ini akan menambahkan data user baru kedalam database
       dengan parameter username, nama_lengkap, progdi, role, dan password.
       Password akan dienkripsi terlebih dahulu sebelum disimpan kedalam database
       dengan menggunakan method getMD5() yang tadi sudah dibuat.
       Setelah itu akan melakukan QUERY INSERT ke database dengan parameterBinding
       agar lebih aman dari SQL Injection
    */
    public void tambahUser(String username, String nama_lengkap, String progdi, String role, String password){
        Autentikasi auth = new Autentikasi();
        String passwordEncrptd = auth.getMd5(password);
        
        String QUERY = "INSERT INTO `users` (`id`, `tanggal_dibuat`, `username`, `password`, `nama_lengkap`, `progdi`, `role`) VALUES (NULL, CURRENT_TIMESTAMP, ?, ?, ?, ?, ?);";

        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connct.prepareStatement(QUERY);)
         {
            statement.setString(1, username);
            statement.setString(2, passwordEncrptd);
            statement.setString(3, nama_lengkap);
            statement.setString(4, progdi);
            statement.setString(5, role);
            
            System.out.println("SEDANG MENULIS DATA KEDALAM DB");
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }


    /**
       Method ini akan menambahkan data Buku baru kedalam database
       dengan parameter kategori, judul, bahasa, pengarang, tahun, dan maxBuku.
       Setelah itu akan melakukan QUERY INSERT ke database dengan parameterBinding
       agar lebih aman dari SQL Injection
    */
    public void tambahBuku(String kategori, String judul, String bahasa, String pengarang, int tahun, int maxBuku){
        
        String QUERY = "INSERT INTO `katalog` (`id`, `kategori`, `judul_buku`, `bahasa`, `nama_pengarang`, `tahun_terbit`, `max_buku`) VALUES (NULL, ?, ?, ?, ?, ?, ?);";

        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connct.prepareStatement(QUERY);)
         {
            statement.setString(1, kategori);
            statement.setString(2, judul);
            statement.setString(3, bahasa);
            statement.setString(4, pengarang);
            statement.setInt(5, tahun);
            statement.setInt(6, maxBuku);
            
            System.out.println("SEDANG MENULIS DATA KEDALAM DB");
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
       Method ini akan menambahkan data peminjaman buku ke database
       dengan parameter userID, dan bukuID
    */
    public void tambahInventori(String userID, String bukuID){
        String QUERY = "INSERT INTO `inventory` (`id_inventory`, `id_user`, `id_buku`) VALUES (NULL, ?, ?);";

        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connct.prepareStatement(QUERY);)
         {
            statement.setString(1, userID);
            statement.setString(2, bukuID);
            
            System.out.println("Meminjam Buku, mohon ditunggu...");
            Menu.sleep(2);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

}
