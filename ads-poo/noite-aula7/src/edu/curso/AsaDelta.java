package edu.curso;

public class AsaDelta implements Pipa {

	@Override
	public void cair() {
		System.out.println("Caindo, e usando mecanismo de seguran�a");
	}

	@Override
	public void mover() {
		System.out.println("Passeando de Asa Delta");
	}
}
