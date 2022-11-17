package DB;

import java.sql.*;
import java.lang.String;

public class Read extends Conn {

    String DB_URL = getConfig()[0];
    String USER = getConfig()[1];
    String PASS = getConfig()[2];

    // Method untuk membaca data user
    public String[] bacaUser(String username) {
        // ntar bisa get data by Role / prodi
        String[] usr = new String[5];
        String getUser = "SELECT id, username, nama_lengkap, progdi, role FROM `users` WHERE `username` = ?;";
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement statement = connct.prepareStatement(getUser);)
        {
            statement.setString(1, username);
            ResultSet hasilKueri = statement.executeQuery();
            while(hasilKueri.next()){
                    usr[0] = hasilKueri.getString("username");
                    usr[1] = hasilKueri.getString("nama_lengkap");
                    usr[2] = hasilKueri.getString("progdi");
                    usr[3] = hasilKueri.getString("role");
                    usr[4] = hasilKueri.getString("id");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return usr;
    }

    public String bacaPassword(String username){
        String getUser = "SELECT `password` FROM `users` WHERE `username` = ?;";
        String pswd = "";
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement statement = connct.prepareStatement(getUser);){
            statement.setString(1, username);
            ResultSet hasilKueri = statement.executeQuery();
            while(hasilKueri.next()){
                pswd = hasilKueri.getString("password");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return pswd;
    }

    public void fetchAllUser(){
        System.out.format("+------+------------------------------+------------------------------------+---------------------------+--------------+%n");
        System.out.format("|  ID  |           USERNAME           |            NAMA LENGKAP            |       PROGRAM STUDI       |     ROLE     |%n");
        System.out.format("+------+------------------------------+------------------------------------+---------------------------+--------------+%n");
        
        String getUser = "SELECT id, username, nama_lengkap, progdi, role  FROM `users`;";
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement statement = connct.prepareStatement(getUser);){
            ResultSet hasilKueri = statement.executeQuery();
            while(hasilKueri.next()){
                String leftAlignFormat = "| %-4d | %-28s | %-34s | %-25s | %-12s |%n";
                
                System.out.format(leftAlignFormat, hasilKueri.getInt("id"), hasilKueri.getString("username"), hasilKueri.getString("nama_lengkap"), hasilKueri.getString("progdi"), hasilKueri.getString("role"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        System.out.format("+------+------------------------------+------------------------------------+---------------------------+--------------+%n");

    }

    public void fetchUserBy(String param, String value){
        System.out.format("+------+------------------------------+------------------------------------+---------------------------+--------------+%n");
        System.out.format("|  ID  |           USERNAME           |            NAMA LENGKAP            |       PROGRAM STUDI       |     ROLE     |%n");
        System.out.format("+------+------------------------------+------------------------------------+---------------------------+--------------+%n");
        
        String getUser = "SELECT id, username, nama_lengkap, progdi, role  FROM `users` WHERE " + param + " = ?;";
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connct.prepareStatement(getUser);)
        {
            statement.setString(1, value);
            
            ResultSet hasilKueri = statement.executeQuery();
            while(hasilKueri.next()){
                String leftAlignFormat = "| %-4d | %-28s | %-34s | %-25s | %-12s |%n";
                
                System.out.format(leftAlignFormat, hasilKueri.getInt("id"), hasilKueri.getString("username"), hasilKueri.getString("nama_lengkap"), hasilKueri.getString("progdi"), hasilKueri.getString("role"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        System.out.format("+------+------------------------------+------------------------------------+---------------------------+--------------+%n");

    }
    

    // Method untuk membaca data buku
    void sisaBuku(int jumlah, int dipinjam){
        int sisa = jumlah - dipinjam;
        System.out.println("Sisa buku: " + sisa + "\n");
    }

    public void bacaDatabaseBuku(){
        String getKatalog = "SELECT * FROM katalog";
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connct.createStatement();
        ResultSet hasilKueri = statement.executeQuery(getKatalog);){
                while(hasilKueri.next()){
                    System.out.println("Judul Buku = " + hasilKueri.getString("judul_buku") + "\nPengarang = " + hasilKueri.getString("nama_pengarang") + "\nTahun Terbit = " + hasilKueri.getString("tahun_terbit") + "\nSedang dipinjam = " + hasilKueri.getString("dipinjam"));

                    int jml = hasilKueri.getInt("jumlah_buku");
                    int dipinjam = hasilKueri.getInt("dipinjam");
                    sisaBuku(jml, dipinjam);

                }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }




}
