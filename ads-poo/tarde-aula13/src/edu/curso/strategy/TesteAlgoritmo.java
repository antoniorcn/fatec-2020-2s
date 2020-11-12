package edu.curso.strategy;

public class TesteAlgoritmo {
	
	public void executar(int alg) { 
		if (alg == 0) { 
			executarA();
		} else if (alg == 1) { 
			executarB();
		}
	}
	
	public void executarA() { 
		System.out.println("Algoritmo A");
	}
	
	public void executarB() { 
		System.out.println("Algoritmo B");
	}
	
	public void executarC() { 
		System.out.println("Algoritmo C");
	}

}
