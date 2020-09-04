package edu.curso;

public class TesteNotebook {

	public static void main(String[] args) {
		Notebook note1 = new Notebook();
		Notebook note2 = new Notebook();
		
		note1.user = "Antonio";
		note2.user = "João";
		
		System.out.println(note1.mostrarDesktop());
		System.out.println(note2.mostrarDesktop());
		// System.out.println(note1.desligar());
	}
}
