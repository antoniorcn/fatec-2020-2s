package edu.curso;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class TelaB implements TelaRecheio {
	private GerenciadorPrincipal gp;

	@Override
	public Pane render() {
		FlowPane fp = new FlowPane();
		Button btn = new Button("Aciona tela A");
		btn.setOnAction( (e) -> { 
			gp.comando("telaA");
		});
		
		Button btnSair = new Button("Sair");
		btnSair.setOnAction( (e) -> { 
			gp.comando("sair");
		});
		fp.getChildren().addAll(
				new Label("Tela B"),
				btn,
				btnSair );
		return fp;
	}
	
	@Override
	public void setGerenciadorPrincipal(GerenciadorPrincipal gp) {
		this.gp = gp;
	}

}
