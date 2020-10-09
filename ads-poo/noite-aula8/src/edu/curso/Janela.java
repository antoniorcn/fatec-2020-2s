package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class Janela extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Pane painel = new Pane();
		Scene scn = new Scene(painel);
		
		Label lblHello = new Label("Digite seu nome: ");
		lblHello.relocate(10, 20);
		//painel.getChildren().add(lblHello);
			
		TextField txtNome = new TextField();
		txtNome.relocate(100, 20);
		//painel.getChildren().add(txtNome);
		
		Button btnOk = new Button("Ok");
		btnOk.relocate(10, 50);
		//painel.getChildren().add(btnOk);
		painel.getChildren().addAll(lblHello, txtNome, btnOk);
		
		stage.setScene(scn);
		stage.setTitle("Janela JavaFX");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(Janela.class, args);
	}
}
