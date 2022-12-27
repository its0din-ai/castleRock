package DB;

import java.sql.*;
import java.lang.String;

import Views.Menu;
import Auth.*;

public class Update extends Conn {

    String DB_URL = getConfig()[0];
    String USER = getConfig()[1];
    String PASS = getConfig()[2];

    /**
       Method dibawah untuk mengupdate data user
       dengan parameter param, id, dan value_baru
       dimana param adalah kolom dari table yang
       akan di update
    */
    public void updateUser(String param, String id, String value_baru){
        Read byId = new Read();
        String QUERY = "UPDATE `users` SET `"+ param +"` = ? WHERE `users`.`id` = ?;";
    
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connct.prepareStatement(QUERY);)
        {
            statement.setString(1, value_baru);
            statement.setString(2, id);
            
            statement.executeUpdate();
            
            Menu.clearConsole();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
       Method dibawah untuk mengupdate password user
       dengan parameter id dan password_baru
    */
    public void updatePassword(String id, String password_baru){
        Autentikasi auth = new Autentikasi();
        String passwordBaruEncrptd = auth.getMd5(password_baru);

        String QUERY = "UPDATE `users` SET `password` = ? WHERE `users`.`id` = ?;";
    
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connct.prepareStatement(QUERY);)
        {
            statement.setString(1, passwordBaruEncrptd);
            statement.setString(2, id);
            
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
       Method dibawah untuk mengupdate data program studi
       user dengan parameter id dan progdi_baru
    */
    public void updateProgdi(String id, String progdi_baru){
        Read byId = new Read();
        String QUERY = "UPDATE `users` SET `progdi` = ? WHERE `users`.`id` = ?;";
    
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connct.prepareStatement(QUERY);)
        {
            statement.setString(1, progdi_baru);
            statement.setString(2, id);
            
            statement.executeUpdate();
            
            Menu.clearConsole();
            System.out.println("Program Studi berhasil di update, berikut hasilnya");
            byId.fetchUserBy("id", id);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
       Method dibawah untuk mengupdate role user
       dengan parameter id dan role_baru
    */
    public void updateRole(String id, String role_baru){
        Read byId = new Read();
        String QUERY = "UPDATE `users` SET `role` = ? WHERE `users`.`id` = ?;";
    
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connct.prepareStatement(QUERY);)
        {
            statement.setString(1, role_baru);
            statement.setString(2, id);
            
            statement.executeUpdate();
            
            Menu.clearConsole();
            System.out.println("Role Pengguna berhasil di update, berikut hasilnya");
            byId.fetchUserBy("id", id);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
       Method dibawah untuk mengupdate Buku di katalog
       dengan parameter param, id, dan value_baru
       dimana param adalah kolom dari table yang
       akan di update
    */
    public void updateBuku(String param, String id, String value_baru){
        // Read byId = new Read();
        String QUERY = "UPDATE `katalog` SET `" + param + "` = ? WHERE `katalog`.`id` = ?;";
    
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connct.prepareStatement(QUERY);)
        {
            statement.setString(1, value_baru);
            statement.setString(2, id);
            statement.executeUpdate();
            
            Menu.clearConsole();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
