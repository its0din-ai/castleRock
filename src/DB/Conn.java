package DB;

public class Conn {
    private final String DB_URL = "jdbc:mysql://localhost/castlerock_lib?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private final String USER = "koboKanaeru";
    private final String PASS = "!hengker99";
    String[] dbConfig = new String[3];

    public String[] getConfig() {
        dbConfig[0] = DB_URL;
        dbConfig[1] = USER;
        dbConfig[2] = PASS;
        return dbConfig;
    }
}
