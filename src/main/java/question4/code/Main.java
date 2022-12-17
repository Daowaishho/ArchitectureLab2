package question4.code;

public class Main {
    public static void main(String[] args){
        try{
            ImageReader gifReader = GifReaderFactory.createImageReader();
            ImageReader jpgReader = JpgReaderFactory.createImageReader();
            gifReader.read();
            jpgReader.read();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

abstract class ImageReaderFactory {
    public static ImageReader createImageReader() {
        return null;
    }
}

class GifReaderFactory extends ImageReaderFactory{
    public static ImageReader createImageReader() {
        return new GifReader();
    }
}

class JpgReaderFactory extends ImageReaderFactory{
    public static JpgReader createImageReader() {
        return new JpgReader();
    }
}

abstract class ImageReader {
    public void read() {

    }
}

class GifReader extends ImageReader{
    public void read() {
        System.out.println("用GifReader进行了文件读取");
    }
}

class JpgReader extends ImageReader{
    public void read() {
        System.out.println("用JpgReader进行了文件读取");
    }
}


