package com.wolfshead.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wolfshead.db.DbConnection;
import com.wolfshead.vo.User;

public class UserInstance {

	String query = "SELECT id, firstName, lastName, role FROM user WHERE username = ?;";

	public User createUser(String username) {
		User user = new User();
		try {
			PreparedStatement pst = DbConnection.getConnection().prepareStatement(query);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setUsername(username);
				user.setRole(rs.getString("role"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("User creation broke");
		} finally {
			DbConnection.closeConnection();
		}

		return user;
	}

}
