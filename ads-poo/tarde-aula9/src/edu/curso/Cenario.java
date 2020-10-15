package edu.curso;

public class Cenario {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("0001", "João");
		Aluno a2 = new Aluno("0002", "Maria");
		Trabalhador t1 = new Trabalhador("Edvaldo");
		Trabalhador t2 = new Trabalhador("Jurema");
		
		Jornal j1 = new Jornal("Folha de São Paulo");
		Jornal j2 = new Jornal("Agora");
		
		j1.adicionarAssinante(a1);
		j1.adicionarAssinante(t2);
		j1.adicionarAssinante(a2);
		
		j2.adicionarAssinante(t1);
		
		j1.notificar("Vacina da COVID esta em fase de testes");
		j2.notificar("Governador dorme com duas mulheres e é flagrado");
		
		
		
		
	}
}
