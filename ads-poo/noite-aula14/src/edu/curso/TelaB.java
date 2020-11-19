package edu.curso;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class TelaB implements TelaStrategy, ProdutorComando {
		
	private FlowPane pane = new FlowPane();
	private AssinanteComando assinanteComando;
	
	public TelaB() { 
		Button btn = new Button("Contato");
		btn.setOnAction((e) -> { 
			acionarComando("contato");
		});
		pane.getChildren().addAll(new Label("Tela de Créditos"),
				btn);
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
