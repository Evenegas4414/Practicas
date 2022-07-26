package Clases.GenericosLambdas;

interface StringFunc {
    String func(String n);
}

class MyStringOps {
    static String strReverse(String str) {
        String result = "";
        int i;
        for(i = str.length()-1; i >= 0; i--)
            result = result + str.charAt(i);
        return result;
    }
}
public class LambdaTest {

    public static void main(String[] args)
    {
        String inStr = "Lambdas add power to Java";
        String outStr;

        outStr = stringOp(MyStringOps::strReverse, inStr);
        System.out.println("Original string: " + inStr);
        System.out.println("String reversed: " + outStr);
    }

    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }
}