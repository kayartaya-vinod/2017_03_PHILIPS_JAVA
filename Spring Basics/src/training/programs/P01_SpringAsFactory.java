package training.programs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.service.HelloService;

public class P01_SpringAsFactory {

	public static void main(String[] args) {
		// variable of Spring container
		ApplicationContext ctx;

		// object of Spring container; loads s1 instance at this time
		System.out.println("Constructing the spring container...");
		ctx = new ClassPathXmlApplicationContext("context01.xml");
		System.out.println("Spring container constructed.");

		HelloService service = ctx.getBean("s1", HelloService.class);
		service.sayHello();
		service.printMessage();
		HelloService service1 = ctx.getBean("s1", HelloService.class);

		System.out.println("service==service1 is " + (service == service1));

		// s2 is instantiated here
		HelloService service2 = ctx.getBean("s2", HelloService.class);
		System.out.println("service==service2 is " + (service == service2));

		((AbstractApplicationContext) ctx).close();
	}
}
