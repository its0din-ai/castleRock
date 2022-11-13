package Views;

import java.io.IOException;

public class Menu {

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

    public void menuAdmin(String name){
        System.out.println("Anda Login Sebagai " + name + "\n");
        System.out.println("Menu Admin");
        System.out.println("1. Tambah User");
        System.out.println("2. Lihat User");
        System.out.println("3. Tambah Buku");
        System.out.println("4. Lihat Buku");
        System.out.println("5. Pinjam Buku");
        System.out.println("6. Kembalikan Buku");
        System.out.println("7. Logout");
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
