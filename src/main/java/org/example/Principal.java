package org.example;

import javax.swing.*; // Se importa todo el paquete de clases necesarias para crear interfaces gráficas (GUI)
import java.awt.event.ActionEvent; // Importa la clase ActionEvent, que se utiliza para manejar los eventos de acciones como un clic en un botón
import java.io.*; // Importa clases de Java necesarias para trabajar con archivos (lectura/escritura)
import java.util.ArrayList; // Importa la clase ArrayList, para trabajar con listas dinámicas
import java.util.List; // Importa la interfaz List, para definir listas genéricas

public class Principal extends JFrame { // La clase Principal extiende de JFrame, lo que significa que es una ventana gráfica
    // Declaración de los componentes de la interfaz gráfica

    private JButton cargarArchivoButton; // Botón que permitirá cargar un archivo

    private JPanel panel1; // Panel principal que contendrá los demás componentes

    private JTextArea textArea1; // Área de texto donde se mostrará el contenido del archivo


    private File selectedFile = null; // Archivo seleccionado por el usuario, inicialmente nulo

    public Principal() { // Constructor de la clase Principal, que inicializa la ventana y sus componentes

        // Configuración básica de la ventana gráfica (JFrame)

        setTitle("Notepad"); // Título de la ventana

        setSize(600, 400); // Tamaño de la ventana (ancho, alto)

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Operación que se ejecuta al cerrar la ventana, en este caso, finalizar el programa

        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        setResizable(false); // Impide que el usuario cambie el tamaño de la ventana

        setContentPane(panel1); // Establece el panel principal (panel1) como el contenido de la ventana

        // Acción del botón "Cargar Archivo"
        cargarArchivoButton.addActionListener((ActionEvent e) -> { // Se añade un ActionListener al botón para escuchar cuando es presionado

            JFileChooser fileChooser = new JFileChooser(); // Se crea una instancia (diálogo) para que el usuario elija un archivo

            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { // Si el usuario selecciona un archivo (botón "Abrir")

                selectedFile = fileChooser.getSelectedFile(); // Se guarda el archivo seleccionado en la variable selectedFile

                String textopantalla = FileUtils.loadTextFile(selectedFile); // Se lee el contenido del archivo seleccionado usando la clase auxiliar (FileUtils) y se guarda en la variable textopantalla

                textArea1.setText(textopantalla); // Se muestra el contenido del archivo en el JTextArea (textArea1)

                this.setTitle(selectedFile.getName()); // Se actualiza el título de la ventana con el nombre del archivo cargado
            }
        });
    }
}
