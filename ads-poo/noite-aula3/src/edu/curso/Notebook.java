package edu.curso;

public class Notebook {
	public String user;
	public String senha;
	public String ip;
	public String marca;
	public String processador;

	public boolean desbloquear(String senha) {
		return this.senha.equals(senha);
	}

	public String mostrarDesktop() {
		return "Icons de programas e games do usuario " + user;
	}

	public String desligar() {
		return "bye bye ^-^";
	}
}
