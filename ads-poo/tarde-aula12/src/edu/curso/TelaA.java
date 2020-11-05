package edu.curso;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class TelaA implements TelaRecheio {
	private GerenciadorPrincipal gp;
	
	@Override
	public Pane render() {
		FlowPane fp = new FlowPane();
		Button btn = new Button("Aciona tela B");
		btn.setOnAction( (e) -> { 
			gp.comando("telaB");
		});
		fp.getChildren().addAll(
				new Label("Tela A"),
				btn );
		return fp;
	}

	@Override
	public void setGerenciadorPrincipal(GerenciadorPrincipal gp) {
		this.gp = gp;
	}
}
