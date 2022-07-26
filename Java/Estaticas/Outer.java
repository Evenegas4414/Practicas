package Clases.Estaticas;

public class Outer {

    public static void main(String[] args) {
        System.out.println(OutInner.staticString);
        OutInner.Inner.MyStaticMethod("Hola Static", new OutInner());
        OutInner oi = new OutInner();
        oi.InnerMethod();
        OutInner.Inner oiinner = new OutInner.Inner();
        oiinner.MyMethod("Hello", oi);

    }
}

class OutInner {

    private String nonStaticString = "Non-Static String";
    public static String staticString = "Static String";

    public void InnerMethod() {
        System.out.println("inner method");
    }

    public static class Inner {

        public void MyMethod(String sent, OutInner ob) {
            System.out.println("MyMethod: " + sent + staticString + OutInner.staticString + ob.nonStaticString);

        }

        public static void MyStaticMethod(String sent, OutInner ob) {
            System.out.println("MyStaticMethod: " + sent + staticString + OutInner.staticString + ob.nonStaticString);

        }
    }
}
