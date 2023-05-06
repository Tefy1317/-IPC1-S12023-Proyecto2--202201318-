import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ventanaConvertidor {
    private JComboBox UsuariocomboBox;
    private JComboBox CategoriacomboBox;
    private JButton agregarButton;
    public JPanel JPanelConvertidor;
    private JProgressBar progressBar1;
    private JButton regresarButton;
    private JButton ejecutarEnParaleloButton;
    private JRadioButton JPEGABMPYRadioButton;
    private JRadioButton copiaJPEGRadioButton;
    private JRadioButton rojoVerdeAzulSepiaRadioButton;
    private JRadioButton modificarImagenRadioButton;
    private JRadioButton blancoYNegroRadioButton;
    private String usuarios;
public ventanaConvertidor() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.frame.setContentPane(new ventanaPrincipal().JPanelVentana);
            Main.frame.pack();
            Main.frame.setVisible(true);
            Main.frame.setSize(900, 600);
        }
    });
    ejecutarEnParaleloButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
}

    private void createUIComponents() {
        // TODO: place custom component creation code here

        CategoriacomboBox = new JComboBox<Categorias>();
        for (Categorias c :
                Main.categorias) {
            CategoriacomboBox.addItem(c);
        }

        UsuariocomboBox = new JComboBox<UsuariosListaSimple>();
        for (int i = 0; i < Main.listaSimple.getSize(); i++) {
            usuarios = ((Usuario)Main.listaSimple.get(i)).getNombre();
            UsuariocomboBox.addItem(usuarios);
        }
    }
}
