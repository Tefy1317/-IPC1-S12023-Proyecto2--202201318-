import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaPrincipal {
    private JTextField textField_Usuario;
    private JButton BibliotecaButton;
    public JPanel JPanelVentana;
    private JButton ingresarAEditorButton;
    private JButton ingresarAConvertidorButton;
public ventanaPrincipal() {
    BibliotecaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(textField_Usuario.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN USUARIO");
            }else{
                Main.listaSimple.add(new Usuario(textField_Usuario.getText()));
                System.out.println("Cantidad de usuarios: " + Main.listaSimple.getSize());
                for (int i = 0; i < Main.listaSimple.getSize(); i++) {
                    System.out.println("Usuario " + i + ": " + ((Usuario)Main.listaSimple.get(i)).getNombre());
                }

                Main.frame.setContentPane(new ventanaBiblioteca().JPanelBiblioteca);
                Main.frame.pack();
                Main.frame.setVisible(true);
                Main.frame.setSize(900, 600);
            }
        }
    });
    ingresarAEditorButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.frame.setContentPane(new ventanaEditor().JPanelEditor);
            Main.frame.pack();
            Main.frame.setVisible(true);
            Main.frame.setSize(900, 600);
        }
    });
    ingresarAConvertidorButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.frame.setContentPane(new ventanaConvertidor().JPanelConvertidor);
            Main.frame.pack();
            Main.frame.setVisible(true);
            Main.frame.setSize(900, 600);
        }
    });
}
}
