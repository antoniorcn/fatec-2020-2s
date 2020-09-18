package edu.curso;

public class Escola {
	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		Aluno a3 = new Aluno();
		Aluno a4 = new Aluno();
		
		SalaAula s1 = new SalaAula();
		
		s1.aluno1 = a4;
		s1.aluno2 = a1;
		s1.aluno3 = a2;
	}
}
