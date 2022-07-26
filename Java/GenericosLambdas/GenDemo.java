package Clases.GenericosLambdas;

public class GenDemo {

    public static void main(String[] args) {
        Gen<String, Integer> myGen = new Gen<String, Integer>("Hola", 8);

        System.out.println(myGen.getClass().getName());
        System.out.println(myGen.ob);
        System.out.println(myGen.ob2.getClass().getName()
        );
    }
}

class Gen<T, T2> {
    T ob;
    T2 ob2;

    public Gen(T ob, T2 ob2) {
        this.ob = ob;
        this.ob2 = ob2;
    }

    public T getOb() {
        return ob;
    }

    private void setOb(T ob) {
        this.ob = ob;
    }
}