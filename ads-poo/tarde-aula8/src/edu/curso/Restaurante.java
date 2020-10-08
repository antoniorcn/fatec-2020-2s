package edu.curso;

public class Restaurante {
	public static void main(String[] args) {
		PizzaMussarela p = new PizzaMussarela();
		FornoDePizza f = new FornoDePizza();
		p.assar(f);
		
		Pizza pizzaPronta = f.pizzaPronta();
	}
}
