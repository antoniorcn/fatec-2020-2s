package edu.curso;

import java.util.Optional;

public class TesteFuncionario {
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario();
		Funcionario f2 = new Funcionario();
		Funcionario f3 = new Funcionario();
		Funcionario f4 = new Funcionario();
		
//		f1.adicionarBeneficios(new float[] {120.0f, 340.0f});
//		f2.adicionarBeneficios(new float[] {150.0f, 0.0f});
//		f3.adicionarBeneficios(new float[] {260.0f, 540.0f, 860.0f});
//		f4.adicionarBeneficios(new float[] {260.0f, 540.0f, 980.0f, 320.0f});
		
		f1.adicionarBeneficios(Optional.of(140.0f), 340.0f);
		f2.adicionarBeneficios(Optional.empty());
		f3.adicionarBeneficios(Optional.empty(), 540.0f, 860.0f);
		f4.adicionarBeneficios(Optional.empty(), 540.0f, 980.0f, 320.0f, 90);
		
		System.out.println("Contracheque do Funcionario 1: " + f1.salario);
		System.out.println("Contracheque do Funcionario 2: " + f2.salario);
		System.out.println("Contracheque do Funcionario 3: " + f3.salario);
		System.out.println("Contracheque do Funcionario 4: " + f4.salario);
	}
}
