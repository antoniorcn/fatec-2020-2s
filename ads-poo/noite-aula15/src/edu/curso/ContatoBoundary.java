package edu.curso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.LongStringConverter;

public class ContatoBoundary implements EventHandler<ActionEvent>,
							TelaStrategy {
	private BorderPane tela = new BorderPane();
	private TextField txtId = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtTelefone = new TextField();
	private TextField txtEmail = new TextField();
	private TextField txtNascimento = new TextField();
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private ContatoControl control = new ContatoControl();
	private TableView<Contato> table = new TableView<>();
	private Principal principal;
	private Gson gson = new Gson();
 	
	public void vincularCampos() { 
		StringConverter<? extends Number> idConverter = new LongStringConverter();
		StringConverter<LocalDate> dateConverter = new LocalDateStringConverter();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Bindings.bindBidirectional(	txtId.textProperty(),
				control.getIdProperty(),
				(StringConverter<Number>)idConverter);	
		Bindings.bindBidirectional(txtNome.textProperty(), control.getNomeProperty());
		Bindings.bindBidirectional(txtTelefone.textProperty(), control.getTelefoneProperty());
		Bindings.bindBidirectional(txtEmail.textProperty(), control.getEmailProperty());
		Bindings.bindBidirectional(txtNascimento.textProperty(), 
				control.getNascimentoProperty(), 
				dateConverter);
		
		TableColumn<Contato, Long> colId = new TableColumn<>("ID");
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Contato, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		TableColumn<Contato, String> colTelefone = new TableColumn<>("Telefone");
		colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		
		TableColumn<Contato, String> colEmail = new TableColumn<>("Email");
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		
		TableColumn<Contato, String> colNascimento = new TableColumn<>("Nascimento");
//		colNascimento.setCellValueFactory(
//				new Callback<TableColumn.CellDataFeatures<Contato, String>, ObservableValue<String>>() {
//					
//					@Override
//					public ObservableValue<String> call(CellDataFeatures<Contato, String> param) {
//						return new SimpleStringProperty(param.getValue().getNascimento().toString()); 
//					}
//				});
		
		colNascimento.setCellValueFactory(
				(item) -> {return new ReadOnlyStringWrapper(item.getValue().getNascimento().format(dtf));}
				);
		
//		(item) -> { 
//			String texto = item.getValue().getNascimento().format(dtf);
//			return new ReadOnlyStringWrapper( texto ); 
//			}
		
		table.getColumns().addAll(colId, colNome, colTelefone, colEmail, colNascimento);
		
		table.setItems( control.getLista() );
		
		table.getSelectionModel().selectedItemProperty().addListener(
				(listener, contatoAntigo, contatoNovo) -> {
					control.setContato(contatoNovo);
				});
	}
	
	public ContatoBoundary(Principal principal) { 
		this.principal = principal;
		vincularCampos();
		dateField(txtNascimento);
	
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
		
		tela.setTop(paneCampos);
		tela.setCenter(table);		
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
			String j = gson.toJson(control.getContato());
			System.out.println("JSON do Contato");
			System.out.println(j);
			try {
				control.adicionar();
			} catch (ContatoException e1) {
				e1.printStackTrace();
				new Alert(AlertType.ERROR, "Erro ao adicionar o contato").show();			
			}
		} else if (e.getTarget() == btnPesquisar) { 
			System.out.println("Botão pesquisar foi pressionado");
			try {
				control.pesquisarPorNome();
			} catch (ContatoException e1) {
				e1.printStackTrace();
				new Alert(AlertType.ERROR, "Erro ao pesquisar o contato").show();

			}
		}
		
	}

	@Override
	public Pane getTela() {
		return tela;
	}
}
