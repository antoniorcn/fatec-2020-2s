package edu.curso;

public class TesteInstanciaCopo {

	public static void main(String[] args) {
		Copo c1 = new Copo();
		System.out.println("Capacidade do Copo: " + c1.getCapacidade());
		c1.setCapacidade(1000);
		System.out.println("Nova Capacidade do Copo: " + c1.getCapacidade());

	}

}
