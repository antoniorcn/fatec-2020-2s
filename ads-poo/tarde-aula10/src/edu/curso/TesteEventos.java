package edu.curso;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

class Codigo implements EventHandler<ActionEvent> {
	private Label label;
	
	@Override
	public void handle(ActionEvent arg0) {
		System.out.println("Botão apertado");
		label.setText("Botão apertado");
	}

	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
}

public class TesteEventos extends Application {
	@Override
	public void start(Stage stage) { 
		BorderPane border = new BorderPane();
		Scene scn = new Scene(border, 400, 200);
		Label lbl = new Label("Texto");
		Button btn = new Button("Me aperte !!!");
		
		// Codigo cod = new Codigo();
		// cod.setLabel(lbl);
		// btn.addEventHandler(ActionEvent.ANY, cod);
		
//		btn.addEventHandler(ActionEvent.ANY, new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent a) {
//				lbl.setText("Botão apertado - Classe Anonima");
//			} 
//		});
		
//		btn.addEventHandler(ActionEvent.ANY, (a) -> {
//			lbl.setText("Botão apertado - Classe Anonima com Lambda");
//		}); 
		
		btn.setOnAction((a) -> { 
			lbl.setText("Botão apertado - Classe Anonima (setOnAction) com Lambda");
		});
		
		border.setBottom(btn);
		border.setTop(lbl);
		
		stage.setScene(scn);
		stage.setTitle("Teste de Eventos");
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(TesteEventos.class, args);
	}
}
