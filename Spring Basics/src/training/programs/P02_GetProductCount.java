package training.programs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import training.cfg.AppConfig1;
import training.dao.DaoException;
import training.dao.ProductDao;

public class P02_GetProductCount {
	public static void main(String[] args) throws DaoException {
		ApplicationContext ctx;
		// ctx = new ClassPathXmlApplicationContext("context2.xml");
		ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
		
		ProductDao dao = ctx.getBean("dao", ProductDao.class);
		int pc = dao.getProductCount();
		
		System.out.printf("There are %d products\n", pc);
		
		((AbstractApplicationContext) ctx).close();
	}
}
