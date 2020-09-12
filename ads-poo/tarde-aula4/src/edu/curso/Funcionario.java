package edu.curso;

public class Funcionario {
	double salario = 1000.0;
	
	public void adicionarBeneficios(float beneficio) { 
		salario += beneficio;
	}
	
//	public void adicionarBeneficios(float beneficio1, float beneficio2) { 
//		salario += beneficio1;
//		salario += beneficio2;
//	}

//	public void adicionarBeneficios(float[] beneficios) { 
//		for (float b : beneficios) { 
//			salario += b;
//		}
//	}
	
	public void adicionarBeneficios(float ... beneficios) {
		for (float b : beneficios) { 
			salario += b;
		}
	}

}
