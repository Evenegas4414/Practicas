package cl.exql.ssm1.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cl.exql.ssm1.config.ProjectConfig;
import cl.exql.ssm1.model.Parrot;

public class Main {

	public static void main(String[] args) {
		
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		
		//Parrot myParrot = context.getBean("myParrot", Parrot.class);
		Parrot myParrot1 = context.getBean("Koko", Parrot.class);
		Parrot myParrot2 = context.getBean("Bulu", Parrot.class);
		Parrot myParrot3 = context.getBean("Fini", Parrot.class);
		Parrot myParrot4 = context.getBean("Lele", Parrot.class);
	
		String hello = context.getBean(String.class);
		
		Integer number10 = context.getBean(Integer.class);
		
		System.out.println(myParrot1.getName());
		System.out.println(myParrot2.getName());
		System.out.println(myParrot3.getName());
		System.out.println(myParrot4.getName());
		System.out.println(hello);
		System.out.println(number10);

	}

}
