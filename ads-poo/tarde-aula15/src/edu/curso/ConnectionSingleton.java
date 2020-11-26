package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URLCON = "jdbc:mariadb://localhost:3306/contatodb?allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "";
	
	private static ConnectionSingleton instancia = null;
	private Connection con;
	
	public static ConnectionSingleton getInstance() { 
		if (instancia == null) { 
			instancia = new ConnectionSingleton();
		}
		return instancia;
	}
	
	private ConnectionSingleton() { 
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() { 
		try {
			if (con == null || con.isClosed() || !con.isValid(5)) { 
				con = DriverManager.getConnection(URLCON, USER, PASS);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
