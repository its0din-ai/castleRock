package Auth;

// Package Java
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.Console;
import java.util.Scanner;

// Local Package
import DB.*;
import Views.*;

public class Autentikasi extends Read {
    // Constructor Login
    public String[] Login() {
        Scanner usrnm = new Scanner(System.in);
        Read bacaUsr = new Read();

        String[] objUser = new String[4];
        int coba = 3;
        
        while(coba > 0){
            Menu.clearConsole();
            Menu.bannerAwal();

            System.out.println("Percobaan login maksimum adalah " + coba + " kali");
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

    // Method untuk mengambil input password tanpa menampilkan karakter
    private String passwordInput() {        
        Console console = System.console();
        char[] passwordArray = console.readPassword("Password: ");
        return new String(passwordArray);
    }

    // Method untuk mengenkripsi password menggunakan algoritma MD5
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

    // Method untuk membandingkan password yang diinput dengan password yang ada di database
    private boolean comparePassword(String username, String passInpt) {
        Read passDb = new Read();
        String pass = passDb.bacaPassword(username);

        if(getMd5(passInpt).equals(pass)){
            return true;
        } else{
            return false;
        }
    }
}
