package edu.curso;

public class Praca {

	public static void main(String[] args) {
		Jornal folha = new Jornal("Folha de São Paulo");
		Jornal zapzap = new Jornal("Zap Zap");
		Jornal elpais = new Jornal("El Pais");
		
		Aluno a1 = new Aluno("Maria");
		Aluno a2 = new Aluno("João");
		Aluno a3 = new Aluno("Evaldo");
		
		Trabalhador t1 = new Trabalhador("Ronaldo");
		Trabalhador t2 = new Trabalhador("Suely");
		Trabalhador t3 = new Trabalhador("Priscila");
		
		folha.adicionar(a1);
		folha.adicionar(a2);
		folha.adicionar(t1);
		
		zapzap.adicionar(t2);
		zapzap.adicionar(a3);
		
		elpais.adicionar(t3);
		elpais.adicionar(a1);
		
		folha.distribuirNoticia("Pibinho de -5% em 2020");
		zapzap.distribuirNoticia("Pais vai de vento em popa, economia punjante");
		elpais.distribuirNoticia("Binden e Trump empatam em pesquisa eleitoral");		
	}
}
