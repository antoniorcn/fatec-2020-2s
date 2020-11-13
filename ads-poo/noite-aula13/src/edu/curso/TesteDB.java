package edu.curso;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class TesteDB {

	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Classe foi carregada");
			String URLCON = "jdbc:mariadb://123.34.56.79:3306/pets";
			String USER = "root";
			String PASS = "";
			Connection con = DriverManager.getConnection(URLCON, USER, PASS);
			System.out.println("Conexão criada");
			
			Statement st = con.createStatement();
			String sql = "INSERT pet (nome, raca, peso) VALUES ('Rex', 'ViraLata', 13.6)";
			int i = st.executeUpdate(sql);
			System.out.printf("Insert executado %d linhas foram afetadas%n", i);
			con.close();
			System.out.println("Conexão fechada");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
