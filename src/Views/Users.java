package Views;

import java.util.Scanner;

import DB.*;
import Auth.*;

public class Users {
    public void menuUser(String id, String username, String name, String prodi){
        Scanner inptn = new Scanner(System.in);

        String inputan;

        System.out.println("Anda Login Sebagai " + name);
        System.out.println("Program Studi " + prodi + "\n");
        System.out.println("Menu Mahasiswa\n1. Lihat Buku\n2. Pinjam Buku\n3. Kembalikan Buku\n4. Ganti Password\n5. Logout");
        inputan = inptn.nextLine();

        switch(inputan){
            case "1":
                System.out.println("Lihat Buku");
                break;
            case "2":
                System.out.println("Pinjam Buku");
                break;
            case "3":
                System.out.println("Kembalikan Buku");
                break;
            case "4":
                System.out.println("Ganti Password");
                gantiPasswordUser(id, username);

                menuUser(id, username, name, prodi);
                break;
            case "5":
                System.out.println("Logout");
                System.exit(0);
                break;
            default:
                System.out.println("Maaf menu salah!");
                menuUser(id, username, name, prodi);
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
        } else{
            System.out.println("Maaf, password lama anda Salah!");
        }

    }
}
