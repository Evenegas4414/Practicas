package com.exequiel.cs;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class LaminaRadio extends JPanel {
    static final ArrayList<CajasRadios> listaCajas = new ArrayList<>();

    public LaminaRadio() {
        setLayout(new GridLayout(2, 3));

        listaCajas.add(new CajasRadios("Tipo", new String[]{"Mensaje", "Confirmar",
                "Opción", "Entrada"}));
        listaCajas.add(new CajasRadios("Tipo Mensaje", new String[]{"ERROR_MESSAGE",
                "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE"}));
        listaCajas.add(new CajasRadios("Mensaje", new String[]{"Cadena", "Icono", "Componente",
                "Otros", "Object[]"}));
        listaCajas.add(new CajasRadios("Confirmar", new String[]{"DEFAULT_OPTION", "YES_NO_CAPTION",
                "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"}));
        listaCajas.add(new CajasRadios("Opción", new String[]{"null", "String[]", "Icon[]", "Object[]"}));
        listaCajas.add(new CajasRadios("Entrada", new String[]{"Campo de texto", "Combo"}));
        for (CajasRadios cr : listaCajas) {
            add(cr);
        }
    }

    protected static void mostrarDialogo() {
        System.out.println(listaCajas.get(0).dameSeleccion());

        switch (listaCajas.get(0).dameSeleccion()) {
            case "Mensaje":
                    JOptionPane.showMessageDialog(Main.marcoPrincipal, configurarMensaje(),
                            "showMessageDialog", configurarTipoMensaje());
                    break;
            case "Confirmar":
                    JOptionPane.showConfirmDialog(Main.marcoPrincipal, configurarMensaje(),
                            "showConfirmDialog", configurarConfirmar(), configurarTipoMensaje());
                    break;
            case "Opción":
                    JOptionPane.showOptionDialog(Main.marcoPrincipal, configurarMensaje(),
                            "showOptionDialog", configurarConfirmar(), configurarTipoMensaje(),
                            null, configurarOpcion(), null);
                    break;
            case "Entrada":
                    JOptionPane.showInputDialog(Main.marcoPrincipal, configurarMensaje(), "showInputDialog",
                            configurarTipoMensaje(), null , configurarEntrada(), null);
                    break;
            default:
                System.out.println("No funciona TIPO");
        }
    }

    private static int configurarTipoMensaje() {
        System.out.println(listaCajas.get(1).dameSeleccion());

        switch (listaCajas.get(1).dameSeleccion()) {
            case "ERROR_MESSAGE":
                return JOptionPane.ERROR_MESSAGE;
            case "INFORMATION_MESSAGE":
                return JOptionPane.INFORMATION_MESSAGE;
            case "WARNING_MESSAGE":
                return JOptionPane.WARNING_MESSAGE;
            case "QUESTION_MESSAGE":
                return JOptionPane.QUESTION_MESSAGE;
            case "PLAIN_MESSAGE":
                return JOptionPane.PLAIN_MESSAGE;
            default:
                System.out.println("No funciona TIPO MENSAJE");
                return 0;
        }
    }

    private static Object configurarMensaje() {
        System.out.println(listaCajas.get(2).dameSeleccion());

        String cadena = "Cadena";
        ImageIcon icono = new ImageIcon("src/com/exequiel/cs/icon/jicon.png");
        JCheckBoxMenuItem chequeo = new JCheckBoxMenuItem("Checkbox");
        LocalDate fecha = LocalDate.now();
        Object[] listaObjetos = new Object[]{cadena, icono, chequeo, fecha};

        switch (listaCajas.get(2).dameSeleccion()) {
            case "Cadena":
                    return cadena;
            case "Icono":
                    return icono;
            case "Componente":
                    return chequeo;
            case "Otros":
                    return fecha;
            case "Object[]":
                    return listaObjetos;
            default:
                System.out.println("No funciona");
                return null;
        }
    }

    private static int configurarConfirmar() {
        System.out.println(listaCajas.get(3).dameSeleccion());

        switch (listaCajas.get(3).dameSeleccion()) {
            case "DEFAULT_OPTION":
                return JOptionPane.DEFAULT_OPTION;
            case "YES_NO_CAPTION":
                return JOptionPane.YES_NO_OPTION;
            case "YES_NO_CANCEL_OPTION":
                return  JOptionPane.YES_NO_CANCEL_OPTION;
            case "OK_CANCEL_OPTION":
                return  JOptionPane.OK_CANCEL_OPTION;
            default:
                System.out.println("No funciona CONFIRMAR");
                return 0;
        }
    }

    private static Object[] configurarOpcion() {
        System.out.println(listaCajas.get(4).dameSeleccion());

        String cadena = "Cadena";
        String[] listaCadenas = {"Opción A", "Opción B", "Opción C"};
        ImageIcon icono = new ImageIcon("src/com/exequiel/cs/icon/jicon.png");
        ImageIcon[] listaIconos = {new ImageIcon("src/com/exequiel/cs/icon/jicon.png"),
                new ImageIcon("src/com/exequiel/cs/icon/jicon.png"),
                new ImageIcon("src/com/exequiel/cs/icon/jicon.png")};
        JCheckBoxMenuItem chequeo = new JCheckBoxMenuItem("Checkbox");
        LocalDate fecha = LocalDate.now();
        Object[] listaObjetos = new Object[]{cadena, icono, chequeo, fecha};

        switch (listaCajas.get(4).dameSeleccion()) {
            case "String[]":
                return listaCadenas;
            case "Icon[]":
                return listaIconos;
            case "Object[]":
                return listaObjetos;
            case "null":
                return null;
            default:
                System.out.println("No funciona");
                return null;
        }
    }

    private static Object[] configurarEntrada() {
        System.out.println(listaCajas.get(5).dameSeleccion());

        String[] listaCadenas = {"Opción A", "Opción B", "Opción C"};

        switch (listaCajas.get(5).dameSeleccion()) {
            case "Campo de texto":
                return null;
            case "Combo":
                return listaCadenas;
            default:
                System.out.println("No funciona");
                return null;
        }
    }
}
