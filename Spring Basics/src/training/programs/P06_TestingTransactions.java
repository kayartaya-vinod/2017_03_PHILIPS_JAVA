package training.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import training.cfg.AppConfig2;
import training.service.impl.ProductService;
import training.service.impl.ServiceException;

public class P06_TestingTransactions {
	
	public static void main(String[] args) throws ServiceException {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig2.class);
		
		ProductService service = ctx.getBean(ProductService.class);
		service.addToCart(45, 8, 21, 32);
		System.out.println("Stock updated!");
		
		ctx.close();
		
	}
}




