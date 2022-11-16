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

    public static void bannerAwal(){
        System.out.println("===================================");
        System.out.println(" Selamat Datang di Citadel Library");
        System.out.println("===================================");
    }

    public static void bannerLogout(){
        System.out.println("===============================");
        System.out.println("       Anda telah logout");
        System.out.println("===============================");
        System.out.println("     ver.0.1-dev encrypt0r");
        System.out.println("-------------------------------");
    }

    

    public void menuStaff(String name, String prodi){
        System.out.println("Anda Login Sebagai " + name);
        System.out.println("Program Studi " + prodi + "\n");
        System.out.println("Menu Staff");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Lihat Buku");
        System.out.println("3. Pinjam Buku");
        System.out.println("4. Kembalikan Buku");
        System.out.println("5. Logout");
    }

    public void menuUser(String name, String prodi){
        System.out.println("Anda Login Sebagai " + name);
        System.out.println("Program Studi " + prodi + "\n");
        System.out.println("Menu Mahasiswa");
        System.out.println("1. Lihat Buku");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Kembalikan Buku");
        System.out.println("4. Logout");
    }
}
