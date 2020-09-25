package edu.curso;

public abstract class Pizza {
	private String[] ingredientes;
	private String sabor;
	private int tamanho;
	
	public void prepararMassa() { 
		System.out.println("Preparando a massa com farinha de trigo");
	}
	
	public abstract void colocarIngredientes();
	
	public abstract void assar();
	
	public void servir() { 
		System.out.println("Cortando a pizza em 8 pedaços");
	}
	
	public String[] getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String[] ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
}
