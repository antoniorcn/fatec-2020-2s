package edu.curso;

import javax.validation.constraints.NotBlank;

public class Contato {
	private String nome;
	private String email;
	private String telefone;

	@NotBlank(message = "É preciso fornecer um nome para o contato")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
