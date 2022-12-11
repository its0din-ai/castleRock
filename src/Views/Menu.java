package Views;

import Main.*;
import java.io.IOException;

public class Menu extends App {

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {

        }
    }

    // Method untuk sleep
    public static void sleep(double rawDetik){
        try {
            int detik = (int) (rawDetik * 1000);
            Thread.sleep(detik);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void bannerAwal(){
        
        System.out.println(" ▄████▄   ▄▄▄        ██████ ▄▄▄█████▓ ██▓    ▓█████  ██▀███   ▒█████   ▄████▄   ██ ▄█▀\n▒██▀ ▀█  ▒████▄    ▒██    ▒ ▓  ██▒ ▓▒▓██▒    ▓█   ▀ ▓██ ▒ ██▒▒██▒  ██▒▒██▀ ▀█   ██▄█▒ \n▒▓█    ▄ ▒██  ▀█▄  ░ ▓██▄   ▒ ▓██░ ▒░▒██░    ▒███   ▓██ ░▄█ ▒▒██░  ██▒▒▓█    ▄ ▓███▄░ \n▒▓▓▄ ▄██▒░██▄▄▄▄██   ▒   ██▒░ ▓██▓ ░ ▒██░    ▒▓█  ▄ ▒██▀▀█▄  ▒██   ██░▒▓▓▄ ▄██▒▓██ █▄ \n▒ ▓███▀ ░ ▓█   ▓██▒▒██████▒▒  ▒██▒ ░ ░██████▒░▒████▒░██▓ ▒██▒░ ████▓▒░▒ ▓███▀ ░▒██▒ █▄\n░ ░▒ ▒  ░ ▒▒   ▓▒█░▒ ▒▓▒ ▒ ░  ▒ ░░   ░ ▒░▓  ░░░ ▒░ ░░ ▒▓ ░▒▓░░ ▒░▒░▒░ ░ ░▒ ▒  ░▒ ▒▒ ▓▒\n  ░  ▒     ▒   ▒▒ ░░ ░▒  ░ ░    ░    ░ ░ ▒  ░ ░ ░  ░  ░▒ ░ ▒░  ░ ▒ ▒░   ░  ▒   ░ ░▒ ▒░\n░          ░   ▒   ░  ░  ░    ░        ░ ░      ░     ░░   ░ ░ ░ ░ ▒  ░        ░ ░░ ░ \n░ ░            ░  ░      ░               ░  ░   ░  ░   ░         ░ ░  ░ ░      ░  ░   \n░                                                                     ░               ");
        System.out.println("+                          Selamat Datang di CastleRock Library                          +");
        System.out.println("==========================================================================================");
    }

    public static void bannerLogout(){
        System.out.println("==========================================");
        System.out.println("             Anda telah logout");
        System.out.println("==========================================");
        System.out.println("           ver.0.7-dev encrypt0r");
        System.out.println("------------------------------------------");
    }

    


}
