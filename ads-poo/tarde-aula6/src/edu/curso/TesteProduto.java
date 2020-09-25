package edu.curso;

public class TesteProduto {
	
	public static void main(String[] args) {
		System.out.println(Produto.quantidade);
		
		Produto p1 = new Produto();
		Produto p2 = new Produto();
		Produto.relatorioQuantidade();
		Produto p3 = new Produto();
		Produto p4 = new Produto();
		
		
		
		System.out.println(Produto.quantidade);
	}

}
