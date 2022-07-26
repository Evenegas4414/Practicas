package Clases.LecturaEscritura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferLector {
    public static void main(String[] args) {

        FileReader miArchivo = null;
        try {
            miArchivo = new FileReader(
                    "C:\\Users\\exequ\\Projects\\Java\\Ejemplos\\src\\com\\exequiel\\ej\\res\\data.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader nuevoLector = new BufferedReader(miArchivo);
        String linea = "";
        try {
            do {
                linea = nuevoLector.readLine();
                if (linea != null) {
                    System.out.println(linea);
                }
            } while (linea != null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                nuevoLector.close();
                miArchivo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
