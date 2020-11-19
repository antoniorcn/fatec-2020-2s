package edu.curso;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class TelaA implements TelaStrategy,
					ProdutorComando {
	
	private FlowPane pane = new FlowPane();
	private AssinanteComando assinanteComando;
	
	public TelaA() { 
		Button btn = new Button("Créditos");
		Button btnSair = new Button("Sair");
		pane.getChildren().addAll(
				new Label("Tela de Contato"),
				btn, btnSair);
		btn.setOnAction((e) -> { 
			acionarComando("creditos");
		});
		
		btnSair.setOnAction((e) -> { 
			acionarComando("sair");
		});
	}
	
	@Override
	public Pane getTela() {
		return pane;
	}

	@Override
	public void setAssinanteComando(AssinanteComando a) {
		this.assinanteComando = a;	
	}

	@Override
	public void acionarComando(String cmd) {
		this.assinanteComando.executarComando(cmd);
	}
}
