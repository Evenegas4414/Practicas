package Clases.Estaticas;

class staticExamples {
	static int a = 3;
	static int b;

	//Metodos estaticos
	public static void main(String[] args) {
		meth(42);
	}

	static void meth(int x) {
		System.out.println("x = " + x);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}

	static {
		System.out.println("Bloque static.");
		b = a * 4;
	}

}