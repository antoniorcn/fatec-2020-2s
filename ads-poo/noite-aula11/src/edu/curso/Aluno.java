package edu.curso;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class Aluno {
	private StringProperty nome = new SimpleStringProperty();
	private StringProperty ra = new SimpleStringProperty("");

	public String getNome() {
		return nome.get();
	}
	public void setNome(String nome) {
		this.nome.set(nome);
	}
	public StringProperty getNomeProperty() { 
		return this.nome;
	}
	
	public String getRa() {
		return ra.get();
	}
	public void setRa(String ra) {
		this.ra.set(ra);
	}
	public StringProperty getRaProperty() { 
		return this.ra;
	}
	
	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		
//		a1.getNomeProperty().addListener( 
//				new ChangeListener<String>() {
//					@Override
//					public void changed(ObservableValue<? extends String> obsValue, 
//											String antigo, String novo) {
//						System.out.printf("Nome alterado de %s para %s%n", 
//								antigo, novo);
//					} 
//				});
		
		a1.getNomeProperty().bindBidirectional(a2.getNomeProperty());
		
		a1.getNomeProperty().addListener( (obsValue, antigo, novo) -> {
			System.out.printf("Nome alterado de %s para %s%n", antigo, novo);
		} );
		
		a1.getRaProperty().addListener( (obsValue, antigo, novo) -> { 
			System.out.printf("RA alterado de %s para %s%n", antigo, novo);
		});
		
		a1.setNome("João");
		System.out.println("Nome do A2: " + a2.getNome());
		a1.setRa("1111");
		a1.setNome("Pedro");
		System.out.println("Nome do A2: " + a2.getNome());
		a2.setNome("Luiz");
		System.out.println("Nome do A2: " + a2.getNome());
		
		System.out.println(a1.getNome());
		
	}
}
