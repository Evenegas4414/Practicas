package Clases.Socket;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        VentanaServidor ventanaS = new VentanaServidor();
    }
}

class VentanaServidor extends JFrame {
    public VentanaServidor() {
        setTitle("Servidor");
        setBounds(1200, 300, 280, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LaminaServidor laminaTexto = new LaminaServidor();
        add(laminaTexto);

        Thread laminaTextoHilo = new Thread(laminaTexto);
        laminaTextoHilo.start();

        setVisible(true);
    }
}

class LaminaServidor extends JPanel implements Runnable {
    private JTextArea areaTexto;
    private String textosRecibidos;
    PaqueteDatos datosRecibidos;

    public LaminaServidor() {
        setLayout(new BorderLayout());
        areaTexto = new JTextArea();
        textosRecibidos = "";
        add(areaTexto, BorderLayout.CENTER);

    }

    @Override
    public void run() {
        try {
            ServerSocket servidorReceptor = new ServerSocket(6193);
            while (true) {
                Socket receptor = servidorReceptor.accept();
                ObjectInputStream flujoEntrada = new ObjectInputStream(receptor.getInputStream());
                try {
                    datosRecibidos = (PaqueteDatos) flujoEntrada.readObject();
                    textosRecibidos = "" + datosRecibidos.getUsuario() + ": \n" + datosRecibidos.getTexto() + "\n";
                    areaTexto.append(textosRecibidos);
                    receptor.close();
                    enviarDatos();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                flujoEntrada.close();
            }
        } catch (IOException e) {
            System.out.println("Error al usar el puerto 6193.");
            e.printStackTrace();
        }
    }

    public void enviarDatos() {
        try {
            Socket emisor = new Socket(datosRecibidos.getIp(), 6194);
            DataOutputStream flujoSalida = new DataOutputStream(emisor.getOutputStream());
            flujoSalida.writeUTF(areaTexto.getText());
        } catch (IOException ex) {
            System.out.println("Error al conectar con el servidor.");
            ex.printStackTrace();
        }
    }
}
