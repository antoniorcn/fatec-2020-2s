package edu.curso;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AgendaContatos extends Application {

	@Override
	public void start(Stage stage) { 
		Pane painel = new Pane();
		Scene scn = new Scene(painel, 600, 200);
		
		Label lblTel = new Label("Nome do produto: ");
		lblTel.relocate(20, 10);
		TextField txtTel = new TextField();
		txtTel.relocate(200, 10);
		txtTel.setPrefColumnCount(30);
		
		Label lblNome = new Label("Quantidade: ");
		lblNome.relocate(20, 40);
		TextField txtNome = new TextField();
		txtNome.relocate(200, 40);
		txtNome.setPrefColumnCount(30);
			
		Label lblDimensoes = new Label("Dimensões: ");
		lblDimensoes.relocate(20, 70);
		TextField txtAltura = new TextField();
		TextField txtLargura = new TextField();
		TextField txtProfundidade = new TextField();
		txtAltura.relocate(200, 70);
		txtLargura.relocate(280, 70);
		txtProfundidade.relocate(360, 70);
		txtAltura.setPrefColumnCount(5);
		txtLargura.setPrefColumnCount(5);
		txtProfundidade.setPrefColumnCount(5);
		
		Label lblPeso = new Label("Peso: ");
		lblPeso.relocate(20, 100);
		Slider sldPeso = new Slider();
		sldPeso.relocate(200, 100);
		
		Label lblEstoque = new Label("Estoque: ");
		lblEstoque.relocate(20, 130);
		ComboBox<String> cmbEstoque = new ComboBox<>();
		cmbEstoque.setItems(FXCollections.observableArrayList(
				"Central", "Filial 1", "Filial 2", "Depósito"));
		cmbEstoque.relocate(200, 130);
	
		
		Button btnOk = new Button("Ok");
		btnOk.relocate(20, 160);
		Button btnCancel = new Button("Cancel");
		btnCancel.relocate(80, 160);

		painel.getChildren().addAll(
				lblTel, txtTel, 
				lblNome, txtNome, 
				lblEstoque, cmbEstoque,
				lblDimensoes, txtAltura, txtLargura, txtProfundidade,
				lblPeso, sldPeso,
				btnOk, btnCancel);
		

		stage.setScene(scn);
		stage.setTitle("Gestão de Produtos");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(AgendaContatos.class, args);
	}
}
