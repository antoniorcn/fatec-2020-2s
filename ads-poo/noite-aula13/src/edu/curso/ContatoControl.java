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
	
	private static final String URLCON = "jdbc:mariadb://localhost:3306/agendadb?allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "";
	
	private ObservableList<Contato> lista = FXCollections.observableArrayList();
	
	private LongProperty idProperty = new SimpleLongProperty(0);
	private StringProperty nomeProperty = new SimpleStringProperty("João");
	private StringProperty telefoneProperty = new SimpleStringProperty("(11)    -    ");
	private StringProperty emailProperty = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> nascimentoProperty = new SimpleObjectProperty<>(LocalDate.now());
	
	public ContatoControl() { 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Contato getContato() { 
		Contato c = new Contato();
		c.setId(idProperty.get());
		c.setNome(nomeProperty.get());
		c.setTelefone(telefoneProperty.get());
		c.setEmail(emailProperty.get());
		c.setNascimento(nascimentoProperty.get());
		return c;
	}
	
	public void setContato(Contato c) { 
		if (c != null)  { 
			idProperty.set(c.getId());
			nomeProperty.set(c.getNome());
			telefoneProperty.set(c.getTelefone());
			emailProperty.set(c.getEmail());
			nascimentoProperty.set(c.getNascimento());
		}
	}
	
	public void adicionar() { 
		// Contato c = getContato();
		// lista.add(c);
		getLista().add(getContato());
		
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			Connection con = DriverManager.getConnection(URLCON, USER, PASS);
			String sql = "INSERT INTO agenda (id, nome, telefone, email, nascimento) " + 
			"VALUES (?, ?, ?, ?, ?)"; 
			PreparedStatement st = con.prepareStatement(sql);
			st.setLong(1, getContato().getId());
			st.setString(2, getContato().getNome());
			st.setString(3,  getContato().getTelefone());
			st.setString(4, getContato().getEmail());
			st.setDate(5, java.sql.Date.valueOf(getContato().getNascimento()));
			st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void pesquisarPorNome() {
		for (Contato c : getLista()) { 
			if (c.getNome().contains(nomeProperty.get())) { 
				setContato(c);
			}
		}
	}
	
	public LongProperty getIdProperty() {
		return idProperty;
	}
	public StringProperty getNomeProperty() {
		return nomeProperty;
	}
	public StringProperty getTelefoneProperty() {
		return telefoneProperty;
	}
	public StringProperty getEmailProperty() {
		return emailProperty;
	}
	public ObjectProperty<LocalDate> getNascimentoProperty() {
		return nascimentoProperty;
	}

	public ObservableList<Contato> getLista() {
		return lista;
	}
}
