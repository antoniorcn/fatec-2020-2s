package edu.curso;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class TelaC implements TelaStrategy {
		
	private FlowPane pane = new FlowPane();
	private Principal principal;
	
	public TelaC(Principal principal) { 
		this.principal = principal;
		pane.getChildren().add(new Label("Outra Tela"));
	}
	
	
	@Override
	public Pane getTela() {
		return pane;
	}
}
