package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//String jdbcurl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
			String jdbcurl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
			
			String userID="hbstudent";
			String password="hbstudent";
			
			System.out.println("Coont");
			
			Connection myconn=DriverManager.getConnection(jdbcurl,userID,password);
			System.out.println("Connection successful");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
