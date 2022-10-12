package com.weirdo.courses.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static final String URL = "jdbc:mysql://localhost:3306/weirdocourses";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return con;
			
			
			
		}catch (Exception e) {
			throw new RuntimeException("Cannot connect to the database");
		}
		
		
	}
	
	
	public static void main(String[] args) {
		ConnectionFactory c = new ConnectionFactory();
		Connection con = c.getConnection();
		System.out.println(con);
	}
	
	
}
