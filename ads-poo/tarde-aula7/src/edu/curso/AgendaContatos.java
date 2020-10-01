package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AgendaContatos extends Application {

	@Override
	public void start(Stage stage) { 
		Pane painel = new Pane();
		Scene scn = new Scene(painel, 400, 200);
		
		Label lblTel = new Label("Entre com o numero do telefone: ");
		lblTel.relocate(20, 10);
		TextField txtTel = new TextField();
		txtTel.relocate(250, 10);
		Label lblNome = new Label("Entre com o seu nome: ");
		lblNome.relocate(20, 50);
		TextField txtNome = new TextField();
		txtNome.relocate(250, 50);
		
		Button btnOk = new Button("Ok");
		btnOk.relocate(20, 90);
		Button btnCancel = new Button("Cancel");
		btnCancel.relocate(250, 90);
		
		
		painel.getChildren().addAll(
				lblTel, txtTel, 
				lblNome, txtNome, 
				btnOk, btnCancel);
		
		
		stage.setScene(scn);
		stage.setTitle("Agenda de Contatos");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(AgendaContatos.class, args);
	}

}
