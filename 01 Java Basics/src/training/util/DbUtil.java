package training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import training.dao.DaoException;

public final class DbUtil {

	private static String driver, url, username, password;

	private DbUtil() {
	}
	
	static {
		ResourceBundle rb = ResourceBundle.getBundle("jdbc-info");
		driver = rb.getString("driver");
		url = rb.getString("url");
		username = rb.getString("usr");
		password = rb.getString("pwd");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws DaoException {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) throws DaoException {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public static void close(Connection conn, Statement stmt) throws DaoException {
		try {
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
}
