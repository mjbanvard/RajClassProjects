package com.wolfshead.service;

import java.sql.ResultSet;
import java.sql.Statement;

import com.wolfshead.db.DbConnection;
import com.wolfshead.vo.User;

public class UpdateService {

	public static boolean updateUser(User user) {
		try {
			Statement st = DbConnection.getConnection().createStatement();

			ResultSet rs = st.executeQuery(
					"UPDATE user SET id = id, firstName = firstName, lastName = lastName, roll = roll WHERE username = username");

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
