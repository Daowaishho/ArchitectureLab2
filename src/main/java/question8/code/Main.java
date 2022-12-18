package question8.code;

public class Main {
    public static void main(String[] args) {
        OASystemClassAdapt oaSystemClassAdapt = new EncryptorClassAdaptor();
        oaSystemClassAdapt.Encryption();

        OASystemObjectAdapt oaSystemObjectAdapt = new EncryptorObjectAdaptor(new EncryptorObjectAdaptee());
        oaSystemObjectAdapt.Encryption();
    }
}

interface OASystemClassAdapt {
    void Encryption();
}

class EncryptorClassAdaptor extends  EncryptorClassAdaptee implements  OASystemClassAdapt{
    public void Encryption() {
        super.Encryption();
    }
}

class EncryptorClassAdaptee {
    public void Encryption() {
        System.out.println("类适配器适配的加密");
    }
}

class  OASystemObjectAdapt {
    public void Encryption() {

    }
}

class EncryptorObjectAdaptor extends OASystemObjectAdapt{
    private EncryptorObjectAdaptee encryptorObjectAdaptee;

    public EncryptorObjectAdaptor(EncryptorObjectAdaptee encryptorObjectAdaptee){
        this.encryptorObjectAdaptee = encryptorObjectAdaptee;
    }

    public void Encryption() {
        encryptorObjectAdaptee.Encryption();
    }
}

class EncryptorObjectAdaptee {
    public void Encryption() {
        System.out.println("对象适配器适配的加密");
    }
}


