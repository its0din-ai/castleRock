package Auth;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import DB.*;

public class Autentikasi {
    public static String getMd5(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean authDevMode(String username, String passInpt){
        Read passDb = new Read();
        String pass = passDb.bacaDatabasePassword(username);
        if(getMd5(passInpt).equals(pass)){
            return true;
        }
        else{
            return false;
        }
    }
}
