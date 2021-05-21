package com.wolfshead.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wolfshead.db.DbConnection;
import com.wolfshead.vo.User;

public class UserList {

	public List<User> userList() {

		List<User> users = new ArrayList<User>();

		try {
			Statement st = DbConnection.getConnection().createStatement();

			ResultSet rs = st.executeQuery("Select id, firstName, lastName, username, role from user");
			
			while (rs.next()) {
				User userRS = new User();
				userRS.setId(rs.getInt("id"));
				userRS.setFirstName(rs.getString("firstName"));
				userRS.setLastName(rs.getString("lastName"));
				userRS.setUsername(rs.getString("username"));
				userRS.setRole(rs.getString("role"));
				users.add(userRS);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
		}
		return users;

	}

}
