package memberManagement.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//PUT || UPDATE
@WebServlet("/update")
public class UpdateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static String url = "jdbc:mysql://localhost:3306/jdbc_practice";
	protected static String user = "recipe_user";
	protected static String password = "root%recipe5";
	protected static String driverName = "com.mysql.cj.jdbc.Driver";
       
    public UpdateMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Updated");
	}

}
