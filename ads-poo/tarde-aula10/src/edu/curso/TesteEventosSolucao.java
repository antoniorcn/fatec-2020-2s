package edu.curso;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class TesteEventosSolucao extends Application
								implements EventHandler<ActionEvent>{
	
	private Label lbl = new Label("Texto");
	
	@Override
	public void start(Stage stage) { 
		BorderPane border = new BorderPane();
		Scene scn = new Scene(border, 400, 200);
		
		Button btn = new Button("Me aperte !!!");
		
		btn.addEventHandler(ActionEvent.ANY, this);
		
		border.setBottom(btn);
		border.setTop(lbl);
		
		stage.setScene(scn);
		stage.setTitle("Teste de Eventos");
		stage.show();
	}
	
	@Override 
	public void handle(ActionEvent e) { 
		lbl.setText("Botão apertado");
	}
	
	public static void main(String[] args) {
		Application.launch(TesteEventosSolucao.class, args);
	}
}
