package edu.curso;

import java.util.Optional;

public class Funcionario {
	double salario = 1000.0;
	
//	public void adicionarBeneficios(float beneficio1, float beneficio2) { 
//		salario += beneficio1;
//		salario += beneficio2;
//	}
	
//	public void adicionarBeneficios(float beneficio1,
//							float beneficio2, float beneficio3) { 
//		salario += beneficio1;
//		salario += beneficio2;
//		salario += beneficio3;
//	}
	
//	public void adicionarBeneficios(float[] beneficios) { 
//		for (float b : beneficios) { 
//			salario += b;
//		}
//	}
	
	public void adicionarBeneficios(Optional<Float> b1, Number ... beneficios) { 
		salario += (b1.orElse(0.0f) * 2);
		for (Number b : beneficios) { 
			salario += b.doubleValue();
		}
	}
	

}
