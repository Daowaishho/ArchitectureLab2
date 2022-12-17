package question4.classes;

public abstract class ImageReaderFactory {
    private String format;

    public ImageReaderFactory(String format) {
        this.format = format;
    }

    public abstract ImageReader createImageReader();

    public static ImageReaderFactory getInstance(String format) {
        if (format.equals("gif")) {
            return new GifReaderFactory();
        } else if (format.equals("jpg")) {
            return new JpgReaderFactory();
        } else {
            return null;
        }
    }
}