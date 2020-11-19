package edu.curso;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class TelaA implements TelaStrategy {
	private Principal principal;
	private FlowPane pane = new FlowPane();
	
	public TelaA(Principal principal) { 
		this.principal = principal;
		Button btn = new Button("Créditos");
		Button btnSair = new Button("Sair");
		pane.getChildren().addAll(
				new Label("Tela de Contato"),
				btn, btnSair);
		btn.setOnAction((e) -> { 
			principal.executarComando("creditos");
		});
		
		btnSair.setOnAction((e) -> { 
			principal.executarComando("sair");
		});
	}
	
	@Override
	public Pane getTela() {
		return pane;
	}
}
