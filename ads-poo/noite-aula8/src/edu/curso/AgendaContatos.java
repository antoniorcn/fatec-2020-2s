package edu.curso;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AgendaContatos extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		GridPane gp = new GridPane();
		Scene scn = new Scene(gp, 600, 200);
		
		Label lblId = new Label("Id: ");
		TextField txtId = new TextField();
		Label lblNome = new Label("Nome: ");
		TextField txtNome = new TextField();
		Label lblTelefone = new Label("Telefone: ");
		TextField txtTelefone = new TextField();
		Button btnSalvar = new Button("Salvar");
		Button btnPesquisar = new Button("Pesquisar");
		
		gp.add(lblId, 0, 0);
		gp.add(txtId, 1, 0);
		gp.add(lblNome, 0, 1);
		gp.add(txtNome, 1, 1);
		gp.add(lblTelefone, 0, 2);
		gp.add(txtTelefone, 1, 2);
		FlowPane fp = new FlowPane();
		fp.getChildren().addAll(btnSalvar, btnPesquisar);
		gp.add(fp, 0, 3);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(25);
		
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(75);
		gp.getColumnConstraints().addAll(col1, col2);

		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(10));
		stage.setScene(scn);
		stage.setTitle("Agenda de Contatos");
		stage.show();	
	}
	public static void main(String[] args) {
		Application.launch(AgendaContatos.class, args);
	}
}
