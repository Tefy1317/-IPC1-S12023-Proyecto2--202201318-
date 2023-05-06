import proyecto2.ImageHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class JPEGImageHandlerRotator extends ImageHandler {
    private BufferedImage bi;
    public JPEGImageHandlerRotator(String filename) {
        super(filename);
    }

    @Override
    public void readFile() throws Exception {
        System.out.println("Imagen: "+this.handledFileName);
        File file = new File(this.handledFileName);
        bi = ImageIO.read(file);
    }

    @Override
    public void generateFiles() throws Exception {
        BufferedImage copiaRX = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage copiaRY = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                int pix = bi.getRGB(i, j);
                int nPosX = (int) (bi.getWidth()- 1 - i);
                int nPosY = (int) (bi.getHeight()- 1 - j);
                copiaRX.setRGB(nPosX, j, pix);
                copiaRY.setRGB(i, nPosY, pix);
            }
        }
        int indexBarra = this.handledFileName.lastIndexOf("\\");
        int indexPunto = this.handledFileName.lastIndexOf(".");

        String nombreHorizontal = this.handledFileName.substring(indexBarra,indexPunto)+"-Hrotation.bmp";
        File nuevoArchivoH = new File("./Temporal/"+nombreHorizontal);
        new File(nuevoArchivoH.getParent()).mkdirs();
        ImageIO.write(copiaRY, "bmp", nuevoArchivoH);

        String nombreVertical = this.handledFileName.substring(indexBarra,indexPunto)+"-Vrotation.bmp";
        File nuevoArchivoV = new File("./Temporal/"+nombreVertical);
        new File(nuevoArchivoV.getParent()).mkdirs();
        ImageIO.write(copiaRX, "bmp", nuevoArchivoV);

    }
}
