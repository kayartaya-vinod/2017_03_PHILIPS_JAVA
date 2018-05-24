package training.programs;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import training.cfg.AppConfig1;

public class P03_TestingJdbcTemplate {

	static JdbcTemplate template;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig1.class);

		template = ctx.getBean("template", JdbcTemplate.class);

		createNewProduct();
		// getProductCount();
		// getProductDetails(23); // 23 -> product_id
		// getProductDetailsByPrice(50.0, 200.0);

		ctx.close();
	}

	static void getProductDetailsByPrice(double min, double max) {
		String sql = "select * from products where unit_price between ? and ? ";
		List<Map<String, Object>> list = template.queryForList(sql, min, max);
		for (Map<String, Object> p : list) {
			System.out.printf("%s --> $%.2f\n", p.get("product_name"), p.get("unit_price"));
		}
	}

	static void getProductDetails(int productId) {
		// 1 row, multiple columns
		String sql = "select * from products where product_id = ?";
		Map<String, Object> p = template.queryForMap(sql, productId);

		System.out.println(p);
		System.out.println("Name = " + p.get("product_name"));
		System.out.println("Price = " + p.get("unit_PRICE"));

	}

	static void getProductCount() {
		// 1 row 1 column
		String sql = "select count(*) from products";
		int pc = template.queryForObject(sql, Integer.class);
		System.out.printf("There are %d products\n", pc);
	}

	static void createNewProduct() {
		String sql = "insert into products(product_id, product_name, unit_price, discontinued) " + "values(?,?,?, 0)";

		// use update(..) for SQL DML
		template.update(sql, 99, "Titan Wrist Watch", 25.0);
		System.out.println("Data inserted!");
	}

}
