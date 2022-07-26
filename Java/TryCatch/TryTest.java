package Clases.TryCatch;


public class TryTest {

    public static void main(String[] args) {
        int n = 40;
        int x = 10;
        int d = 0;

        try {
            System.out.println(x);
            x = 999;
            System.out.println("Antes Imprimido");
            System.out.println(n/d);
            x = 123;
            System.out.println("Despues No imprimido");

        } catch (ArithmeticException e) {
            System.out.println(e);
            x = 4321;
        } finally {
            System.out.println("Finally");
            x = 7655;

        }
        System.out.println(x);
    }
}
