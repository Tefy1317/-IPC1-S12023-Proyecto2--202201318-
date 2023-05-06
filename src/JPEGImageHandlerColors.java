import proyecto2.ImageHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class JPEGImageHandlerColors extends ImageHandler {
    private BufferedImage bi;
    public JPEGImageHandlerColors(String filename) {
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
        BufferedImage copiaRoja = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage copiaVerde = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage copiaAzul = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage copiaSepia = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int i = 0; i < bi.getWidth(); i++){
            for(int j = 0; j < bi.getHeight(); j++){
                int pix = bi.getRGB(i, j);
                Color color = new Color(pix);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int alpha = color.getAlpha();

                Color colorRojo = new Color(red,0,0,alpha);
                Color colorAzul = new Color (0,0,blue,alpha);
                Color colorVerde = new Color(0,green,0,alpha);

                int nRojo = (int)(red * 0.393 + green * 0.769 + blue * 0.189);
                int nVerde = (int)(red * 0.349 + green * 0.686 + blue * 0.168);
                int nAzul = (int)(red * 0.272 + green * 0.534 + blue * 0.131);

                if(nRojo > 255){
                    nRojo = 255;
                }
                if(nVerde > 255){
                    nVerde = 255;
                }
                if (nAzul > 255){
                    nAzul = 255;
                }

                Color colorSepia = new Color(nRojo, nVerde, nAzul, alpha);

                copiaRoja.setRGB(i, j, colorRojo.getRGB());
                copiaAzul.setRGB(i, j, colorAzul.getRGB());
                copiaVerde.setRGB(i, j, colorVerde.getRGB());
                copiaSepia.setRGB(i, j, colorSepia.getRGB());
            }
        }
            int indexBarra = this.handledFileName.lastIndexOf("\\");
            int indexPunto = this.handledFileName.lastIndexOf(".");


            String nombreRojo = this.handledFileName.substring(indexBarra,indexPunto)+"-Rojo.bmp";
            File nuevoArchivoRojo = new File("./Temporal/"+nombreRojo);
            new File(nuevoArchivoRojo.getParent()).mkdirs();
            ImageIO.write(copiaRoja, "bmp", nuevoArchivoRojo);

        String nombreAzul = this.handledFileName.substring(indexBarra,indexPunto)+"-Azul.bmp";
        File nuevoArchivoAzul = new File("./Temporal/"+nombreAzul);
        new File(nuevoArchivoAzul.getParent()).mkdirs();
        ImageIO.write(copiaAzul, "bmp", nuevoArchivoAzul);

        String nombreVerde = this.handledFileName.substring(indexBarra,indexPunto)+"-Verde.bmp";
        File nuevoArchivoVerde = new File("./Temporal/"+nombreVerde);
        new File(nuevoArchivoVerde.getParent()).mkdirs();
        ImageIO.write(copiaVerde, "bmp", nuevoArchivoVerde);

        String nombreSepia = this.handledFileName.substring(indexBarra,indexPunto)+"-Sepia.bmp";
        File nuevoArchivoSepia = new File("./Temporal/"+nombreSepia);
        new File(nuevoArchivoSepia.getParent()).mkdirs();
        ImageIO.write(copiaSepia, "bmp", nuevoArchivoSepia);
    }
}
