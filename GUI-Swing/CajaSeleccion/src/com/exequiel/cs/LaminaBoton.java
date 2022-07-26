package com.exequiel.cs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaminaBoton extends JPanel {
    JButton botonMostrar;

    public LaminaBoton() {
        botonMostrar = new JButton("Mostrar Diálogo");
        add(botonMostrar);
        botonMostrar.addActionListener(new AccionMostrar());
    }

    private static class AccionMostrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LaminaRadio.mostrarDialogo();
        }
    }
}
