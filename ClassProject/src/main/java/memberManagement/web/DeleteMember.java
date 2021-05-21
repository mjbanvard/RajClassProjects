package memberManagement.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//DELETE
@WebServlet("/delete")
public class DeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static String url = "jdbc:mysql://localhost:3306/jdbc_practice";
	protected static String user = "recipe_user";
	protected static String password = "root%recipe5";
	protected static String driverName = "com.mysql.cj.jdbc.Driver";
	
    public DeleteMember() {
        super();
        // TODO Auto-generated constructor stub
    }

//	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int memId = Integer.parseInt(request.getParameter("delId"));
//		MemberDao dao = new MemberDao();
//		Member member = dao.get(memId);
//
//		request.setAttribute("member", member);
//
//		RequestDispatcher rd = request.getRequestDispatcher("showMember.jsp");
//		rd.forward(request, response);
//
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//
//		System.out.println("Deleted");
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int delId = Integer.parseInt(request.getParameter("delId"));
		String delete_member_sql = "DELETE FROM first_table WHERE ID = " + "(?);";
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
			PreparedStatement state = con.prepareStatement(delete_member_sql);
			state.setInt(1, delId);
//			boolean rs = state.execute(delete_member_sql);
			
			System.out.println(state);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Member");
	}
}