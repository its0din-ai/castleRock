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
    
    String[] dbConfig = new String[3];
    String[] secureConfig = new String[3];

    private String[] securedCreds() throws ParserConfigurationException, SAXException, IOException {
        File configFile = new File("config.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(configFile);
        NodeList urlNodes = document.getElementsByTagName("url");
        NodeList usernameNodes = document.getElementsByTagName("username");
        NodeList passwordNodes = document.getElementsByTagName("password");
        String url = urlNodes.item(0).getTextContent();
        String username = usernameNodes.item(0).getTextContent();
        String password = passwordNodes.item(0).getTextContent();
        secureConfig[0] = url;
        secureConfig[1] = username;
        secureConfig[2] = password;
        return secureConfig;
    }

    public String[] getConfig() {
        try {
            securedCreds();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        dbConfig[0] = secureConfig[0];
        dbConfig[1] = secureConfig[1];
        dbConfig[2] = secureConfig[2];
        return dbConfig;
    }
}
