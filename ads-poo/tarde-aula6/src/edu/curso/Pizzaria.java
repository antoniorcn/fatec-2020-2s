package edu.curso;

public class Pizzaria {
	
	public static void main(String[] args) {
		Pizza p1 = new PizzaMussarelaBemPassada();
		
		p1.prepararMassa();
		p1.colocarIngredientes();
		p1.assar();
		p1.servir();
	}

}
