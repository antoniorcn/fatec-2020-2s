package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JanelaContatos extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		GridPane grid = new GridPane();
		Scene scn = new Scene(grid, 600, 200);
		grid.add(new Label("Id"), 0, 0);
		grid.add(new Label("Nome"), 0, 1);
		grid.add(new Label("Telefone"), 0, 2);
		
		TextField txtId = new TextField();
		TextField txtNome = new TextField();
		TextField txtTelefone = new TextField();
		grid.add(txtId, 1, 0);
		grid.add(txtNome, 1, 1);
		grid.add(txtTelefone, 1, 2);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(25);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(75);
		grid.getColumnConstraints().addAll(col1, col2);
		
		FlowPane fp = new FlowPane();
		
		Button btnSave = new Button("Salvar");
		Button btnPesquisar = new Button("Pesquisar");
		fp.getChildren().addAll(btnSave, btnPesquisar);
		grid.add(fp, 0, 3);


		grid.setVgap(10);
		
		stage.setTitle("Agenda de Contatos");
		stage.setScene(scn);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(JanelaContatos.class, args);
	}
	
}
