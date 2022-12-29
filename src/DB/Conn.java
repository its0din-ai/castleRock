package DB;

// import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Conn {
    
    private String[] secureConfig = new String[3];
    String[] dbConfig = new String[3];

    /**
       Method untuk membaca file config.xml dan mengembalikan
       nilai url, username, dan password yang nantinya akan
       digunakan untuk login ke mysql menggunakan JDBC
       (Setter)
    */
    private String[] setDBAkun() throws ParserConfigurationException, SAXException, IOException {
        InputStream configFile = getClass().getClassLoader().getResourceAsStream("config/config.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(configFile);
        NodeList urlNodes = document.getElementsByTagName("url");
        NodeList usernameNodes = document.getElementsByTagName("username");
        NodeList passwordNodes = document.getElementsByTagName("password");
        String url = urlNodes.item(0).getTextContent();
        String username = usernameNodes.item(0).getTextContent();
        String password = passwordNodes.item(0).getTextContent();
        this.secureConfig[0] = url;
        this.secureConfig[1] = username;
        this.secureConfig[2] = password;
        return secureConfig;
    }

    /**
       Menggunakan konsep Encapsulation agar data config.xml
       tidak bisa diakses secara langsung dari luar class
       dan akan menjadi lebih aman (Getter)
    */
    public String[] getConfig() {
        try {
            setDBAkun();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        this.dbConfig[0] = secureConfig[0];
        this.dbConfig[1] = secureConfig[1];
        this.dbConfig[2] = secureConfig[2];
        return dbConfig;
    }


}
