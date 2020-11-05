package edu.curso;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.LongStringConverter;

public class ContatoBoundary extends Application 
							implements EventHandler<ActionEvent>{
	
	private TextField txtId = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtTelefone = new TextField();
	private TextField txtEmail = new TextField();
	private TextField txtNascimento = new TextField();
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private ContatoControl control = new ContatoControl();
	
	public void vincularCampos() { 
		StringConverter<? extends Number> idConverter = new LongStringConverter();
		StringConverter<LocalDate> dateConverter = new LocalDateStringConverter();
		Bindings.bindBidirectional(	txtId.textProperty(),
				control.getIdProperty(),
				(StringConverter<Number>)idConverter);	
		Bindings.bindBidirectional(txtNome.textProperty(), control.getNomeProperty());
		Bindings.bindBidirectional(txtTelefone.textProperty(), control.getTelefoneProperty());
		Bindings.bindBidirectional(txtEmail.textProperty(), control.getEmailProperty());
		Bindings.bindBidirectional(txtNascimento.textProperty(), 
				control.getNascimentoProperty(), 
				dateConverter);
	}
	
	@Override
	public void start(Stage stage) { 
		vincularCampos();
		dateField(txtNascimento);
		BorderPane bp = new BorderPane();
		Scene scn = new Scene(bp, 600, 200);
		
		GridPane paneCampos = new GridPane();
		
		paneCampos.add(new Label("Id"), 0, 0);
		paneCampos.add(txtId, 1, 0);
		paneCampos.add(new Label("Nome"), 0, 1);
		paneCampos.add(txtNome, 1, 1);
		paneCampos.add(new Label("Telefone"), 0, 2);
		paneCampos.add(txtTelefone, 1, 2);
		paneCampos.add(new Label("Email"), 0, 3);
		paneCampos.add(txtEmail, 1, 3);
		paneCampos.add(new Label("Nascimento"), 0, 4);
		paneCampos.add(txtNascimento, 1, 4);
		paneCampos.add(btnAdicionar, 0, 5);
		paneCampos.add(btnPesquisar, 1, 5);
		
		btnAdicionar.setOnAction(this);
		btnPesquisar.setOnAction(this);
		
		bp.setCenter(paneCampos);
		
		stage.setScene(scn);
		stage.setTitle("Agenda de Contatos");
		stage.show();
	}
	
	private static void maxField(final TextField textField, final Integer length) {
	    textField.textProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
	            if (newValue.length() > length)
	                textField.setText(oldValue);
	        }
	    });
	}
	
	public static void dateField(final TextField textField) {
	    maxField(textField, 10);

	    textField.lengthProperty().addListener(new ChangeListener<Number>() {
	        @Override
	        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
	            if (newValue.intValue() < 11) {
	                String value = textField.getText();
	                value = value.replaceAll("[^0-9]", "");
	                value = value.replaceFirst("(\\d{2})(\\d)", "$1/$2");
	                value = value.replaceFirst("(\\d{2})\\/(\\d{2})(\\d)", "$1/$2/$3");
	                textField.setText(value);
	                positionCaret(textField);
	            }
	        }
	    });
	}
	
	private static void positionCaret(final TextField textField) {
	    Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	            // Posiciona o cursor sempre a direita.
	            textField.positionCaret(textField.getText().length());
	        }
	    });
	}
	
	@Override
	public void handle(ActionEvent e) {
		if (e.getTarget() == btnAdicionar) { 
			System.out.println("Botão adicionar foi pressionado");
			control.adicionar();
		} else if (e.getTarget() == btnPesquisar) { 
			System.out.println("Botão pesquisar foi pressionado");
			control.pesquisarPorNome();
		}
		
	}
	
	public static void main(String[] args) {
		Application.launch(ContatoBoundary.class, args);
	}
}
