package com.wolfshead.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wolfshead.db.DbConnection;

public class UserCheck {

	String pwQuery = ("SELECT password FROM user WHERE username = ?");


	public boolean validatePassword(String username, String password) {
		try {
			PreparedStatement pst = DbConnection.getConnection().prepareStatement(pwQuery);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				if (rs.getString(1).equals(password)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Broke in PW Validation");
		} finally {
			DbConnection.closeConnection();
		}
		return false;
	}

//	String unQuery = "SELECT username FROM user";
//	String adminQuery = ("SELECT role FROM user WHERE username = " + "(?);");
//
//	public boolean validateUser(String username) {
//		try {
//			Statement st = DbConnection.getConnection().createStatement();
//			ResultSet rs = st.executeQuery(unQuery);
//			while (rs.next()) {
//			if (rs.getString(1).equalsIgnoreCase(username)) {
//				return true;
//			}
//		}
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("User Validation statement broke");
//		} finally {
//			DbConnection.closeConnection();
//		}
//		return false;
//	}
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
