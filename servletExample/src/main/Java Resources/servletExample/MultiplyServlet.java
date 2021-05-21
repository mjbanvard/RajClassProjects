package servletExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultiplyServlet {
	
public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		//Tomcat
		System.out.println("Add Servlet GET Method Called");
		
		
		int number1 = Integer.parseInt(req.getParameter("num1"));
		int number2 = Integer.parseInt(req.getParameter("num2"));
		
		int result = number1 + number2;
		
		
		System.out.println(result);
		
		PrintWriter writer = res.getWriter();
		
		writer.println(result);
		
	}

}
