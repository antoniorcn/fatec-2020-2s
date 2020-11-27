package edu.curso;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class TelaB implements TelaStrategy {
		
	private FlowPane pane = new FlowPane();
	private Principal principal;
	
	public TelaB(Principal principal) { 
		this.principal = principal; 
		Button btn = new Button("Contato");
		btn.setOnAction((e) -> { 
			principal.executarComando("contato");
		});
		pane.getChildren().addAll(new Label("Tela de Créditos"),
				btn);
	}
	
	
	@Override
	public Pane getTela() {
		return pane;
	}
}
