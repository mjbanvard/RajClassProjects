package com.classroom.service;

import java.sql.ResultSet;
import java.sql.Statement;

import com.galaxe.jspfs.db.DbConnection;

public class LoginValidation {

	public boolean isValid(String username, String pword) {

		String query = "SELECT password FROM user WHERE username = '" + username + "';";

		boolean yesTheyAre = false;
		try {
			Statement st = DbConnection.getConnection().createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				String pwValue = rs.getString(1);
				if (pword.equalsIgnoreCase(pwValue)) {
					yesTheyAre = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
		}

		return yesTheyAre;
	}

}
