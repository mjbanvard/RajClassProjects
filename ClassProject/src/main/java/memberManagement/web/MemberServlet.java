package memberManagement.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberManagement.dao.MemberDao;
import memberManagement.model.Member;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/register")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static String url = "jdbc:mysql://localhost:3306/jdbc_practice";
	protected static String user = "recipe_user";
	protected static String password = "root%recipe5";
	protected static String driverName = "com.mysql.cj.jdbc.Driver";
	public MemberDao memberDao = new MemberDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	// READ
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Gotten!");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	// CREATE
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Member member = new Member();
		int rdmId = (int) (1000 * Math.random());

		try {
			member.setID(rdmId);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Duplicate ID number");
			member.setID(rdmId);
		}
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setUsername(username);
		member.setPassword(password);

		try {
			int what = memberDao.registerMember(member);
			if (what > 0) {
				System.out.println("Successful registration");
			}
		} catch (Exception e) {
			System.out.println("Failed: Member Servlet calling memberDao");
			e.printStackTrace();
		}

	}

	// UPDATE
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Updated/Posted!");

	}

	// DELETE
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 4;
		String delete_member_sql = "DELETE * FROM first_table WHERE ID = " + id;
//		Member member = new Member();

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			System.out.println("Yup, it's a ClassNotFound");
			e1.printStackTrace();
		}
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			Statement state = con.createStatement();
			boolean rs = state.execute(delete_member_sql);
			
			System.out.println(state);
			System.out.println(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Member");
	}
	}


