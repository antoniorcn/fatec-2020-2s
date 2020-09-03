package edu.curso;
public class TesteClasses {
	public static void main(String[] args) {
		Lampada lamp1 = new Lampada();
		System.out.println("Lampada está ligada: " + lamp1.ligada);
		lamp1.cor = "Amarela";
		lamp1.ligar();
		System.out.println("Lampada está ligada: " + lamp1.ligada);
		lamp1.desligar();
		System.out.println("Lampada está ligada: " + lamp1.ligada);
	}
}
