package edu.curso;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Aluno {
	
	private StringProperty nome = new SimpleStringProperty("");

	public String getNome() {
		return nome.get();
	}
	public void setNome(String nome) {
		this.nome.set(nome);
	}
	
	public StringProperty getNomeProperty() { 
		return this.nome;
	}
	
	
	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		System.out.println("Programa troca de nomes");
//		a1.getNomeProperty().addListener(new ChangeListener<String>() {
//			@Override
//			public void changed(ObservableValue<? extends String> obsValue, 
//					String nomeAntigo, String nomeNovo) {
//				System.out.printf("O aluno teve seu nome "
//						+ "trocado de %s para %s %n", nomeAntigo, nomeNovo);
//			} 
//		});
		
		a1.getNomeProperty().addListener((obsValue, antigo, novo) -> {
			System.out.printf("O aluno teve seu nome "
					+ "trocado de %s para %s %n", antigo, novo);
		});
		
		a1.getNomeProperty().bindBidirectional(a2.getNomeProperty());
		System.out.println("Nome do aluno a2: " + a2.getNome());
		a1.setNome("João");
		System.out.println("Nome do aluno a2: " + a2.getNome());
		a1.setNome("Oswaldo");
		System.out.println("Nome do aluno a2: " + a2.getNome());
		a2.setNome("Pedro");
		System.out.println("Nome do aluno a1: " + a1.getNome());
		
	}
}
