package DB;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.lang.String;


public class Read extends Conn {

    String DB_URL = getConfig()[0];
    String USER = getConfig()[1];
    String PASS = getConfig()[2];

    // Method untuk membaca data user berdasarkan username
    public String[] bacaUser(String username) {
        String[] usr = new String[6];
        String getUser = "SELECT id, username, nama_lengkap, progdi, role, password FROM `users` WHERE `username` = ?;";
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement statement = connct.prepareStatement(getUser);)
        {
            statement.setString(1, username);
            ResultSet hasilKueri = statement.executeQuery();
            while(hasilKueri.next()){
                usr[0] = hasilKueri.getString("id");
                usr[1] = hasilKueri.getString("username");
                usr[2] = hasilKueri.getString("nama_lengkap");
                usr[3] = hasilKueri.getString("progdi");
                usr[4] = hasilKueri.getString("role");
                usr[5] = hasilKueri.getString("password");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return usr;
    }

    // Method untuk mencetak List User keseluruhan
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


    // Method untuk mencetak List User berdasarkan parameter dan value tertentu
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
    
    // Method untuk mengembalikan nilai User berdasarkan parameter dan value tertentu
    public String returnUserBy(String param, String value){
        String result;
        
        String getUser = "SELECT id, username, nama_lengkap, progdi, role  FROM `users` WHERE " + param + " = ?;";
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connct.prepareStatement(getUser);)
        {
            statement.setString(1, value);
            
            ResultSet hasilKueri = statement.executeQuery();
            while(hasilKueri.next()){
                result = hasilKueri.getString(param);
                return result;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    

    // Method untuk membaca database buku yang ada di katalog
    public void bacaDatabaseBuku(){
        String getKatalog = "SELECT * FROM katalog";
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connct.createStatement();
        ResultSet hasilKueri = statement.executeQuery(getKatalog);){
                while(hasilKueri.next()){
                    int tersedia = hasilKueri.getInt("max_buku") - hasilKueri.getInt("dipinjam");

                    System.out.println("-----------------------------------------------------------------------------------------------------------------");
                    System.out.println("[*] ID Buku              :: " + hasilKueri.getInt("id"));
                    System.out.println("[*] Kategori             :: " + hasilKueri.getString("kategori"));
                    System.out.println("[*] Judul Buku           :: " + hasilKueri.getString("judul_buku"));
                    System.out.println("[*] Bahasa               :: " + hasilKueri.getString("bahasa"));
                    System.out.println("[*] Pengarang Buku       :: " + hasilKueri.getString("nama_pengarang"));
                    System.out.println("[*] Tahun Terbit Buku    :: " + hasilKueri.getInt("tahun_terbit"));
                    System.out.println("[*] Jumlah Tersedia      :: " + tersedia + " Buku");
                }
                System.out.println("-----------------------------------------------------------------------------------------------------------------");
            }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    // Method untuk mengembalikan nilai buku berdasarkan parameter dan value tertentu
    public String returnBukuBy(String param, String value){
        String result;
        
        String getKatalog = "SELECT * FROM katalog WHERE " + param + " = ?;";
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connct.prepareStatement(getKatalog);)
        {
            statement.setString(1, value);
            
            ResultSet hasilKueri = statement.executeQuery();
            while(hasilKueri.next()){
                result = hasilKueri.getString(param);
                return result;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public void printBukuBy(String param, String value){
        // String result;
        
        String getKatalog = "SELECT * FROM katalog WHERE " + param + " = ?;";
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connct.prepareStatement(getKatalog);)
        {
            statement.setString(1, value);
            
            ResultSet hasilKueri = statement.executeQuery();
            while(hasilKueri.next()){
                int tersedia = hasilKueri.getInt("max_buku") - hasilKueri.getInt("dipinjam");

                System.out.println("-----------------------------------------------------------------------------------------------------------------");
                System.out.println("[*] ID Buku              :: " + hasilKueri.getInt("id"));
                System.out.println("[*] Kategori             :: " + hasilKueri.getString("kategori"));
                System.out.println("[*] Judul Buku           :: " + hasilKueri.getString("judul_buku"));
                System.out.println("[*] Bahasa               :: " + hasilKueri.getString("bahasa"));
                System.out.println("[*] Pengarang Buku       :: " + hasilKueri.getString("nama_pengarang"));
                System.out.println("[*] Tahun Terbit Buku    :: " + hasilKueri.getInt("tahun_terbit"));
                System.out.println("[*] Jumlah Tersedia      :: " + tersedia + " Buku");
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }


    // ntar dipindah
    public String modulLocale(String tanggal){
        Locale localeID = new Locale("id", "ID");
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", localeID);
        java.sql.Date tanggalSql = java.sql.Date.valueOf(tanggal);  

        Date tgl = new Date(tanggalSql.getTime());
        String tanggalIndonesia = sdf.format(tgl);

        return tanggalIndonesia;
    }



    // Baca Inventori
    public void printInventory(String user_id){
        String getKatalog = "SELECT id_buku, DATE(tanggal_pinjam) FROM `inventory` WHERE id_user = ?;";
        try(Connection connct = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = connct.prepareStatement(getKatalog);)
        {
            statement.setString(1, user_id);
            ResultSet hasilKueri = statement.executeQuery();

            System.out.println("Inventori Buku Anda");

            while(hasilKueri.next()){
                String tgls = hasilKueri.getString("DATE(tanggal_pinjam)");
                String id_buku = hasilKueri.getString("id_buku");
                String getBuku = "SELECT * FROM katalog WHERE id = ?;";
                try(Connection connct2 = DriverManager.getConnection(DB_URL, USER, PASS);
                    PreparedStatement statement2 = connct2.prepareStatement(getBuku);)
                {
                    statement2.setString(1, id_buku);
                    ResultSet hasilKueri2 = statement2.executeQuery();

                    while(hasilKueri2.next()){
                        System.out.println("-----------------------------------------------------------------------------------------------------------------");
                        System.out.println("[*] Tanggal Pinjam       :: " + modulLocale(tgls));
                        System.out.println("[*] Kategori             :: " + hasilKueri2.getString("kategori"));
                        System.out.println("[*] Judul Buku           :: " + hasilKueri2.getString("judul_buku"));
                        System.out.println("[*] Bahasa               :: " + hasilKueri2.getString("bahasa"));
                        System.out.println("[*] Pengarang Buku       :: " + hasilKueri2.getString("nama_pengarang"));
                        System.out.println("[*] Tahun Terbit Buku    :: " + hasilKueri2.getInt("tahun_terbit"));

                    }
                } catch(SQLException e){
                    e.printStackTrace();
                }

            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }



}
