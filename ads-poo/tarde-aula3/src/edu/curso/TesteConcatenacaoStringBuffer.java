package edu.curso;

public class TesteConcatenacaoStringBuffer {

	public static void main(String[] args) {
		long tempoInicial = System.currentTimeMillis();
		System.out.println("Programa iniciado");
		StringBuffer texto = new StringBuffer("");
		for (int i = 0; i < 1200000; i++) { 
			if (i % 10000 == 0) { 
				System.out.println(i);
			}
			texto.append("*");
		}
		System.out.println("Programa finalizado");
		long tempoFinal = System.currentTimeMillis();
		float dif = (tempoFinal - tempoInicial) / 1000.0f;
		System.out.printf("Foram gastos %6.2f segundos na execução %n", dif);
	}
}
