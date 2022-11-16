package Views;

import Main.*;
import java.util.Scanner;

import DB.*;

public class Admin extends Menu {
    
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
                menuTambahUsers();
                break;
            case "2":
                Menu.clearConsole();
                lihatUser();
                menuAdmin(name);
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


    protected void menuTambahUsers(){
        Scanner tambah = new Scanner(System.in);

        String username, password, nama_lengkap, progdi, role;

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
                Create tambahUsr = new Create();
                
                System.out.println("Menu Tambah User");
                System.out.println("Masukkan Username: ");
                username = tambah.nextLine();
                System.out.println("Masukkan Password: ");
                password = tambah.nextLine();
                System.out.println("Masukkan Nama Lengkap: ");
                nama_lengkap = tambah.nextLine();
                System.out.println("Masukkan Program Studi: ");
                progdi = tambah.nextLine();
                System.out.println("Masukkan Role: ");
                role = tambah.nextLine();

                tambahUsr.tambahUser(username, nama_lengkap, progdi, role, password);
                System.out.println("User " + username + " berhasil ditambahkan\n");
                Menu.sleep(1.5);
                Menu.clearConsole();
                menuTambahUsers();
                break;


            case "2":
                Menu.clearConsole();
                System.out.println("Menu Lihat User");
                lihatUser();
                menuTambahUsers();
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
                menuTambahUsers();
        break;
        }

    }


    protected void lihatUser(){
        Read fetch = new Read();
        fetch.fetchUser();
    }





}
