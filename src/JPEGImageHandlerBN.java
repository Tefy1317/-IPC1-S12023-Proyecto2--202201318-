import proyecto2.ImageHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class JPEGImageHandlerBN extends ImageHandler {
    public JPEGImageHandlerBN(String filename) {
        super(filename);
    }

    private BufferedImage bi;

    @Override
    public void readFile() throws Exception {
        System.out.println("Imagen: "+this.handledFileName);
        File file = new File(this.handledFileName);
        bi = ImageIO.read(file);
    }

    @Override
    public void generateFiles() throws Exception {
        BufferedImage copiaBN = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int i = 0; i < bi.getWidth(); i++){
            for(int j = 0; j < bi.getHeight(); j++){
                int pix = bi.getRGB(i, j);

                Color color = new Color(pix);

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int alpha = color.getAlpha();
                int gris = (red+green+blue)/3;

                Color colorGris = new Color(gris,gris,gris,alpha);
                copiaBN.setRGB(i, j, colorGris.getRGB());
            }
            int indexBarra = this.handledFileName.lastIndexOf("\\");
            int indexPunto = this.handledFileName.lastIndexOf(".");


            String nombreBN = this.handledFileName.substring(indexBarra,indexPunto)+"-BN.bmp";
            File nuevoArchivoBN = new File("./Temporal/"+nombreBN);
            new File(nuevoArchivoBN.getParent()).mkdirs();
            ImageIO.write(copiaBN, "bmp", nuevoArchivoBN);
        }
    }

}
