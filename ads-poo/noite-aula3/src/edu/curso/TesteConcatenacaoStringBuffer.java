package edu.curso;

public class TesteConcatenacaoStringBuffer {

	public static void main(String[] args) {
		long tempoInicial = System.currentTimeMillis();
		System.out.println("Inicio do Programa");
		StringBuffer texto = new StringBuffer("");
		for (int i = 0; i < 1900000; i++) { 
			texto.append("*");
			if (i % 1000 == 0) { 
				System.out.println(i);
			}
		}
		System.out.println("Final do Programa");
		long tempoFinal = System.currentTimeMillis();
		float dif = (tempoFinal - tempoInicial) / 1000.0f;
		System.out.printf("Tempo gasto %6.2f %n", dif);
	}

}
