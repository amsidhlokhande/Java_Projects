package com.mkyong.web.controller;

import java.sql.Connection;
import java.sql.SQLException;


public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		org.springframework.jdbc.datasource.DriverManagerDataSource dataSource= new org.springframework.jdbc.datasource.DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		//dataSource.setPassword("password");
		try {
			Connection con=dataSource.getConnection();
			System.out.println(con.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
