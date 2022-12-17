package question4.classes;

public class JpgReader extends ImageReader {
    public JpgReader() {
        super("jpg");
    }

    @Override
    public void read() {
        // 实现读取 JPG 图片的方法
        System.out.println("读取了JPG图片");
    }
}