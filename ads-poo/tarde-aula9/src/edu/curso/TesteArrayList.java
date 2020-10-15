package edu.curso;

import java.util.ArrayList;
import java.util.List;

public class TesteArrayList {
	public static void main(String[] args) {
		String nomes[] = {"João", "Maria", "Alberto", "Flavio", 
				"Iane", "Mario", "Suely", "Sara"};
		long start = System.currentTimeMillis();
		List<Aluno> lista = new ArrayList<Aluno>();
		for (int i = 0; i < 1000000; i++) {
			int indiceNome = i % (nomes.length - 1);
			String nome = nomes[indiceNome];
			String ra = String.valueOf(i);
			Aluno a = new Aluno(ra, nome);
			lista.add(a);
		}
		long finish = System.currentTimeMillis();
		
		long diff = finish - start;
		System.out.printf("Demorou %d milisegundos%n", diff);
	}
}
