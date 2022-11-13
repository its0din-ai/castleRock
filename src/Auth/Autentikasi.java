package Auth;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.Console;
import java.util.Scanner;

import DB.*;
import Views.*;

public class Autentikasi extends Read {
    public static String passwordInput() {        
        Console console = System.console();
        char[] passwordArray = console.readPassword("Password: ");
        return new String(passwordArray);
    }

    public static String getMd5(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean authDevMode(String username, String passInpt){
        Read passDb = new Read();
        String pass = passDb.bacaPassword(username);
        if(getMd5(passInpt).equals(pass)){
            return true;
        }
        else{
            return false;
        }
    }

    public String[] Login(){
        Scanner input = new Scanner(System.in);
        Read bacaUsr = new Read();
        String[] fail = new String[1];
        
        Menu.clearConsole();
        Menu.bannerAwal();
        System.out.println("Login");

        System.out.print("Username: ");
        String username = input.nextLine();
        String pass = passwordInput();
        input.close();
        
        if(authDevMode(username, pass)){
            String[] objUser = bacaUsr.bacaUser(username);
            System.out.println("Login Berhasil");
            return objUser;
        }
        else{
            return fail;
        }
    }


}
