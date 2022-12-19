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
    protected static String[] users = new String[5];
    
    public static void login() {
        Autentikasi authDev = new Autentikasi();
        users = authDev.Login();
    }

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
