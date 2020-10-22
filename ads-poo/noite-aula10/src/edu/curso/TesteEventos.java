package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

class Manipulador implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) { 
//		System.out.printf("Tipo:%s\tOrigem:%s\tDestino%s%n",
//				e.getEventType().getName(), 
//				e.getSource().getClass().getName(), 
//				e.getTarget().getClass().getName());
		System.out.println("Botão apertado");
	}
}


public class TesteEventos extends Application {
	
	@Override
	public void start(Stage stage) { 
		BorderPane bp = new BorderPane();
		Scene scn = new Scene(bp, 400, 200);
		Button btn = new Button("Aperte-me");
		Label lbl = new Label("Texto");
		
		Manipulador man = new Manipulador();
		btn.addEventFilter(ActionEvent.ANY, man);
		bp.setBottom(btn);
		bp.setTop(lbl);
		
		stage.setScene(scn);
		stage.setTitle("Teste de Eventos");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TesteEventos.class, args);
	}

}
