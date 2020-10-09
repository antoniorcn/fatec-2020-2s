package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ExemploLayout extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		// FlowPane fp = new FlowPane();
		GridPane gp = new GridPane();
		Scene scn = new Scene(gp, 600, 200);
		
		Label lblNome = new Label("Nome: ");
		TextField txtNome = new TextField();
		Button btnOk = new Button("Adicionar");
		
		gp.add(lblNome, 0, 0);
		gp.add(txtNome, 1, 0);
		gp.add(btnOk, 0, 1);
		gp.setHgap(10);
		gp.setVgap(10);
		// fp.setHgap(10);
		// fp.setVgap(10);
		// fp.getChildren().addAll(lblNome, txtNome, btnOk);
		stage.setScene(scn);
		stage.setTitle("Janela de Teste");
		stage.show();	
	}
	public static void main(String[] args) {
		Application.launch(ExemploLayout.class, args);
	}
}
