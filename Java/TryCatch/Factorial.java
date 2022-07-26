package Clases.TryCatch;

public class Factorial {
    int result;

    int fact(int n) {
        if ( n <= 0 ) {
            result = 0;
        } else if ( n == 1 ) {
            result = 1;
        } else {
            result = fact(n - 1) * n;
        }
        return result;
    }
}

class FactorialUse {
    public static void main(String[] args) {
        Factorial f = new Factorial();

        System.out.println(f.fact(10));

    }
}
