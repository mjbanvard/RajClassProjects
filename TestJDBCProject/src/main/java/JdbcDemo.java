import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.galaxe.testjdbc.jdbc.DbConnection;

public class JdbcDemo {

	public static void main(String[] args) {
		Connection con = DbConnection.getConnection();
		
		try {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ingredient");
		
		while (rs.next()) {
			
		}
	} catch (Exception e) {
		System.out.println("Exception Caught");
	}
	}

}
