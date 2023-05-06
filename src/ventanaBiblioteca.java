import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaBiblioteca {
    private JButton agregarImagenButton;
    private JButton eliminarImagenButton;
    private JButton anteriorButton;
    private JButton siguienteButton;
    private JLabel ImageLabel;
    private JButton agregarCategoríaButton;
    private JButton eliminarCategoríaButton;
    public JPanel JPanelBiblioteca;
    private JButton regresarButton;
    private JLabel Usuariolabel;
    private JComboBox CategoriascomboBox;
    private JTextField textFieldCategoria;
    private JButton asociarCategoriaButton;
    private Nodo imgActual;
    private Nodo usuarioActual;
    private String imagePath;
    private String categoria;
public ventanaBiblioteca() {
    imgActual = (Nodo) Main.imagenesListaDoble.peek();
    usuarioActual = (Nodo) Main.listaSimple.peek();
    System.out.println("ACTUAL: "+((Usuario)usuarioActual.getDato()).getNombre());

    Usuariolabel.setText("Usuario: "+((Usuario)usuarioActual.getDato()).getNombre());

    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Usuariolabel.setText(" ");
            Main.frame.setContentPane(new ventanaPrincipal().JPanelVentana);
            Main.frame.pack();
            Main.frame.setVisible(true);
            Main.frame.setSize(900, 600);
        }
    });
    agregarImagenButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int selec = fileChooser.showOpenDialog(JPanelBiblioteca);
            if (selec == JFileChooser.APPROVE_OPTION) {
                Main.imagenesListaDoble.add(fileChooser.getSelectedFile().getAbsolutePath());
                imgActual = (Nodo) Main.imagenesListaDoble.peek();
                agregarImagen(fileChooser.getSelectedFile().getAbsolutePath());
                imagePath = imgActual.getDato().toString();
            }
        }
    });
    siguienteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (imgActual == null) {
                return;
            }

            if (imgActual.getSiguiente() != null) {
                imgActual = imgActual.getSiguiente();
                agregarImagen((String) imgActual.getDato());
            }
        }
    });
    anteriorButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (imgActual == null) {
                return;
            }
            if (imgActual.getAnterior() != null) {
                imgActual = imgActual.getAnterior();
                agregarImagen((String) imgActual.getDato());
            }
        }
    });
    eliminarImagenButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (imgActual != null) {
                Main.imagenesListaDoble.delete(imgActual.getDato());
                if (imgActual.getSiguiente() != null) {
                    imgActual = imgActual.getSiguiente();
                    agregarImagen((String) imgActual.getDato());
                } else if (imgActual.getAnterior() != null) {
                    imgActual = imgActual.getAnterior();
                    agregarImagen((String) imgActual.getDato());
                } else {
                    imgActual = null;
                    ImageLabel.setIcon(null);
                }
            }
        }
    });
    agregarCategoríaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (textFieldCategoria.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "DEBE INGRESAR UNA CATEGORIA", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Main.categorias.add(new Categorias(textFieldCategoria.getText()));
            CategoriascomboBox.removeAllItems();
            for (Categorias c :
                    Main.categorias) {
                CategoriascomboBox.addItem(c);
            }
            JOptionPane.showMessageDialog(null, "CATEGORIA AGREGADA CORRECTAMENTE");
            textFieldCategoria.setText("");
        }
    });
    eliminarCategoríaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int indexEliminar = CategoriascomboBox.getSelectedIndex();
            Main.categorias.remove(indexEliminar);

            CategoriascomboBox.removeAllItems();
            for (Categorias c :
                    Main.categorias) {
                CategoriascomboBox.addItem(c);
            }
        }
    });
    asociarCategoriaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int indexseleccion = CategoriascomboBox.getSelectedIndex();
            Categorias seleccion = Main.categorias.get(indexseleccion);
            categoria = seleccion.getNombre();
            ((Usuario) usuarioActual.getDato()).setCategorias(categoria);
            String categoriaUsuarioActual;
            categoriaUsuarioActual = ((Usuario) usuarioActual.getDato()).getCategorias();
            System.out.println("Usuario: "+usuarioActual.getDato()+" Categoría asociada: "+categoriaUsuarioActual+" Path: "+imagePath);
        }
    });
}
    public void agregarImagen(String ruta) {
        ImageIcon imagen = new ImageIcon(ruta);
        ImageLabel.setIcon(imagen);
        ImageLabel.setSize(imagen.getIconWidth(), imagen.getIconHeight());
        ImageLabel.repaint();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        CategoriascomboBox = new JComboBox<Categorias>();
        for (Categorias c :
                Main.categorias) {
            CategoriascomboBox.addItem(c);
        }
    }
}
