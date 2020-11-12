package edu.curso.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDB {

	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Classe carregada");
			
			String URLCON = "jdbc:mariadb://localhost:3306/pets";
			String user = "root";
			String pass = "";
			Connection con = DriverManager.getConnection(URLCON, user, pass);
			System.out.println("Conectado no banco de dados");
			
			String sql = "INSERT INTO pet (nome, raca, peso) VALUES ('Rex', 'Viralata', 13.8)";
			Statement st = con.createStatement();
			int i = st.executeUpdate(sql);
			System.out.printf("INSERT executado, foram alteradas %s linhas%n", i);
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
