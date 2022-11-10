package DB;

import java.sql.*;
import java.lang.String;

public class Read {
    void sisaBuku(int jumlah, int dipinjam){
        int sisa = jumlah - dipinjam;
        System.out.println("Sisa buku: " + sisa + "\n");
    }

    public void bacaDatabaseBuku(){
        String getKatalog = "SELECT * FROM katalog";
        try(Connection connct = DriverManager.getConnection(Conn.DB_URL, Conn.USER, Conn.PASS);
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

    public void bacaDatabaseUsers(){
        // ntar bisa get data by Role / prodi
        String getUser = "SELECT `username`, `nama_lengkap`, `progdi`, `role` FROM `users`";
        try(Connection connct = DriverManager.getConnection(Conn.DB_URL, Conn.USER, Conn.PASS);
        Statement statement = connct.createStatement();
        ResultSet hasilKueri = statement.executeQuery(getUser);){
                while(hasilKueri.next()){
                    System.out.println("Username = " + hasilKueri.getString("username") + "\nNama = " + hasilKueri.getString("nama_lengkap") + "\nProdi = " + hasilKueri.getString("progdi") + "\nRole = " + hasilKueri.getString("role") + "\n");
                }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public String bacaDatabasePassword(String username){
        String getUser = "SELECT `password` FROM `users` WHERE `username` = ?;";
        String pswd = "";
        try(Connection connct = DriverManager.getConnection(Conn.DB_URL, Conn.USER, Conn.PASS);
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
}
