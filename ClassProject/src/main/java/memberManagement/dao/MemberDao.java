package memberManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.annotation.WebServlet;

import memberManagement.jdbc.DbConnection;
import memberManagement.model.Member;

@WebServlet("/ClassProject/create")
public class MemberDao implements Dao<Member> {

	protected static String url = "jdbc:mysql://localhost:3306/jdbc_practice";
	protected static String user = "recipe_user";
	protected static String password = "root%recipe5";
	protected static String driverName = "com.mysql.cj.jdbc.Driver";

	// CREATE
	public int registerMember(Member member) throws ClassNotFoundException {
		
		String insert_member_sql = "INSERT INTO first_table " +
				"(id, firstName, lastName, username, password) VALUES " + "(?, ?, ?, ?, ?);";
		int result = 1;
		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			System.out.println("Yup, it's a ClassNotFound");
			e1.printStackTrace();
		}
		Connection con = null;

		try {
			con = DbConnection.getConnection();
			PreparedStatement pState = con.prepareStatement(insert_member_sql);
			pState.setInt(1, (int) (100 * Math.random()));
			pState.setString(2, member.getFirstName());
			pState.setString(3, member.getLastName());
			pState.setString(4, member.getUsername());
			pState.setString(5, member.getPassword());
			
			System.out.println(pState);
			result = pState.executeUpdate();

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
		return result;
		
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

	private List<Member> mems = new ArrayList<Member>();

	public MemberDao() {
	}

	@Override
	public List<Member> getAll() {
		String insert_member_sql = "GET * FROM first_table ";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			System.out.println("Yup, it's a ClassNotFound");
			e1.printStackTrace();
		}
		Connection con = null;

		try {
			con = DbConnection.getConnection();
			PreparedStatement pState = con.prepareStatement(insert_member_sql);

				System.out.println(pState);
//				int result = pState.executeUpdate();

		} catch (Exception e) {
			System.out.println("Caught in MemberDao");
			printSQLException(e);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return mems;
	}

	@Override
	public void save(Member t) {
		mems.add(t);
	}

	@Override
	public void update(Member t, String[] params) {
		t.setFirstName(Objects.requireNonNull(params[0], "First Name cannot be null"));
		t.setLastName(params[1]);
		t.setUsername(Objects.requireNonNull(params[2], "Username cannot be null"));
		t.setPassword(Objects.requireNonNull(params[3], "Please enter a password"));

		mems.add(t);
	}

	@Override
	public void delete(Member t) {
		mems.remove(t);
	}

	@Override
	public Member get(int id) {
		Member member = new Member();
		Connection con = null;
//		member.setID(id);
//		member.setFirstName("Michael");
//		member.setLastName("Banvard");
//		member.setUsername("mbanvard");
//		member.setPassword("aagewrgva");
		
		try {
			Class.forName(driverName);
			con = DbConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM first_table WHERE ID = " + id);
			if (rs.next()) {
				member.setID(rs.getInt("ID"));
				member.setFirstName(rs.getString("firstName"));
				member.setLastName(rs.getString("lastName"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			DbConnection.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return member;
	}
}
