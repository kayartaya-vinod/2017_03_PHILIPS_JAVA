package training.programs;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import training.cfg.AppConfig2;
import training.dao.DaoException;
import training.dao.ProductDao;
import training.entity.Product;

public class P04_TestingJdbcTemplateProductDao {

	static ProductDao dao;

	public static void main(String[] args) throws DaoException {

		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig2.class);
		dao = ctx.getBean(ProductDao.class);

		// getProductDetails(23);
		// getProductsByPrice(50.0, 200.0);
		getProductCount();

		ctx.close();
	}

	static void getProductCount() throws DaoException {
		int pc = dao.getProductCount();
		System.out.println("There are " + pc + " products!");
	}

	static void getProductsByPrice(double min, double max) throws DaoException {
		List<Product> list = dao.getByPrice(min, max);
		for (Product p : list) {
			System.out.printf("%s --> $%.2f\n", p.getProductName(), p.getUnitPrice());
		}
	}

	static void getProductDetails(int productId) throws DaoException {
		Product p = dao.get(productId);
		System.out.println(p);
	}
}
