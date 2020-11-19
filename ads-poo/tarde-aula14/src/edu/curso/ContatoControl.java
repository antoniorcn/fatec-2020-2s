package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContatoControl {
	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URLCON = "jdbc:mariadb://localhost:3306/contatodb?allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "";
	
	
	private ObservableList<Contato> lista = FXCollections.observableArrayList();
	
	private LongProperty id = new SimpleLongProperty();
	private StringProperty nome = new SimpleStringProperty();
	private StringProperty telefone = new SimpleStringProperty();
	private StringProperty email = new SimpleStringProperty();
	private ObjectProperty<LocalDate> nascimento = 
			new SimpleObjectProperty<>(LocalDate.now());
	
	public ContatoControl() { 
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Contato getContato() { 
		Contato c = new Contato();
		c.setId(this.id.get());
		c.setNome(this.nome.get());
		c.setTelefone(this.telefone.get());
		c.setEmail(this.email.get());
		c.setNascimento(this.nascimento.get());
		return c;
	}
	
	public void setContato(Contato c) { 
		if (c != null) {
			this.id.set(c.getId());
			this.nome.set(c.getNome());
			this.telefone.set(c.getTelefone());
			this.email.set(c.getEmail());
			this.nascimento.set(c.getNascimento());
		}
	}
	
	public void adicionar() {
		Contato c = getContato();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		lista.add( c );
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
			
//			Statement st = con.createStatement();
//			String sql = String.format("INSERT INTO contato (id, nome, telefone, "
//					+ "email, nascimento) VALUES (%d, '%s', '%s', '%s', '%s')",
//					c.getId(), c.getNome(), c.getTelefone(), 
//					c.getEmail(), c.getNascimento().format(dtf));
// 			st.executeUpdate(sql);
// 			System.out.println(sql);
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		lista.add(c);
	}
	
	public void pesquisarPorNome() { 
		String txt = this.nome.get();
		for (Contato c : lista) { 
			if (c.getNome().contains(txt)) { 
				setContato(c);
			}
		}
	}

	public LongProperty getIdProperty() {
		return id;
	}
	public StringProperty getNomeProperty() {
		return nome;
	}
	public StringProperty getTelefoneProperty() {
		return telefone;
	}
	public StringProperty getEmailProperty() {
		return email;
	}
	public ObjectProperty<LocalDate> getNascimentoProperty() {
		return nascimento;
	}
	public ObservableList<Contato> getLista() { 
		return lista;
	}
}
