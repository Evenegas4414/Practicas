package Clases.Serializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class StreamByte {
    public static void main(String[] args) {
        FileInputStream miStreamInput;
        ArrayList<Integer> miListaBytes =  new ArrayList<>();
        int lecturaBytes = -1;
        int cantidadBytes = 0;

        try {
            miStreamInput = new FileInputStream(
                    "C:/Users/exequ/Projects/Java/Ejemplos/src/com/exequiel/ej/res/eva.jpg");
            do {
                try {
                    lecturaBytes = miStreamInput.read();
                    if (lecturaBytes != -1) {
                        miListaBytes.add(lecturaBytes);
                        System.out.println(lecturaBytes);
                        cantidadBytes++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (lecturaBytes != -1);
            try {
                miStreamInput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
        System.out.println(cantidadBytes);
        CreadorArchivo.creaArchivo(miListaBytes);
    }
}

class CreadorArchivo {
    public CreadorArchivo() {
    }
    public static void creaArchivo(ArrayList<Integer> listaBytes) {

        try {
            FileOutputStream miStreamOutput = new FileOutputStream(
                    "C:/Users/exequ/Projects/Java/Ejemplos/src/com/exequiel/ej/res/eva-copia.jpg");
            for (Integer lb: listaBytes) {
                try {
                    miStreamOutput.write(lb);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        };
    }
}
