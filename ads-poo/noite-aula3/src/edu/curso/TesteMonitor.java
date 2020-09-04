package edu.curso;

public class TesteMonitor {

	public static void main(String[] args) {
		Monitor m1 = new Monitor();
		m1.marca = "Samsung";
		m1.resolucao = "1024x768";
		m1.ligar();
		m1.desligar();
		
		System.out.println(m1.mostrarDadosMonitor());

	}

}
