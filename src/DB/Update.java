package DB;

import java.sql.*;
import java.lang.String;

import Views.Menu;
import Auth.*;

public class Update extends Conn {

    String DB_URL = getConfig()[0];
    String USER = getConfig()[1];
    String PASS = getConfig()[2];

    // Method untuk mengupdate data user
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

    // Method untuk mengupdate password user
    public void updatePassword(String id, String password_baru){
        Read byId = new Read();
        Autentikasi auth = new Autentikasi();
        String passwordBaruEncrptd = auth.getMd5(password_baru);

        String QUERY = "UPDATE `users` SET `password` = ? WHERE `users`.`id` = ?;";
    
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connct.prepareStatement(QUERY);)
        {
            statement.setString(1, passwordBaruEncrptd);
            statement.setString(2, id);
            
            statement.executeUpdate();
            
            Menu.clearConsole();
            System.out.println("Password berhasil di update, menjadi : " + password_baru + " (" + passwordBaruEncrptd + ")");
            byId.fetchUserBy("id", id);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method untuk mengupdate data Program Studi
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

    // Method untuk mengupdate data Role
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


    // Method untuk mengupdate Judul
    public void updateBuku(String param, String id, String value_baru){
        Read byId = new Read();
        String QUERY = "UPDATE `katalog` SET `" + param + "` = ? WHERE `katalog`.`id` = ?;";
    
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connct.prepareStatement(QUERY);)
        {
            statement.setString(1, value_baru);
            statement.setString(2, id);
            
            statement.executeUpdate();
            
            Menu.clearConsole();
            // System.out.println("Judul Buku berhasil di update, berikut hasilnya");
            // byId.printBukuBy("id", id);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






}
