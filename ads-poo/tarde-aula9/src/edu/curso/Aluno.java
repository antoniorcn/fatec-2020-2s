package edu.curso;

public class Aluno implements Comparable<Aluno>, Assinante {
	private String ra;
	private String nome;
	
	public Aluno(String ra, String nome) { 
		this.setRa(ra);
		this.setNome(nome);
	}

	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() { 
		return this.ra + " - " + this.nome;
	}

	@Override
	public int compareTo(Aluno a) {
		return a.getNome().compareTo(this.getNome());
	}

	@Override
	public void receberInformacao(String msg) {
		String texto = String.format("Aluno %s esta lendo %s", this.nome, msg);
		System.out.println(texto);
	}
}
