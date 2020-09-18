package edu.curso.aeroporto;

public class Piloto extends Pessoa {
	
	String companhiaAerea;
	String turnoTrabalho;
	String breve;
	
	public Piloto(String breve, String companhiaAerea) { 
		super("Jo�o");
		this.breve = breve;
		this.companhiaAerea = companhiaAerea;
		System.out.println("Criando inst�ncia de piloto");
	}
	
	public Piloto(String breve) { 
		this(breve, "Azul");
	}
	
	public Piloto() { 
		this("0000");
	}
	
	public void decolar() { 
		System.out.println("Decolando com o avi�o");
	}

}
