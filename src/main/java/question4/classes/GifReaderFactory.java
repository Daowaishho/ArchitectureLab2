package question4.classes;

public class GifReaderFactory extends ImageReaderFactory {
    public GifReaderFactory() {
        super("gif");
    }

    @Override
    public ImageReader createImageReader() {
        return new GifReader();
    }
}