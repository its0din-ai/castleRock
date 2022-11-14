package Main;

// import DB.*;
import Auth.*;
import Views.*;

// import java.util.Scanner;
// import java.io.Console;

public class App {
    protected static String[] users = new String[4];
    public static void login() {
        Autentikasi authDev = new Autentikasi();
        users = authDev.Login();
    }

    public void sleep(int detik){
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        login();
        mainMenu(users);

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
