package question4.test;

import question4.classes.ImageReader;
import question4.classes.ImageReaderFactory;

public class Test {
    public static void main(String[] args){
        // 获取 GifReaderFactory 实例
        ImageReaderFactory factory = ImageReaderFactory.getInstance("jpg");

// 创建 GifReader 对象
        ImageReader reader= factory.createImageReader();

// 使用 GifReader 读取图片
        reader.read();
    }
}
