package com.galaxe.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static Connection connection = null;

	static String username = "Gxdash";
	static String password = "Galaxy@123";
	static String dbURL = "jdbc:sqlserver://9.3.1.100;databaseName=myDB;columnEncryptionSetting=Enabled;";
	static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	public static Connection getConnection() {
		// Step#1: Register the driver.
		try {
			Class.forName(driver); // com.mysql.jdbc.driver
			// Step#2: Create connection
			connection = DriverManager.getConnection(dbURL, username,password);

		} catch (Exception ex) {
			System.out.println("There are some issue in connectivity : " + ex.getMessage());
		}
		return connection;
	}
	
	public static void closeConnection() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("issue in connection closing.");
			}
		}
	}
}
