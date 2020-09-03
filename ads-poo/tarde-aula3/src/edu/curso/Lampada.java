package edu.curso;

public class Lampada {
	int tamanho;
	String tipo;
	int potencia;
	boolean ligada;
	String cor;
	
	void ligar() {
		ligada = true;
		System.out.println("está ligada");
	}
	void desligar() {
		ligada = false;
		System.out.println("está desligada");
	}
	static void cor (String cor) {
		System.out.println("A cor da lampada é "+cor);
	}
}