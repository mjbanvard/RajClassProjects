package com.classroom;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classroom.domain.Employee;
import com.classroom.service.EmployeeService;

@WebServlet("/EmployeeRegistration")
public class EmployeeRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeRegistration() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Employee emp = new Employee();


		emp.setFirstName(request.getParameter("firstName"));
		emp.setLastName(request.getParameter("lastName"));
		emp.setUserName(request.getParameter("userName"));
		emp.setPassword(request.getParameter("password"));
		emp.setEmail(request.getParameter("email"));

		System.out.println(emp.toString());

		boolean result = new EmployeeService().saveEmployee(emp);
		System.out.println(result);
		if (result) {
			// success
			System.out.println("Ready to head for success");
			RequestDispatcher rd = request.getRequestDispatcher("userSuccess.jsp");
			rd.forward(request, response);
		} else {
			// fail.jsp
			System.out.println("Failure!");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}

	}

}
