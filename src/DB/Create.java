package DB;

import java.sql.*;
import java.lang.String;

import Auth.*;

public class Create extends Conn {

    String DB_URL = getConfig()[0];
    String USER = getConfig()[1];
    String PASS = getConfig()[2];

    // Method untuk menambahkan data user
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


    

}
