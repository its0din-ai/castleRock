package Views;

import Main.*;

import java.io.IOException;
import java.util.Scanner;

import DB.Read;

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
        System.out.println("    ver.0.0.1-dev encrypt0r");
        System.out.println("-------------------------------");
    }

    public void menuAdmin(String name){
        Scanner menu = new Scanner(System.in);

        System.out.println("Anda Login Sebagai " + name + "\n");
        System.out.println("Menu Admin");
        System.out.println("1. Tambah User");
        System.out.println("2. Lihat User");
        System.out.println("3. Tambah Buku");
        System.out.println("4. Lihat Buku");
        System.out.println("5. Pinjam Buku");
        System.out.println("6. Kembalikan Buku");
        System.out.println("7. Logout");
        System.out.println("===================================");
        System.out.println("Masukkan pilihan anda: ");
        String inputPilihan = menu.nextLine();

        switch(inputPilihan){
            case "1":
                Menu.clearConsole();
                tambahUser();
                break;
            case "2":
                Menu.clearConsole();
                lihatUser();
                break;
            case "3":
                Menu.clearConsole();
                System.out.println("Menu Tambah Buku");
                break;
            case "4":
                Menu.clearConsole();
                System.out.println("Menu Lihat Buku");
                break;
            case "5":
                Menu.clearConsole();
                System.out.println("Menu Pinjam Buku");
                break;
            case "6":
                Menu.clearConsole();
                System.out.println("Menu Kembalikan Buku");
                break;
            case "7":
                Menu.clearConsole();
                Menu.bannerLogout();
                System.exit(0);
            default:
                System.out.println("Pilihan tidak tersedia");
                super.sleep(1);
                super.mainMenu(App.users);
        break;
        }
        

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

    protected void tambahUser(){
        Scanner tambah = new Scanner(System.in);
        Operation ops = new Operation();


        System.out.println("Menu Tambah User");
        System.out.println("1. Tambah User");
        System.out.println("2. Lihat User");
        System.out.println("3. Edit User");
        System.out.println("4. Hapus User");
        System.out.println("5. Kembali");
        System.out.println("===================================");
        System.out.println("Masukkan pilihan anda: ");
        String inputPilihan = tambah.nextLine();
        switch(inputPilihan){
            case "1":
                Menu.clearConsole();
                System.out.println("ISI ID USER & QUERY KE DB,\nSETELAH SUKSES BALIK KE MENU TAMBAH USER");
                ops.tambah();
                break;
            case "2":
                Menu.clearConsole();
                System.out.println("Menu Lihat User");
                break;
            case "3":
                Menu.clearConsole();
                System.out.println("Menu Edit User");
                break;
            case "4":
                Menu.clearConsole();
                System.out.println("Menu Hapus User");
                break;
            case "5":
                Menu.clearConsole();
                System.out.println("Kembali");
                super.mainMenu(App.users);
                break;
            default:
                System.out.println("Pilihan tidak tersedia !");
                super.sleep(1);
                Menu.clearConsole();
                tambahUser();
        break;
        }
    }

    protected void lihatUser(){
        Read fetch = new Read();

        fetch.fetchUser();

    }

}
