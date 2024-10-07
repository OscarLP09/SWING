package org.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Hello 2DAM");
        frame.setSize(300,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var label = new JLabel("Hello World");
        var button = new JButton("Click Me");

        JPanel footer = new JPanel();
        footer.add(label);
        footer.add(button);

        JPanel principal = new JPanel();
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
        var label2 = new JLabel("Welcome to Swing");
        var texto = new JTextField(20);

        var lista = new JList<String>();

        var modelo = new DefaultListModel<String>();
        lista.setModel(modelo);


        principal.add(label2);
        principal.add(texto);
        JScrollPane scrollPane = new JScrollPane(lista);
        principal.add(scrollPane);



        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(principal, BorderLayout.CENTER);
        content.add(footer, BorderLayout.SOUTH);


        button.addActionListener( (e) -> {
            label2.setText("Hola mundo");
            String saludo = "Hola "+texto.getText();
            //JOptionPane.showMessageDialog(frame,saludo,"Titulo",JOptionPane.WARNING_MESSAGE);
            modelo.addElement(saludo);
        });

        frame.setContentPane(content);
        frame.setVisible(true);
    }
}