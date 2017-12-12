package com.chabed.spring.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	public Connection getDBConnection() {
		Connection conn = null;
		 try {
			try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	           System.out.println("Please include Classpath Where your MySQL Driver is located");
	           e.printStackTrace();
	        } 
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chabed?autoReconnect=true&useSSL=false","root","apcl123456");
		 }catch (Exception sqlExp) {
			 System.out.println( "Exception::" + sqlExp.toString());
		 } /*finally {
			 try {
		         if (conn != null) {
		             conn.close();
		             conn = null;
		         }
			  } catch (SQLException expSQL) {
			     System.out.println("SQLExp::CLOSING::" + expSQL.toString());
			  }
		  }*/
		return conn;
	}
	
}
