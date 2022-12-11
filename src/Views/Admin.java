package Views;

import Main.*;
import java.util.Scanner;

import DB.*;

public class Admin extends Menu {
    
    public void menuAdmin(String name){
        Scanner menu = new Scanner(System.in);
        Read baca = new Read();

        System.out.println("Anda Login Sebagai " + name);
        System.out.println("Menu Admin");
        System.out.println("1. Manage User\n2. Manage Buku\n3. Lihat Buku\n4. Pinjam Buku\n5. Kembalikan Buku\n6. Logout");
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
                manageBuku();
                break;
            case "3":
                System.out.println("Menu Liat Katalog Buku");
                Menu.clearConsole();
                baca.bacaDatabaseBuku();
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

    protected void manageUsers(){
        Scanner inputan = new Scanner(System.in);
        Read fetch = new Read();
        // Print prnt = new Print();

        String id, username, password, nama_lengkap, progdi, role;

        System.out.println("Menu Tambah User");
        System.out.println("1. Tambah User\n2. Lihat User\n3. Edit User\n4. Hapus User\n5. Kembali");
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
                String duplikat = fetch.returnUserBy("username", username);
                if(duplikat == null){
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
                    sleep(1);
                    Menu.clearConsole();
                    manageUsers();
                }
                else if(duplikat != null){
                    System.out.println("Username sudah ada");
                    sleep(1);
                    Menu.clearConsole();
                    manageUsers();
                }

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
                        editUser.updateUser("nama_lengkap", id, nama_lengkap_baru);

                        System.out.println("Nama Lengkap berhasil diubah");
                        fetch.fetchUserBy("id", id);
                        break;


                    case "2":
                        System.out.println("\nMasukkan Program Studi Baru: ");
                        String progdi_baru = inputan.nextLine();
                        editUser.updateUser("progdi", id, progdi_baru);

                        System.out.println("Program Studi berhasil diubah");
                        fetch.fetchUserBy("id", id);
                        break;


                    case "3":
                        System.out.println("\nPilih Role: \n1. Admin\n2. Staff\n3. User");
                        String pilihanRole = inputan.nextLine();
                        switch(pilihanRole){
                            case "1":
                                editUser.updateUser("role", id, "admin");
                                System.out.println("Role User berhasil diubah");
                                fetch.fetchUserBy("id", id);
                                break;
                            case "2":
                                editUser.updateUser("role", id, "staff");
                                System.out.println("Role User berhasil diubah");
                                fetch.fetchUserBy("id", id);
                                break;
                            case "3":
                                editUser.updateUser("role", id, "user");
                                System.out.println("Role User berhasil diubah");
                                fetch.fetchUserBy("id", id);
                                break;
                            default:
                                System.out.println("Salah statement boss!");
                                System.out.println("Role User GAGAL diubah");
                                break;
                        }
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
    
    protected void manageBuku(){
        Scanner inputan = new Scanner(System.in);
        Read baca = new Read();
        // Read fetch = new Read();

        String id, kategori, judul, bahasa, pengarang;
        int tahun, maxBuku, sisaBuku;

        System.out.println("Menu Manage Buku");
        System.out.println("1. Tambah Buku\n2. Lihat Buku\n3. Edit Buku\n4. Hapus Buku\n5. Kembali");
        System.out.println("===================================");
        System.out.println("Masukkan pilihan anda: ");
        String inputPilihan = inputan.nextLine();
        switch(inputPilihan){
            case "1":
                Menu.clearConsole();
                Create tambahBuku = new Create();
                
                System.out.println("Menu Tambah Buku");

                System.out.println("Masukkan Kategori Buku: ");
                kategori = inputan.nextLine();
                System.out.println("Masukkan Judul Buku: ");
                judul = inputan.nextLine();
                System.out.println("Masukkan Bahasa Buku: ");
                bahasa = inputan.nextLine();
                System.out.println("Masukkan Nama Pengarang: ");
                pengarang = inputan.nextLine();
                System.out.println("Masukkan Tahun Terbit: ");
                tahun = inputan.nextInt();
                System.out.println("Masukkan Jumlah Buku: ");
                maxBuku = inputan.nextInt();
                tambahBuku.tambahBuku(kategori, judul, bahasa, pengarang, tahun, maxBuku);
                System.out.println("Buku " + judul + " berhasil ditambahkan\n");
                sisaBuku = maxBuku - 2;
                System.out.println("[DEBUG] Sisa Buku :: " + sisaBuku);
                sleep(3);
                Menu.clearConsole();
                manageBuku();
                

                break;

            case "2":
                Menu.clearConsole();
                baca.bacaDatabaseBuku();
                manageBuku();
                break;

            case "3":
                Menu.clearConsole();
                System.out.println("Menu EDIT Buku");
                Update editBuku = new Update();

                baca.bacaDatabaseBuku();

                System.out.println("Masukkan ID Buku: ");
                id = inputan.nextLine();
                baca.returnBukuBy("id", id);

                System.out.println("Data apa yang akan di Update: ");
                System.out.println("1. Judul Buku\n2. Kategori\n3. Bahasa\n4. Nama Pengarang\n5. Tahun Terbit\n6. Jumlah Maks Buku");
                String pilihData = inputan.nextLine();
                switch(pilihData){
                    case "1":
                        System.out.println("\nMasukkan Judul Baru: ");
                        String judul_baru = inputan.nextLine();
                        editBuku.updateBuku("judul_buku", id, judul_baru);
                        System.out.println("Judul buku berhasil diubah");
                        baca.printBukuBy("id", id);
                        break;
                    case "2":
                        System.out.println("\nMasukkan Kategori Baru: ");
                        String kategori_baru = inputan.nextLine();
                        editBuku.updateBuku("kategori", id, kategori_baru);
                        System.out.println("Kategori buku berhasil diubah");
                        baca.printBukuBy("id", id);
                        break;
                    // case "3":
                    //     System.out.println("\nMasukkan Role Baru: ");
                    //     String role_baru = inputan.nextLine();
                    //     editBuku.updateRole(id, role_baru);
                    //     break;
                    // case "4":
                    //     System.out.println("\nMasukkan Password Baru: ");
                    //     String password_baru = inputan.nextLine();
                    //     editBuku.updatePassword(id, password_baru);
                    //     break;
                    default:
                        System.out.println("MAAF ERROR PADA SISI PENGGUNA awkoawkoakwo");
                        super.sleep(1);
                        Menu.clearConsole();
                        manageUsers();
                }


                System.out.println("Tunggu selama 5 detik sebelum kembali ke Prompt");
                sleep(5);
                Menu.clearConsole();
                manageBuku();
                break;
                
            case "4":
                // Delete hapusById = new Delete();

                // Menu.clearConsole();
                // fetch.fetchAllUser();

                // System.out.println("\nMasukkan ID yang akan dihapus!");
                // id = inputan.nextLine();
                // hapusById.deleteUsers(id);

                // sleep(2);
                // Menu.clearConsole();
                // manageUsers();
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
