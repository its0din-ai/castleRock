package Auth;

// Package Java
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

// Local Package
import DB.*;
import Views.*;

public class Autentikasi {
    
    /**
       Method dibawah ini akan mengambil input username dan password
       username diambil menggunakan Java Scanner biasa, sedangkan password
       diambil menggunakan Java Console, sehingga karakter yang diinput tidak
       akan terlihat di layar (seperti menginput password di terminal linux)
    */

    /**
       Setelah mengambil data dari User, maka akan dibangingkan dengan data
       yang ada di database. Jika data cocok, maka akan mengembalikan data
       user dalam bentuk array String. Jika tidak cocok, maka akan mengurangi
       jumlah percobaan login yang tersisa, dan jika percobaan login sudah
       habis, maka akan keluar dari program.
    */
    public String[] Login() throws IOException {
        Scanner usrnm = new Scanner(System.in);
        Read bacaUsr = new Read();

        String[] objUser = new String[4];
        int coba = 3;
        
        while(coba > 0){
            Menu.clearConsole();
            Menu.bannerAwal();

            System.out.println("Percobaan login anda tersisa " + coba + " kali");
            System.out.print("Username: ");
            String username = usrnm.nextLine();
            String pass = passwordInput();
            
            if(comparePassword(username, pass)){
                objUser = bacaUsr.bacaUser(username);
                System.out.println("Login Berhasil, anda masuk sebagai " + objUser[1]);
                return objUser;
            } else{
                coba--;
                if(coba == 0){
                    System.out.println("\nLogin Gagal, Anda telah mencapai batas percobaan");
                    System.out.println("Silahkan hubungi Admin untuk pembuatan akun\natau melaporkan perihal kesalahan pada Akun!\n");
                    Menu.bannerLogout();
                    System.exit(0);
                }
            }
        }

        return objUser;
    }


    /**
       Method dibawah ini akan mengambil input password dari user dengan cara
       menghilangkan karakter yang diinput dari layar. Dengan menggunakan
       Console, dan method readPassword(), maka karakter yang diinput tidak
       akan terlihat di layar. dan karena method readPassword() mengembalikan
       data dalam bentuk char[], maka harus diubah ke String terlebih dahulu
     * @throws IOException 
    */
    private String passwordInput() throws IOException {      
    	
        Console console = System.console();
        
        // Inputan password dari dalam Eclipse IDE
        if (console==null) {
            System.out.print("Password: ");
            InputStream in=System.in;
            int max=50;
            byte[] b=new byte[max];

            int l= in.read(b);
            l--;//last character is \n
            if (l>0) {
                byte[] e=new byte[l];
                System.arraycopy(b,0, e, 0, l);
                return new String(e);
            } else {
                return null;
            }
        } 
        
        // Inputan password dari Terminal (diluar Eclipse IDE)
        else {
            return new String(console.readPassword("Password: "));
        }
    }
    


    /**
       Method comparePassword() akan membandingkan password yang diinput
       dengan password yang ada di database. Caranya, password yang diinput
       akan dienkripsi ke MD5 dahulu, dan selanjutnya akan dibandingkan
       dengan MD5 yang ada di database. Jika cocok, maka akan mengembalikan
       nilai true, jika tidak, maka akan mengembalikan nilai false
    */
    private boolean comparePassword(String username, String passInpt) {
        Read passDb = new Read();
        String pass = passDb.bacaUser(username)[5];
        
        if(getMd5(passInpt).equals(pass)){
            return true;
        } else{
            return false;
        }
    }

    /**
       Method ini adalah method untuk melakukan Enkripsi data kedalam
       Algoritma MD5 dengan menggunakan Java MessageDigest. Method ini
       akan mengembalikan nilai String yang sudah dienkripsi ke MD5
    */
    public String getMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            
            return hashtext;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
