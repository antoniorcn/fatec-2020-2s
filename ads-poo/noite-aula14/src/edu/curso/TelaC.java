package edu.curso;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class TelaC implements TelaStrategy, ProdutorComando {
		
	private FlowPane pane = new FlowPane();
	private AssinanteComando assinanteComando;
	
	public TelaC() { 
		pane.getChildren().add(new Label("Outra Tela"));
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
