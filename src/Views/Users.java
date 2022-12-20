package Views;

import java.util.Scanner;

import DB.*;
import Main.App;
import Auth.*;

public class Users extends Menu {
    public void menuUser(String id, String username, String name, String prodi){
        Scanner inptn = new Scanner(System.in);

        String inputan;
        Read baca = new Read();

        System.out.println("Anda Login Sebagai " + name);
        System.out.println("Program Studi " + prodi + "\n");
        System.out.println("Menu Mahasiswa\n1. Lihat Buku\n2. Pinjam Buku\n3. Kembalikan Buku\n4. Ganti Password\n5. Logout");
        inputan = inptn.nextLine();

        switch(inputan){
            case "1":
                Menu.clearConsole();
                baca.bacaDatabaseBuku();
                System.out.println("Tekan Enter untuk kembali ke menu");
                inputan = inptn.nextLine();
                super.mainMenu(App.users);
                break;
            case "2":
                System.out.println("Pinjam Buku");
                peminjaman(id);
                super.mainMenu(App.users);
                break;
            case "3":
                System.out.println("Kembalikan Buku");
                pengembalian(id);
                super.mainMenu(App.users);
                break;
            case "4":
                System.out.println("Ganti Password");
                gantiPasswordUser(id, username);

                super.mainMenu(App.users);
                break;
            case "5":
                System.out.println("Logout");
                Menu.bannerLogout();
                System.exit(0);
                break;
            default:
                System.out.println("Maaf menu salah!");
                super.mainMenu(App.users);
        }

    }

    private void gantiPasswordUser(String id, String usrnm){
        Read baca = new Read();
        Update updtr = new Update();
        Autentikasi autentikasi = new Autentikasi();
        Scanner inptPass = new Scanner(System.in);
        String pswrdLama = baca.bacaUser(usrnm)[5];

        System.out.println("Masukkan password lama anda");
        String pswLama =  autentikasi.getMd5(inptPass.nextLine());

        if(pswLama.equals(pswrdLama)){
            System.out.println("OK!");
            System.out.println("Masukkan password baru!");
            String pswrdBaru = inptPass.nextLine();
            // String pswrdCrypt = autentikasi.getMd5(pswrdBaru);
            updtr.updatePassword(id, pswrdBaru);
            System.out.println("Password berhasil diganti, harap di ingat :)");
            Menu.sleep(4);
        } else{
            System.out.println("Maaf, password lama anda Salah!");
        }

    }
   
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
