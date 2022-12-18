package question9.code;

public class Main {
    public static void main(String[] args){
        Image image = new JPGImage();
        Filter filter = new CutoutFilter();
        image.setFilter(filter);
        image.processImage();
    }
}

abstract class Image {
    protected Filter filter;

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public abstract void processImage();
}

class JPGImage extends Image{
    public void processImage() {
        System.out.print("对于JPGImage");
        filter.doFilter();
    }
}

class GIFImage extends Image{
    public void processImage() {
        System.out.print("对于GIFImage");
        filter.doFilter();
    }
}

class BMPImage extends Image{
    public void processImage() {
        System.out.print("对于BMPImage");
        filter.doFilter();
    }
}

interface Filter {
    void doFilter();
}

class CutoutFilter implements Filter{
    public void doFilter() {
        System.out.println("用CutoutFilter进行处理");
    }
}

class BlurFilter implements Filter{
    public void doFilter() {
        System.out.println("用BlurFilter进行处理");
    }
}

class SharpenFilter implements Filter{
    public void doFilter() {
        System.out.println("用SharpenFilter进行处理");
    }
}

class TextureFilter implements Filter{
    public void doFilter() {
        System.out.println("用TextureFilter进行处理");
    }
}
