package edu.curso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.parser.DateParser;

public class ContatoBoundary extends Application 
			implements EventHandler<ActionEvent> {

	private TextField txtId = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtTelefone = new TextField();
	private TextField txtEmail = new TextField();
	private TextField txtNascimento = new TextField();
	
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	
	private List<Contato> lista = new ArrayList<>();
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Override
	public void start(Stage stage) { 
		BorderPane bp = new BorderPane();
		
		Scene scn = new Scene(bp, 600, 200);
		
		GridPane grid = new GridPane();
		grid.setHgap(20);
		
		ColumnConstraints colLabels = new ColumnConstraints();
		colLabels.setHalignment(HPos.RIGHT);
		colLabels.setPercentWidth(30);

		
		ColumnConstraints colTextField = new ColumnConstraints();
		colTextField.setPercentWidth(70);

		grid.getColumnConstraints().addAll(colLabels, colTextField);
		
		bp.setCenter(grid);
		
		grid.add(new Label("Id"), 0, 0);
		grid.add(txtId, 1, 0);
		grid.add(new Label("Nome"), 0, 1);
		grid.add(txtNome, 1, 1);
		grid.add(new Label("Telefone"), 0, 2);
		grid.add(txtTelefone, 1, 2);
		grid.add(new Label("Email"), 0, 3);
		grid.add(txtEmail, 1, 3);
		grid.add(new Label("Nascimento"), 0, 4);
		grid.add(txtNascimento, 1, 4);
		grid.add(btnAdicionar, 0, 5);
		grid.add(btnPesquisar, 1, 5);
		
		btnAdicionar.addEventHandler(ActionEvent.ACTION, this);
		btnPesquisar.addEventHandler(ActionEvent.ACTION, this);
		
		stage.setScene(scn);
		stage.setTitle("Agenda de Contatos");
		stage.show();
		
	}
	
	public Contato boundaryParaContato() { 
		Contato c = new Contato();
		c.setId(Long.parseLong(txtId.getText()));
		c.setNome(txtNome.getText());
		c.setTelefone(txtTelefone.getText());
		c.setEmail(txtEmail.getText());
		LocalDate localDate = LocalDate.parse(txtNascimento.getText(), formatter);
		c.setNascimento(localDate);
		return c;
	}
	
	public void contatoParaBoundary(Contato c) { 
		txtId.setText(String.valueOf(c.getId()));
		txtNome.setText(c.getNome());
		txtTelefone.setText(c.getTelefone());
		txtEmail.setText(c.getEmail());
		String txtData = c.getNascimento().format(formatter);
		txtNascimento.setText(txtData);
	}
	
	@Override
	public void handle(ActionEvent e) {
		if (e.getTarget() == btnAdicionar) {
			Contato c = boundaryParaContato();
			lista.add(c);
			System.out.printf("A lista agora tem %d contatos%n", lista.size());
		} else if (e.getTarget() == btnPesquisar) { 
			for (Contato c : lista) { 
				if (c.getNome().contains(txtNome.getText())) { 
					contatoParaBoundary(c);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Application.launch(ContatoBoundary.class, args);
	}
}
