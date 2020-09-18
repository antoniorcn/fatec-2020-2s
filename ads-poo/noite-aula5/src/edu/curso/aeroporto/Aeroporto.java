package edu.curso.aeroporto;

public class Aeroporto {
	
	String horarioFuncionamento;
	int numeroPistas;
	String torreControle;
	Pessoa[] pessoas = new Pessoa[2000];
	Passageiro[] passageiros = new Passageiro[1000];
	Piloto[] pilotos = new Piloto[50];
	Aeronave[] aeronaves = new Aeronave[25];
	
	public void liberarVoo() { 
		System.out.println("Voo liberado");
	}
	
	public static void main(String[] args) {
		Aeroporto aeroporto = new Aeroporto();
		
		aeroporto.pessoas[0] = new Pessoa();
		aeroporto.pessoas[1] = new Pessoa();
		
		aeroporto.passageiros[0] = new Passageiro();
		aeroporto.passageiros[1] = new Passageiro();
		aeroporto.passageiros[2] = new Passageiro();
		aeroporto.passageiros[3] = new Passageiro();
		
		aeroporto.pilotos[0] = new Piloto();
		
		aeroporto.aeronaves[0] = new Aeronave();
		
		Aeronave aviao = aeroporto.aeronaves[0];
		
		aviao.piloto = aeroporto.pilotos[0];
		aviao.passageiros[0] = aeroporto.passageiros[0];
		aviao.passageiros[1] = aeroporto.passageiros[1];
		aviao.passageiros[2] = aeroporto.passageiros[2];

		aviao.decolar();
		
	}
	

}
