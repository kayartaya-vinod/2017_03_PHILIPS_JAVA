package training.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import training.model.Contact;

public final class HibernateUtil {
	
	static SessionFactory sf;
	
	static {
		Configuration cfg = new Configuration();
		// read information from hibernate.cfg.xml
		// cfg.configure();
		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:8889/philips_training");
		cfg.setProperty("hibernate.connection.username", "root");
		cfg.setProperty("hibernate.connection.password", "root");
		cfg.setProperty("hibernate.show_sql", "false");
		cfg.setProperty("hibernate.format_sql", "true");
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		cfg.addAnnotatedClass(Contact.class);
		sf = cfg.buildSessionFactory();
	}
	
	private HibernateUtil() {
	}
	
	public static Session getSession(){
		return sf.openSession();
	}
}
