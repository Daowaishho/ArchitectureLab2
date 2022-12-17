package question4.classes;

public class JpgReaderFactory extends ImageReaderFactory {
    public JpgReaderFactory() {
        super("jpg");
    }

    @Override
    public ImageReader createImageReader() {
        return new JpgReader();
    }
}