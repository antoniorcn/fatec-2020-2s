package edu.curso;

import java.util.HashSet;
import java.util.Set;

public class TesteHashSet {

	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("0001", "João");
		Aluno a2 = new Aluno("0002", "Maria");
		
		Set<Aluno> alunos = new HashSet<Aluno>();
		alunos.add(a2);
		alunos.add(a2);
		alunos.add(a1);
		
		System.out.println("Tamanho do conjunto de alunos: " + alunos.size());
		
		for (Aluno a : alunos) { 
			System.out.println(a);
		}
		
	}
}

