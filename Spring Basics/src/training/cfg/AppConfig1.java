package training.cfg;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

import training.dao.ProductDao;
import training.dao.impl.JdbcProductDao;

// equivalent of context.xml
@Configuration
@ComponentScan(basePackages = { "training.dao.impl" })
public class AppConfig1 { // <beans></beans>

	public AppConfig1() {
	}

	// <bean></bean>
	// the return value of the method is the bean instance
	// name of the method becomes the name of the bean
	@Bean(name = { "dao", "product-dao" }, autowire = Autowire.BY_NAME)
	public ProductDao dao() {
		JdbcProductDao dao = new JdbcProductDao();

		// manual wiring
		// dao.setJdbcProperties(this.jdbcProperties());

		return dao;
	}

	@Bean(name = "jdbcProperties")
	@Scope("singleton")
	public Properties jdbcProperties() {
		Properties p = new Properties();
		p.setProperty("jdbc.drivername", "com.mysql.jdbc.Driver");
		p.setProperty("jdbc.url", "jdbc:mysql://localhost:8889/philips_training");
		p.setProperty("jdbc.user", "root");
		p.setProperty("jdbc.pwd", "root");
		return p;
	}

	@Bean(name = "dataSource")
	public DataSource dbcp() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:8889/philips_training");
		bds.setUsername("root");
		bds.setPassword("root");

		bds.setInitialSize(5);
		bds.setMaxActive(50);
		bds.setMaxIdle(5);
		bds.setMinIdle(5);
		bds.setMaxWait(2);

		return bds;
	}

	@Bean(name = "template", autowire = Autowire.BY_NAME)
	public JdbcTemplate template() {
		return new JdbcTemplate();
	}

}
