package edu.curso;


public class Meia {
	String cor;
	String tamanho;
	String tipo;
	String decoracao;
	String material;

	public void desbotar() {
		System.out.printf("A meia %s está desbotando%n", cor);
	}
	
	public void desfiar() {
		System.out.printf("A meia de %s está desfiando%n", material);
	}
	
	public void secar() {
		System.out.println("A meia está secando ao sol");
	}	
	
	public static void descartarMeia() {
		System.out.println("A meia esta sendo descartada");
	}
	
}
