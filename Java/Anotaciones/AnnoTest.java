package Clases.Anotaciones;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class AnnoTest {
    @MyCustomAnno(name = "Anotacion", id = 15)
    public static void myMethod() {
        AnnoTest ob = new AnnoTest();
        System.out.println("******************");
        System.out.println("new Annotest() = ob");
        System.out.println("ob is: " + ob.toString());
        System.out.println("******************");

        try {
            MyCustomAnno b = new AnnoTest().getClass().getMethod("myMethod").getAnnotation(MyCustomAnno.class);
            //Class<AnnoTest> c = AnnoTest.class;
            Class<?> c = ob.getClass();
            System.out.println("ob.getClass() = c");
            System.out.println("ob.getClass() / c is: " + ob.getClass().toString());
            System.out.println("******************");

            Method m = c.getMethod("myMethod");
            System.out.println("c.getMethod() = m");
            System.out.println("c.getMethod / m is: " + c.getMethod("myMethod").toString());
            System.out.println("******************");

            MyCustomAnno a = m.getAnnotation(MyCustomAnno.class);
            System.out.println("m.getAnnotation() = a");
            System.out.println("m.getAnnotation / a is : " + m.getAnnotation(MyCustomAnno.class).toString());
            System.out.println("******************");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        myMethod();
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyCustomAnno {
    String name();

    int id();
}
