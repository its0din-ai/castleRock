package Views;

import Main.*;
import java.util.Scanner;

import DB.*;

public class Admin extends Menu {
    
    public void menuAdmin(String name){
        Scanner menu = new Scanner(System.in);

        System.out.println("Anda Login Sebagai " + name + "\n");
        System.out.println("Menu Admin");
        System.out.println("1. Manage User");
        System.out.println("2. Manage Buku");
        System.out.println("3. Lihat Buku");
        System.out.println("4. Pinjam Buku");
        System.out.println("5. Kembalikan Buku");
        System.out.println("6. Logout");
        System.out.println("===================================");
        System.out.println("Masukkan pilihan anda: ");
        String inputPilihan = menu.nextLine();

        switch(inputPilihan){
            case "1":
                Menu.clearConsole();
                manageUsers();
                break;
            case "2":
                System.out.println("Menu Manage Buku");
                Menu.clearConsole();
                break;
            case "3":
                Menu.clearConsole();
                System.out.println("Menu Liat Katalog Buku");
                break;
            case "4":
                Menu.clearConsole();
                System.out.println("Menu Pinjam Buku");
                break;
            case "5":
                Menu.clearConsole();
                System.out.println("Menu Kembalikan Buku");
                break;
            case "6":
                Menu.clearConsole();
                Menu.bannerLogout();
                System.exit(0);
            default:
                System.out.println("Pilihan tidak tersedia");
                sleep(1);
                super.mainMenu(App.users);
        break;
        }

    }


    private void lihatUser(){
        Read fetch = new Read();
        fetch.fetchUser();
    }

    protected void manageUsers(){
        Scanner inputan = new Scanner(System.in);

        String username, password, nama_lengkap, progdi, role;

        System.out.println("Menu Tambah User");
        System.out.println("1. Tambah User");
        System.out.println("2. Lihat User");
        System.out.println("3. Edit User");
        System.out.println("4. Hapus User");
        System.out.println("5. Kembali");
        System.out.println("===================================");
        System.out.println("Masukkan pilihan anda: ");
        String inputPilihan = inputan.nextLine();
        switch(inputPilihan){
            case "1":
                Menu.clearConsole();
                Create tambahUsr = new Create();
                
                System.out.println("Menu Tambah User");
                System.out.println("Masukkan Username: ");
                username = inputan.nextLine();
                System.out.println("Masukkan Password: ");
                password = inputan.nextLine();
                System.out.println("Masukkan Nama Lengkap: ");
                nama_lengkap = inputan.nextLine();
                System.out.println("Masukkan Program Studi: ");
                progdi = inputan.nextLine();
                System.out.println("Masukkan Role: ");
                role = inputan.nextLine();

                tambahUsr.tambahUser(username, nama_lengkap, progdi, role, password);
                System.out.println("User " + username + " berhasil ditambahkan\n");
                Menu.sleep(1.5);
                Menu.clearConsole();
                manageUsers();
                break;

            case "2":
                Menu.clearConsole();
                // System.out.println("Menu Lihat User");
                lihatUser();
                System.out.println("\n=============================================================================================================");
                manageUsers();
                break;

            case "3":
                Menu.clearConsole();
                System.out.println("Menu EDIT User");
                
                Menu.clearConsole();
                manageUsers();
                break;
                
            case "4":
                Delete hapusById = new Delete();

                Menu.clearConsole();
                lihatUser();

                System.out.println("\nMasukkan ID yang akan dihapus!");
                String id = inputan.nextLine();
                hapusById.deleteUsers(id);

                sleep(2);
                Menu.clearConsole();
                manageUsers();
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
                manageUsers();
        break;
        }

    }

    






}
