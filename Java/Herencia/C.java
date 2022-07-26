package Clases.Herencia;

public class C extends B{

    public C(int x, int y) {
        super(5, 5);
        super.a = 6;
        System.out.println("C: " + a + " " + super.a + " ");
    }
}
