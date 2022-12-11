package DB;

import java.sql.*;
import java.util.Scanner;

import Views.Menu;

import java.lang.String;

public class Delete extends Conn {
    
    String DB_URL = getConfig()[0];
    String USER = getConfig()[1];
    String PASS = getConfig()[2];

    // Method untuk menghapus data user
    public void deleteUsers(String id){
        Read byId = new Read();
        Scanner konfirmasi = new Scanner(System.in);

        byId.fetchUserBy("id", id);

        if(id.equals("0")){
            System.out.println("ID 0 Immortal bang, gabisa dihapus!!");
        } else{
            System.out.println("Apakah anda yakin ingin menghapus data diatas? ([Y]/n)");
            String confirm = konfirmasi.nextLine();

            switch(confirm.toLowerCase()){
                case "y":
                    String QUERY = "DELETE FROM `users` WHERE `users`.`id` = ?;";
    
                    try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
                        PreparedStatement statement = connct.prepareStatement(QUERY);)
                    {
                        statement.setString(1, id);
                        
                        System.out.println("User dengan ID " + id + " Berhasil dihapus");
                        statement.executeUpdate();
            
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
    
                case "n":
                    System.out.println("User Tidak jadi dihapus");
                    break;
    
                case "":
                    System.out.println("Command salah!");
                    break;
            }
        }
    }

    public void deleteBuku(String id){
        Read print = new Read();
        Scanner konfirmasi = new Scanner(System.in);

        Menu.clearConsole();
        print.printBukuBy("id", id);

        System.out.println("Apakah anda yakin ingin menghapus Buku diatas? ([Y]/n)");
        String confirm = konfirmasi.nextLine();

        switch(confirm.toLowerCase()){
            case "y":
                String QUERY = "DELETE FROM `katalog` WHERE `katalog`.`id` = ?;";

                try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
                    PreparedStatement statement = connct.prepareStatement(QUERY);)
                {
                    statement.setString(1, id);
                    
                    System.out.println("Buku dengan ID " + id + " Berhasil dihapus");
                    statement.executeUpdate();
        
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "n":
                System.out.println("Buku Tidak jadi dihapus");
                break;

            case "":
                System.out.println("Command salah!");
                break;
        }
    }



}
