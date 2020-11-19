package edu.curso;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class CreditosBoundary implements SubTela {
	
	@Override
	public Pane gerarTela() { 
		
		GridPane grid = new GridPane();
		grid.add(new Label("Desenvolvedor: "), 0, 0);
		grid.add(new Label("Antonio Rodrigues: "), 1, 0);
		grid.add(new Label("Direção: "), 0, 1);
		grid.add(new Label("Ayrton Sena: "), 1, 1);
		grid.add(new Label("Dev Ops: "), 0, 2);
		grid.add(new Label("Wellignton: "), 1, 2);
		grid.add(new Label("Analista Negócio: "), 0, 3);
		grid.add(new Label("Cristina: "), 1, 3);
		
		return grid;
	}

}
