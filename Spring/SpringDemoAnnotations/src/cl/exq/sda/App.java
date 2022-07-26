package cl.exq.sda;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Entrenador entrenador = context.getBean("entrenadorTrineo", Entrenador.class);
		System.out.println(entrenador.obtenerEntrenamientoDiario());
		System.out.println(entrenador.obtenerFortunaDiaria());
		context.close();
	}

}
