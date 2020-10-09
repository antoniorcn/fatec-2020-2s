package edu.curso;
public class FornoDePizza implements Forno {
	private int temperatura;
	public Pizza pizzaPronta() { 
		return new PizzaMussarela();
	}
	public void acenderForno() { 
		temperatura = 180;
	}
	public void apagarForno() { 
		temperatura = 0;
	}
}
