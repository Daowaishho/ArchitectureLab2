package question3.code;

import org.w3c.dom.NodeList;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.File;

public class Main {
    public static void main(String[] args){
        try{
            String type = XMLUtil.getEncryptorType();
            Encryptor encryptor = EncryptorFactory.getEncryptor(type);
            encryptor.encrypt("");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

abstract class Encryptor {
    public String encrypt(String str){
        return null;
    }
}

class DES extends Encryptor{
    @Override
    public String encrypt(String str){
        System.out.println("模拟DES方法加密");
        return null;
    }
}

class DESede extends Encryptor{
    @Override
    public String encrypt(String str){
        System.out.println("模拟DESede方法加密");
        return null;
    }
}

class MD5 extends Encryptor{
    @Override
    public String encrypt(String str){
        System.out.println("模拟MD5方法加密");
        return null;
    }
}

class EncryptorFactory {
    public static Encryptor getEncryptor(String type){
        Encryptor encryptor = null;
        if (type.equalsIgnoreCase("DES")) {
            encryptor = new DES();
        }else if (type.equalsIgnoreCase("DESede")) {
            encryptor = new DESede();
        }else if (type.equalsIgnoreCase("MD5")) {
            encryptor = new MD5();
        }
        return encryptor;
    }
}

class XMLUtil {
    public static String getEncryptorType() {
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            Document document;
            document = builder.parse(new File("src/main/java/question3/xml/config.xml"));
            NodeList nodeList = document.getElementsByTagName("algorithm");
            Node node = nodeList.item(0).getFirstChild();
            String encryptorType = node.getNodeValue().trim();
            return encryptorType;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
