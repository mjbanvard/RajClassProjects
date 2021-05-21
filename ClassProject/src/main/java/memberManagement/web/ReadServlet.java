package memberManagement.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberManagement.dao.MemberDao;
import memberManagement.model.Member;

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet("/get")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memId = Integer.parseInt(request.getParameter("memId"));
		MemberDao dao = new MemberDao();
		Member member = dao.get(memId);

		request.setAttribute("member", member);

		RequestDispatcher rd = request.getRequestDispatcher("showMember.jsp");
		rd.forward(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
