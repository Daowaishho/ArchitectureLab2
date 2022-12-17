package question4.classes;

public class GifReader extends ImageReader {
    public GifReader() {
        super("gif");
    }

    @Override
    public void read() {
        // 实现读取 GIF 图片的方法
        System.out.println("读取了GIF图片");
    }
}