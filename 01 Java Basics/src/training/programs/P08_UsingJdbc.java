package training.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class P08_UsingJdbc {

	public static void main(String[] args) throws Exception {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:8889/philips_training";
		String username = "root";
		String password = "root";
		
		Class.forName(driver); // loads the class
		// a driver class, upon loading, will register an
		// instance of the same class with DriverManager
		
		Connection conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(false);
		
		try {
			String sql = "update contacts set name = 'Shawn Gardner' where id = 1";
			Statement stmt = conn.createStatement();
			int uc = stmt.executeUpdate(sql); // insert/update/delete
			conn.commit();
			System.out.printf("%d row/s udpated!\n", uc);
		} catch (Exception e) {
			conn.rollback();
			System.err.println("There was a problem while updating.");
			System.err.println(e.getMessage());
		}
		conn.close();
	}
}






