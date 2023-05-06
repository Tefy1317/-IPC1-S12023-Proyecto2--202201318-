import proyecto2.BmpHandlerCopy;
import proyecto2.ImageHandler;

import java.io.FileOutputStream;

public class JPEGImageCopy extends ImageHandler {
    public JPEGImageCopy(String filename) {
        super(filename);
    }

    @Override
    public void readFile() throws Exception {
        System.out.println("Imagen: "+this.handledFileName);
        BmpHandlerCopy bmpHandlerCopy = new BmpHandlerCopy((this.handledFileName));
        bmpHandlerCopy.readFile();
        bmpHandlerCopy.generateFiles();
    }
    @Override
    public void generateFiles() throws Exception {
    }
}
