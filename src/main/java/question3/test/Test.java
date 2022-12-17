package question3.test;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import question3.classes.Encryptor;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        // 读取 XML 文件
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("src/main/java/question3/xml/config.xml"));

        NodeList algorithmList = doc.getElementsByTagName("algorithm");
        String algorithm = algorithmList.item(0).getTextContent();

// 从 XML 文件中获取的参数可以用来创建不同的加密器对象
        Encryptor encryptor = Encryptor.getInstance(algorithm);
        encryptor.encrypt("123");
    }
}
