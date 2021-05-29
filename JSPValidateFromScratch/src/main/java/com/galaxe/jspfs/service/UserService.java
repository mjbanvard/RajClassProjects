package com.galaxe.jspfs.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.galaxe.jspfs.db.DbConnection;
import com.galaxe.jspfs.vo.UserVO;

public class UserService {

	static String query = "SELECT id, firstName, lastName, role FROM user WHERE username = ?;";

	public static UserVO createUser(String username) {
		UserVO user = new UserVO();
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
