package Clases.Socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        VentanaCliente ventanaC = new VentanaCliente();
    }
}

class VentanaCliente extends JFrame {
    private JTextField textoUsuario;
    private JTextField textoDireccion;
    private JTextArea textoHistorial;
    private JTextField campoEscritura;
    private JButton botonEnviar;

    public VentanaCliente() {
        setTitle("Chat");
        setBounds(600, 300, 280, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        add(new LaminaSuperior(), BorderLayout.NORTH);
        add(new LaminaCentral(), BorderLayout.CENTER);
        add(new LaminaInferior(), BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    class LaminaSuperior extends JPanel {

        public LaminaSuperior() {
            setLayout(new GridLayout(2, 2));
            add(new JLabel("Usuario:"));
            textoUsuario = new JTextField("Exequiel Venegas");
            add(textoUsuario);
            add(new JLabel("Contacto:"));
            textoDireccion = new JTextField("192.168.1.87");
            add(textoDireccion);
        }
    }

    class LaminaCentral extends JPanel {

        public LaminaCentral() {
            textoHistorial = new JTextArea(15, 20);
            add(textoHistorial);
        }
    }

    class LaminaInferior extends JPanel {
        private PaqueteDatos datos;
        private String textosRecibidos;

        public LaminaInferior() {
            setLayout(new BorderLayout());
            campoEscritura = new JTextField();
            add(campoEscritura, BorderLayout.CENTER);
            botonEnviar = new JButton("Enviar");
            add(botonEnviar, BorderLayout.EAST);

            botonEnviar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    datos = new PaqueteDatos(textoUsuario, textoDireccion, campoEscritura);
                    enviarDatos(datos);
                    recibirDatos();

                }
            });
        }

        private void enviarDatos(PaqueteDatos datos) {
            try {
                Socket emisor = new Socket(textoDireccion.getText(), 6193);
                ObjectOutputStream flujoSalida = new ObjectOutputStream(emisor.getOutputStream());
                flujoSalida.writeObject(datos);
            } catch (IOException ex) {
                System.out.println("Error al conectar con el servidor.");
                ex.printStackTrace();
            }
        }

        private void recibirDatos() {
            try {
                ServerSocket servidorReceptor = new ServerSocket(6194);
                while (true) {
                    Socket receptor = servidorReceptor.accept();
                    DataInputStream flujoEntrada = new DataInputStream(receptor.getInputStream());
                    textosRecibidos = flujoEntrada.readUTF();
                    textoHistorial.append(textosRecibidos);
                    receptor.close();
                }
            } catch (IOException e) {
                System.out.println("Error al usar el puerto 6193.");
                e.printStackTrace();
            }
        }
    }
}

class PaqueteDatos implements Serializable {
    private String usuario;
    private String ip;
    private String texto;

    public PaqueteDatos(JTextField usuario, JTextField ip, JTextField texto) {
        this.usuario = usuario.getText();
        this.ip = ip.getText();
        this.texto = texto.getText();
    }

    public String getUsuario() {
        return usuario;
    }

    public String getIp() {
        return ip;
    }

    public String getTexto() {
        return texto;
    }
}


