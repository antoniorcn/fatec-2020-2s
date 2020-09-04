package edu.curso;

public class TesteConcatenacaoString {
	public static void main(String[] args) {
		long tempoInicio = System.currentTimeMillis();
		System.out.println("Inicio do Programa");
		String texto = "";
		for (int i = 0; i < 300000; i++) { 
			texto = texto + "*";
			if (i % 1000 == 0) { 
				System.out.println(i);
			}
		}
		System.out.println("Final do Programa");
		long tempoFinal = System.currentTimeMillis();
		float dif = (tempoFinal - tempoInicio) / 1000.0f;
		System.out.printf("Gastou %6.2f segundos%n", dif);
	}
}
