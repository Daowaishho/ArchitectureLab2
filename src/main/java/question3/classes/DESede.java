package question3.classes;

public class DESede extends Encryptor {
    public DESede() {
        super("desede");
    }

    @Override
    public void encrypt(String text) {
        // 实现三重 DES 加密方法
        System.out.println("三重DES加密");
    }
}