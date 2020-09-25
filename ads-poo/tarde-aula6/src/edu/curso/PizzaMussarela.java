package edu.curso;

public abstract class PizzaMussarela extends Pizza {
	
	@Override
	public void colocarIngredientes() { 
		System.out.println("Colocando molho e queijo");
	}
	
//	@Override
//	public void assar() { 
//		System.out.println("Assando no forno por 5 minutos");
//	}

}
