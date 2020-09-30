package edu.curso;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Acao {
	private long id;
	private String usuario;
	private String descricao;
	private String tipo;
	private Incidente incidente;
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@ManyToOne
	public Incidente getIncidente() {
		return incidente;
	}
	public void setIncidente(Incidente incidente) {
		this.incidente = incidente;
	}
	
	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append(String.format("\t\t %d - %s%n", getId(), getTipo()));
		sb.append(String.format("\t\t %s%n", getDescricao()));
		return sb.toString();
	}
}
