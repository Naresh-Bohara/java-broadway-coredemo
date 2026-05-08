package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	public static  Connection connectDB() {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/javabroadwaytestdb",
	                "root",
	                "Naresh@123#"
	        );
			return con;
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		return null;
	}
}
