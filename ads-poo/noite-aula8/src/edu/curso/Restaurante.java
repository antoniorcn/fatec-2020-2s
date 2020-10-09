package edu.curso;

public class Restaurante {
	public static void main(String[] args) {
		PizzaMussarela p1 = new PizzaMussarela();
		FornoDePizza fp = new FornoDePizza();
		FornoEletrico fe = new FornoEletrico();
		fe.acessoWifi();
		p1.assar(fe);
		
		Pizza p = fe.pizzaPronta();
		p.servir();
	}
}
