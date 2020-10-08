package edu.curso;

public class FornoDePizza implements Forno {

	private int temperatura;
	
	public Pizza pizzaPronta() { 
		return null;
	}
	
	public void acenderForno() { 
		temperatura = 180;
	}
	
	public void apagarForno() { 
		temperatura = 20;
	}
}
