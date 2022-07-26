package swing.hilosCirculos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class UsoHilos {
    public static void main(String[] args) {
        VentanaRebote miVentana = new VentanaRebote();
        miVentana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        miVentana.setVisible(true);
    }
}

class HilosCirculos implements Runnable {

    private Circulo unCirculo;
    private Component componente;

    public HilosCirculos(Circulo circulo, Component component) {
        unCirculo = circulo;
        componente = component;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 3000; i++) {
            unCirculo.moverCirculo(componente.getBounds());
            componente.paint(componente.getGraphics());
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



class Circulo {

    private static final int TAMX = 15;
    private static final int TAMY = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;

    public Ellipse2D obtenerForma() {
        return new Ellipse2D.Double(x, y, TAMX, TAMY);
        }

    public void moverCirculo(Rectangle2D limites) {
        x += dx;
        y += dy;

        if ( x < limites.getMinX()) {
            x = limites.getMinX();
            dx = -dx;
        }
        if ( x + TAMX >= limites.getMaxX()) {
            x = limites.getMaxX() - TAMX;
            dx = -dx;
        }

        if ( y < limites.getMinY()) {
            y = limites.getMinY();
            dy = -dy;
        }
        if ( y + TAMY >= limites.getMaxY()) {
            y = limites.getMaxY() - TAMY;
            dy = -dy;
        }
    }
}



class VentanaRebote extends JFrame {
    LaminaCirculo laminaSuperior = new LaminaCirculo();
    LaminaBotones laminaInferior = new LaminaBotones();
    Runnable miRun;
    Thread miHilo;

    public VentanaRebote() {
        setTitle("Rebotes");
        setBounds(600, 300, 400, 350);

        add(laminaSuperior, BorderLayout.CENTER);
        add(laminaInferior, BorderLayout.SOUTH);

        ponerBoton(laminaInferior, "¡Dale!", new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                comenzarJuego();
            }
        });

        ponerBoton(laminaInferior, "¡Detener!", new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                detener();
            }
        });

        ponerBoton(laminaInferior, "Salir", new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                System.exit(0);
            }
        });
    }

    public void ponerBoton(Container c, String titulo, ActionListener oyente) {
        JButton boton = new JButton(titulo);
        c.add(boton);
        boton.addActionListener(oyente);
    }

    public void comenzarJuego() {
        Circulo circulo = new Circulo();
        laminaSuperior.add(circulo);
        miRun = new HilosCirculos(circulo, laminaSuperior);
        miHilo = new Thread(miRun);
        miHilo.start();
    }

    public void detener() {

    }
}


class LaminaCirculo extends JPanel {

    private ArrayList<Circulo> circulos = new ArrayList<Circulo>();

    public void add(Circulo c) {
        circulos.add(c);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Circulo c: circulos) {
            g2.fill(c.obtenerForma());
        }
    }
}

class LaminaBotones extends JPanel {
}

