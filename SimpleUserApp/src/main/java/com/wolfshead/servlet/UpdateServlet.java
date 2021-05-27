package com.wolfshead.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wolfshead.service.UpdateService;
import com.wolfshead.service.UserInstance;
import com.wolfshead.vo.User;

//PUT || UPDATE
@WebServlet("/SimpleUserApp/update")
public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		User user = new UserInstance().createUser(username);

		boolean didItWork = UpdateService.updateUser(user);
		if (didItWork) {
			System.out.println("${username} Updated");
		} else {
			System.out.println("DidItWork came back false");
		}
	}

}
