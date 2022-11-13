// import DB.*;
import Auth.*;
import Views.*;

import java.util.Scanner;
// import java.io.Console;

public class App {
    

    public static void main(String[] args) throws Exception {
        // Read bacaUsr = new Read();
        Autentikasi authDev = new Autentikasi();
        String[] users = authDev.Login();
        Scanner input = new Scanner(System.in);
        String namaLengkap = users[1];
        String prodi = users[2];

        switch(users[3]){
            case "admin":
                Menu menuAdmin = new Menu();
                Operation pilihan = new Operation();

                Menu.clearConsole();
                menuAdmin.menuAdmin(namaLengkap);
                System.out.println("Masukkan pilihan anda: ");
                String inputPilihan = "1";

                switch(inputPilihan){
                    case "1":
                        Menu.clearConsole();
                        pilihan.menuTambahUser(namaLengkap);
                        break;
                    case "2":
                        Menu.clearConsole();
                        pilihan.menuLihatUser();
                        break;
                    case "3":
                        Menu.clearConsole();
                        pilihan.menuTambahBuku();
                        break;
                    case "4":
                        Menu.clearConsole();
                        pilihan.menuLihatBuku();
                        break;
                    case "5":
                        Menu.clearConsole();
                        pilihan.menuPinjamBuku();
                        break;
                    case "6":
                        Menu.clearConsole();
                        pilihan.menuKembalikanBuku();
                        break;
                    case "7":
                        Menu.clearConsole();
                        pilihan.menuLogout();
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia");
                break;
                }
            case "staff":
                Menu menuStaff = new Menu();
                Menu.clearConsole();
                menuStaff.menuStaff(namaLengkap, prodi);
                break;
            case "user":
                Menu menuUser = new Menu();
                Menu.clearConsole();
                menuUser.menuUser(namaLengkap, prodi);
                break;
            default:
                System.out.println("Pilihan tidak tersedia");
                break;
        }
        input.close();
        

    }
}
