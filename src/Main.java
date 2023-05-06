
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static JFrame frame;
    public static ImagenesListaDoble imagenesListaDoble = new ImagenesListaDoble();
    public static UsuariosListaSimple listaSimple = new UsuariosListaSimple();
    public static ArrayList<Categorias> categorias = new ArrayList<>();
    public static void main(String[] args) {
        categorias.add(new Categorias("General"));

        frame = new JFrame("Ugallery");
        frame.setContentPane(new ventanaPrincipal().JPanelVentana);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(900, 600);
    }
}