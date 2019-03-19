package com.evrybank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EBDatabaseUtil {

	public static Connection getConnection(){
		Connection con = null;
		
		final String DB_URL = "jdbc:mysql://localhost/evrybankdb";
		final String USER = "evrybankuser";
		final String PASS = "evrybank123";  
		
		try {
			  //STEP 1: Register JDBC driver
		      Class.forName("com.mysql.cj.jdbc.Driver");

		      //STEP 2: Open a connection
		      System.out.println("Connecting to a selected database...");
		      
		      //STEP 3: Connection URL, USERNAME, PASSWORD
		      con = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    return con;
	}
}
