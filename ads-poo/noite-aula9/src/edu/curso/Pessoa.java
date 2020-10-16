package edu.curso;

public class Pessoa implements Comparable<Pessoa> {
	private int idade;
	private String nome;
	
	public Pessoa(String nome, int idade) { 
		this.setNome(nome);
		this.setIdade(idade);
	}

	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int compareTo(Pessoa p) {
		if (this.idade > p.idade) { 
			return -1;
		} else if (this.idade < p.idade) { 
			return 1;
		} else { 
			return 0;
		}
	}
}
