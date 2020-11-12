package edu.curso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.LongStringConverter;

public class ContatoBoundary implements 
		EventHandler<ActionEvent>, SubTela {
	private TextField txtId = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtTelefone = new TextField();
	private TextField txtEmail = new TextField();
	private TextField txtNascimento = new TextField();
	
	private Button btnGravar = new Button("Gravar");
	private Button btnPesquisar = new Button("Pesquisar");
	
	private ContatoControl control = new ContatoControl();
	
	private TableView<Contato> table = new TableView<>();
	
	@Override
	public Pane gerarTela() { 
		vincularCampos();
        BorderPane panePrincipal = new BorderPane();
        
        GridPane paneCampos = new GridPane();
        
        paneCampos.add(new Label("ID"), 0, 0);
        paneCampos.add(txtId, 1, 0);
        paneCampos.add(new Label("Nome"), 0, 1);
        paneCampos.add(txtNome, 1, 1);
        paneCampos.add(new Label("Telefone"), 0, 2);
        paneCampos.add(txtTelefone, 1, 2);
        paneCampos.add(new Label("Email"), 0, 3);
        paneCampos.add(txtEmail, 1, 3);
        paneCampos.add(new Label("Nascimento"), 0, 4);
        paneCampos.add(txtNascimento, 1, 4);
        paneCampos.add(btnGravar, 0, 5);
        paneCampos.add(btnPesquisar, 1, 5);
        
        btnGravar.setOnAction(this);
        btnPesquisar.setOnAction(this);
        
        panePrincipal.setTop(paneCampos);
        panePrincipal.setCenter(table);
        
        return panePrincipal;
	}
	
	public void vincularCampos() { 
		StringConverter<? extends Number> converter = new LongStringConverter();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		StringConverter<LocalDate> dateConverter = new LocalDateStringConverter(dtf, dtf);
        Bindings.bindBidirectional(	txtId.textProperty(), 
        							control.getIdProperty(), 
        							(StringConverter<Number>)converter);
        Bindings.bindBidirectional(txtNome.textProperty(), control.getNomeProperty());
        Bindings.bindBidirectional(txtTelefone.textProperty(), control.getTelefoneProperty());
        Bindings.bindBidirectional(txtEmail.textProperty(), control.getEmailProperty());
        Bindings.bindBidirectional(txtNascimento.textProperty(), 
        							control.getNascimentoProperty(),
        							dateConverter);
        
        TableColumn<Contato, Long> colId = new TableColumn<>("Id");
//        colId.setCellValueFactory( ( item ) -> { 
//        	return new ReadOnlyStringWrapper( String.valueOf(item.getValue().getId()));
//        });
        colId.setCellValueFactory( new PropertyValueFactory<Contato, Long>("id") );
        
        TableColumn<Contato, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory( new PropertyValueFactory<Contato, String>("nome") );
        
        TableColumn<Contato, String> colTelefone = new TableColumn<>("Telefone");
        colTelefone.setCellValueFactory( new PropertyValueFactory<Contato, String>("telefone") );        
        
        TableColumn<Contato, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory( new PropertyValueFactory<Contato, String>("email") );
        
        TableColumn<Contato, String> colNascimento = new TableColumn<>("Nascimento");
        colNascimento.setCellValueFactory(
        		(item) -> {
        			return new ReadOnlyStringWrapper( 
        					item.getValue().getNascimento().format(dtf)
        					);
        		}
        		);
        
        table.getColumns().addAll(colId, colNome, colTelefone, colEmail, colNascimento);
        table.setItems(control.getLista());
        
	}

	@Override
	public void handle(ActionEvent e) {
		if (btnGravar == e.getTarget()) { 
			control.adicionar();
		} else if (btnPesquisar == e.getTarget()){ 
			control.pesquisarPorNome();
		}
	}
}
