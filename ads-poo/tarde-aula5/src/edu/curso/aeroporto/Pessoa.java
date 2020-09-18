package edu.curso.aeroporto;

public class Pessoa {
	private String cpf;
	private String nome;
	private double altura;
	
	public String getCpf() { 
		return cpf;
	}
	public void setCpf(String value) { 
		cpf = value;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
}
