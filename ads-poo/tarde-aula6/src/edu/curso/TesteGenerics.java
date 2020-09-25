package edu.curso;

public class TesteGenerics {
	
	public static void main(String[] args) {
		Matematica<Float> mat = new Matematica<>();
		double resultado = mat.somar(10.0f, 10.0f);
	}

}
