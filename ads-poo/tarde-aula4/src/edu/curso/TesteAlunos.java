package edu.curso;

public class TesteAlunos {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("João");
		Aluno a2 = new Aluno("Maria");
		Aluno a3 = new Aluno();
		
		if (a1.caracter == 0) { 
			System.out.println("Igual a 0");
		}
		if (a1.caracter == '\u0000') { 
			System.out.println("Igual a \u0000");
		}

	}

}
