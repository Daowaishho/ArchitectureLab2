package question3.classes;

public class MD5 extends Encryptor {
    public MD5() {
        super("md5");
    }

    @Override
    public void encrypt(String text) {
        // 实现 MD5 加密方法
        System.out.println("MD5加密");
    }
}