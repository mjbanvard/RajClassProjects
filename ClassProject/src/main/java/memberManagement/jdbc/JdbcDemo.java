package memberManagement.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo {

	protected static String url = "jdbc:mysql://localhost:3306/jdbc_practice";
	protected static String user = "recipe_user";
	protected static String password = "root%recipe5";
	protected static String driverName = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) {
		Connection con = null;
		
		try {
			Class.forName(driverName);
			con = DbConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM first_table");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + ", " + rs.getString(2));
			}
		} catch (Exception e) {
			System.out.println("Exception Caught");
			e.printStackTrace();
		} finally {
			try {
				DbConnection.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
