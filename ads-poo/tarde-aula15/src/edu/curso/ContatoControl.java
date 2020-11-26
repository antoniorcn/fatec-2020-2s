package edu.curso;
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
	
	private ObservableList<Contato> lista = FXCollections.observableArrayList();
	
	private LongProperty id = new SimpleLongProperty();
	private StringProperty nome = new SimpleStringProperty();
	private StringProperty telefone = new SimpleStringProperty();
	private StringProperty email = new SimpleStringProperty();
	private ObjectProperty<LocalDate> nascimento = 
			new SimpleObjectProperty<>(LocalDate.now());
	
	private ContatoDAO contatoDAO = new ContatoDAOImpl();
	
	
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
	
	public void adicionar() throws DAOException {
		Contato c = getContato();
		contatoDAO.adicionar(c);
	} 
	
	public void pesquisarPorNome() throws DAOException { 
		String txt = this.nome.get();
		lista.clear();
		lista.addAll(contatoDAO.pesquisarPorNome(txt));
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
