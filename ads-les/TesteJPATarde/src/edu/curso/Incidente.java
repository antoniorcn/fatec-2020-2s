package edu.curso;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Incidente {
	private long id;
	private String titulo;
	private String descricao;
	private LocalDateTime abertura;
	private LocalDateTime fechamento;
	private String categoria;
	private String status;
	private Set<Acao> acoes;
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public LocalDateTime getAbertura() {
		return abertura;
	}
	public void setAbertura(LocalDateTime abertura) {
		this.abertura = abertura;
	}
	
	public LocalDateTime getFechamento() {
		return fechamento;
	}
	public void setFechamento(LocalDateTime fechamento) {
		this.fechamento = fechamento;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@OneToMany(mappedBy = "incidente", fetch=FetchType.LAZY)
	public Set<Acao> getAcoes() {
		return acoes;
	}
	public void setAcoes(Set<Acao> acoes) {
		this.acoes = acoes;
	}
	
	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append(String.format("%d - %s%n", getId(), getTitulo()));
		sb.append(String.format("%s - %s%n", getStatus(), getAbertura()));
		sb.append(String.format("%s - %s%n", getCategoria(), getFechamento()));
//		for (Acao a : getAcoes()) { 
//			sb.append(a.toString());
//		}
		return sb.toString();
	}
}
