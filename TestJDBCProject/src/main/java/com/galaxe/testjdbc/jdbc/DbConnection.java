package com.galaxe.testjdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection extends UserAndURL {

	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, user, password);
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ingredient");
			
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return con;
	}

}
