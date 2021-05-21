package com.wolfshead.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wolfshead.service.UserCheck;
import com.wolfshead.service.UserInstance;
import com.wolfshead.service.UserList;
import com.wolfshead.vo.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	// Login Distribution
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isValidPassword = new UserCheck().validatePassword(username, password);
		User user = new User();
		
		if (isValidPassword) {
			user = new UserInstance().createUser(username);
		}
		
		request.setAttribute("user", user);
		String role = user.getRole();

		if (role == null) {
			System.out.println("User was null");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("message", "Please enter a valid Username and Password.");
			rd.forward(request, response);
		} else if (role.toLowerCase().equals("admin")) {
			System.out.println("User was admin");
			List<User> userList = new UserList().userList(); 
			request.setAttribute("userList", userList);
			RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("Just a User");
			RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
			rd.forward(request, response);
		}

	}	
}

