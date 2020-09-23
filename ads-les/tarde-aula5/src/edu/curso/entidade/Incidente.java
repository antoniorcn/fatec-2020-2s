package edu.curso.entidade;

import java.time.LocalDateTime;

public class Incidente {
	private long id;
	private String titulo;
	private String descricao;
	private LocalDateTime abertura;
	private LocalDateTime fechamento;
	private String categoria;
	
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
}
