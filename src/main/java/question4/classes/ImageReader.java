package question4.classes;

public abstract class ImageReader {
    private String format;

    public ImageReader(String format) {
        this.format = format;
    }

    public abstract void read();
}