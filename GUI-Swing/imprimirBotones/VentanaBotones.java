package swing.imprimirBotones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBotones extends JFrame {

    public VentanaBotones() {
        setTitle("Panel de control");
        setBounds(100, 100, 400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(new LaminaBotones());
        pack();
        setVisible(true);
    }
}

class LaminaBotones extends JPanel {
    JButton baComenzar = new JButton("Comenzar A");
    JButton baDetener = new JButton("Detener A");
    JButton bbComenzar = new JButton("Comenzar B");
    JButton bbDetener = new JButton("Detener B");
    Thread miThreadA;
    Thread miThreadB;

    public LaminaBotones() {
        setLayout(new GridLayout(2, 2));


        add(baComenzar);
        baComenzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable miRunA = new ImprimirA();
                miThreadA = new Thread(miRunA);
                miThreadA.start();
            }
        });

        add(bbComenzar);
        bbComenzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable miRunB = new ImprimirB();
                miThreadB = new Thread(miRunB);
                miThreadB.start();
            }
        });

        add(baDetener);
        baDetener.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miThreadA.interrupt();
            }
        });

        add(bbDetener);
        bbDetener.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miThreadB.interrupt();
            }
        });

    }

}
