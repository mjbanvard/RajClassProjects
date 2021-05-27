package com.wolfshead.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wolfshead.db.DbConnection;
import com.wolfshead.vo.User;

public class UpdateService {

	public static boolean updateUser(User user) {
		
		String query = "UPDATE user SET id = ?, firstName = ?, lastName = ?, roll = ? "
				+ "WHERE username = ?";
		try {
			PreparedStatement pst = DbConnection.getConnection().prepareStatement(query);
			pst.setInt(1, user.getId());			
			pst.setString(2, user.getFirstName());
			pst.setString(3, user.getLastName());
			pst.setString(4, user.getRole());
			pst.setString(5, user.getUsername());
			
			ResultSet rs = pst.executeQuery();

			if (rs.getBoolean(1)) {
				System.out.println("The user was updated.");
			}
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update failed!");
		} finally {
			DbConnection.closeConnection();
		}

		return false;
	}
}
