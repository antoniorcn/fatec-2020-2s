package edu.curso.aeroporto;

public class Aeronave {
	
	private Piloto piloto;
	private Passageiro[] passageiros = new Passageiro[150];
	private int velocidade;
	
	public Piloto getPiloto() {
		return piloto;
	}
	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}
	
	public Passageiro[] getPassageiros() {
		return passageiros;
	}
	public void setPassageiros(Passageiro[] passageiros) {
		this.passageiros = passageiros;
	}
	
	public int getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
}
