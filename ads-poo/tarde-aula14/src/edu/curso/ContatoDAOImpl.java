package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContatoDAOImpl implements ContatoDAO {
	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URLCON = "jdbc:mariadb://localhost:3306/contatodb?allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "";
	
	public ContatoDAOImpl() { 
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void adicionar(Contato c) throws DAOException {
		try {
			Connection con = DriverManager.getConnection(URLCON, USER, PASS);
			String sql = "INSERT INTO contato (id, nome, telefone, email, nascimento) "
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setLong(1, c.getId());
			st.setString(2, c.getNome());
			st.setString(3,  c.getTelefone());
			st.setString(4,  c.getEmail());
			st.setDate(5, java.sql.Date.valueOf(c.getNascimento()));
			st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public Contato pesquisarPorNome(String nome) throws DAOException {
		try {
			Connection con = DriverManager.getConnection(URLCON, USER, PASS);
			String sql = "SELECT * FROM contato WHERE nome like ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + nome + "%");
			ResultSet rs = st.executeQuery();
			if (rs.next()) { 
				Contato c = new Contato();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setTelefone(rs.getString("telefone"));
				c.setEmail(rs.getString("email"));
				c.setNascimento(rs.getDate("nascimento").toLocalDate());
				return c;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return null;
	}
}
