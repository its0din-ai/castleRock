package DB;

import java.sql.*;
import java.util.Scanner;
import java.lang.String;


public class Delete extends Conn {
    String DB_URL = getConfig()[0];
    String USER = getConfig()[1];
    String PASS = getConfig()[2];

    // Method untuk menambahkan data user
    public void deleteUsers(String id){
        Read byId = new Read();
        Scanner validasi = new Scanner(System.in);

        byId.fetchUserBy("id", id);

        if(id.equals("0")){
            System.out.println("ID 0 Immortal bang, gabisa dihapus!!");
            

        } else{
            System.out.println("Apakah anda yakin ingin menghapus data diatas? ([Y]/n)");
            String confirm = validasi.nextLine();

            switch(confirm.toLowerCase()){
                case "y" :
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
    
                case "n":
                    System.out.println("User Tidak jadi dihapus");
                    break;
    
                default:
                    QUERY = "DELETE FROM `users` WHERE `users`.`id` = ?;";
    
                    try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
                        PreparedStatement statement = connct.prepareStatement(QUERY);)
                    {
                        statement.setString(1, id);
                        
                        System.out.println("User dengan ID " + id + " Berhasil dihapus");
                        statement.executeUpdate();
            
                    } catch (SQLException e) {
                        e.printStackTrace();
                }
                    
            }
        }


    }



}
