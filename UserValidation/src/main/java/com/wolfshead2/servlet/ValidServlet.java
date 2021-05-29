package com.wolfshead.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wolfshead.service.UserCheck;

/**
 * Servlet implementation class UserValid
 */
@WebServlet("/validate")
public class UserValid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserValid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("This is the user " + request.getAttribute("username"));
		boolean isValidUser;
		try {
			String username = "cdir";
			isValidUser = new UserCheck().validateUser(username);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getting attribute failed");
			isValidUser = false;
		}
		// boolean isValidUser = new UserCheck().validateUser("username");
		// URI goodUri = new URI("file:///C:/Users/13146/GxLearning/UserValidation/src/main/webapp/userSuccess.jsp");
		// URI badUri = new URI("file:///C:/Users/13146/GxLearning/UserValidation/src/main/webapp/userFail.jsp");
		
		if (isValidUser) {
			// link to good page
			System.out.println("I got stuck here");
			RequestDispatcher rd = request.getRequestDispatcher("userSuccess.jsp");
			// rd.forward(request, response);
			// rd.toString();
		} else {
			// link to bad page
			System.out.println("Damnit, not again!");
			RequestDispatcher rd = request.getRequestDispatcher("userFail.jsp");
			// rd.forward(request, response);
			//rd.toString();
		}
	}

}
