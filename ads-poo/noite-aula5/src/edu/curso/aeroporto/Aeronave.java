package edu.curso.aeroporto;

public class Aeronave {

	String companhiaAerea;
	int qtdPassageiros;
	Piloto piloto;
	Passageiro[] passageiros = new Passageiro[150];
	
	
	public void decolar() { 
		System.out.println("Aeronave pronta");
		piloto.decolar();
	}
}
