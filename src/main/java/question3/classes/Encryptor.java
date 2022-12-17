package question3.classes;

public abstract class Encryptor {
    private String algorithm;

    public Encryptor(String algorithm) {
        this.algorithm = algorithm;
    }

    public abstract void encrypt(String text);

    public static Encryptor getInstance(String algorithm) {
        if (algorithm.equals("des")) {
            return new DES();
        } else if (algorithm.equals("desede")) {
            return new DESede();
        } else if (algorithm.equals("md5")) {
            return new MD5();
        } else {
            return null;
        }
    }
}

