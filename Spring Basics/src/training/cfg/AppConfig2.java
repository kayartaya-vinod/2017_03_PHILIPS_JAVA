package training.cfg;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import training.dao.ProductDao;
import training.dao.impl.HibernateTemplateProductDao;
import training.service.impl.ProductService;

@Configuration
@ComponentScan(basePackages = { "training.aspects" })
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class AppConfig2 {
	
	@Bean
	public ProductService service(){
		return new ProductService();
	}

	@Bean(name="txManager", autowire=Autowire.BY_NAME) // wires "sessionFactory" bean
	public HibernateTransactionManager htm(){
		return new HibernateTransactionManager();
	}
	
	@Bean(name = "dao")
	public ProductDao dao() {
		return new HibernateTemplateProductDao();
	}

	@Bean(name = "hibernateTemplate", autowire = Autowire.BY_NAME)
	public HibernateTemplate ht() {
		return new HibernateTemplate();
	}

	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean lsfb() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
		return sf;
	}

}
