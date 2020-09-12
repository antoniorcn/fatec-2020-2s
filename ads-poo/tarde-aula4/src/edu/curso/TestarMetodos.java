package edu.curso;

public class TestarMetodos {
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario();
		f1.adicionarBeneficios(250.0f);
		
		Funcionario f2 = new Funcionario();
		// f2.adicionarBeneficios(250.0f, 140.0f);
		// f2.adicionarBeneficios(new float[] {250.0f, 140.0f, 80.0f, 240.0f});
		f2.adicionarBeneficios(250.0f, 140.0f, 80.0f, 240.0f);
		
		System.out.println("Contracheque Funcionario 1: " + f1.salario);
		System.out.println("Contracheque Funcionario 2: " + f2.salario);
	}
}
