package training.programs;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import training.cfg.AppConfig2;
import training.dao.ProductDao;
import training.entity.Product;

public class P05_TestingAOP {

	public static void main(String[] args) throws Exception {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig2.class);
		ProductDao dao = ctx.getBean(ProductDao.class);
		
		System.out.println("dao is an instance of " + dao.getClass().getName());
		Product p = dao.get(1);
		p.setUnitPrice(-99.3);
		dao.update(p);
		List<Product> list = dao.getByPrice(50.0, 100.0);
		for(Product pr: list){
			System.out.println(pr.getProductName() + " --> $" + pr.getUnitPrice());
		}
		
		ctx.close();
		
	}
}
