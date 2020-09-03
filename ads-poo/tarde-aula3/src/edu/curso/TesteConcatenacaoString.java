package edu.curso;

public class TesteConcatenacaoString {
	public static void main(String[] args) {
		long tempoInicial = System.currentTimeMillis();
		System.out.println("Inicio do programa");
		String texto = "";
		for (int i = 0; i < 200000; i++) { 
			texto = texto + "*";
			if (i % 10000 == 0) { 
				System.out.println(i);
			}
		}
		System.out.println("Termino do programa");
		long tempoFinal = System.currentTimeMillis();
		float dif = (tempoFinal - tempoInicial) / 1000.0f;
		System.out.printf("Gastou %6.2f segundos na execução%n", dif);
	}
}
