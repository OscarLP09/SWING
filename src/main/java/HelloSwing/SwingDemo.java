package HelloSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDemo extends JFrame {
    private JPanel panelMain;
    private JTextField txtName;
    private JButton btnClick;
    private JLabel contraseña;
    private JLabel usuario;
    private JPasswordField passwordField1;
    private JTextField txtusuario;

    public SwingDemo() {
        btnClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnClick, "Bienvenido de nuevo " + txtName.getText());

            }
        });
    }

    public static void main(String[] args) { // Se encarga del funcionamiento de la ventana
        SwingDemo frame = new SwingDemo(); // Creamos un objeto de nuestro frame
        frame.setContentPane(frame.panelMain); // Establece el panel de contenido
        frame.setTitle("Hello"); // Arriba en el titulo de la ventana pondra esto
        //frame.setBounds(600,200,200,200);
        frame.setSize(400, 500); // Tamaño de la ventana
        frame.setVisible(true); // Hacemos que la ventana sea visible
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // Hace que la ventana aparezca en el centro de la pantalla
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para que funcione el cerrar ventana
    }
}
