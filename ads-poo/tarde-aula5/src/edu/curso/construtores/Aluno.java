package edu.curso.construtores;

public class Aluno extends Pessoa {
	String ra;
	
	public Aluno(String nome, String ra) {
		super(nome);
		this.ra = ra;
		System.out.println("Criando instância de Aluno");
	}
	
	public Aluno(String nome) { 
		this(nome, "0000");
	}
	
	public Aluno() { 
		this("João Silva");
	}

}
