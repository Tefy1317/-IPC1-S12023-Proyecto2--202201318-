import proyecto2.ImageHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
public class JPEGtoBMPImage extends ImageHandler {
    private BufferedImage bi;

    public JPEGtoBMPImage(String filename) {
        super(filename);
    }

    @Override
    public void readFile() throws Exception {
        System.out.println("IMAGEN: " + this.handledFileName);
        File file = new File(this.handledFileName);
        bi = ImageIO.read(file);
    }

    @Override
    public void generateFiles() throws Exception {
        if (this.handledFileName.endsWith(".jpg")) {
            int indexBarra = this.handledFileName.lastIndexOf("\\");
            int indexPunto = this.handledFileName.lastIndexOf(".");

            String nuevoNombre = this.handledFileName.substring(indexBarra, indexPunto) + ".bmp";
            File nuevoArchivo = new File("./Temporal/" + nuevoNombre);
            new File(nuevoArchivo.getParent()).mkdirs();
            ImageIO.write(bi, "bmp", nuevoArchivo);
        }
        if (this.handledFileName.endsWith(".bmp")) {
            {
                int indexBarra = this.handledFileName.lastIndexOf("\\");
                int indexPunto = this.handledFileName.lastIndexOf(".");
                //this.handledFileName = "converted-"+getFileName().substring(indexBarra, indexPunto) + ".jpg";
                String nuevoNombre = this.handledFileName.substring(indexBarra, indexPunto) + "-converted.jpg";
                File nuevoArchivo = new File("./Temporal/" + nuevoNombre);
                new File(nuevoArchivo.getParent()).mkdirs();
                ImageIO.write(bi, "jpg", nuevoArchivo);
            }
        }
    }
}
