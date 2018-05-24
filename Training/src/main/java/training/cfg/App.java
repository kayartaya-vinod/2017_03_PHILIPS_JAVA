package training.cfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import training.controllers.HelloController;

@EnableAutoConfiguration
@ComponentScan(basePackageClasses = { HelloController.class })
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
