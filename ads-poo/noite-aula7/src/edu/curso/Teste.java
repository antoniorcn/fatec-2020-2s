package edu.curso;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Teste {

	public static void main(String[] args) {
		// Exemplos de Classes Anônimas
		Pipa p = new Pipa() {
			@Override
			public void mover() {
				System.out.println("Pipa caindo");
			} 
		};
		
		Button b = new Button();
		b.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Botão apertado");
			} 
		});
	}

}
