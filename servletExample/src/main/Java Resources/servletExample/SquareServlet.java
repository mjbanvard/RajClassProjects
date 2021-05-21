package servletExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SquareServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		int result = (int) req.getAttribute("result");
		int square = result * result;

		System.out.println("Square Servlet Called" + square);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		System.out.println("Add Servlet POST Method Called");

		int number1 = Integer.parseInt(req.getParameter("num1"));
		int number2 = Integer.parseInt(req.getParameter("num2"));

		int result = number1 + number2;

		ServletContext context = getServletContext();
		int number3 = Integer.parseInt(context.getInitParameter("num3"));
		System.out.println("Servlet Context Parameter = " + number3);

//		ServletConfig config = getServletConfig();
//		int number4 = Integer.parseInt(config.getInitParameter("num4"));
//
//		System.out.println("Servlet Config Parameter = " + number4);

		req.setAttribute("result", result);
		RequestDispatcher rd = req.getRequestDispatcher("sq");
		rd.forward(req, res);

		System.out.println(result);

		PrintWriter writer = res.getWriter();

		writer.println(result);

	}
}
