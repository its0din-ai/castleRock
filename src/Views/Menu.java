package Views;

import Main.*;
import java.io.IOException;

public class Menu extends App {

    /**
       Method dibawah untuk menghapus / mereset terminal
       seperti semula (command: clear). Method ini akan
       menggunakan package System untuk mendapatkan informasi
       tentang nama OS, jika terdapat windows, maka akan
       menggunakan ProccessBuilder untuk menjalankan command
       'clear' di windows. Jika nama os tidak terdapat Windows
       maka akan menggunakan escape sequence (kode ASCII) untuk
       menghapus terminal '\033\143'
    */
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

    /**
       Method dibawah untuk melakukan Freeze pada program
       seperti halnya time.sleep() pada Python. Dengan
       menggunakan Thread, dan method sleep, maka program
       akan berhenti selama beberapa detik sesuai dengan
       parameter yang diberikan. Parameter secara default
       adalah milidetik, dan tinggal dikalikan dengan 1000
       agar menjadi detik
    */
    public static void sleep(double rawDetik){
        try {
            int detik = (int) (rawDetik * 1000);
            Thread.sleep(detik);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
       Method hanya digunakan untuk menampilkan Banner
       awal, yaitu sebuah Ascii Art dengan tulisan
       CastleRock
    */
    public static void bannerAwal(){
        
        System.out.println("   ▄████▄   ▄▄▄        ██████ ▄▄▄█████▓ ██▓    ▓█████  ██▀███   ▒█████   ▄████▄   ██ ▄█▀\n  ▒██▀ ▀█  ▒████▄    ▒██    ▒ ▓  ██▒ ▓▒▓██▒    ▓█   ▀ ▓██ ▒ ██▒▒██▒  ██▒▒██▀ ▀█   ██▄█▒ \n  ▒▓█    ▄ ▒██  ▀█▄  ░ ▓██▄   ▒ ▓██░ ▒░▒██░    ▒███   ▓██ ░▄█ ▒▒██░  ██▒▒▓█    ▄ ▓███▄░ \n  ▒▓▓▄ ▄██▒░██▄▄▄▄██   ▒   ██▒░ ▓██▓ ░ ▒██░    ▒▓█  ▄ ▒██▀▀█▄  ▒██   ██░▒▓▓▄ ▄██▒▓██ █▄ \n  ▒ ▓███▀ ░ ▓█   ▓██▒▒██████▒▒  ▒██▒ ░ ░██████▒░▒████▒░██▓ ▒██▒░ ████▓▒░▒ ▓███▀ ░▒██▒ █▄\n  ░ ░▒ ▒  ░ ▒▒   ▓▒█░▒ ▒▓▒ ▒ ░  ▒ ░░   ░ ▒░▓  ░░░ ▒░ ░░ ▒▓ ░▒▓░░ ▒░▒░▒░ ░ ░▒ ▒  ░▒ ▒▒ ▓▒\n    ░  ▒     ▒   ▒▒ ░░ ░▒  ░ ░    ░    ░ ░ ▒  ░ ░ ░  ░  ░▒ ░ ▒░  ░ ▒ ▒░   ░  ▒   ░ ░▒ ▒░\n  ░          ░   ▒   ░  ░  ░    ░        ░ ░      ░     ░░   ░ ░ ░ ░ ▒  ░        ░ ░░ ░ \n  ░ ░            ░  ░      ░               ░  ░   ░  ░   ░         ░ ░  ░ ░      ░  ░   \n  ░                                                                     ░               ");
        System.out.println("+                          Selamat Datang di CastleRock Library                          +");
        System.out.println("==========================================================================================");
    }

    /**
       Tiga method dibawah adalah method yang dipakai
       untuk Overriding pada Kelas Admin, Staff, dan Users
    */
    public void menuAdmin(String id, String name){
        System.out.println("Halo " + name + "!");
    }
    public void menuStaff(String id, String name){
        System.out.println("Halo " + name + "!");
    }
    public void menuUser(String id, String username, String name, String prodi){
        System.out.println("Halo " + name + "!");
    }


    /**
       Method hanya digunakan untuk menampilkan Banner
       Logout, yaitu sebuah Informasi bahwa user telah
       logout dan informasi tentang versi program
    */
    public static void bannerLogout(){
        System.out.println("==========================================");
        System.out.println("              Anda telah logout           ");
        System.out.println("==========================================");
        System.out.println("                ver.1.2-final             ");
        System.out.println("------------------------------------------");
    }

    


}
