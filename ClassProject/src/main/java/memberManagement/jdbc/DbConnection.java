package memberManagement.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	static String url = "jdbc:mysql://localhost:3306/jdbc_practice";
	static String user = "recipe_user";
	static String password = "root%recipe5";
	static String driverName = "com.mysql.cj.jdbc.Driver";
	static Connection con = null;

	public static Connection getConnection() {
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("issue in connection closing.");
			}
		}
	}

}
