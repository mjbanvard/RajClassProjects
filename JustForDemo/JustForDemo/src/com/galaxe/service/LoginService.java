package com.galaxe.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.galaxe.db.DbConnection;

public class LoginService {

	public boolean validateUser(String username) {
		try {
			Statement st = DbConnection.getConnection().createStatement();

			ResultSet rs = st.executeQuery("SELECT username FROM user_Profile");

			while (rs.next()) {
				if (rs.getString(1).equalsIgnoreCase(username))
					return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
		}

		return false;
	}

}
