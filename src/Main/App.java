package Main;

import Auth.*;
import Views.*;

public class App {
    // MAIN METHOD
    public static void main(String[] args) throws Exception {
        login();
        mainMenu(users);

    }



    // KODE TAMBAHAN
    protected static String[] users = new String[4];
    
    public static void login() {
        Autentikasi authDev = new Autentikasi();
        users = authDev.Login();
    }

    protected static void mainMenu(String[] users){
        switch(users[3]){
            case "admin":
                Admin menuAdmin = new Admin();
                Menu.clearConsole();
                menuAdmin.menuAdmin(users[1]);
                break;
            case "staff":
                Menu menuStaff = new Menu();
                Menu.clearConsole();
                menuStaff.menuStaff(users[1], users[2]);
                break;
            case "user":
                Menu menuUser = new Menu();
                Menu.clearConsole();
                menuUser.menuUser(users[1], users[2]);
                break;
            default:
                System.out.println("Kamu ini siapa ngab? Hengker kh?");
                break;
        }
    }


}
