package question3.classes;

public class DES extends Encryptor {
    public DES() {
        super("des");
    }

    @Override
    public void encrypt(String text) {
        // 实现 DES 加密方法
        System.out.println("DES加密");
    }
}