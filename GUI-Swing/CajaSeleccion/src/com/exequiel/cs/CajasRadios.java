package com.exequiel.cs;

import javax.swing.*;
import java.util.ArrayList;

public class CajasRadios extends JPanel {
    ArrayList<JRadioButton> botonesRadios = new ArrayList<>();
    ButtonGroup grupoCaja = new ButtonGroup();

    public CajasRadios(String titulo, String[] listaRadio) {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        crearBotonesRadios(listaRadio);
        botonesRadios.get(0).setSelected(true);
    }

    private void crearBotonesRadios(String[] listaRadio) {
        for (int i = 0; i < listaRadio.length; i++) {
            botonesRadios.add(new JRadioButton(listaRadio[i]));
            botonesRadios.get(i).setActionCommand(listaRadio[i]);
            grupoCaja.add(botonesRadios.get(i));
            add(botonesRadios.get(i));
        }
    }

    public String dameSeleccion() {
        return grupoCaja.getSelection().getActionCommand();
    }
}
