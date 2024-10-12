package org.example;

import java.io.*; // Se importan las clases necesarias para la lectura de archivos y manejo de excepciones
import java.util.List; // Se importa la clase List, utilizada para trabajar con listas dinámicas

public class FileUtils { // Clase auxiliar que contiene métodos estáticos para el manejo de archivos

    public static String loadTextFile(File file) { // Método estático que recibe un archivo y devuelve su contenido como un String

        String salida = ""; // Variable que almacenará el contenido del archivo

        try (var bfr = new BufferedReader(new FileReader(file))) { // Se utiliza un BufferedReader para leer el archivo línea por línea

            List<String> texto = bfr.lines().toList(); // Se leen todas las líneas del archivo y se guardan en una lista de cadenas (List<String>)

            // Se itera sobre la lista de líneas y se concatena cada línea al string de salida
            for (String s : texto) {
                salida = salida + s + "\n"; // Agrega cada línea del archivo, seguida de un salto de línea
            }
        } catch (FileNotFoundException ex) { // Captura la excepción si el archivo no se encuentra

            throw new RuntimeException(ex); // Lanza una RuntimeException si ocurre este error

        } catch (IOException ex) { // Captura cualquier otra excepción de entrada/salida (IOException)

            throw new RuntimeException(ex); // Lanza una RuntimeException si ocurre un error de E/S
        }

        return salida; // Devuelve el contenido del archivo como un String
    }
}
