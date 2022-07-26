package Clases.LecturaEscritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Flujos {
    public static void main(String[] args) {

        try {
            FileReader miLectorArchivo = new FileReader(
                    "C:\\Users\\exequ\\Projects\\Java\\Ejemplos\\src\\com\\exequiel\\ej\\res\\data.txt");
            int c;
            do {
                c = miLectorArchivo.read();
                char letra = (char) c;
                System.out.print(letra);
            }
            while (c != -1);
        } catch (IOException e) {
            System.out.println("Archivo no encontrado.");
        }
    }
}

class LectorArchivos {

    public void leer() {
        try {
            FileReader miLectorArchivo = new FileReader(
                    "C:\\Users\\exequ\\Projects\\Java\\Ejemplos\\src\\com\\exequiel\\ej\\res\\data.txt");
            int c;
            do {
                c = miLectorArchivo.read();
                char letra = (char) c;
                System.out.print(letra);
            }
            while (c != -1);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        } catch (IOException e) {
            System.out.println("Error de lectura.");
        }
    }
}

class LectorArchivos2 {
    public void leer() {
        try {
            FileReader miLectorArchivo = new FileReader(
                    "C:\\Users\\exequ\\Projects\\Java\\Ejemplos\\src\\com\\exequiel\\ej\\res\\data.txt");
            int c;
            try {
                do {
                    c = miLectorArchivo.read();
                    char letra = (char) c;
                    System.out.print(letra);
                }
                while (c != -1);
            } catch (IOException e) {
                System.out.println("Error de lectura.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        }
    }
}



