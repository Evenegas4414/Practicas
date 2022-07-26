package Clases.TryCatch;

import javax.swing.*;

public class VariasExcepciones {
    public static void main(String[] args) {
        try {
            division();
        } catch (ArithmeticException e) {
            System.out.println("Estas dividiendo por 0, no es posible dividir por 0.");
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getName());

        } catch (NumberFormatException e) {
            System.out.println("Lo introducido no es un número entero valido.");
        }
    }

    static void division() {
        int dividendo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el dividendo:",
                "División", JOptionPane.QUESTION_MESSAGE ));
        int divisor = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el dividendo:",
                "División", JOptionPane.QUESTION_MESSAGE ));
        int cuociente = dividendo / divisor;
        String resultado = "El resultado es : " + cuociente + ".";
        JOptionPane.showMessageDialog(null, resultado, "División", JOptionPane.INFORMATION_MESSAGE);
    }
}
