package com.wolfshead2.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wolfshead2.db.DbConnection;

public class UserCheck {

	String userQuery = ("SELECT username FROM user WHERE username = ?");

	public UserCheck() {
	}


	public boolean validateUser(String username) {

		boolean isValid = false;
		try {
			PreparedStatement pst = DbConnection.getConnection().prepareStatement(userQuery);
			pst.setString(1, username);
			System.out.println(pst);
			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				if (rs.getString(1).equalsIgnoreCase(username)) {
					isValid = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("User Validation statement broke");
		} finally {
			DbConnection.closeConnection();
		}
		System.out.println(isValid);
		return isValid;
	}

//	String unQuery = "SELECT username FROM user";
//	String adminQuery = ("SELECT role FROM user WHERE username = " + "(?);");
//
//	public boolean validatePassword(String username, String password) {
//	try {
//		PreparedStatement pst = DbConnection.getConnection().prepareStatement(pwQuery);
//		pst.setString(1, username);
//		ResultSet rs = pst.executeQuery();
//		
//		while (rs.next()) {
//			if (rs.getString(1).equals(password)) {
//				return true;
//			}
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//		System.out.println("Broke in PW Validation");
//	} finally {
//		DbConnection.closeConnection();
//	}
//	return false;
//}

//	public boolean isAdmin(String username) {
//	try {
//		PreparedStatement pst = DbConnection.getConnection().prepareStatement(adminQuery);
//		pst.setString(1, username);
//		ResultSet rs = pst.executeQuery();
//
//		while (rs.next()) {
//			if (rs.getString(1).equalsIgnoreCase("Admin")) {
//				return true;
//			}
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//		System.out.println("Broke in Admin Check.");
//	} finally {
//		DbConnection.closeConnection();
//	}
//	return false;
//}
}
