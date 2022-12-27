package Views;

import Main.*;
import java.util.Scanner;

import DB.*;

public class Staff extends Menu {

    /**
       Method dibawah untuk menampilkan menu
       jika user adalah Staff, didalamnya ada
       5 menu yaitu: Manage Buku, Lihat Buku,
       Pinjam Buku, Kembalikan Buku, dan Logout
    */
    public void menuStaff(String id, String name){
        Scanner menu = new Scanner(System.in);
        Read baca = new Read();

        System.out.println("Anda Login Sebagai " + name);
        System.out.println("Menu Staff");
        System.out.println("1. Manage Buku\n2. Lihat Buku\n3. Pinjam Buku\n4. Kembalikan Buku\n5. Logout");
        System.out.println("===================================");
        System.out.println("Masukkan pilihan anda: ");
        String inputPilihan = menu.nextLine();

        switch(inputPilihan){
            case "1":
                System.out.println("Menu Manage Buku");
                super.clearConsole();
                manageBuku();
                break;
            case "2":
                System.out.println("Menu Liat Katalog Buku");
                super.clearConsole();
                baca.bacaDatabaseBuku();
                System.out.println("Tekan Enter untuk kembali ke menu");
                inputPilihan = menu.nextLine();
                super.clearConsole();
                super.mainMenu(App.users);
                break;
            case "3":
                super.clearConsole();
                System.out.println("Menu Pinjam Buku");
                peminjaman(id);
                super.mainMenu(App.users);
                break;
            case "4":
                super.clearConsole();
                System.out.println("Menu Kembalikan Buku");
                pengembalian(id);
                super.mainMenu(App.users);
                break;
            case "5":
                super.clearConsole();
                Menu.bannerLogout();
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak tersedia");
                sleep(1);
                super.mainMenu(App.users);
        break;
        }

    }

    /**
       Method dibawah untuk menampilkan menu
       Manage Buku, didalamnya ada 5 menu yaitu:
       Tambah Buku, Lihat Buku, Edit Buku, Hapus Buku,
       dan Kembali. Menu ini hanya tersedia untuk role
       Admin dan Staff
    */
    protected void manageBuku(){
        Scanner inputan = new Scanner(System.in);
        Read baca = new Read();
        // Read fetch = new Read();

        String id, kategori, judul, bahasa, pengarang;
        int tahun;

        System.out.println("Menu Manage Buku");
        System.out.println("1. Tambah Buku\n2. Lihat Buku\n3. Edit Buku\n4. Hapus Buku\n5. Kembali");
        System.out.println("===================================");
        System.out.println("Masukkan pilihan anda: ");
        String inputPilihan = inputan.nextLine();
        switch(inputPilihan){
            case "1":
                super.clearConsole();
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
                
                tambahBuku.tambahBuku(kategori, judul, bahasa, pengarang, tahun);
                System.out.println("Buku " + judul + " berhasil ditambahkan\n");
                
                sleep(3);
                super.clearConsole();
                manageBuku();
                

                break;

            case "2":
                super.clearConsole();
                baca.bacaDatabaseBuku();
                System.out.println("Tekan Enter untuk kembali ke menu Manage Buku");
                inputPilihan = inputan.nextLine();
                super.clearConsole();
                manageBuku();
                break;

            case "3":
                super.clearConsole();
                System.out.println("Menu EDIT Buku");
                Update editBuku = new Update();

                baca.bacaDatabaseBuku();

                System.out.println("Masukkan ID Buku: ");
                id = inputan.nextLine();

                super.clearConsole();
                baca.printBukuBy("id", id);

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
                    case "3":
                        System.out.println("\nMasukkan Bahasa Baru: ");
                        String bahasa_baru = inputan.nextLine();
                        editBuku.updateBuku("bahasa", id, bahasa_baru);
                        System.out.println("Bahasa buku berhasil diubah");
                        baca.printBukuBy("id", id);
                        break;
                    case "4":
                        System.out.println("\nMasukkan Nama Pengarang Baru: ");
                        String nama_baru = inputan.nextLine();
                        editBuku.updateBuku("nama_pengarang", id, nama_baru);
                        System.out.println("Nama Pengarang buku berhasil diubah");
                        baca.printBukuBy("id", id);
                        break;
                    case "5":
                        System.out.println("\nMasukkan Tahun Terbit Baru: ");
                        String tahun_baru = inputan.nextLine();
                        editBuku.updateBuku("tahun_terbit", id, tahun_baru);
                        System.out.println("Tahun Terbit buku berhasil diubah");
                        baca.printBukuBy("id", id);
                        break;
                    case "6":
                        System.out.println("\nMasukkan Jumlah Maksimum Baru: ");
                        String maks_baru = inputan.nextLine();
                        editBuku.updateBuku("max_buku", id, maks_baru);
                        System.out.println("Jumlah Maksimum buku berhasil diubah");
                        baca.printBukuBy("id", id);
                        break;
                    default:
                        System.out.println("MAAF ERROR PADA SISI PENGGUNA awkoawkoakwo");
                        super.sleep(1);
                        super.clearConsole();
                        manageBuku();
                }
                System.out.println("Tunggu selama 5 detik sebelum kembali ke Prompt");
                sleep(5);
                super.clearConsole();
                manageBuku();
                break;
                
            case "4":
                Delete hapusById = new Delete();

                super.clearConsole();
                baca.bacaDatabaseBuku();

                System.out.println("\nMasukkan ID yang akan dihapus!");
                id = inputan.nextLine();
                hapusById.deleteBuku(id);

                sleep(2);
                super.clearConsole();
                manageBuku();
                break;

            case "5":
                super.clearConsole();
                System.out.println("Kembali");
                super.mainMenu(App.users);
                break;

            default:
                System.out.println("Pilihan tidak tersedia !");
                super.sleep(1);
                super.clearConsole();
                manageBuku();

        break;
        }

    }

    /**
       Method dibawah untuk menampilkan menu
       Peminjaman buku, dimana method ini akan
       meminta input dari user berupa ID buku.
       sebelumnya akan ditampilkan daftar buku
    */
    protected void peminjaman(String userid){
        Scanner pinjam = new Scanner(System.in);
        Read baca = new Read();
        Create tambah = new Create();

        System.out.println("Menu Peminjaman");
        baca.bacaDatabaseBuku();
        System.out.println("Masukkan ID Buku: ");
        String bukuid = pinjam.nextLine();

        tambah.tambahInventori(userid, bukuid);


    }

    /**
       Method dibawah untuk menampilkan menu
       Pengembalian buku, dimana method ini akan
       meminta input dari user berupa ID Inventori.
       sebelumnya akan ditampilkan daftar Inventori
       yang dipinjam oleh user
    */
    protected void pengembalian(String userid){
        Scanner kembalikan = new Scanner(System.in);
        Read baca = new Read();
        Delete hapus = new Delete();

        System.out.println("Menu Pengembalian");
        baca.printInventory(userid);
        System.out.println("Masukkan ID Peminjaman: ");
        String id = kembalikan.nextLine();

        hapus.kurangiInventori(id);
    }

    
}
