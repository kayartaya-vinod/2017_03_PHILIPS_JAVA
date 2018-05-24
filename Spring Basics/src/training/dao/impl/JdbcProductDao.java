package training.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import training.dao.DaoException;
import training.dao.ProductDao;
import training.entity.Product;

public class JdbcProductDao implements ProductDao {

	private String driver;
	private String url;
	private String username;
	private String password;
	
	private DataSource dataSource;
	/// setter for Spring to do DI
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private Connection getConnection() throws DaoException {
		try {
			if(dataSource != null){
				System.out.println("using the dataSource...");
				return dataSource.getConnection();
			}
			System.out.println("No datasource found, using driver, url, username, password..");
			Class.forName(driver);
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new DaoException(e);
		}

	}

	public JdbcProductDao() {
	}

	public JdbcProductDao(String driver, String url, String username,
			String password) {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public void setJdbcProperties(Properties props){
		this.driver = props.getProperty("jdbc.drivername");
		this.url = props.getProperty("jdbc.url");
		this.username = props.getProperty("jdbc.user");
		this.password = props.getProperty("jdbc.pwd");
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int getProductCount() throws DaoException {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select count(*) from products";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				throw new DaoException("No result from query!");
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				throw new DaoException(e2);
			}
		}

	}

	@Override
	public void create(Product product) throws DaoException {
		throw new DaoException("Not implemented");
	}

	@Override
	public Product get(Integer productId) throws DaoException {
		throw new DaoException("Not implemented");
	}

	@Override
	public void update(Product product) throws DaoException {
		throw new DaoException("Not implemented");
	}

	@Override
	public void delete(Integer productId) throws DaoException {
		throw new DaoException("Not implemented");
	}

	@Override
	public List<Product> getAll() throws DaoException {
		throw new DaoException("Not implemented");
	}

	@Override
	public List<Product> getByPrice(Double min, Double max) throws DaoException {
		throw new DaoException("Not implemented");
	}

}
