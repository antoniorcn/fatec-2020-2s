package edu.curso;

import java.util.Set;

public class PizzaMarguerita implements Pizza {
	private Set<String> ingredientes;
	
	public void assar(Forno f) { 
	}
	
	public void cortar() { 
	}
	
	public void servir() { 
		System.out.println("Servindo Pizza de Marguerita");
	}
}
