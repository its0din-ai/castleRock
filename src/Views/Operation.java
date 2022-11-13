package Views;

import java.util.Scanner;

public class Operation {
    public static String pilihanInput(){
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Pilihan: ");
            String pilihan = input.nextLine();
            return pilihan;
        }
    }

    public void menuTambahUser(String namaLengkap){
        System.out.println("Tambah User");
        System.out.println("1. Tambah User");
        System.out.println("2. Kembali");
        String pilihan = "2";
        switch(pilihan){
            case "1":
                System.out.println("Tambah User");
                break;
            case "2":
                Menu menuAdmin = new Menu();
                menuAdmin.menuAdmin(namaLengkap);
                break;
            default:
                System.out.println("Pilihan tidak tersedia");
                break;
        }
    }

    public void menuLihatUser(){
        System.out.println("Lihat User");
    }
    public void menuTambahBuku(){
        System.out.println("Tambah Buku");
    }
    public void menuLihatBuku(){
        System.out.println("Lihat Buku");
    }
    public void menuPinjamBuku(){
        System.out.println("Pinjam Buku");
    }
    public void menuKembalikanBuku(){
        System.out.println("Kembalikan Buku");
    }
    public void menuLogout(){
        System.out.println("Logout");
        System.exit(0);
    }
}
