package edu.curso.aeroporto;

public class Aeroporto {
	
	private Passageiro[] passageiros = new Passageiro[1000];
	private Piloto[] piloto = new Piloto[50];
	private Aeronave[] aeronaves = new Aeronave[50];
	
	public Passageiro[] getPassageiros() {
		return passageiros;
	}
	public void setPassageiros(Passageiro[] passageiros) {
		this.passageiros = passageiros;
	}

	public Piloto[] getPiloto() {
		return piloto;
	}
	public void setPiloto(Piloto[] piloto) {
		this.piloto = piloto;
	}

	public Aeronave[] getAeronaves() {
		return aeronaves;
	}
	public void setAeronaves(Aeronave[] aeronaves) {
		this.aeronaves = aeronaves;
	}
}
