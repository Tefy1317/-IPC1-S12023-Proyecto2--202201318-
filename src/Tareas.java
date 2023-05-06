import proyecto2.ImageHandler;
import proyecto2.JPEGHandler;

public class Tareas implements Runnable{
private ImageHandler imageHandler;

public Tareas(String Imagepath, TipoT tarea){
    switch (tarea){
        case MODIFICAR:
            imageHandler = new JPEGImageHandlerRotator(Imagepath);
            break;
        case COPIA_JPEG:
            imageHandler = new JPEGImageCopy(Imagepath);
            break;
        case ROJO_VERDE_AZUL_SEPIA:
            imageHandler = new JPEGImageHandlerColors(Imagepath);
            break;
        case BMP_TO_JPEG:
            imageHandler = new JPEGtoBMPImage(Imagepath);
            break;
    }

}
    @Override
    public void run() {
        try {
            JPEGHandler.runHandler(imageHandler);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
