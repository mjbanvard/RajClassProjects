package com.galaxe.jspfs.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.galaxe.jspfs.db.DbConnection;
import com.galaxe.jspfs.vo.UserVO;

public class LoginValidation {

	public LoginValidation() {
	}

	String query = "SELECT password, role FROM user WHERE username = ?";
	UserVO user = new UserVO();

	public boolean isValid(String username, String pword) {

		boolean yesTheyAre = false;
		try {
			PreparedStatement pst = DbConnection.getConnection().prepareStatement(query);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
//			if (rs.next()) {
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getString(2));
//			}

			if (rs.next()) {
				String pwValue = rs.getString(1);
				if (pword.contains(pwValue)) /* == (String) rs.getString(1)) */ {
//					System.out.println();
//					user = UserService.createUser(username);
//					RequestAttribute request.setAttribute("user", user);
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
