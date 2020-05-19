package com.springboot.EventManager.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/event_info?useSSL=false&serverTimezone=UTC";
		String user = "event_data";
		String pass = "data_info_event";

		try {
			System.out.println("Connecting To Database: " + jdbcUrl);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("Connection Successful!: " + myConn);

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
