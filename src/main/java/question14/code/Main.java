package question14.code;

public class Main {
    public static void main(String[] args) {
        Message commonMessage = new CommonMessage();
        commonMessage.setContent("私は中国人です");
        SendingMethod sendingMethod = new EmailMessage();
        EmailHandlerAdaptor emailHandlerAdaptor = new EmailHandlerAdaptor();
        sendingMethod.setEmailHandlerAdaptor(emailHandlerAdaptor);
        commonMessage.setSendingMethod(sendingMethod);
        commonMessage.sendMessage();
    }
}

abstract class Message {
    private String content = "空消息";
    protected SendingMethod sendingMethod;

    public void setSendingMethod(SendingMethod sendingMethod) {
        this.sendingMethod = sendingMethod;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }
    public abstract void sendMessage();
}

class CommonMessage extends Message{
    public void sendMessage() {
        System.out.println("正在发送CommonMessage");
        sendingMethod.send(this.getContent());
    }
}

class UrgentMessage extends Message{
    public void sendMessage() {
        System.out.println("正在发送UrgentMessage");
        sendingMethod.send(this.getContent());
    }
}

class EmergencyMessage extends Message{
    public void sendMessage() {
        System.out.println("正在发送EmergenceyMessage");
        sendingMethod.send(this.getContent());
    }
}

interface SendingMethod {
    void send(String str);

    void setEmailHandlerAdaptor(EmailHandlerAdaptor emailHandlerAdaptor);

    void setMobileMessageHandlerAdaptor(MobileMessageHandlerAdaptor mobileMessageHandlerAdaptor);
}

class ShortMessage implements SendingMethod{
    public void send(String str) {
        System.out.println("用ShortMessage方式发送:"+str);
    }

    @Override
    public void setEmailHandlerAdaptor(EmailHandlerAdaptor emailHandlerAdaptor) {
        System.out.println("错误");
    }

    @Override
    public void setMobileMessageHandlerAdaptor(MobileMessageHandlerAdaptor mobileMessageHandlerAdaptor) {
        System.out.println("错误");
    }
}

class EmailMessage implements SendingMethod{
    private EmailHandlerAdaptor emailHandlerAdaptor;

    public void setEmailHandlerAdaptor(EmailHandlerAdaptor emailHandlerAdaptor){
        this.emailHandlerAdaptor = emailHandlerAdaptor;
    }

    @Override
    public void setMobileMessageHandlerAdaptor(MobileMessageHandlerAdaptor mobileMessageHandlerAdaptor) {
        System.out.println("错误");
    }

    public void send(String str){
        emailHandlerAdaptor.send(str);
    }

}

class EmailHandlerAdaptor extends EmailHandler{
    public void send(String str) {
        super.send(str);
    }
}

class EmailHandler {
    public void send(String str) {
        System.out.println("用Email方式发送:"+str);
    }
}

class MobileMessage implements SendingMethod{
    private MobileMessageHandlerAdaptor mobileMessageHandlerAdaptor;

    public void setMobileMessageHandlerAdaptor(MobileMessageHandlerAdaptor mobileMessageHandlerAdaptor){
        this.mobileMessageHandlerAdaptor = mobileMessageHandlerAdaptor;
    }
    public void send(String str) {
        mobileMessageHandlerAdaptor.send(str);
    }

    @Override
    public void setEmailHandlerAdaptor(EmailHandlerAdaptor emailHandlerAdaptor) {
        System.out.println("错误");
    }
}

class MobileMessageHandlerAdaptor extends MobileMessageHandler{
    public void send(String str) {
        super.send(str);
    }
}

class MobileMessageHandler {
    public void send(String str){
        System.out.println("用MobileMessage方式发送:"+str);
    }
}
