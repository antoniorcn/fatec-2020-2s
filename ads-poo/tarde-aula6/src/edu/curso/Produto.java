package edu.curso;

public class Produto {
	
	public static final int estoqueMinimo = 10;
	public static int quantidade = 0;
	
	private String id;
	private String nome;
	private double imposto;
	private double valorUnitario;
	
	public Produto() { 
		Produto.quantidade++;
	}
	
	public static void relatorioQuantidade() { 
		System.out.printf("O estoque possui %d produtos%n", 
					Produto.quantidade);
		if (Produto.quantidade < Produto.estoqueMinimo) { 
			System.out.println("O estoque está abaixo do estoque minimo");
		}
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getImposto() {
		return imposto;
	}
	public void setImposto(double imposto) {
		this.imposto = imposto;
	}
	
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
}
