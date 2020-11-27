package edu.curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAOImpl implements ContatoDAO {

	public ContatoDAOImpl() { 		
	}
	
	@Override
	public void adicionar(Contato c) throws ContatoException {
		try {
			Connection con = ConnectionSingleton.instancia().connection();
			String sql = "INSERT INTO contato (id, nome, telefone, email, nascimento) " + 
			"VALUES (?, ?, ?, ?, ?)"; 
			PreparedStatement st = con.prepareStatement(sql);
			st.setLong(1, c.getId());
			st.setString(2, c.getNome());
			st.setString(3,  c.getTelefone());
			st.setString(4, c.getEmail());
			st.setDate(5, java.sql.Date.valueOf(c.getNascimento()));
			st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ContatoException(e);
		}

	}

	@Override
	public List<Contato> pesquisarPorNome(String nome) throws ContatoException {
		List<Contato> lista = new ArrayList<>();
		try {
			Connection con = ConnectionSingleton.instancia().connection();
			String sql = "SELECT * FROM contato WHERE nome like ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + nome + "%");
			ResultSet rs = st.executeQuery();
			while (rs.next()) { 
				Contato c = new Contato();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setTelefone(rs.getString("telefone"));
				c.setEmail(rs.getString("email"));
				c.setNascimento(rs.getDate("nascimento").toLocalDate());
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ContatoException(e);
		}
		return lista;
	}

}
