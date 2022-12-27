package DB;

import java.sql.*;
import java.util.Scanner;

import Views.Menu;

import java.lang.String;

public class Delete extends Conn {
    
    String DB_URL = getConfig()[0];
    String USER = getConfig()[1];
    String PASS = getConfig()[2];

    /**
       Method ini akan menghapus data users dari dalam database
       dengan parameter id. Setelah itu akan melakukan QUERY DELETE
       ke database dengan parameterBinding agar lebih aman dari SQL Injection

       Pertama, method ini akan memanggil method fetchUserBy() dari class Read
       untuk menampilkan data user yang akan dihapus. Kemudian, akan menampilkan
       konfirmasi apakah user yakin ingin menghapus data tersebut. Jika user
       memilih y, maka akan dilakukan proses penghapusan data user dari database.
       Jika user memilih n, maka akan menampilkan pesan bahwa user tidak jadi menghapus data.
       Jika user tidak memilih apapun, maka akan menampilkan pesan bahwa command salah.
    */
    public void deleteUsers(String id){
        Read byId = new Read();
        Scanner konfirmasi = new Scanner(System.in);

        byId.fetchUserBy("id", id);

        if(id.equals("0")){
            System.out.println("ID 0 Immortal bang, gabisa dihapus!!");
        } else{
            System.out.println("Apakah anda yakin ingin menghapus data diatas? (Y/n)");
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


    /**
       Method ini akan menghapus data buku dari dalam database
       dengan parameter id. Setelah itu akan melakukan QUERY DELETE
       ke database dengan parameterBinding agar lebih aman dari SQL Injection

       Pertama, method ini akan memanggil method fetchBukuBy() dari class Read
       untuk menampilkan data buku yang akan dihapus. Kemudian, akan menampilkan
       konfirmasi apakah buku tersebut ingindihapus. Jika user memilih y,
       maka akan dilakukan proses penghapusan data buku dari database.
       Jika user memilih n, maka akan menampilkan pesan bahwa buku tidak jadi menghapus data.
       Jika user tidak memilih apapun, maka akan menampilkan pesan bahwa command salah.
    */
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

    /**
       Method ini akan menghapus data inventori peminjaman buku dari
       dalam database. sehingga seperti buku tersebut sudah dikembalikan

       Method ini akan menggunakan idInven sebagai parameter untuk menghapus
       data inventori dari database. Setelah itu akan melakukan QUERY DELETE
       ke database dengan parameterBinding agar lebih aman dari SQL Injection
    */
    public void kurangiInventori(String idInven){
        String QUERY = "DELETE FROM `inventory` WHERE `inventory`.`id_inventory` = ?;";

        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connct.prepareStatement(QUERY);)
            {
            statement.setString(1, idInven);
            
            System.out.println("Mengembalikan Buku, mohon ditunggu...");
            Menu.sleep(2);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
