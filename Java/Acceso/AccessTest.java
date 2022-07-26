package Clases.Acceso;

public class AccessTest {
    public static void main(String[] args) {
        Test ob = new Test();

        ob.a = 5;
        ob.b = 4;
        //ob.c = 3;

        ob.setC(3);

        System.out.println(ob.a);
        System.out.println(ob.b);
        System.out.println(ob.getC());
    }
}
