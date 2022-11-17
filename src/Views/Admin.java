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


    // private void lihatUser(){
    //     Read fetch = new Read();
    //     fetch.fetchAllUser();
    // }

    protected void manageUsers(){
        Scanner inputan = new Scanner(System.in);
        Read fetch = new Read();

        String id, username, password, nama_lengkap, progdi, role;

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
                // NANTI BISA DI SORT BY PARAMETER
                System.out.println("DAFTAR PENGGUNA PERPUSTAKAAN");
                System.out.println("1. Ambil Semua Data\n2. Ambil Data sesuai Prodi\n3. Ambil Data sesuai Role");
                System.out.println("Masukkan pilihan anda: ");
                String pilihanData = inputan.nextLine();

                switch(pilihanData){
                    case "1":
                        Menu.clearConsole();
                        fetch.fetchAllUser();
                        manageUsers();
                        break;
                    case "2":
                        Menu.clearConsole();
                        System.out.println("Masukkan Nama Prodi");
                        String valueQuery = inputan.nextLine();
                        fetch.fetchUserBy("progdi", valueQuery);
                        manageUsers();
                        break;
                    case "3":
                        Menu.clearConsole();
                        System.out.println("Masukkan Nama Role");
                        valueQuery = inputan.nextLine();
                        fetch.fetchUserBy("role", valueQuery);
                        manageUsers();
                        break;
                    default:
                        Menu.clearConsole();
                        manageUsers();
                        break;
                }
                break;

            case "3":
                Menu.clearConsole();
                System.out.println("Menu EDIT User");
                Update editUser = new Update();

                fetch.fetchAllUser();

                System.out.println("Masukkan ID User: ");
                id = inputan.nextLine();
                fetch.fetchUserBy("id", id);

                System.out.println("Data apa yang akan di Update: ");
                System.out.println("1. Nama Lengkap\n2. Program Studi\n3. Role\n4. Password");
                String pilihData = inputan.nextLine();
                switch(pilihData){
                    case "1":
                        System.out.println("\nMasukkan Nama Lengkap Baru: ");
                        String nama_lengkap_baru = inputan.nextLine();
                        editUser.updateNama(id, nama_lengkap_baru);
                        break;
                    case "2":
                        System.out.println("\nMasukkan Program Studi Baru: ");
                        String progdi_baru = inputan.nextLine();
                        editUser.updateProgdi(id, progdi_baru);
                        break;
                    case "3":
                        System.out.println("\nMasukkan Role Baru: ");
                        String role_baru = inputan.nextLine();
                        editUser.updateRole(id, role_baru);
                        break;
                    case "4":
                        System.out.println("\nMasukkan Password Baru: ");
                        String password_baru = inputan.nextLine();
                        editUser.updatePassword(id, password_baru);
                        break;
                    default:
                        System.out.println("MAAF ERROR PADA SISI PENGGUNA awkoawkoakwo");
                        super.sleep(1);
                        Menu.clearConsole();
                        manageUsers();
                }

                System.out.println("Tunggu selama 5 detik sebelum kembali ke Prompt");
                sleep(5);
                Menu.clearConsole();
                manageUsers();
                break;
                
            case "4":
                Delete hapusById = new Delete();

                Menu.clearConsole();
                fetch.fetchAllUser();

                System.out.println("\nMasukkan ID yang akan dihapus!");
                id = inputan.nextLine();
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
