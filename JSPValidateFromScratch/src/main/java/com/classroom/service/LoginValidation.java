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
			System.out.println("Am I in validation? Yes, just about got the result set.");
			System.out.println(rs.getFetchSize());
//			if (rs.next()) {
//				System.out.println(rs.getString(1));
//			}

			while (rs.next()) {

				String pwValue = rs.getString(1);
				System.out.println(pwValue);
				if (pword.contains(pwValue)) /* == (String) rs.getString(1)) */ {
//					System.out.println();
//					user = UserService.createUser(username);
//					RequestAttribute request.setAttribute("user", user);
					System.out.println("Yup, it's real");
					yesTheyAre = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Oops, in LoginValidation");
		} finally {
			DbConnection.closeConnection();
		}

		return yesTheyAre;
	}

}
