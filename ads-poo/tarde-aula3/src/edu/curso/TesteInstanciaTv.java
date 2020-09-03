package edu.curso;

public class TesteInstanciaTv {
	public static void main(String[] args) {
		Tv tv = new Tv();
		tv.cor = "preto";
		tv.marca = "LG";
		tv.nomeProgr = "now";
		tv.canal = 500;
		tv.ligar();
		tv.assistir();
		tv.desligar();
		System.out.println("Cor da Tv: " + tv.cor);
		System.out.println("Marca da Tv: " + tv.marca);
		System.out.println("Nome do Programa: " + tv.nomeProgr);
		System.out.println("Canal: " + tv.canal);
	}
}
