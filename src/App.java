import DB.*;
import Auth.*;

import java.util.Scanner;
import java.io.Console;

public class App {
    public static String blankPassInput() {        
        Console console = System.console();
        // if (console == null) {
        //     System.out.println("Maap, gaada console yg bisa dibuka");
        //     System.exit(0);
        // }
        char[] passwordArray = console.readPassword("Password: ");
        return new String(passwordArray);
    }

    public static void main(String[] args) throws Exception {
        Read read = new Read();
        Autentikasi authDev = new Autentikasi();
        Scanner input = new Scanner(System.in);

        System.out.println("Selamat datang di CastleRock Library!");
        System.out.println("Silahkan login terlebih dahulu");
        System.out.print("Username: ");
        String username = input.nextLine();
        String pass = blankPassInput();

        if(authDev.authDevMode(username, pass)){
            System.out.println("-------------------");
            System.out.println("Selamat datang " + username);
            System.out.println("-------------------");
            read.bacaDatabaseBuku();
            read.bacaDatabaseUsers();
        }
        else{
            System.out.println("-------------------");
            System.out.println("Maap, elu siape ngab??");
        }

        input.close();
    }
}
