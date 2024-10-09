package org.example; // El paquete donde reside la clase, organiza el código en módulos.

import javax.swing.*; // Importa las clases necesarias para la interfaz gráfica (JButton, JLabel, JPanel, etc.).
import java.awt.event.ActionEvent; // Importa la clase para manejar eventos de acción, como clics de botones.
import java.awt.event.ActionListener; // Importa la interfaz para manejar eventos de acción de botones.

public class Info extends JDialog { // La clase Info hereda de JDialog, lo que significa que es un cuadro de diálogo (ventana modal).
    private JPanel contentPane; // Panel principal que contiene todos los componentes gráficos.
    private JButton buttonOK; // Botón "OK" que cierra el diálogo.
    private JLabel platform; // Etiqueta para mostrar la plataforma del juego seleccionado.
    private JLabel year; // Etiqueta para mostrar el año del juego seleccionado.
    private JLabel titulo; // Etiqueta para mostrar el título del juego seleccionado.

    public Info() { // Constructor de la clase Info, donde se configura la ventana de diálogo y su funcionalidad.

        // Establece el contenido del cuadro de diálogo con el panel principal.
        setContentPane(contentPane);

        // Hace que el cuadro de diálogo sea modal, es decir, bloquea la interacción con otras ventanas hasta que se cierre.
        setModal(true);

        // Define que el botón "OK" será el botón por defecto, lo que significa que al presionar Enter se activará.
        getRootPane().setDefaultButton(buttonOK);

        // Establece el título del cuadro de diálogo utilizando el título del juego seleccionado de la sesión.
        setTitle(Session.gameSelected.getTitle());

        // Centra el cuadro de diálogo en la pantalla.
        setLocationRelativeTo(null);

        // Muestra el título del juego seleccionado en la etiqueta correspondiente.
        titulo.setText(Session.gameSelected.getTitle());

        // Muestra la plataforma del juego seleccionado en la etiqueta correspondiente.
        platform.setText(Session.gameSelected.getPlatform());

        // Muestra el año del juego seleccionado en la etiqueta correspondiente, y lo convierte a cadena de texto.
        year.setText(Session.gameSelected.getYear().toString());

        // Ajusta el tamaño del cuadro de diálogo para que se adapte al contenido.
        pack();

        // Añade un listener al botón "OK", que se ejecutará cuando el botón sea presionado.
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(); // Llama al método onOK cuando el botón es presionado.
            }
        });
    }

    // Método que se ejecuta al hacer clic en el botón "OK".
    private void onOK() {
        // Aquí podrías añadir más código si se necesita realizar alguna acción antes de cerrar.
        dispose(); // Cierra el cuadro de diálogo.
    }
}
