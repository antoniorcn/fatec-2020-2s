package edu.curso;

public class Copo {
	private String tipo;
	private String cor;
	private int capacidade;
	private boolean limpo;
	public Copo(String tipo, String cor, int capacidade, boolean limpo) {
		this.tipo = tipo;
		this.cor = cor;
		this.capacidade = capacidade;
		this.limpo = limpo;
	}
	public Copo() { 

	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		if (capacidade >=0 && capacidade <= 1000) {  
			this.capacidade = capacidade;
		}
	}
	public boolean isLimpo() {
		return limpo;
	}
	public void setLimpo(boolean limpo) {
		this.limpo = limpo;
	}
	public void usar() {
		this.limpo = false;
		System.out.println("O copo foi usado");
	}
	public void lavar() {
		if (!limpo) {
			this.limpo = true;
		}
		System.out.println("O copo esta limpo");
	}
}