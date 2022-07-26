package com.exequiel.cs;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana() {
        setTitle("Caja de Diálogos");
        setBounds(100, 100, 600, 400);
        setResizable(false);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(new LaminaRadio(), BorderLayout.CENTER);
        add(new LaminaBoton(), BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }
}
