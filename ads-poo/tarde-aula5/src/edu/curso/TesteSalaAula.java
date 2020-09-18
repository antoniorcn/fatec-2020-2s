package edu.curso;

public class TesteSalaAula {
	public static void main(String args[]) { 
		Aluno a1 = new Aluno("111", "João");
		Aluno a2 = new Aluno("222", "Maria");
		Aluno a3 = new Aluno("333", "Pedro");
		Aluno a4 = new Aluno("444", "Ana");
		Aluno a5 = new Aluno("555", "Paulo");
		Aluno a6 = new Aluno("666", "Carol");
		
		SalaAula s1 = new SalaAula("S1");
		SalaAula s2 = new SalaAula("S2");
		SalaAula s3 = new SalaAula("S3");
		
		s1.aluno1 = a1;
		s1.aluno2 = a3;
		s1.aluno3 = a5;
		
		s2.aluno1 = a2;
		s2.aluno2 = a4;
		s2.aluno3 = a6;
		
		s3.aluno1 = a3;
		s3.aluno2 = a1;
		s3.aluno3 = a5;
		
		Aluno a10 = s1.aluno1;
		s1 = null;
	}
}
