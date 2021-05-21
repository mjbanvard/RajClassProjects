package com.galaxe.gxdemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.galaxe.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String username= request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isValidUser = new LoginService().validateUser(username);
		
		if(isValidUser) {
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			RequestDispatcher rd = request.getRequestDispatcher("/memberDetails.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("error", "Username and password are invalid.");
			RequestDispatcher rd = request.getRequestDispatcher("/memberRegister.jsp");
			rd.forward(request, response);
		}
		
		System.out.println(username);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
