package DB;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Conn {
    

    private final String DB_URL = "jdbc:mysql://103.172.205.207/castlerock_lib?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    // private final String DB_URL = "jdbc:mysql://6.tcp.ngrok.io:10255/castlerock_lib?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    
    String[] dbConfig = new String[3];
    String[] secureConfig = new String[2];

    private String[] securedCreds() throws ParserConfigurationException, SAXException, IOException {
        File configFile = new File("config.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(configFile);
        NodeList usernameNodes = document.getElementsByTagName("username");
        NodeList passwordNodes = document.getElementsByTagName("password");
        String username = usernameNodes.item(0).getTextContent();
        String password = passwordNodes.item(0).getTextContent();
        secureConfig[0] = username;
        secureConfig[1] = password;
        return secureConfig;
    }


    public String[] getConfig() {
        try {
            securedCreds();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        dbConfig[0] = DB_URL;
        dbConfig[1] = secureConfig[0];
        dbConfig[2] = secureConfig[1];
        return dbConfig;
    }
}
