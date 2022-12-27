package Main;

import java.io.IOException;

import Auth.*;
import Views.*;

public class App {

    /** Main Method hanya akan memanggil method login() dan mainMenu()
        untuk menampilkan halaman login dan menu utama. Sisanya akan dihandle
        oleh method-method yang dipanggil oleh method-method tersebut dengan 
        menggunakan Switch-Case. 
    */
    public static void main(String[] args) throws Exception {
        login();
        mainMenu(users);
    }


    /** Method dibawah ini digunakan untuk menampilkan halaman login,
        dan melakukan autentikasi user. Jika user berhasil login,
        maka akan diarahkan ke halaman utama sesuai dengan role-nya.
        data user akan disimpan selama program berjalan pada variabel
        users[].
    */
    protected static String[] users = new String[5];
    private static void login() throws IOException {
        Autentikasi authDev = new Autentikasi();
        users = authDev.Login();
    }

    /** Method dibawah ini digunakan untuk menampilkan menu utama
        sesuai dengan role user yang login. Method ini akan memanggil
        method-method yang ada di class-class yang berbeda sesuai dengan
        role user yang login. method juga membutuhkan parameter dari data
        users[] yang dihasilkan oleh method login() yang nantinya akan
        digunakan untuk menampilkan data user yang login.
    */
    protected static void mainMenu(String[] users){
        switch(users[4]){
            case "admin":
                Admin menuAdmin = new Admin();
                Menu.clearConsole();
                menuAdmin.menuAdmin(users[0], users[2]);
                break;
            case "staff":
                Staff menuStaff = new Staff();
                Menu.clearConsole();
                menuStaff.menuStaff(users[2], users[3]);
                break;
            case "user":
                Users menuUser = new Users();
                Menu.clearConsole();
                menuUser.menuUser(users[0], users[1], users[2], users[3]);
                break;
            default:
                System.out.println("Kamu ini siapa ngab? Hengker kh?");
                break;
        }
    }


}
