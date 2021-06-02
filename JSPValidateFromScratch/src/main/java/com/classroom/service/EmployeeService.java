package com.classroom.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.classroom.domain.Employee;
import com.galaxe.jspfs.db.DbConnection;

public class EmployeeService {

	public boolean saveEmployee(Employee emp) {
		
		boolean result = false;

		Connection con = DbConnection.getConnection();
		try {
			Statement st = con.createStatement();
			st.execute("INSERT into user(firstName, lastName, username, password, email) "
					+ "VALUES ('" + emp.getFirstName() + "','" + emp.getLastName() + "', '" + emp.getUserName() + "',"
					+ " '" + emp.getPassword() + "', '" + emp.getEmail() + "');");
			result = true;

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
		}
		
		
		return result;
		
	}

}
