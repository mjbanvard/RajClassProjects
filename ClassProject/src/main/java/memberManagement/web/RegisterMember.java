package memberManagement.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberManagement.model.Member;

// @WebServlet("/create")
public class RegisterMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static String url = "jdbc:mysql://localhost:3306/jdbc_practice";
	protected static String user = "recipe_user";
	protected static String password = "root%recipe5";
	protected static String driverName = "com.mysql.cj.jdbc.Driver";
  
    public RegisterMember() {
        super();
        // TODO Auto-generated constructor stub
    } 
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String insert_member_sql = "INSERT INTO first_table " +
				"(id, firstName, lastName, username, password) VALUES " + "(?, ?, ?, ?, ?);";
//		int result = 1;
		Member member = (Member) request;
		System.out.println(member);
//				new Member();
		System.out.println("Before Class call");
		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			System.out.println("Yup, it's a ClassNotFound");
			e1.printStackTrace();
		}
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("After Connection creation");
			PreparedStatement pState = con.prepareStatement(insert_member_sql);
			pState.setInt(1, (int) (100 * Math.random()));
			pState.setString(2, member.getFirstName());
			pState.setString(3, member.getLastName());
			pState.setString(4, member.getUsername());
			pState.setString(5, member.getPassword());
			
//			System.out.println(pState);
//			result = pState.executeUpdate();

		} catch (Exception e){
			System.out.println("Caught in MemberDao");
			printSQLException(e);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Member added");
		
	}
	
	private void printSQLException(Exception ex) {
		if (ex instanceof SQLException) {
			ex.printStackTrace(System.err);
			System.err.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.err.println("Error Code: " + ((SQLException) ex).getErrorCode());
			System.err.println("Message: " + ex.getMessage());
			Throwable t = ex.getCause();
			while (t != null) {
				System.out.println("Cause: " + t);
				t = t.getCause();
			}

		}

	}

}
