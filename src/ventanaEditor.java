import proyecto2.JPEGHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ventanaEditor {
    private JRadioButton JPEGABMPYRadioButton;
    private JButton seleccionarImagenButton;
    private JLabel ImageLabel;
    public JPanel JPanelEditor;
    private JButton JPEGABMPYButton;
    private JButton copiaJPEGButton;
    private JButton rojoVerdeAzulSepiaButton;
    private JButton modificarImagenButton;
    private JButton blancoYNegroButton;
    private JButton regresarButton;
    private Nodo imgActual;
    private String fileName;

    public ventanaEditor() {
    seleccionarImagenButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File choosedFileName = fileChooser.getSelectedFile();
                System.out.println(choosedFileName);
                ImageLabel.setText(choosedFileName.toString());
                fileName = choosedFileName.toString();

            }
        }
    });
        JPEGABMPYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JPEGHandler.runHandler(new JPEGtoBMPImage(fileName));
                }catch (Exception exception){
                    exception.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "PROCESAMIENTO DE IMAGEN COMPLETO :)");
            }
        });
        copiaJPEGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JPEGHandler.runHandler(new JPEGImageCopy(fileName));
                }catch (Exception exception){
                    exception.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "COPIA CREADA CON EXITO");
            }
        });
        rojoVerdeAzulSepiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JPEGHandler.runHandler(new JPEGImageHandlerColors(fileName));
                }catch (Exception exception){
                    exception.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "IMAGENES CON COLORES Y SEPIA GENERADAS CON EXITO");
            }
        });
        modificarImagenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JPEGHandler.runHandler(new JPEGImageHandlerRotator(fileName));
                }catch (Exception exception){
                    exception.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "IMAGEN MODIFICADA CON EXITO");
            }
        });
        blancoYNegroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JPEGHandler.runHandler(new JPEGImageHandlerBN(fileName));
                }catch (Exception exception){
                    exception.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "IMAGEN GENERADA EN BLANCO Y NEGRO CON EXITO");
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.setContentPane(new ventanaPrincipal().JPanelVentana);
                Main.frame.pack();
                Main.frame.setVisible(true);
                Main.frame.setSize(900, 600);
            }
        });
    }
}
