package org.example; // El paquete donde reside la clase, organiza el código en módulos.

import javax.swing.*; // Importa las clases para la creación de interfaces gráficas (JFrame, JPanel, JTable, etc.).
import javax.swing.event.ListSelectionEvent; // Importa la clase para manejar eventos de selección en listas/tablas.
import javax.swing.event.ListSelectionListener; // Importa el listener que detecta cambios en la selección de filas.
import javax.swing.table.DefaultTableModel; // Importa el modelo de tabla para gestionar los datos de la tabla.
import java.awt.event.ActionEvent; // Importa la clase para manejar eventos de acción (como los clics de botones).
import java.awt.event.ActionListener; // Importa la interfaz para manejar acciones de eventos.

public class Principal extends JFrame { // La clase Principal hereda de JFrame, lo que significa que representa una ventana.
    private JPanel panel1; // Declaración del panel que contiene los elementos de la interfaz gráfica.
    private JTable table1; // Declaración de una tabla para mostrar datos en la interfaz gráfica.
    private JButton button1; // Declaración de un botón.

    private DefaultTableModel model; // Declaración del modelo de la tabla, que contendrá y gestionará los datos.

    public Principal() { // Constructor de la clase Principal, donde se configura la ventana y su funcionalidad.

        // Se crea un array con los nombres de las columnas de la tabla.
        String[] cabecera = {"Titulo","Plataforma","Año"};

        // Se inicializa el modelo de la tabla con la cabecera, y se indica que inicialmente no tiene filas (0 filas).
        model = new DefaultTableModel(cabecera,0);

        // Se asigna el modelo a la tabla para que ésta use el modelo y muestre los datos.
        table1.setModel(model);

        // Recorremos una lista de juegos (Data.games) y por cada juego se añade una fila a la tabla.
        for(Game g : Data.games){
            // Se crea un arreglo con los datos del juego (título, plataforma y año) y se añade como una nueva fila al modelo de la tabla.
            Object[] row = { g.getTitle(), g.getPlatform(), g.getYear() };
            model.addRow(row); // Se añade la fila al modelo de la tabla.
        }

        // Se establece el contenido del JFrame como el panel1, donde están los componentes gráficos.
        setContentPane(panel1);

        // Configura la operación por defecto al cerrar la ventana, es decir, la aplicación se cierra cuando se cierra la ventana.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establece el título de la ventana.
        setTitle("Lista de Juegos");

        // Ajusta el tamaño de la ventana para que se adapte al contenido.
        pack();

        // Centra la ventana en la pantalla.
        setLocationRelativeTo(null);

        // Agrega un listener que se activará cuando se seleccione una fila en la tabla.
        table1.getSelectionModel().addListSelectionListener(
                (ListSelectionEvent e) -> {
                    // Si el evento está en proceso de ajuste, se interrumpe para evitar acciones múltiples.
                    if(e.getValueIsAdjusting()) return;

                    // Imprime en consola el índice de la fila seleccionada.
                    System.out.println( table1.getSelectedRow() );

                    // Obtiene los valores de la fila seleccionada y los convierte a las variables correspondientes.
                    var title = model.getValueAt(table1.getSelectedRow(), 0).toString(); // Título del juego.
                    var platform = model.getValueAt(table1.getSelectedRow(), 1).toString(); // Plataforma del juego.
                    var year = (Integer) model.getValueAt(table1.getSelectedRow(), 2); // Año del juego.

                    // Imprime los detalles del juego seleccionado (título, plataforma y año).
                    System.out.println(title + " " + platform + " " + year);

                    // Guarda el juego seleccionado en una variable global `Session.gameSelected` para usarlo en otra parte del programa.
                    Session.gameSelected = new Game(title, platform, year);

                    // Crea una nueva ventana (Info) y la muestra al usuario.
                    var info = new Info();
                    info.setVisible(true);
                }
        );

        // Añade un listener al botón1, que detectará cuando el botón sea presionado.
        button1.addActionListener((ActionEvent e)->{
            // Este bloque está vacío, puedes añadir funcionalidad aquí.
        });
    }
}
