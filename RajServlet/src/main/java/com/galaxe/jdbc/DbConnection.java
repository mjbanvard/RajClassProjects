package com.galaxe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://SUMMERHOLM; databaseName = StackOverflow2013;",
					"SUMMERHOLM\13146", "");
				
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from dbo.Posts");
			
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
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
	}

}
