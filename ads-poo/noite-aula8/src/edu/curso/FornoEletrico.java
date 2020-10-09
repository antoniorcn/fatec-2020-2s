package edu.curso;
public class FornoEletrico extends Forno2000 implements Forno{
	private int temperatura;
	public Pizza pizzaPronta() { 
		return new PizzaMarguerita();
	}
	public void acenderForno() { 
		temperatura = 180;
	}
	public void apagarForno() { 
		temperatura = 0;
	}
}
