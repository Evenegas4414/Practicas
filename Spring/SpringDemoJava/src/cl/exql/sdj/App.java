package cl.exql.sdj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ConfiguracionDeportes.class);
		
		Entrenador entrenador = context.getBean("entrenadorNatacion", Entrenador.class);
		
		System.out.println(entrenador.obtenerEntrenamientoDiario());
	
		context.close();
	}

}
